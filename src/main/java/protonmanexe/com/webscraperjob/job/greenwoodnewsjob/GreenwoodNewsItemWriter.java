package protonmanexe.com.webscraperjob.job.greenwoodnewsjob;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;

@Component
public class GreenwoodNewsItemWriter implements ItemWriter<GreenwoodNewsArticle> {

    private final static Logger log = LoggerFactory.getLogger(GreenwoodNewsItemReader.class);

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.greenwood.news.chat.id}")
    private String chatId;

    @SuppressWarnings("unchecked")
    @Override
    public void write(Chunk<? extends GreenwoodNewsArticle> items) throws Exception {

        log.info("Starting itemwriter...");

        // 1) Initialise variables
        TelegramBot bot = null;
        Long fullChatId = null;
        List<GreenwoodNewsArticle> listOfNews = (List<GreenwoodNewsArticle>) items.getItems();

        try {
        // 2) Create Telegram bot object and chat id
            bot = new TelegramBot(botToken);
            fullChatId = -Long.valueOf(chatId);
        } catch (NumberFormatException e) {
            log.error("Error sending message, error {}", e.toString());
        }

        // 2) Create Telegram bot object and chat id
        for (GreenwoodNewsArticle article : listOfNews) {
            log.info("Article: {}", article.toString());

            String message = ("Headline: ").concat(article.getHeadlines()).concat(System.lineSeparator())
                .concat("Link: ").concat(article.getUrl());

            SendMessage request = new SendMessage(fullChatId, message);
            SendResponse response = bot.execute(request);

            // Check if the message was sent successfully
            if (response.isOk()) {
                System.out.println("Message sent successfully!");
            } else {
                System.out.println("Error sending message: " + response.description());
            }
        }
    
    }

}
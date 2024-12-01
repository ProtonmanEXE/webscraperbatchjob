package protonmanexe.com.webscraperjob.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

@Service
public class TelegramMessagerService {

    private final static Logger log = LoggerFactory.getLogger(TelegramMessagerService.class);

    public boolean sendTelegramMessage(TelegramBot bot, String msg, long chatId) {
        // 1) Send msg to telegram
        SendMessage request = new SendMessage(chatId, msg);
        SendResponse response = bot.execute(request);

        if (response.isOk()) { // Check if the message was sent successfully
            log.info("Message sent successfully!");
            return true;
        } else {
            log.info("Error sending message: " + response.description());
            return false;
        }
    }

}
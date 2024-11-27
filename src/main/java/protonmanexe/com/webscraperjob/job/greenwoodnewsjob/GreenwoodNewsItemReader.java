package protonmanexe.com.webscraperjob.job.greenwoodnewsjob;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;
import protonmanexe.com.webscraperjob.service.GreenwoodNewsService;

@Component
public class GreenwoodNewsItemReader implements ItemReader<GreenwoodNewsArticle> {

    private final static Logger log = LoggerFactory.getLogger(GreenwoodNewsItemReader.class);

    int i = 0;

    @Autowired
    private GreenwoodNewsService greenwoodNewsSvc;

    @Override
    public GreenwoodNewsArticle read() throws Exception, UnexpectedInputException, 
    ParseException, NonTransientResourceException {

        log.info("Starting itemreader...");

        // 1) Insert webscraper to extract news
        greenwoodNewsSvc.scrapeGreenwoodNewsWebsite();

        GreenwoodNewsArticle article = new GreenwoodNewsArticle(i);
        article.setHeadlines("Test only");
        ArrayList<GreenwoodNewsArticle> listOfNews = new ArrayList<GreenwoodNewsArticle>();
        listOfNews.add(article);

        // 2) For each article, send it to itemwriter
        if (!listOfNews.isEmpty()) {

            if (listOfNews.size() > i) {
                GreenwoodNewsArticle item = new GreenwoodNewsArticle();
                item = listOfNews.get(i);
                i = i + 1;
                log.info("Reading article {}", i);
                return item;
            }

        }

        return null;
    }

}
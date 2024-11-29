package protonmanexe.com.webscraperjob.job.greenwoodnewsjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;

@Component
public class GreenwoodNewsItemProcessor implements ItemProcessor<GreenwoodNewsArticle, GreenwoodNewsArticle> {

    private final static Logger log = LoggerFactory.getLogger(GreenwoodNewsItemReader.class);

    @Value("${greenwood.news.home.page}")
    private String greenwoodNewsHomePageUrl;

    @Override
    public GreenwoodNewsArticle process(GreenwoodNewsArticle article) throws Exception {
        
        log.info("Starting itemprocessor...");

        article.setUrl(greenwoodNewsHomePageUrl.concat(article.getUrl()));
        return article;
    }

}
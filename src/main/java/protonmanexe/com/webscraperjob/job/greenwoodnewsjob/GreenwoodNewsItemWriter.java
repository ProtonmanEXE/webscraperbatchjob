package protonmanexe.com.webscraperjob.job.greenwoodnewsjob;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;

@Component
public class GreenwoodNewsItemWriter implements ItemWriter<GreenwoodNewsArticle> {

    private final static Logger log = LoggerFactory.getLogger(GreenwoodNewsItemReader.class);

    @SuppressWarnings("unchecked")
    @Override
    public void write(Chunk<? extends GreenwoodNewsArticle> items) throws Exception {

        log.info("Starting itemwriter...");

        List<GreenwoodNewsArticle> listOfNews = (List<GreenwoodNewsArticle>) items.getItems();

        for (GreenwoodNewsArticle article : listOfNews) {
            log.info("Article: {}", article.toString());
        }
    }

}
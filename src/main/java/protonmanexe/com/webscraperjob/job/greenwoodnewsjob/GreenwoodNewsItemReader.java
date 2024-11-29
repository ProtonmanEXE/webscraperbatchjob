package protonmanexe.com.webscraperjob.job.greenwoodnewsjob;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import static protonmanexe.com.webscraperjob.constants.Constants.GREENWOOD_NEWS_ARTICLE_LIST;
import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;

@Component
public class GreenwoodNewsItemReader implements ItemReader<GreenwoodNewsArticle>, StepExecutionListener {

    private final static Logger log = LoggerFactory.getLogger(GreenwoodNewsItemReader.class);

    private StepExecution stepExecution;

    int i = 0;

    @SuppressWarnings("unchecked")
    @Override
    public GreenwoodNewsArticle read() throws Exception, UnexpectedInputException, 
    ParseException, NonTransientResourceException {

        log.info("Starting itemreader...");

        // 1) Initialise variables
        GreenwoodNewsArticle item;
        List<GreenwoodNewsArticle> filteredArticleList = 
            (List<GreenwoodNewsArticle>) this.stepExecution.getJobExecution().getExecutionContext()
                .get(GREENWOOD_NEWS_ARTICLE_LIST);

        // 2) For each relevant article, send it to itemwriter
        try {
            if (filteredArticleList.size() > i) {
                item = filteredArticleList.get(i);
                i = i + 1;
                log.info("Reading article {}: Headlines {}", i, item.getHeadlines());
                return item;
            }
        } catch (NullPointerException e) {
            log.info("No relevant articles were found");
        }

        return null;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return stepExecution.getExitStatus();
    }
}
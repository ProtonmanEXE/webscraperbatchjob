package protonmanexe.com.webscraperjob.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import protonmanexe.com.webscraperjob.job.greenwoodnewsjob.GreenwoodNewJobExecutionListener;
import protonmanexe.com.webscraperjob.job.greenwoodnewsjob.GreenwoodNewsItemProcessor;
import protonmanexe.com.webscraperjob.job.greenwoodnewsjob.GreenwoodNewsItemReader;
import protonmanexe.com.webscraperjob.job.greenwoodnewsjob.GreenwoodNewsItemWriter;
import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;

@Configuration
public class JobConfig {

    @Autowired
    private GreenwoodNewJobExecutionListener gNJobListener;

    @Autowired
    private GreenwoodNewsItemReader gNItemReader;

    @Autowired
    private GreenwoodNewsItemProcessor gNItemProcessor;

    @Autowired
    private GreenwoodNewsItemWriter gNItemWriter;

    @Bean
    public Job greenwoodNewsJob(JobRepository jobRepository, 
                                Step greenwoodNewsStep, 
                                PlatformTransactionManager transactionManager) {
        return new JobBuilder("greenwoodNewsJob", jobRepository)
            .start(greenwoodNewsStep)
            .listener(gNJobListener)
            .build();
    }
    
    @Bean
    public Step greenwoodNewsStep(JobRepository jobRepository, 
                                  PlatformTransactionManager transactionManager) {
        return new StepBuilder("greenwoodNewsStep", jobRepository)
            .<GreenwoodNewsArticle, GreenwoodNewsArticle>chunk(10, transactionManager)
            .reader(gNItemReader)
            .processor(gNItemProcessor)
            .writer(gNItemWriter)
            .build();
    }
   
}
package protonmanexe.com.webscraperjob.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import protonmanexe.com.webscraperjob.models.GreenwoodNewsArticle;

@Configuration
public class JobConfig {

    @Autowired
    private ItemReader<GreenwoodNewsArticle> gNItemReader;

    @Autowired
    private ItemWriter<GreenwoodNewsArticle> gNItemWriter;

    @Bean
    public Job greenwoodNewsJob(JobRepository jobRepository, 
                                Step greenwoodNewsStep, 
                                PlatformTransactionManager transactionManager) {
        return new JobBuilder("greenwoodNewsJob", jobRepository)
            .start(greenwoodNewsStep)
            .build();
    }
    
    @Bean
    public Step greenwoodNewsStep(JobRepository jobRepository, 
                                  PlatformTransactionManager transactionManager) {
        return new StepBuilder("greenwoodNewsStep", jobRepository)
                .<GreenwoodNewsArticle, GreenwoodNewsArticle>chunk(10, transactionManager)
                .reader(gNItemReader)
                .writer(gNItemWriter)
                .build();
    }
   
}
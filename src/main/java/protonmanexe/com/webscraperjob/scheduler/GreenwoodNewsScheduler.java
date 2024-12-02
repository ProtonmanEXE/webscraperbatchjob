package protonmanexe.com.webscraperjob.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GreenwoodNewsScheduler {

    private final static Logger log = LoggerFactory.getLogger(GreenwoodNewsScheduler.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job greenwoodNewsJob;

    @Scheduled(cron = "0 0 8,13 * * ?") // Run every at 8am and 1pm
    public void runBatchJob() {
        log.error("Starting scheduler...");
        JobParameters jobParameters = new JobParametersBuilder()
            .addLong("time", System.currentTimeMillis())
            .toJobParameters();

        try {
            jobLauncher.run(greenwoodNewsJob, jobParameters);
        } catch (Exception e) {
            log.error("Job failed to run, {}", e.toString());
        }
    }
}
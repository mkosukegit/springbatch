package com.batchsample.batchsample.tasklet.batchConfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batchsample.batchsample.tasklet.step.SampleTasklet;

@EnableBatchProcessing
@Configuration
public class SampleConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final SampleTasklet sampleTasklet;

    public SampleConfig(JobBuilderFactory jobBuilderFactory,
            StepBuilderFactory stepBuilderFactory,
            SampleTasklet sampleTasklet) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sampleTasklet = sampleTasklet;
    }

    @Bean
    public Job sampleJob(Step sampleStep) {
        return jobBuilderFactory.get("sampleJob") // Job名を指定
                .flow(sampleStep) // 実行するStepを指定
                .end()
                .build();
    }

    @Bean
    public Step sampleStep() {
        return stepBuilderFactory.get("sampleStep") // Step名を指定
                .tasklet(sampleTasklet) // 実行するTaskletを指定
                .build();
    }
}

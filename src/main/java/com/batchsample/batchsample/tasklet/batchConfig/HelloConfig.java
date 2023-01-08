package com.batchsample.batchsample.tasklet.batchConfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batchsample.batchsample.tasklet.step.HelloTasklet;

@EnableBatchProcessing
@Configuration
public class HelloConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final HelloTasklet helloTasklet;

    public HelloConfig(JobBuilderFactory jobBuilderFactory,
            StepBuilderFactory stepBuilderFactory,
            HelloTasklet helloTasklet) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.helloTasklet = helloTasklet;
    }

    @Bean
    public Job helloJob(Step helloStep) {
        return jobBuilderFactory.get("helloJob") // Job名を指定
                .flow(helloStep) // 実行するStepを指定
                .end()
                .build();
    }

    @Bean
    public Step helloStep() {
        return stepBuilderFactory.get("helloStep") // Step名を指定
                .tasklet(helloTasklet) // 実行するTaskletを指定
                .build();
    }
}

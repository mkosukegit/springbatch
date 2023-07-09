package com.batchsample.batchsample.tasklet.step;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
@StepScope
public class HelloTasklet implements Tasklet {

    @Value("#{jobParameters[param1]}")
    private String param1;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Hello Task");
        System.out.println("param1: " + param1);
        return RepeatStatus.FINISHED;
    }
}

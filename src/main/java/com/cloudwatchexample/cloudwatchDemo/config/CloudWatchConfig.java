package com.cloudwatchexample.cloudwatchDemo.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.logs.AWSLogs;
import com.amazonaws.services.logs.AWSLogsClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudWatchConfig {

    @Value("${accessKey}")
    private String accessKey;

    @Value("${secretKey}")
    private String secretKey;


    public AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return credentials;
    }

    @Bean
    public AWSLogs awsLogs() {

        AWSLogs cloudWatchlog = AWSLogsClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials())).withRegion(Regions.US_EAST_1)
                .build();
        return cloudWatchlog;
    }
}
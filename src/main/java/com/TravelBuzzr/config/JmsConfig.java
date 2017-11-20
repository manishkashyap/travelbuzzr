package com.TravelBuzzr.config;

import javax.jms.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
@EnableJms
public class JmsConfig {

	// Create the connection factory using the environment variable credential provider.
	// Connections this factory creates can talk to the queues in AP_SOUTH_1 region. 
	SQSConnectionFactory connectionFactory;
	
	public JmsConfig(@Value("${AWS_ACCESS_KEY_ID}") String accessKey, 
			@Value("${AWS_SECRET_ACCESS_KEY}") String secretAccessKey) {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretAccessKey);
		connectionFactory = new SQSConnectionFactory(
		        new ProviderConfiguration(),
		        AmazonSQSClientBuilder.standard()
		                .withRegion(Regions.AP_SOUTH_1)
		                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		        );
	}
	 
	@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(this.connectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConcurrency("3-10");
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return factory;
    }

    @Bean
    public JmsTemplate defaultJmsTemplate() {
        return new JmsTemplate(this.connectionFactory);
    }

}

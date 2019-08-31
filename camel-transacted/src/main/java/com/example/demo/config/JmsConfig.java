package com.example.demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;

@Configuration
public class JmsConfig {

	@Autowired
	private ActiveMQConnectionFactory factory;

	@Bean
	public JmsTransactionManager txManager() {
		return new JmsTransactionManager(factory);
	}

	@Bean
	public JmsComponent setComponentTxmanager(@Autowired JmsTransactionManager txMgr) {
		JmsComponent jmsComponent = new JmsComponent();
		jmsComponent.setTransactionManager(txMgr);
		jmsComponent.setTransacted(true);

		return jmsComponent;

	}

}

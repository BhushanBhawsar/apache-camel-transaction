package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Component
public class TransactedRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("jms:queue:incoming").transacted().to("file:C:\\");

	}

}

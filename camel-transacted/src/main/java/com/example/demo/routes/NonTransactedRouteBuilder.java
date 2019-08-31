package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class NonTransactedRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("jms:queue:incoming").process(i -> {
			String msg = i.getIn().getBody(String.class);
			i.getOut().setBody(msg + " : Outgoing");
			;
		}).to("file:C:\\");

	}

}

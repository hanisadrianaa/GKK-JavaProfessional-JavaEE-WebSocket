package com.javaclass.feb27.websocket;

import org.springframework.context.annotation.Bean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Slf4j
@Configuration
public class WebSocketEndpointConfig {
	
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {

		log.debug("Configure ServerEndpointExporter");

		return new ServerEndpointExporter();
	}
}

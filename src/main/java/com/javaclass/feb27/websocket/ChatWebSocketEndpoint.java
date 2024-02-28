package com.javaclass.feb27.websocket;

import org.springframework.stereotype.Component;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@ServerEndpoint(value = "/chat")
public class ChatWebSocketEndpoint {

	@OnOpen
	public void onOpen(Session session) throws IOException, EncodeException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String formattedTime = formatter.format(new Date());

		System.out.println("Client connected: " + session.getId() + " Time: " + formattedTime);
	}

	@OnClose
	public void onClose(Session session) throws IOException, EncodeException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String formattedTime = formatter.format(new Date());

		System.out.println("Client disconnected: " + session.getId() + " Time: " + formattedTime);
	}

    @OnMessage
    public void OnMessage(Session session, String message) throws IOException, EncodeException {
        System.out.println("Message from " + session.getId() + ": " + message);
        try {
            session.getBasicRemote().sendText("Echo: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@OnError
	public void onError(Session session, Throwable throwable) {

		throwable.printStackTrace();
	}

}


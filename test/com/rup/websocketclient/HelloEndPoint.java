package com.rup.websocketclient;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

public class HelloEndPoint extends Endpoint {

	private Session session;

	@Override public void onOpen(Session session, EndpointConfig endpointConfig) {
		this.session = session;
		this.session.addMessageHandler(new MessageHandler.Whole<String>() {

			public void onMessage(String message) {
				System.out.print("!!!!! retrieved " + message);
			}
		});
	}

	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}
}

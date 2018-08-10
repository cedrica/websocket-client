package com.rup.websocketclient;

import org.junit.Before;
import org.junit.Test;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SocketClientTest {

	WebSocketContainer webSocketContainer;
	HelloEndPoint helloEndPoint;
	@Before public void onInit() {
		webSocketContainer = ContainerProvider.getWebSocketContainer();
		helloEndPoint = new HelloEndPoint();
	}

	@Test public void pingServer() throws URISyntaxException, IOException, DeploymentException, InterruptedException {
		Session connectToserver = webSocketContainer.connectToServer(this.helloEndPoint,new URI("ws://localhost:8080/WebSocket_Server_war_exploded/hello"));
		this.helloEndPoint.sendMessage("Hello from client");
		Thread.sleep(1000);
	}
}

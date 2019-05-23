package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class SocketNode {
	
	private static HashMap<String, Session> sessions = new HashMap<String, Session>();
	
	@OnOpen
	public void onOpen(Session session) {
		//sessions.add(session);
	}
	@OnMessage
	public void onMessage(String msg, Session session) {
		try {
			
			if(msg.startsWith("ID::")) {
				sessions.put(msg.split("::")[1], session);
				return;
			}
			
			
			//Por defecto
			for(String key : sessions.keySet()) {
				sessions.get(key).getBasicRemote().sendText(key + ":" + msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@OnClose
	public void onClose(Session session) {
		sessions.remove(session);
	}
	
}

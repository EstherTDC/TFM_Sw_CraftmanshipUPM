package es.tfm.bingo.websocket;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class CustomHandshakeHandler extends DefaultHandshakeHandler{

	class StompPrincipal implements Principal {
	    String name;

	    StompPrincipal(String name) {
	        this.name = name;
	    }

	    @Override
		public String getName() {
	        return name;
	    }
	}
	
	@Override
	protected Principal determineUser(ServerHttpRequest request,
	                                  WebSocketHandler wsHandler,
	                                  Map<String, Object> attributes){
		
	        return new StompPrincipal(UUID.randomUUID().toString());
	}
}

package site.tj.program.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.Oneway;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * WebSocket后台处理类，测试用
 */
@ServerEndpoint(value = "/ws/y/{id}")
public class TestWebSocket {
    private Logger logger= LoggerFactory.getLogger(TestWebSocket.class);
    private String id;
    @OnOpen
    public void onOpen(@PathVariable String id,Session session) throws IOException {
        session.getBasicRemote().sendText("hello");
    }
    @OnClose
    public void onClose(){

    }
    @OnMessage
    public void onMessage(String message, Session session){
        session.getAsyncRemote().sendText("异步");
    }
    @OnError
    public void onError(Session session,Throwable error){
        logger.debug("用户id:{}",this.id);
    }
}

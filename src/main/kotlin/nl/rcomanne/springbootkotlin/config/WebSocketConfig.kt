package nl.rcomanne.springbootkotlin.config

import nl.rcomanne.springbootkotlin.socket.BuildResultHandler
import nl.rcomanne.springbootkotlin.socket.ChatHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(ChatHandler(), "/chat").withSockJS()
        registry.addHandler(BuildResultHandler(), "/jenkins").withSockJS()
    }
}
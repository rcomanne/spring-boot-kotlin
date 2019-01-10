package nl.rcomanne.springbootkotlin.socket

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import nl.rcomanne.springbootkotlin.domain.BuildResult
import nl.rcomanne.springbootkotlin.domain.Device
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class BuildResultHandler : TextWebSocketHandler() {
    val deviceList = HashMap<WebSocketSession, Device>()


    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val json = ObjectMapper().readTree(message.payload)

//        broadcast()
    }

    fun emit(session: WebSocketSession, buildResult: BuildResult) = session.sendMessage(TextMessage(jacksonObjectMapper().writeValueAsString(buildResult)))
    fun broadcast(buildResult: BuildResult) = deviceList.forEach { emit(it.key, buildResult) }

}
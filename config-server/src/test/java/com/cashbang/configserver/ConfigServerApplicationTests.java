package com.cashbang.configserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.SubscribableChannel;

@SpringBootTest
class ConfigServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testIntegration(){
        SubscribableChannel messageChannel = new DirectChannel();
        messageChannel.subscribe(msg->{
            System.out.println("receive:"+msg.getPayload());
        });
        messageChannel.send(MessageBuilder.withPayload("msgfrom alibaba").build());
    }

    /**
     * UnicastingDispatcher单播分发器，将消息分发到对应的消息通道MessageChannel中，
     * 只能选择一个消息通道。如何选择则是通过LoadBalancingStrategy负载均衡策略，默认只有轮询的实现
     */
    @Test
    public void testUnicastingDispatcher(){
        SubscribableChannel messageChannel = new DirectChannel();
        messageChannel.subscribe(msg->{
            System.out.println("receive1:"+msg.getPayload());
        });
        messageChannel.subscribe(msg->{
            System.out.println("receive2:"+msg.getPayload());
        });

        messageChannel.send(MessageBuilder.withPayload("msg from alibaba").build());
        messageChannel.send(MessageBuilder.withPayload("msg from  jd").build());
    }

    /**
     * BroadcastingDispatcher广播消息分发器，被PublishSubscribeChannel这个消息通道所使用。
     * 广播消息分发器会把消息分发给所有的MessageHandler
     */
    @Test
    public void testBroadcastingDispatcher(){
        SubscribableChannel messageChannel = new PublishSubscribeChannel();
        messageChannel.subscribe(msg->{
            System.out.println("receive1:"+msg.getPayload());
            System.out.println("receive1:"+msg.getHeaders());
        });
        messageChannel.subscribe(msg->{
            System.out.println("receive2:"+msg.getPayload());
            System.out.println("receive2:"+msg.getHeaders());

        });
        messageChannel.send(MessageBuilder.withPayload("msg from alibaba").build());
        messageChannel.send(MessageBuilder.withPayload("msg from jd").build());
    }

}

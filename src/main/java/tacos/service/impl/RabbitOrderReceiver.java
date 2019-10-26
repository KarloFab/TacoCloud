package tacos.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.amqp.support.converter.MessageConverter;
import tacos.domain.Order;
import tacos.service.OrderReceiver;

import javax.jms.JMSException;

@Component
public class RabbitOrderReceiver implements OrderReceiver {

    private RabbitTemplate rabbit;
    private MessageConverter converter;

    public RabbitOrderReceiver(RabbitTemplate rabbit, MessageConverter converter) {
        this.rabbit = rabbit;
        this.converter = converter;
    }

    @Override
    public Order receiveOrder() throws JMSException {
        Message message = rabbit.receive("tacocloud.orders");
        return message != null
                ? (Order) converter.fromMessage(message)
                : null;
    }
}

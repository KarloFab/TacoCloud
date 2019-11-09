package tacos.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.support.converter.MessageConverter;
import tacos.domain.Order;
import tacos.service.OrderReceiver;

import javax.jms.JMSException;

@Component
public class RabbitOrderReceiver implements OrderReceiver {

    private RabbitTemplate rabbit;
    private MessageConverter converter;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
        this.converter = rabbit.getMessageConverter();
    }

    @Override
    public Order receiveOrder() throws JMSException {
        Message message = rabbit.receive("tacocloud.orders");
        return message != null
                ? (Order) converter.fromMessage(message)
                : null;
    }
}

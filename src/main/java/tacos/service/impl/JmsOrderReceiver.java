package tacos.service.impl;

import org.springframework.jms.core.JmsTemplate;
import tacos.config.messages.MessageConverter;
import tacos.domain.Order;
import tacos.service.OrderReceiver;

import javax.jms.JMSException;
import javax.jms.Message;

public class JmsOrderReceiver implements OrderReceiver {
    private JmsTemplate jmsTemplate;
    private MessageConverter messageConverter;

    public JmsOrderReceiver(JmsTemplate jmsTemplate, MessageConverter messageConverter) {
        this.jmsTemplate = jmsTemplate;
        this.messageConverter = messageConverter;
    }

    @Override
    public Order receiveOrder() throws JMSException {
        Message message  = jmsTemplate.receive("tacocloud.order.queue");
        return (Order) messageConverter.messageConverter().fromMessage(message);
    }
}

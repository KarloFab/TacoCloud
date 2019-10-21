package tacos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import tacos.domain.Order;
import tacos.service.OrderMessagingService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class JmsOrderMessagingService implements OrderMessagingService {
    private JmsTemplate jmsTemplate;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms){
        this.jmsTemplate = jms;
    }

    @Override
    public void sendOrder(Order order) {
        jmsTemplate.send(session -> session.createObjectMessage(order));
    }
}

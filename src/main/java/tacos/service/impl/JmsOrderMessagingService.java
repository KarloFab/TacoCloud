package tacos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import tacos.domain.Order;
import tacos.service.OrderMessagingService;

import javax.jms.Destination;

public class JmsOrderMessagingService implements OrderMessagingService {
    private JmsTemplate jmsTemplate;
    private Destination orderQueue;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms, Destination destination){
        this.jmsTemplate = jms;
        this.orderQueue = destination;
    }

    @Override
    public void sendOrder(Order order) {
        jmsTemplate.send(
                orderQueue,
                session -> session.createObjectMessage(order));
    }

}

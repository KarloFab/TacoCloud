package tacos.service.impl;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import tacos.domain.Order;
import tacos.service.OrderMessagingService;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService {

    private RabbitTemplate rabbitTemplate;

    public RabbitOrderMessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendOrder(Order order) {
        MessageConverter messageConverter = rabbitTemplate.getMessageConverter();
        MessageProperties messageProperties = new MessageProperties();
        Message message = messageConverter.toMessage(order, messageProperties);
        rabbitTemplate.send("tacocloud.order", message);
    }
}

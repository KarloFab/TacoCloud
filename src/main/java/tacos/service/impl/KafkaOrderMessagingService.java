package tacos.service.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tacos.domain.Order;
import tacos.service.OrderMessagingService;

@Service
public class KafkaOrderMessagingService implements OrderMessagingService {

    private KafkaTemplate<String, Order> kafkaTemplate;

    public KafkaOrderMessagingService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(Order order) {
        kafkaTemplate.send("tacocloud.orders.topic", order);
    }
}

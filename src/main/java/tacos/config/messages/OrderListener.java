package tacos.config.messages;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tacos.domain.Order;

@Component
public class OrderListener {

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order){
        System.out.println(order);
    }
}

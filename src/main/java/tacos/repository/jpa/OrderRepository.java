package tacos.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import tacos.domain.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByZip(String deliveryZip);
}

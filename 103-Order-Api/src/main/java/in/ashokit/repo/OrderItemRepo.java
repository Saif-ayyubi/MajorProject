package in.ashokit.repo;

import in.ashokit.entity.Order;
import in.ashokit.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
}

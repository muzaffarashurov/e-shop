package uz.brogrammers.eshop.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.eshop.order.entity.OrderItem;


@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

}

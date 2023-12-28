package uz.brogrammers.eshop.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.eshop.order.entity.Order;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}

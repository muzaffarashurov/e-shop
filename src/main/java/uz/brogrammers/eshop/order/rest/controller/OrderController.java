package uz.brogrammers.eshop.order.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uz.brogrammers.eshop.order.entity.Order;
import uz.brogrammers.eshop.order.mapper.OrderMapper;
import uz.brogrammers.eshop.order.rest.dto.CreateOrderRequest;
import uz.brogrammers.eshop.order.rest.dto.OrderResponse;
import uz.brogrammers.eshop.order.service.OrderItemService;
import uz.brogrammers.eshop.order.service.OrderService;
import uz.brogrammers.eshop.product.model.ProductModel;
import uz.brogrammers.eshop.product.service.ProductService;
import uz.brogrammers.eshop.shipping.entity.Shipping;
import uz.brogrammers.eshop.shipping.service.ShippingService;
import uz.brogrammers.eshop.user.entity.User;
import uz.brogrammers.eshop.user.service.UserService;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Tag(name = "Order")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final UserService userService;
    private final ShippingService shippingService;
    private final ProductService productService;

    @Operation(summary = "Get Orders By User ID")
    @GetMapping("/user/{userId}")
    public List<OrderResponse> getOrdersByUseId(@PathVariable Integer userId) {
        return orderService.getAllByUserId(userId).stream()
                .map(OrderMapper::mapToDto)
                .toList();
    }

    @Operation(summary = "Get Orders By ID")
    @GetMapping("/{id}")
    public OrderResponse getOrdersById(@PathVariable Integer id) {
        return orderService.getOrderById(id).map(OrderMapper::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @Operation(summary = "Get All")
    @GetMapping("/")
    public List<OrderResponse> getAll() {
        return orderService.getAll().stream()
                .map(OrderMapper::mapToDto)
                .toList();
    }

    @Operation(summary = "Create Order")
    @PostMapping("/")
    public OrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        User user = userService.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        Shipping shipping = Shipping.builder()
                .address(request.getShipping().getAddress())
                .state(request.getShipping().getState())
                .name(request.getShipping().getName())
                .city(request.getShipping().getCity())
                .build();

        var savedShipping = shippingService.save(shipping);

        request.getItems().stream()
                .forEach(orderItem ->
                {
                    orderItem.setPrice(getProductPrice(orderItem.getProductId()));
                    orderItem.setId(orderItemService.save(orderItem).getId());
                });


        Order order = Order.builder()
                .items(request.getItems())
                .created(ZonedDateTime.now())
                .shippingId(savedShipping.getId())
                .userId(request.getUserId())
                .build();

        var orderModel = OrderMapper.mapToModel(order);
        return orderService.save(orderModel);

    }

    private BigDecimal getProductPrice(Integer productId) {
        return productService.findById(productId)
                .map(ProductModel::getPrice)
                .orElseThrow();
    }

}

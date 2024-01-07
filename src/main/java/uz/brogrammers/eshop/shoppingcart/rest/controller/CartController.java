package uz.brogrammers.eshop.shoppingcart.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uz.brogrammers.eshop.product.service.ProductService;
import uz.brogrammers.eshop.shoppingcart.entity.Cart;
import uz.brogrammers.eshop.shoppingcart.entity.CartItem;
import uz.brogrammers.eshop.shoppingcart.rest.dto.CreateCartItemRequest;
import uz.brogrammers.eshop.shoppingcart.service.CartItemService;
import uz.brogrammers.eshop.shoppingcart.service.CartService;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final CartItemService cartItemService;

    @GetMapping("/{id}")
    public Cart getById(@PathVariable Integer id) {
        return cartService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public List<Cart> getAll() {
        return cartService.findAll();
    }

    @PostMapping("/")
    public Cart create() {

        Cart cart = new Cart();
        cart.setCreated(ZonedDateTime.now());

        return cartService.save(cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cartService.deleteById(id);
    }


    @GetMapping("/{cartId}/items/{productId}")
    public Cart getShoppingCartItem(@PathVariable Integer cartId,
                                    @RequestBody CreateCartItemRequest request) {
        Cart cart = cartService.findById(cartId).orElseThrow();

        productService.findById(request.getProductId()).ifPresent(
                productModel -> {
                    CartItem item = CartItem.builder()
                            .quantity(request.getQuantity())
                            .productId(request.getProductId())
                            .build();

                    var shoppingCartItem = cartItemService.save(item);
                    cart.getItems().add(shoppingCartItem);
                    cartService.save(cart);
                }
        );

        return cart;
    }

    @PostMapping("/{cartId}/items")
    public Cart createcartItems(@PathVariable Integer cartId, @RequestBody CreateCartItemRequest request) {
        Cart cart = cartService.findById(cartId).orElseThrow();

        productService.findById(request.getProductId()).ifPresent(productModel -> {
            CartItem item = CartItem.builder()
                    .quantity(request.getQuantity())
                    .productId(request.getProductId())
                    .build();

            var shoppingCartItem = cartItemService.save(item);
            cart.getItems().add(shoppingCartItem);
            cartService.save(cart);
        });
        return cart;
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public Cart deleteCartItem(@PathVariable Integer cartId,
                               @PathVariable Integer productId) {
        var cart = cartService.findById(cartId).orElseThrow();
        cart.getItems().stream()
                .filter(item -> item.getProductId() == productId)
                .forEach(item -> {
                    cart.getItems().remove(item);
                    cartItemService.delete(item);
                    cartService.save(cart);
                });

        return cart;
    }

    @DeleteMapping("/{cartId}/clear")
    public Cart clearShoppingCart(@PathVariable Integer cartId){
        Cart cart= cartService.findById(cartId).orElseThrow();

        cart.removeiteme();
        cartService.save(cart);

        cart.getItems()
                .forEach(item->cartItemService.delete(item));

        return cart;
    }

}

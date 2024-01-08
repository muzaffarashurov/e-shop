package uz.brogrammers.eshop.shoppingcart.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uz.brogrammers.eshop.product.service.ProductService;
import uz.brogrammers.eshop.shoppingcart.entity.Cart;
import uz.brogrammers.eshop.shoppingcart.entity.CartItem;
import uz.brogrammers.eshop.shoppingcart.mapper.CartMapper;
import uz.brogrammers.eshop.shoppingcart.model.CartModel;
import uz.brogrammers.eshop.shoppingcart.rest.dto.CartResponse;
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

    @Operation(summary = "Get Cart By ID")
    @GetMapping("/{id}")
    public CartResponse getById(@PathVariable Integer id) {
        return cartService.findById(id)
                .map(CartMapper::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Get AllCart")
    @GetMapping("/")
    public List<CartResponse> getAll() {
        return cartService.findAll().stream()
                .map(CartMapper::mapToDto)
                .toList();
    }

    @Operation(summary = "Create new empty Cart")
    @PostMapping("/")
    public CartResponse create() {
        Cart cart = new Cart();
        cart.setCreated(ZonedDateTime.now());
        var cartModel = CartMapper.mapToModel(cart);
        var saved = cartService.create(cartModel);
        return CartMapper.mapToDto(saved);
    }

    @Operation(summary = "Delete Cart By ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cartService.deleteById(id);
    }

    @Operation(summary = "Get ShoppingCart Item By ID")
    @GetMapping("/{cartId}/items/{productId}")
    public CartResponse getShoppingCartItem(@PathVariable Integer cartId,
                                            @RequestBody CreateCartItemRequest request) {
        CartResponse cart = cartService.findById(cartId)
                .map(CartMapper::mapToDto)
                .orElseThrow();

        productService.findById(request.getProductId()).ifPresent(
                productModel -> {
                    CartItem item = CartItem.builder()
                            .quantity(request.getQuantity())
                            .productId(request.getProductId())
                            .build();

                    var shoppingCartItem = cartItemService.save(item);
                    cart.getItems().add(shoppingCartItem);
                    var cartModel = CartMapper.mapToModel(cart);
                    cartService.save(cartModel);
                }
        );

        return cart;
    }

    @Operation(summary = "Create Cart Item By ID")
    @PostMapping("/{cartId}/items")
    public CartResponse createCartItems(@PathVariable Integer cartId, @RequestBody CreateCartItemRequest request) {
        CartModel cart = cartService.findById(cartId).orElseThrow();

        productService.findById(request.getProductId()).ifPresent(productModel -> {
            CartItem item = CartItem.builder()
                    .quantity(request.getQuantity())
                    .productId(request.getProductId())
                    .build();

            var shoppingCartItem = cartItemService.save(item);
            cart.getItems().add(shoppingCartItem);
            cartService.save(cart);
        });
        return CartMapper.mapToDto(cart);
    }

    @Operation(summary = "Delete Cart Item")
    @DeleteMapping("/{cartId}/items/{productId}")
    public CartResponse deleteCartItem(@PathVariable Integer cartId,
                                       @PathVariable Integer productId) {
        var cart = cartService.findById(cartId).orElseThrow();
        cart.getItems().stream()
                .filter(item -> item.getProductId() == productId)
                .forEach(item -> {
                    cart.getItems().remove(item);
                    cartItemService.delete(item);
                    cartService.save(cart);
                });

        return CartMapper.mapToDto(cart);
    }

    @Operation(summary = "Clear Shopping Cart")
    @DeleteMapping("/{cartId}/clear")
    public CartResponse clearShoppingCart(@PathVariable Integer cartId) {
        CartResponse cart = cartService.findById(cartId)
                .map(CartMapper::mapToDto)
                .orElseThrow();

        cart.removeitems();
        var cartModel = CartMapper.mapToModel(cart);
        cartService.save(cartModel);

        cart.getItems()
                .forEach(item -> cartItemService.delete(item));

        return cart;
    }

}

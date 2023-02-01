package se.jensenyh.javacourse.saltmerch.backend.controller;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "http://localhost:3010")
public class CartController {

    @Autowired //
    CartService cartService;

    @GetMapping("/cart/{id}")
    public List<CartItem>getCartItems(@PathVariable int id)
    {
        return cartService.getCartItems();
    }
    @PatchMapping("/carts/{id}")
    public ResponseEntity<Void> updateCart(@PathVariable int id,
                                                      @RequestParam@Nullable String action,
                                                      @RequestBody CartItem item ) {
        if (action.equalsIgnoreCase("add")) {
            cartService.addCartItems(item);
//            if ("add".equals(action)) {
//            cartService.addCartItems(item);
        } else if ("remove".equals(action)) {
            cartService.deleteOrDecrementItems(item);

        }
            return ResponseEntity.status(200).build();



    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id,
                                                @RequestParam(required = false) boolean buyout) {
        if (id == 1) {
            cartService.deleteAllItemsOrRestock(buyout);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


}

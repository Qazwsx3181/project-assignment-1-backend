package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;
@RestController

public class CartService
{
    @Autowired
    CartRepository cartRepository;
    public int addCartItems(CartItem item) {
        return cartRepository.insertOrIncrementItem(item);
    }

    public List<CartItem> getCartItems() {

        return cartRepository.selectAllItems();
    }
    public void deleteAllItemsOrRestock(boolean buyout)
    {
        cartRepository.deleteAllItems(!buyout);
    }
    public int deleteOrDecrementItems(CartItem item){
        cartRepository.deleteOrDecrementItem(item);
        return 0;
    }



}

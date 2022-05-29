package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.Purchase;
import com.sha.springbootproductseller.repository.projection.PurchaseItem;

import java.util.List;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:37
 */
public interface PurchaseService
{
    // service layer does all the talking!!!

    Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseItemsOfUser(Long userId);
}

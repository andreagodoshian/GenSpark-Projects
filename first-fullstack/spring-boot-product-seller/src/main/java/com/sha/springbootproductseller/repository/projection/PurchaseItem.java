package com.sha.springbootproductseller.repository.projection;

import java.time.LocalDateTime;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:14
 */
public interface PurchaseItem
{
    // in Spring, we describe projections with interfaces
    // because for projections, we only need Getters

    String getName();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}

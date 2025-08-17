package com.example.market.dto.object.favoriteproduct;

import lombok.Data;

@Data
public class GetFavoriteSellerDto {
    
    private String title;

    private String sellerNic;

    private long isValid;

    private long sellerId;


}

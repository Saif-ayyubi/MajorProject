package in.ashokit.dto;

import lombok.Data;

@Data
public class OrderItemDto {

    private Integer itemId;
    private String imageUrl;
    private Integer Quantity;
    private Double unitPrice;
    private String productName;
}

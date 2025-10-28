package in.ashokit.dto;

import in.ashokit.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseOrderRequestDto {

    private CustomerDto customerDto;
    private AddressDto addressDto;
    private OrderDto orderDto;
    private List<OrderItemDto> orderItemDtos;
}

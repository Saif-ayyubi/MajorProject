package in.ashokit.service;

import in.ashokit.dto.OrderDto;
import in.ashokit.dto.PurchaseOrderRequestDto;
import in.ashokit.dto.PurchaseOrderResponseDto;

import java.util.List;

public interface OrderService {

    public PurchaseOrderResponseDto createOrder(PurchaseOrderRequestDto orderRequestDto);

    public PurchaseOrderResponseDto updateOrder(PurchaseOrderRequestDto orderRequestDto);

    public PurchaseOrderRequestDto cancelOrder(String orderTrackingNumber);
    public List<OrderDto> getCustomerOrders(String customerEmail);


}

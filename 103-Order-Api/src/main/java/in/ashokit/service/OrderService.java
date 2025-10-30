package in.ashokit.service;

import in.ashokit.dto.OrderDto;
import in.ashokit.dto.PurchaseOrderRequestDto;
import in.ashokit.dto.PurchaseOrderResponseDto;
import in.ashokit.dto.UpdateOrderRequestDto;

import java.util.List;

public interface OrderService {

    public PurchaseOrderResponseDto createOrder(PurchaseOrderRequestDto orderRequestDto) throws Exception;

    public PurchaseOrderResponseDto updateOrder(UpdateOrderRequestDto updateOrderRequestDto);

    public PurchaseOrderResponseDto cancelOrder(String orderTrackingNumber) throws Exception;
    public List<OrderDto> getCustomerOrders(String customerEmail);


}

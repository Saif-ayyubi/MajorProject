package in.ashokit.service;

import in.ashokit.dto.OrderDto;
import in.ashokit.dto.PurchaseOrderRequestDto;
import in.ashokit.dto.PurchaseOrderResponseDto;
import in.ashokit.repo.CustomerRepo;
import in.ashokit.repo.OrderItemRepo;
import in.ashokit.repo.OrderRepo;
import in.ashokit.repo.ShippingAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ShippingAddressRepo addressRepo;

    @Override
    public PurchaseOrderResponseDto createOrder(PurchaseOrderRequestDto orderRequestDto) {
        return null;
    }

    @Override
    public PurchaseOrderResponseDto updateOrder(PurchaseOrderRequestDto orderRequestDto) {
        return null;
    }

    @Override
    public PurchaseOrderRequestDto cancelOrder(String orderTrackingNumber) {
        return null;
    }

    @Override
    public List<OrderDto> getCustomerOrders(String customerEmail) {
        return List.of();
    }
}

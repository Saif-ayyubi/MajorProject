package in.ashokit.rest;

import in.ashokit.dto.OrderDto;
import in.ashokit.dto.PurchaseOrderRequestDto;
import in.ashokit.dto.PurchaseOrderResponseDto;
import in.ashokit.dto.UpdateOrderRequestDto;
import in.ashokit.response.ApiResponse;
import in.ashokit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("order")
    public ResponseEntity<ApiResponse<PurchaseOrderResponseDto>> createOrder(@RequestBody PurchaseOrderRequestDto orderRequestDto) throws Exception {

        ApiResponse<PurchaseOrderResponseDto> response = new ApiResponse<>();

        PurchaseOrderResponseDto orderResponseDto = orderService.createOrder(orderRequestDto);

        if (orderResponseDto != null) {
            response.setStatus(201);
            response.setMsg("Order Created");
            response.setData(orderResponseDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setStatus(500);
            response.setMsg("Order Failed");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/order")
    public ResponseEntity<ApiResponse<PurchaseOrderResponseDto>> updateOrder(@RequestBody UpdateOrderRequestDto orderRequestDto) throws Exception {

        ApiResponse<PurchaseOrderResponseDto> response = new ApiResponse<>();
        PurchaseOrderResponseDto orderResponseDto = orderService.updateOrder(orderRequestDto);

        if (orderResponseDto != null) {
            response.setStatus(200);
            response.setMsg("Order Updated");
            response.setData(orderResponseDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setStatus(500);
            response.setMsg("Order Update Failed");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cancel-order/{orderTrackingNum}")
    public ResponseEntity<ApiResponse<PurchaseOrderResponseDto>> updateOrder(@PathVariable String orderTrackingNum) throws Exception {

        ApiResponse<PurchaseOrderResponseDto> response = new ApiResponse<>();
        PurchaseOrderResponseDto orderResponseDto = orderService.cancelOrder(orderTrackingNum);

        if (orderResponseDto != null) {
            response.setStatus(200);
            response.setMsg("Order Cancelled");
            response.setData(orderResponseDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setStatus(500);
            response.setMsg("Order Cancel Failed");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customer-orders/email")
    public ResponseEntity<ApiResponse<List<OrderDto>>> getOrders(@PathVariable String email) throws Exception {

        ApiResponse<List<OrderDto>> response = new ApiResponse<>();
        List<OrderDto> customerOrders = orderService.getCustomerOrders(email);

        if (!customerOrders.isEmpty()) {
            response.setStatus(200);
            response.setMsg("Fetched Orders Successfully");
            response.setData(customerOrders);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setStatus(500);
            response.setMsg("Failed to fetch the orders");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



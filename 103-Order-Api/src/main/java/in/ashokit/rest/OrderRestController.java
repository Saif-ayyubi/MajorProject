package in.ashokit.rest;

import in.ashokit.dto.PurchaseOrderRequestDto;
import in.ashokit.dto.PurchaseOrderResponseDto;
import in.ashokit.response.ApiResponse;
import in.ashokit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}



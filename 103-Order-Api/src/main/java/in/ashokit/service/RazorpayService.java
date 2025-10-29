package in.ashokit.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {//write logic to integraqte our application with Razorpay

    @Value("${razorpay.key.id}")
    private String keyId;

    @Value("${razorpay.key.secret}")
    private String keySecret;

    @Autowired
    private RazorpayClient razorpayClient;//Predefined component

    public String createRazorpayOrder(Double amount) throws Exception{//for how much amount you want to create order//springboot app wants to communicate with Razorpay api for that we have "RazorpayClient"

        this.razorpayClient = new RazorpayClient(keyId,keySecret);//creating RazorpayClient obj. using our keyId,keySecret

        JSONObject orderRequest = new JSONObject();//to prepare order request for Razorpay Order


       //below setting Order Request data in JSON format
        orderRequest.put("amount",amount * 100);//amount in paisa
        orderRequest.put("currency", "INR");
        orderRequest.put("payment_capture",1);

        Order order = razorpayClient.Orders.create(orderRequest);//generate Order//creating Razorpay Order using RazorpayClient

        return order.get("id");//returning orderId

    }


}

package top.karmel.orderservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author BC
 * @Date 2025/2/21 10:06
 * @Version 1.0
 */
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String createOrder(@RequestParam String username,@RequestParam Integer productId) {
        String userserviceUrl = "http://localhost:8081/user?username=" + username;
        String productserviceUrl = "http://localhost:8083/product?productId=" + productId;
        String userInfo = restTemplate.getForObject(userserviceUrl, String.class);
        String productInfo = restTemplate.getForObject(productserviceUrl, String.class);
        String info = "订单信息：\n" + " " + userInfo + "\n" + " " + productInfo;
        return info;

    }
}

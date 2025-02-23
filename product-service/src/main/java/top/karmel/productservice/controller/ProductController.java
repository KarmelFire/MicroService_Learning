package top.karmel.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author BC
 * @Date 2025/2/21 10:21
 * @Version 1.0
 */
@RestController
public class ProductController {
    @GetMapping("/product")
    public String getProduct(@RequestParam Integer productId) {
        return "产品信息:" + productId;
    }
}

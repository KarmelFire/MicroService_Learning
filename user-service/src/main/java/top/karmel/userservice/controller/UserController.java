package top.karmel.userservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author BC
 * @Date 2025/2/21 9:38
 * @Version 1.0
 */
@RestController
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user")
    public String getUser(@RequestParam String username) {
        return "User: " + username;
    }

    @GetMapping("/chat")
    public String chatWithAI(@RequestParam String question) {
        String aiserviceUrl = "http://localhost:8084/ai?question=" + question;
        String aiInfo = restTemplate.getForObject(aiserviceUrl, String.class);
        String info = "回答为：" + " " + aiInfo;
        return info;

    }

    @GetMapping("/node")
    public String callNodeService() {
        String nodeServiceUrl = "http://localhost:8085/hello";
        return restTemplate.getForObject(nodeServiceUrl, String.class);
    }
}

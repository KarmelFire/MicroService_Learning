package top.karmel.aiservice.controller;

import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.karmel.aiservice.AIService;

import static top.karmel.aiservice.AIService.callWithMessage;

/**
 * @ClassName AIController
 * @Description TODO
 * @Author BC
 * @Date 2025/2/21 10:58
 * @Version 1.0
 */
@RestController
public class AIController {

    @GetMapping("/ai")
    public String chat(@RequestParam String question) throws NoApiKeyException, InputRequiredException {
        GenerationResult result = callWithMessage(question);
        return result.getOutput().getChoices().get(0).getMessage().getContent();
    }
}

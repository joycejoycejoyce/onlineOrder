package com.joyceeat.onlineorder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SignInController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/login")
    public void login(@RequestParam("error") String error, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401 验证失败
        Map<String, Object> data = new HashMap<>();
        data.put("message", "bad credentials");
        response.getOutputStream().println(objectMapper.writeValueAsString(data));
    }
}

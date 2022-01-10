package com.joyceeat.onlineorder;

import org.json.JSONObject;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.commons.io.IOUtils;



@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json = new JSONObject();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject json = new JSONObject(IOUtils.toString(req.getReader()));
        String email = json.getString("email");
        System.out.println("Email: " + email);

        resp.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        resp.getWriter().print(jsonResponse);

    }

    public void destroy() {
    }
}
package com.zhangqiang.web.controller;

import org.apache.log4j.Logger;
import org.slf4j.MDC;
import utils.log.LogUtil;
import utils.log.TraceIDUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Description:
 * @Author zhangqiang
 * @Date Created by 2018/7/10 on 下午3:05.
 */
public class ServletTest extends HttpServlet {
    private static Logger logger = Logger.getLogger(ServletTest.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        TraceIDUtils.addTraceID();
        TraceIDUtils.addURI(req);
        String acceptjson = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) req.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            acceptjson = sb.toString();
            System.out.print(acceptjson);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        req.getRequestDispatcher("www.baidu.com").forward(req,resp);
        Map<String, String> map = MDC.getCopyOfContextMap();
        for (Map.Entry<String, String> entry : map.entrySet()
                ) {
            LogUtil.warn("key={}----------->value={}", entry.getKey(), entry.getValue());
        }
        LogUtil.info("username={}", req.getParameter("username"));
        LogUtil.info("password={}", req.getParameter("password"));
        String[] hobbies = req.getParameterValues("hobby");
        Map<String, String[]> map1 = req.getParameterMap();
        LogUtil.info("map={}", map1);
        LogUtil.info("req={}", req);
        LogUtil.info("resp={}", resp);
        System.out.println("get");
        resp.setContentType("text/html;charset=UTF-8");
        int count = (int) this.getServletContext().getAttribute("count");
        resp.getWriter().println("<h1>您是第" + count + "位登录成功的用户！</h1>");

//        resp.sendRedirect("http://www.baidu.com");
//        String this.getInitParameter();
        Enumeration enumeration = this.getInitParameterNames();
        ServletContext servletContext = this.getServletContext();
        String name = this.getServletName();
        System.out.println(name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        TraceIDUtils.addTraceID();
        TraceIDUtils.addURI(req);

        String acceptjson = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) req.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            acceptjson = sb.toString();
            System.out.print(acceptjson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> map = MDC.getCopyOfContextMap();
        LogUtil.info("username={}", req.getParameter("username"));
        LogUtil.info("password={}", req.getParameter("password"));
        for (Map.Entry<String, String> entry : map.entrySet()
                ) {
            LogUtil.warn("key={}----------->value={}", entry.getKey(), entry.getValue());
        }

        LogUtil.info("ContextPath={}", req.getContextPath());

        req.getRequestDispatcher("www.baidu.com").forward(req, resp);
        LogUtil.info("req={}", req);
        LogUtil.info("resp={}", resp);
        System.out.println("post");
        resp.sendRedirect("www.baidu.com");
    }
}

package com.zhangqiang.web.controller;

import utils.log.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author zhangqiang
 * @Date Created by 2018/7/12 on 下午5:52.
 */
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Cookie[] cookies = req.getCookies();

        for (Cookie cook:cookies
             ) {
            LogUtil.info("cook={}",cook.getValue());
        }



        try {
            resp.setContentType("text/html;charset=UTF-8");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            LogUtil.info("username={},password={}",username,password);
            if(password!=null&&password.equals("1234")){
                resp.getWriter().println("<h1>登录失败：用户名或密码错误!</h1>");

            }else {

                int count = (int)this.getServletContext().getAttribute("count");
                count++;
                this.getServletContext().setAttribute("count",count);
                LogUtil.warn("count={}",count);
                resp.getWriter().println("<h1>登录成功:您好:"+username+"</h1>");
                resp.getWriter().println("<h3>页面将在5秒后跳转!</h3>");
                resp.setHeader("Refresh","10;/abc");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


//        resp.setStatus(404);

//        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        int count = 0;
        this.getServletContext().setAttribute("count",count);
    }
}

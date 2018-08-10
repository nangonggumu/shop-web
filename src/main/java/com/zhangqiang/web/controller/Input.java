package com.zhangqiang.web.controller;

import utils.log.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description:
 * @Author zhangqiang
 * @Date Created by 2018/8/2 on 下午3:19.
 */
public class Input extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        try {

            String start = req.getParameter("start");
            String end = req.getParameter("end");

            LogUtil.info("start={},end={}",start,end);


            StringBuffer sb = new StringBuffer("");

            FileReader reader = new FileReader("/Users/yoho8/Desktop/logs/all.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;

            while ((str = br.readLine()) != null){
                sb.append(str+"\r\n");
//                LogUtil.info(str);
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            LogUtil.error("e={}", e);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

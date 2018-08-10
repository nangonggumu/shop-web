package com.zhangqiang.web.controller;

import utils.log.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @Description:
 * @Author zhangqiang
 * @Date Created by 2018/7/18 on 上午10:03.
 */
public class DownloadServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogUtil.info("开始");
        String filename = req.getParameter("filename");
        filename = new String(filename.getBytes("iso-8859-1"),"UTF-8");
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/"+filename);
        filename = URLEncoder.encode(filename,"UTF-8");
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        String mimeType = this.getServletContext().getMimeType(filename);
        resp.setHeader("Content-Type",mimeType);
        ServletOutputStream os = resp.getOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while((len=is.read(b))!=-1){
            os.write(b,0,len);
        }

        resp.sendRedirect("/aaa");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

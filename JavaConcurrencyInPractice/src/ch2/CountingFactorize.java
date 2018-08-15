package ch2;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 黄世鹏
 * @date 2018/8/15 10:55
 * @description:
 */
public class CountingFactorize extends HttpServlet {
    private final AtomicLong count = new AtomicLong(0);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long l = count.incrementAndGet();
        System.out.println(l);
    }
}

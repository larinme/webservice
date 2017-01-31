package servlets;

import templator.VelocityHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorServlet extends HttpServlet {

    private Map<String, String> paramsMapping = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        paramsMapping.put("value", req.getParameter("key"));

        resp.getWriter().print(new VelocityHelper( "templates/mirror.vm", paramsMapping));
    }
}

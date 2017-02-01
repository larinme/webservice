package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingUpServlet extends HttpServlet {

    private AccountService accountService;

    public SingUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        resp.setContentType("text/html;charset=utf-8");
        if (login == null || pass == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            accountService.addNewUser(new UserProfile(login, pass, pass));
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().print("Registered: OK");
        }
    }
}

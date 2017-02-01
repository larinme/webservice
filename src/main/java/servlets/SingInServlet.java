package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

public class SingInServlet extends HttpServlet {

    private AccountService accountService;

    public SingInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        resp.setContentType("text/html;charset=utf-8");
        if (login == null || pass == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile userProfile = accountService.getUserProfile(login);
        if (userProfile == null || !pass.equals(userProfile.getPass())) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().print("Unauthorized");
        } else {
            accountService.addSession(req.getSession().getId(), userProfile);
            resp.getWriter().print(MessageFormat.format("Authorized: {0}", userProfile.getLogin()));
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}

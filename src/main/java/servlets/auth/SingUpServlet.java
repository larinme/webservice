package servlets.auth;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingUpServlet extends AuthorizationServlet {


    public SingUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        accountService.addNewUser(new UserProfile(login, password, password));
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().print("Registered: OK");
    }
}

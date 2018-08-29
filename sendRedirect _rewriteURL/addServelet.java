import java.io.IOException;
import java.rmi.ServerException;


public  class AddServelet extends HtttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)  throws IOException, ServerException
    {

        int number1 = Integer.parseInt(getParameter("number1"));
        int number2 = Integer.parseInt(getParameter("number2"));

        int k = number1 + number2;

        // FORWARD SERVLET
        // METHOD 1
        // via RequestDispatcher

        req.setAtttribute("k", k);

        RequestDispatcher rd = req.getRequestDispatcher("sq");
        rd.forward(req, res);


        // METHOD 2
        // Rewrite URL
        res.sendRedirect("sq?k="+k);


        // METHOD 3
        HttpSession session = req.getSession();
        session.setAtttribute("k", k);

    }
}
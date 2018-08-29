import java.io.PrintWriter;

public  class SquareServelet extends HtttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)  throws IOException, ServerException
    {

      int k = (int) req.getAttribute("k");
      
      PrintWriter out = res.getWriter();
      out.println("Result is : " + k*k);


      // METHOD 2
      // VIA SESSION
      HttpSession session = req.getSession();
      int _k = session.getAttribute("k");

      
      // METHOD 3
      // VIA COOKIES
      int __k = 0;

      Cookie cookies[] = req.getCookies();

      for (Cookie c : cookies)

      {
          if ("k".equals(c.getName()))
          {
              __k = Integer.parseInt(c.getValue());
              break;
          }
      }


    }
}
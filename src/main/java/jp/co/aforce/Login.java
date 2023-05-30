package jp.co.aforce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @param st 
	 * @param id 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, PrintWriter st, Object id) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
	
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/Login");
			Connection con=ds.getConnection();
			
			String sql = "select id, password from logintable";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			
			if(rset.next()) {
				request.setAttribute("id", id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("../jsp/success.jsp");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute(null, null);
				out.println("IDもしくはパスワードが違います。");
			}
			
			
			st.close();
			con.close();
			
		}catch (Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}

package Member_Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member.MemberDAO;
import Member.MemberVO;

/**
 * Servlet implementation class InsertController
 */

@WebServlet("/insert.do")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String manager;
		
		// 관리자인지 아닌지 판별
		if (id.equals("akxxkd")) {
			manager = "1";
		} else manager = "0";
		
		System.out.println("id : " + id);
		System.out.println("pwd : " + password);
		System.out.println("name : " + name);
		System.out.println("email : " + email);
		System.out.println("address : " + address);
		System.out.println("phoneNumber : " + phoneNumber);
		System.out.println("manager : " + manager);
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setEmail(email);
		vo.setAddress(address);
		vo.setPhoneNumber(phoneNumber);
		vo.setManager(manager);
		MemberDAO dao = new MemberDAO();
		try {
			dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("join   | id: " + id + ", password: " + password + ", manager: " + manager + ", address: " + address);
		System.out.println("------------------------------------------------------------------------");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
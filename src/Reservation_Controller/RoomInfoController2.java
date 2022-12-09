package Reservation_Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Reservation.RoomDAO;
import Reservation.RoomDTO;

@WebServlet({ "/rinfoP.do" })
public class RoomInfoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomid = request.getParameter("id");
		RoomDAO rdao=new RoomDAO();
		try {
			RoomDTO rInfo = rdao.selectRoom(roomid);
			HttpSession session=request.getSession();
			session.setAttribute("rinfo", rInfo);
			
			String start = (String)session.getAttribute("resv_start");
	         String end = (String)session.getAttribute("resv_end");
	         if(start.equals("")||end.equals("")) {
	            request.getRequestDispatcher("index.jsp?addr=reser.jsp&result=derror2").forward(request, response);
	            return;
	         }
			
			request.getRequestDispatcher("index.jsp?addr=payment.jsp").forward(request, response);	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

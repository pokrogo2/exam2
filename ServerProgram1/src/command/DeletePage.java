package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class DeletePage implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name3");
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		
		int result = MemberDAO.getInstance().delete(dto);
		try {
			
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<h1>");
				out.println("탈퇴되었습니다.");
				out.println("</h1>");
				out.println("<a href='ServerProgram1/login/join.jsp'>");
				out.println("회원가입");
				out.println("</a>");
			} 
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

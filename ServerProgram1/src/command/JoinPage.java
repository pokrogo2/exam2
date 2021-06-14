package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class JoinPage implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id1");
		String name = request.getParameter("name1");
		String grade = "bronze";
		int point = 1000;
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setGrade(grade);
		dto.setPoint(point);
		int result = MemberDAO.getInstance().join(dto);
		try {
			
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<h1>");
				out.println("가입되었습니다");
				out.println("</h1>");
				out.println("<a href='ServerProgram1/login.jsp'>");
				out.println("로그인");
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

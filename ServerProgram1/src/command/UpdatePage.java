package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdatePage implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id3");
		String name= request.getParameter("name3");
		int point = Integer.parseInt(request.getParameter("point3"));
		MemberDTO dto = new MemberDTO();
		if(point>=5000) {
			dto.setGrade("vip");
		}else if(point>=4000) {
			dto.setGrade("gold");
		}else if(point>=3000) {
			dto.setGrade("silver");
		}else {
			dto.setGrade("bronze");
		}
		int result = MemberDAO.getInstance().update(dto);
		try {
			
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>");
				out.println("location.href='ServerProgram1/login/manager.jsp'");
				out.println("</script>");
			} 
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

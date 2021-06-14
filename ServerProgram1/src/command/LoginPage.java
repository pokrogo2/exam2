package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LoginPage implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		MemberDTO login = MemberDAO.getInstance().login(dto);
		
		if (login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
		}
		return new ModelAndView("/ServerProgram1/login/manager.jsp",true);
	}

}

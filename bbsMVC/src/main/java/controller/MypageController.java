package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.UserService;
import model.UserVO;

@WebServlet("/mypage.do")
public class MypageController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String userId= (String) req.getSession().getAttribute("userId");
		  if(userId !=null) {
			  // 세션에 유저 정보가 있으면 index.jsp 페이지로 보냄 (로그인 할 필요가 없으나)
			  resp.sendRedirect("index.jsp"); 
			  //redirect 클라이언트에게 다시 요청하라고 전달  데이터를 안들고있음 인덱스 페이지는 외부 접근
		  }else {
			  
			  // forward는 정보를 해당 페이지로 전달  로그인 페이지를 해당글에 전달 포워드는
			  // 데이터를 들고 전달 분리시킨거임 확장자 web-inf 내부적으로 연결
			  req.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(req, resp);
		    	resp.sendRedirect("mypage.jsp");
		    	
		    	/*String userId = null;
	if(session.getAttribute("userId") != null){
		userId = (String)session.getAttribute("userId");
	}else{
		//client 에게 login.jsp로 다시 요청하도록 지시
		response.sendRedirect("login.jsp");
	}				// 리 다이렉트 - 재요청 지시 = 로그인 페이지로 재요청을 해라
	//user_id 가 있을경우 user의 상세정보를 조회
	UserService service = UserService.getInstance();
	UserVO vo = service.userInfo(userId);
	pageContext.setAttribute("user",vo);
		    	 * 
		    	 *  
		    	 * */
		  }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post로 요청옴");
	    UserService service =UserService.getInstance();
	    UserVO vo= service.loginUser(req.getParameter("userId")
	    		                        ,req.getParameter("userPw"));
	    if(vo !=null) {
	    	HttpSession session =req.getSession();
	     	session.invalidate();   //세션 초기화
	    }else {
	  	  req.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(req, resp);
	    	resp.sendRedirect("mypage.jsp");
	 }
   }
}
<%@page import="jdbc.UserVO"%>
<%@page import="jdbc.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>mypage</title>
</head>
<%
	String userId = null;
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

%>
<body>
<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>

		
<!-- content 영역 -->
      <div class="container-fluid">
         <div class="row align-items-center" style="height:700px">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
          <form action="joinAction.jsp" method="post">   <!-- 위에 있던 .needs-validation 추가해준것.-->
            <h3   style="text-align: center; padding-bottom: 5%; padding-top: 15%;">마이페이지</h3>
            <div class="form-group">
              <input type="text"  value="${user.userId}"disabled class="form-control" 
              placeholder="아이디"    name="userId" maxlength="20" >  
              <input type="hidden" value="${user.userId }" class="form-control"
               placeholder="아이디"    name="userId" maxlength="20" > 
              <div class="invalid-feedback">  <!-- 필수 입력요소 없을 때 메시지 출력해주는 div-->
                아이디는 필수입니다.
              </div>
            </div>
            <div class="form-group pt-1">
              <input type="password" value="${user.userPw}"disabled class="form-control" 
              placeholder="비밀번호" name="userPw" maxlength="20" >
              <div class="invalid-feedback">
                비밀번호는 필수입니다.
              </div>
            </div>
            <div class="form-group pt-1" style="padding-bottom: 5%;">
              <input type="text"  value="${user.userNm}" disabled class="form-control"
              placeholder="이름" name="userNm" maxlength="20" >
              <div class="invalid-feedback">
                이름은 필수입니다.
              </div>
              <input type="submit" class="btn btn-success form-control" value="수정">
            </div>
          </form>
        </div>
        <div class="col-lg-4">
        </div>
         </div>
       </div>
<!-- content 영역 끝 -->

<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</body>
</html>
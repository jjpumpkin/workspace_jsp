<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/list.js/2.3.1/list.min.js"></script>
</head>

<body>

<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include> <!--  동적 포함  -->
   
<script>
   
   $(document).ready(function(){
      let options = {
            valueNames : ["nm","title","readCount","updateDt"]
      ,page :10
      ,pagination :true
      };
      let bbsList = new List("bbs",options)
   });
   
   
   </script>
   
<!-- content 영역 -->
   <main class="container-fluid p-3">
      <div class="row d-flex align-items-center"  style="height: 600px;">
         <div class="col-lg-1"></div>
         <div class="col-lg-10" id="bbs">
         <!-- 검색 부분 -->
                <div class="input-group">
                    <input type="text" class="search form-control" placeholder="search">
                    <button class="sort btn input-group-text" data-sort="nm">종목명</button>
                </div>
         
            <table class="table table-striped" style="text-align:center;" >
               <thead>
                  <tr>
                     <th style="background-color: #eeeeee; text-align:center">번호</th>
                     <th style="background-color: #eeeeee; text-align:center">제목</th>
                     <th style="background-color: #eeeeee; text-align:center">조회수</th>
                     <th style="background-color: #eeeeee; text-align:center">수정일</th>
                  </tr>
               </thead>
               <tbody class ="list">
               <!--  jstl c rag foreach 화면에서 for 사용 가능 -->
               <!--  var 에 표기한 키워드로 -->
               
                  <c:forEach var="item" items ="${arr}">
                     <tr>
                     <td class ="nm">${item.nm }</td>
                     <td class ="title">${item.title }</td>
                     <td class ="readCount">${item.readCount }</td>
                     <td class ="updateDt">${item.updateDt }</td>
                     </tr>
                  </c:forEach>
                  
                  
                  
               </tbody>
            </table>
            <div class = "d-flex justrify-content-center">
               <ul class= "pagination"></ul>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
               <a href="write.jsp" class="btn btn-dark pull-right" role="button" >글쓰기</a>
            </div>
         </div>
         <div class="col-lg-1">
         </div>
      </div>
   </main>
    <!-- content 영역 끝 -->
<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</body>
</html>
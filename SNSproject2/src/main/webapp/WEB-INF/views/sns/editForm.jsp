<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type = "javascript" src = "resources/jquery-3.1.1.min.js"></script>
 <script type="text/javascript">
	 $(function () {
	
	     $('#password').data('holder', $('#password').attr('placeholder'));
	
	     $('#password').focusin(function () {
	         $(this).attr('placeholder', '');
	     });
	     $('#password').focusout(function () {
	         $(this).attr('placeholder', $(this).data('holder'));
	     });
	     
	 });
	 
	 function chk(){

		document.form2.submit();
	 }
 </script>
</head>
<body>

<h1>회원정보 수정</h1>

<form name="form2" action = "UpdateInfo" method="post">
	<input type = "text" id = "member_name" value = "${sessionScope.userLoginInfo.member_name}" name="member_name" onfocus="clearText(this)" disabled="disabled"><br>
           <input type = "text" id = "member_id" value = "${sessionScope.userLoginInfo.member_id}" name="member_id" onfocus="clearText(this)" onkeyup="CheckEmail()" onkeydown = "check_Overlap_Id()" disabled="disabled"><br>
           <div id="checkId"></div> <!-- 이메일 유효성 체크 메세지 -->
           <div id="checkOverlap"></div> <!-- 아이디 중복 검사 메세지 -->
           <input type = "password" id = "member_password" placeholder = "비밀번호" name="member_password" onfocus="clearText(this)" onkeyup="CheckPassword()">
           <div id="checkPwd"></div> <!-- 비밀번호 유효성 체크 메세지 -->
           <input type = "password" id = "password_re" placeholder = "비밀번호 재입력" onfocus="clearText(this)" onkeyup="CheckValue()">
           <div id="checkValue"></div> <!-- 비밀번호 일치 여부 메세지  -->
          
 		   <select  name="password_q" >
	         <option value="">질문 </option>
			 <option value="아버지의 성함은?">아버지의 성함은?</option>
			 <option value="가장 좋아하는 색깔은?">가장 좋아하는 색깔은?</option>
			 <option value="가장 좋아하는 음식은?">가장 좋아하는 음식은?</option>
	       </select>  
	       
	       <input type = "text" id = "password_a" name="password_a" placeholder = "비밀번호 찾기 답변" onfocus="clearText(this)"><br>         
          
           <select name="member_birth_y">
	         <option value="">연도 </option>
		         <c:forEach var="member_birth" begin="1980" end="2016" step="1">
		        	 <option value=${member_birth}>${member_birth}</option>
		         </c:forEach>
	       </select>  
	       <select name="member_birth_m">
	         <option value="">월 </option>
		         <c:forEach var="member_birth" begin="1" end="12" step="1">
		        	 <option value=${member_birth}>${member_birth}</option>
		         </c:forEach>
	       </select>
	       <select name="member_birth_d">
	         <option value="">일 </option>
		         <c:forEach var="member_birth" begin="1" end="31" step="1">
		    		 <option value=${member_birth}>${member_birth}</option>
	          	 </c:forEach>
           </select>
           <input type="hidden" name="member_birth" id="member_birth" value="">
             <br><input type="radio" id= "1" name="member_sex" value="FEMALE">여성
                 <input type="radio" id = "1" name="member_sex" value="MALE">남성<br><br>
             <input type="button" value="수정" onClick="chk()"/>
</form>
</body>
</html>
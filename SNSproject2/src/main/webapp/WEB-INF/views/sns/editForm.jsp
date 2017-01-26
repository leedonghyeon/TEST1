<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>회원정보 수정</h1>

<form action = "editMember" method="post">
	<input type = "text" id = "name" value = "이름" name="member_name" onfocus="clearText(this)"><br>
           <input type = "text" id = "id" value = "이메일" name="member_id" onfocus="clearText(this)" onkeyup="CheckEmail()" onkeydown = "check_Overlap_Id()"><br>
           <div id="checkId"></div> <!-- 이메일 유효성 체크 메세지 -->
           <div id="checkOverlap"></div> <!-- 아이디 중복 검사 메세지 -->
           <input type = "password" id = "password" value = "비밀번호" name="member_password" onfocus="clearText(this)" onkeyup="CheckPassword()">
           <div id="checkPwd"></div> <!-- 비밀번호 유효성 체크 메세지 -->
           <input type = "password" id = "password_re" value = "비밀번호" onfocus="clearText(this)" onkeyup="CheckValue()">
           <div id="checkValue"></div> <!-- 비밀번호 일치 여부 메세지  -->
          
 		   <select  name="password_q" >
	         <option value="">질문 </option>
			 <option value="아버지의 성함은?">아버지의 성함은?</option>
			 <option value="가장 좋아하는 색깔은?">가장 좋아하는 색깔은?</option>
			 <option value="가장 좋아하는 음식은?">가장 좋아하는 음식은?</option>
	       </select>  
	       
	       <input type = "text" id = "password_a" name="password_a" value = "비밀번호답변" onfocus="clearText(this)"><br>         
          
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
             <input type="button" value="계정	 만들기" onClick="Check_input_form()"/>
</form>
</body>
</html>
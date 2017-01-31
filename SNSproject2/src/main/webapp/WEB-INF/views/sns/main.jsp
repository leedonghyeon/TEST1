<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page </title>
<script>
function btnClick(){
	document.form2.action = 'findpeople';
	document.form2.submit();
}
</script>
</head>
	<body>
		<form name='form1' action="main">
		    <h2>회원 전용 페이지</h2>
		    ${sessionScope.userLoginInfo.member_name}님으로 로그인 하셨습니다.<br>
		    ${sessionScope.userLoginInfo.member_id}님 환영합니다<br>
	  
		    <input type="button" value="로그아웃" onclick="location.href='logout.do'">  
		    <input type="button" value="친구조회" onclick="location.href='Myfriend'">
		    <input type="button" value="회원수정페이지" onclick="location.href='memberUpdateForm.do'"> 
		    <input type="button" value="회원탈퇴" onclick="location.href='deleteForm.do'">
		
		</form> 
		   <br>
		  <form name='form2' action="findpeople">
		   <input type="text" value="찾고자하는 이름" name="member_name" onfocus="clearText(this)">
		   <input type="button" value="찾기" onclick="btnClick()" >
	      </form> 
	</body>
</html>

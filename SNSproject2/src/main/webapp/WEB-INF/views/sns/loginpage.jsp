<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>로그인 </title>
	<script type="text/javascript">

	   function Login()
	   {
	        var form = document.form1;
	
            //아이디에서 입력 필수 조건문
            if (form.member_id.value == "")
            {
                    alert("아이디를 입력하세요!");
                    form.member_id.focus();//포커스를 id박스로 이동.
                    return false;
            }
            
            //비밀번호에서 입력 필수 조건문
            if (form.member_password.value == "")
            {
                 alert("패스워드를  입력하세요!");
                 form.member_password.focus();//포커스를 Password박스로 이동.
                 return false;
            }
            
            form.submit();
	   }
	
    </script>
</head>
<body>
<c:choose>
	<c:when test="${not empty sessionScope.userLoginInfo}">
		<h2>로그인 성공 </h2>
		${sessionScope.userLoginInfo.member_name}님, 안녕하세요. 로그인 되었습니다!<br>
		<a href="main.jsp">메인페지</a>
		<br>
		<br>
		<a href="logout">로그아웃</a>
		<br><br>
		<!-- <a href="page1">페이지1</a>&nbsp;&nbsp;<a href="page2">페이지2</a> -->
	</c:when>
	<c:otherwise>
		<h1>로그인</h1>
		<form name="form1" method="post" action="loginProcess" onSubmit="return Login()">
			<table>
				<tr height="40px">
					<td>Email: <br></td>
					<td><input type="text" name="member_id"></td>
				</tr>
				<tr height="40px">
					<td>Password:<br></td>
					<td><input type="password" name="member_password"></td>
				</tr>
			</table>
			<table>
				<tr>
					<td align="center"><input type="submit" value="로그인"></td>
					<td align="center"><input type="reset" value="초기화"></td>
				</tr>
			</table>
			<br><a href="application">계정 만들기</a>
			<br><a href="pass">비밀번호찾기</a>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>
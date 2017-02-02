<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page </title>
</head>
<style type="text/css">
		table{
			height:10px;
			margin:auto;
			}
	</style>
	<body class="subpage">
<header id="header">
				<div class="inner">
					<a href="review" class="logo"><strong> &nbsp; &nbsp;눈</strong></a>
					<nav id="nav">
						<a>게시판</a>
						<a href="info">내정보 &nbsp; &nbsp;</a>
					</nav>
					<a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
				</div>
			</header>
			
		<form action="fdpassword">
		    <h2>회원 전용 페이지</h2>
		    <table>
		    	<tr>
		    		<td><input type="button" value="회원수정페이지" onclick="location.href='memberUpdateForm'"></td>
		    		<td><input type="button" value="회원탈퇴" onclick="location.href='deleteForm'"></td>
		    	</tr>
		    </table>
	    </form><br>
	    
	    
	</body>
</html>

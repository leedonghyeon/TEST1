<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호찾기</title>
      <script type="text/javascript">
	       window.onload = function(){
    	   var msg = '${msg1}';
    	   
    	   if ( msg != '')	   alert('${msg1}');
       }
  </script>
</head>
<body>
<form name="form1" method="post" action="findpassword" >
아이디 <input type="text" id="member_id" value="id" name="member_id" onfocus="clearText(this)"><br>
이름   <input type="text" id="member_name" value="name" name="member_name" onfocus="clearText(this)"><br>
비밀번호 질문
           <select >
	         <option value="">질문</option>
			 <option value=" ">아버지의 성함은?</option>
			 <option value="">가장 좋아하는 색깔은?</option>
			 <option value="">가장 좋아하는 음식은?</option>
	       </select><br>
비밀번호 답변 <input type = "text" id = "password_a" name="password_a" value = "비밀번호답변" onfocus="clearText(this)"><br>

<input type="submit" value="조회"> 
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호변경</title>
        <meta charset="utf-8" >
        <script type="text/javascript">
	       window.onload = function(){
    	   alert('${msg}');
       } 
  		//비밀번호 유효성 검사
        function CheckPassword(){
	        var pw1 = document.getElementById("password");
	    
	        if(!/^[a-zA-Z0-9]{8,20}$/.test(pw1.value))
	
	        { 
	        	document.getElementById('checkPwd').style.color = "red";
	        	document.getElementById('checkPwd').innerHTML = "비밀번호는 숫자와 영문자 조합으로 8~20자리를 사용해야 합니다.";
	        }	       
	        else{
	        	document.getElementById('checkPwd').style.color = "green";
	        	document.getElementById('checkPwd').innerHTML = "적절한 비밀번호 입니다.";
	        }
	        var chk_num = pw1.value.search(/[0-9]/g); 
	        var chk_eng = pw1.value.search(/[a-z]/ig);
	
	        if(chk_num < 0 || chk_eng < 0)
	        { 
	        	document.getElementById('checkPwd').style.color = "red";
	        	document.getElementById('checkPwd').innerHTML = "비밀번호는 숫자와 영문자를 혼용하여야 합니다.";
	            return false;
	        }
        }
 
        function CheckValue(){
        	if(document.form1.password.value != document.form1.password_re.value){
        		document.getElementById('checkValue').style.color = "red";
	        	document.getElementById('checkValue').innerHTML = "비밀번호가 일치하지 않습니다.";
        	}
        	else{
        		document.getElementById('checkValue').innerHTML ="";
        	}
        }
        </script>
</head>
<body>
<form name="form1" method="post" action="updatepassword" >
아이디 <input type="text" id="id" value="${joinmember.member_id }" name="member_id" onfocus="clearText(this)"><br>
이름   <input type="text" id="name" value="${joinmember.member_name }" name="member_name" onfocus="clearText(this)"><br>
비밀번호 질문
           <select   >
	         <option value="">질문 </option>
			 <option value=" ">아버지의 성함은?</option>
			 <option value="">가장 좋아하는 색깔은?</option>
			 <option value="">가장 좋아하는 음식은?</option>
	       </select><br>
비밀번호 답변 <input type = "text" id = "password_a" name="password_a" value = "${joinmember.password_a}" onfocus="clearText(this)"><br>

새비밀번호 <input type="password" id="password" value="새비밀번호" name="member_password" onfocus="clearText(this)" onkeyup="CheckPassword()"><br>
 <div id="checkPwd"></div>
새비밀번호 확인 <input type="password" id="password_re" value="확인"  onfocus="clearText(this)" onkeyup="CheckValue()"><br>
 <div id="checkValue"></div>
<input type="submit" value="수정"> 
</form>
</body>
</html>
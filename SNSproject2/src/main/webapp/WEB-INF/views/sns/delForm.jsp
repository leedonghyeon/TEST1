<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ȸ��Ż��</title>
</head>

<script language="javascript">
  
    function begin(){
      	document.deleteform.member_password.focus();
    }

    function checkIt(){
 		if(!document.deleteform.member_password.value){
	        alert("��й�ȣ�� �Է��ϼ���.");
	        document.deleteform.member_password.focus();
	        return false;
      	}
 		else{
 			alert("������ Ż���Ͻðڽ��ϱ�?");
 			confirm("Ż��Ǿ����ϴ�.");
 			document.location.href = "loginForm";
 			return true;
 		}
 		return true;
 	}   
    	
    window.onload = function(){
 	   var msg = '${msg1}';
 	   
 	   if ( msg != '')	   alert('${msg1}');
    }
    
</script>
<body onload="begin()">
    <h1>ȸ��Ż�� ������</h1>

    <form name="deleteform" action="delete" method="post" onSubmit="return checkIt()"> 
        <TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
        <TR height="30">
            <TD colspan="2" align="middle">
                <font size="+1" ><b>ȸ�� Ż��</b></font>
            </TD>
        </TR>
        
        <TR height="30">
            <TD width="110" align=center>��й�ȣ</TD>
            <TD width="150" align=center>
                <INPUT type=password name="member_password"  size="15" maxlength="12">
            </TD>
        </TR>
        
        <TR height="30">
            <TD colspan="2" align="middle">      	
                <input type="submit" value="Ż��"> 
                <input type="button" value="���" onclick="alert('ȸ��Ż�� ����մϴ�.'); history.back(); ">
            </TD>
        </TR>
        </TABLE>
    </form>
</body>
</html>
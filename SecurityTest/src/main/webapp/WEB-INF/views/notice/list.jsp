<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

@media print {
    body * {
        display: none;
    }

    .print-section, .print-section * {
        display: block;
    }
   
}

</style>
</head>
<body>
	 <div class="print-section">
        <h3>NOTICE LIST : access to all</h3>
        <hr/>
    </div>
	
	<div><div>
    <p>기본정보 </p>
    <button class="print" onclick="printPage()"><b>출력</b></button> 
	</div>
		<a href="/notice/register">등록</a>
	</div>
	
	<div>
		<a href="/">HOME</a>
	</div>
</body>
<script type="text/javascript">

function printPage(){
    window.print();
}

</script>
</html>
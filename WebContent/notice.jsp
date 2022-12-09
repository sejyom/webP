<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>공지사항</title>
<h3 style="color: #EB6952;">공지사항</h3> <br>
<style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
	}
	h3 { text-align: center; }
</style>
<br>
</head>
<body>
<section id="content">
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
						<tr>
						<td>3</td>
						<td><a href="index.jsp?addr=notice3.jsp">SSH호텔 COVID 19 고객 정책</a> </td> 
						<td>2022-12-01</td>
						</tr>
						
						<tr>
						<td>2</td>
						<td><a href="index.jsp?addr=notice2.jsp">SSS호텔 개인정보처리방침 개정안내</a> </td> 
						<td>2022-06-01</td>
						</tr>
						
						<tr>
						<td>1</td>
						<td><a href="index.jsp?addr=notice1.jsp">호텔 체크 아웃시간 안내</a> </td> 
						<td>2022-03-11</td>
						</tr>
					</tbody>
			</table>
		</div>
	</div>
</section>
</body>
</html>
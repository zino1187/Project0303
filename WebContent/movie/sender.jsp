<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script>
 //이 영역은 프로그래밍 영역!!! 단 실행위치는 jsp와 같은 서버가 아니라
 //이미 요청이 끝난 이후 시점인 클라이언트측에서 실행된다..
 //따라서 javascript와 같은 언어를 가리켜 클라이언트 스크립트라 한다
//자바스크립트에서는 개발자가 정의한 함수를 사용자 정의함수라 하며
//함수명 앞에 function 키워드를 반드시 붙여야 한다!!
//
//문서가 모두~~~로드되었을때...
$(document).ready(function(){
	//버튼을 누르면..
	$("button").click(function(){
		send();
	});
});
function send(){
	//서버에 전송하자!!! ( post)
	$("form").attr("method","post");//전송방법 결정
	$("form").attr("action", "/movie");//요청 주소??
	$("form").submit();//전송!!			
}
 </script>
</head>
<body>
	<form>
		<select name="movie">
			<option>영화 선택하세요</option>			
			<option value="극한직업">극한직업</option>			
			<option value="아이언맨3">아이언맨3</option>			
			<option value="증인">증인</option>			
		</select>
	</form>
	<button>평가 요청</button>
</body>
</html>












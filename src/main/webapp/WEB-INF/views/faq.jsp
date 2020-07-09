<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
  <title>고용량 오메가3 함요 : 자연방사유정란 오메란</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <!--<link href="css/common.css" rel="stylesheet" type="text/css">-->
  <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" />
  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/common.js"></script>
</head>

<body>
  <div id="omeran_pc_all">

    <header id="p2_header">

      <jsp:include page="./popupMail.jsp"></jsp:include>

      <img src="img/p1_top_banner.png" class="p2_top_banner">
      <a href="index" class="p2_top_logo" id="p1_top_logoc"><img src="img/p1_top_logo.png" alt=""></a>
      <div class="p2_util p1_util">
        <jsp:include page="./topRight.jsp"></jsp:include>
      </div>
      <div class="p2_menu01" id="p1_menu01">
        <jsp:include page="./menuLeft.jsp"></jsp:include>
      </div>
      <div class="p2_menu02" id="p1_menu02">
        <jsp:include page="./menuRight.jsp"></jsp:include>
      </div>
    </header>
    
    <jsp:include page="./login.jsp"></jsp:include>

    <div class="faq-mid">
      <div class="faq-mid-menu">
        <p class="faq-title">FAQ </p>
        <div class="faq-mid-line"></div>
        
	    <div class="faq-div">
	      <form id="faqSearch" action="">
  	        <input type="text" id="input_id" class="faq-input" placeholder="제목을 검색해주세요.">
	        <input type="submit" class="faq-submit" value="검색하기">
	        <input type="button" class="faq-submit" value="글쓰기">
	      </form>
	    </div>
        
        <div class="faq-table">
          <table>
	          <tr>
			    <th>글 번호</th>
			    <th>질문 내용</th>
			   	<th>글쓴이</th>
			    <th>조회수</th>
			  </tr>
			  <tr>
			    <td>4</td>
			    <td>[결재/배송] 이게 질문입니다.</td>
			    <td>관리자 </td>
			    <td>25</td>
			  </tr>
			  <tr>
			    <td>3</td>
			    <td>[회원가입] 이게 질문입니다. 2트 </td>
			    <td>관리자</td>
			    <td>25</td>
			  </tr>
			  <tr>
			    <td>2</td>
			    <td>[회원가입] 이게 질문입니다. 33트 </td>
			    <td>관리자</td>
			    <td>82</td>
			  </tr>
			  <tr>
			    <td>1</td>
			    <td>[기타] 이게 질문입니다. 4트 </td>
			    <td>관리자</td>
			    <td>83</td>
			  </tr>
			  <tr>
			    <td>4</td>
			    <td>[결재/배송] 이게 질문입니다.</td>
			    <td>관리자 </td>
			    <td>25</td>
			  </tr>
			  <tr>
			    <td>3</td>
			    <td>[회원가입] 이게 질문입니다. 2트 </td>
			    <td>관리자</td>
			    <td>25</td>
			  </tr>
			  <tr>
			    <td>2</td>
			    <td>[회원가입] 이게 질문입니다. 33트 </td>
			    <td>관리자</td>
			    <td>82</td>
			  </tr>
			  <tr>
			    <td>1</td>
			    <td>[기타] 이게 질문입니다. 4트 </td>
			    <td>관리자</td>
			    <td>83</td>
			  </tr>
          </table>
          <div>
	         <ul>
		         <li class="page-num"><a class="page-num-selected" href="#"> 1 </a></li>
		         <li class="page-num"><a href="#"> 2 </a></li>
		         <li class="page-num"><a href="#"> 3 </a></li>
		         <li class="page-num"><a href="#"> 4 </a></li>
		         <li class="page-num"><a href="#"> 5 </a></li>
		         <li class="page-num"><a href="#"> 6 </a></li>
		         <li class="page-num"><a href="#"> 7 </a></li>
		         <li class="page-num"><a href="#"> 8 </a></li>
		         <li class="page-num"><a href="#"> 9 </a></li>
		         <li class="page-num"><a href="#"> 10 </a></li>
		         <li class="page-num"><a href="#"> 다음 </a></li>
	         </ul>
          </div>
        </div>
      </div>
    </div>

    <jsp:include page="./footer.jsp"></jsp:include>
  </div>

  <!-- 모바일 시작 -->
  <div id="omeran_mob_all">  
    <div id="m_index">
      <img src="img/m_index.png" id="m_main_img">
      <a href="p1.html" id="m_logo_area"></a>

      <div id="m_p1_header">
        <jsp:include page="./mobMenu.jsp"></jsp:include>
      </div>

      <div id="m_p1_foo_menu">
        <ul>
          <li><a href="#" class="m_index_main">오메란의 특별한 생산환경</a></li>
          <li><p>|</p></li>
          <li><a href="#" class="m_index_main">오메란의 오메가 함유</a></li>
          <li><p>|</p></li>
          <li><a href="#" class="m_index_main">오메가3의 장점</a></li>
        </ul>
      </div>

    </div>

    <div id="m_p1_footer">
      <jsp:include page="./mobFooter.jsp"></jsp:include>
    </div>
  </div>

</body>

</html>
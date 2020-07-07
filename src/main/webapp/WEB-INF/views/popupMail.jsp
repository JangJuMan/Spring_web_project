<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
  <title>고용량 오메가3 함요 : 자연방사유정란 오메란</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/common.js"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- 여기에 스크립트 추가 -->
  <script src='https://www.google.com/recaptcha/api.js'></script>

  <script>
    $(document).ready(function() {
      $("#test_btn").click(function() {
        $.ajax({
          url: 'VerifyRecaptcha',
          type: 'post',
          data: {
            recaptcha: $("#g-recaptcha-response").val()
          },
          success: function(data) {
            switch (data) {
              case 0:
                alert("자동 가입 방지 봇 통과");
                document.getElementById("captcha").style.display = "";
                break;

              case 1:
                alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
                break;

              default:
                alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
                break;
            }
          }
        });
      });
    });
  </script>

</head>

<body>
  <div class="dim-layer">
    <div class="dimBg" style="cursor: pointer" onclick="$('.dim-layer').fadeOut()"></div>
    <div id="form-mail-popup" class="pop-layer">
      <div class="pop-container">
        <div class="pop-conts">
          <!--content //-->
          <div class="popup-container">
<<<<<<< HEAD
            <h4 class="popup-title">사이트 관리자에게 문의 바랍니다.</h4>
            <p>오메란 웹 사이트의 회원 신청이 비활성화 되었습니다. 관리자에게 문의 바랍니다.</p>

            <form action="${pageContext.request.contextPath}/mailSending" method="post">
              <div align="center">
                <!-- 받는 사람 이메일 -->
                <input type="hidden" name="tomail" placeholder="보낼 사람의 이메일을 입력해 주세요" value="21300506@handong.edu" class="form-control">
=======
            <h4 class="popup-title">문의하기</h4>
            <p class="popup-content">오메란 웹 사이트의 회원 신청이 비활성화 되었습니다. 관리자에게 문의 바랍니다.</p>

            <form id="mailForm" onsubmit="return check('mailForm')" action="${pageContext.request.contextPath}/mailSending" method="post" >
              <div align="center">
                <!-- 받는 사람 이메일 -->
                <!-- <input type="hidden" name="tomail" placeholder="보낼 사람의 이메일을 입력해 주세요" value="21300506@handong.edu" class="form-control"> -->
                <input type="hidden" name="tomail" placeholder="보낼 사람의 이메일을 입력해 주세요" value="21700633@handong.edu" class="form-control">
>>>>>>> 6ad0f157475acea8a3c805f1acf6064042da2dbc
              </div>
              <div align="center">
                <!-- 제목 -->
                <input type="text" name="title" placeholder="제목을 입력해주세요" class="form-control">
              </div>
<<<<<<< HEAD
              <p>
              <div align="center">
                <!-- 내용 -->
                <textarea name="content" cols="12" rows="12" placeholder="보내시는 분 메일과, 번호 , 문의사항을 입력해주세요" class="form-control"></textarea>
              </div>
              <p>
=======
              <div align="center">
                <!-- 보내는 사람 -->
                <input type="text" name="fromMail" placeholder="본인의 메일 주소를 입력해주세요." class="form-control">
              </div>
              <div align="center">
                <!-- 내용 -->
                <textarea name="content" cols="12" rows="12" placeholder="문의사항을 입력해주세요" class="form-control"></textarea>
              </div>
            
>>>>>>> 6ad0f157475acea8a3c805f1acf6064042da2dbc
                <!--recaptcha -->
              <div class="g-recaptcha" data-sitekey="6LcYU6wZAAAAAD3_mJDSd6KCwmAWIPSc5yeV9QGj"></div>
              <button id="test_btn">테스트 버튼</button>
              <div align="center">
<<<<<<< HEAD
                <div style="display:none" id="captcha">
=======
                <div id="captcha">
>>>>>>> 6ad0f157475acea8a3c805f1acf6064042da2dbc
                  <input type="submit" id="smbt" value="메일 보내기" class="popup-submit">
                </div>
                <a href="#" class="btn-layerClose">닫기</a>
              </div>
            </form>


          </div>
        </div>
      </div>
    </div>
  </div>
<<<<<<< HEAD
=======
  
  <script>
	  function check(formName){
	  	var valid = true;
	  	var form = $('#' + formName);
	  	var text = "곧 문의가 접수됩니다...";
	  	form.find('input, textarea').each(function(key){
	  		var obj = $(this);
	  		var type = obj.prop("name");
	  		if(isEmpty(obj.val())){
	  			if(type == "title"){
	  				text = "제목을 입력해주세요";
	  				valid = false;
	  			}
	  			else if(type == "fromMail"){
	  				text = "보낼 이메일을 입력해주세요";
	  				valid = false;
	  				
	  			}
	  			else if(type == "content"){
	  				text = "내용을 입력해주세요";
	  				valid = false;
	  			}
	  			return false;
	  		}
	  		else{
	  			if(type == "fromMail"){
	  				var emailCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	  				if(!emailCheck.test(obj.prop("value"))){
	  					text = "이메일 형식이 올바르지 않습니다.";
	  					valid = false;
	  					return false;
	  				}
	  			}
	  		}
	  	});
	  	alert(text);
	  	if(valid){
	  		return true;
	  	}
	  	return false;
	  }
	
	  function isEmpty(val){
	  	if(val == null || typeof val == "undefind" || val.trim().length < 1){
	  		return true;
	  	}
	  	return false;
	  }
  </script>
>>>>>>> 6ad0f157475acea8a3c805f1acf6064042da2dbc
</body>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Board</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
		<style>
			body {transform: scale(0.8); margin-top: -50px; overflow-x: hidden;}
			.uploadResult{
				width: 100%;
			}
			
			.uploadResult ul{
				display: flex;
				justify-content: center;
			}
			
			.uploadResult ul li{
				list-style: none;
			}
			
		</style>
	</head>
	<body class="is-preload">
		<!-- Main -->
		<div id="main">
			<div class="wrapper">
				<div class="inner">

					<!-- Elements -->
					<header class="major">
						<h1>Board</h1>
						<p>게시글 등록</p>
					</header>
					<!-- Table -->
					<h3><a href="/board/list" class="button small">목록 보기</a></h3>
					<div class="content">
						<div class="form">
							<form method="post" action="/board/register" id="registForm">
								<div class="fields">
									<div class="field">
										<h4>제목</h4>
										<input name="title" placeholder="Title" type="text" />
									</div>
									<div class="field">
										<h4>내용</h4>
										<textarea name="content" rows="6" placeholder="Content" style="resize:none"></textarea>
									</div>
									<div class="field">
										<h4>작성자</h4>
										<input name="writer" placeholder="Writer" type="text" />
									</div>
									<div class="field">
										<h4>첨부파일</h4>
										<input name="multipartFiles" type="file" multiple/>
									</div>
									
									<div class="field">
<!-- 									파일 썸네일(미리보기 보여주기용) -->
										<div class="uploadResult">
											<ul></ul>
										</div>
									</div>
								</div>
								<ul class="actions special">
									<li><input type="submit" class="button" value="등록" /></li>
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</body>
	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	
	<script type="text/javascript">
		// 아래는 함수 영역이므로 var를 굳이 피할 필요 없음
		$(document).ready(function(){
			var uploadResult = $(".uploadResult ul");
			var contextPath = "${pageContext.request.contextPath}";
			
			// 파일 타입, 사이즈에 대한 유효성 검사
			var regex = new RegExp("(.*/)\.(exe|sh|zip|alz)$");
			
			// 서버에서는 20메가로 설정했었음
			var maxSize = 1024 * 1024 * 20; // 바이트 단위. 즉 20메가바이트
			
			function showUploadResult(files){
				var str = "";
				$(files).each(function(i, file){
					
					if(file.fileType){ // 해당 파일이 이미지라면
						// 파일명을 만들어놓는다
						var fileName = file.uploadPath + "\\t_" + file.uuid + "_" + file.fileName;
						fileName = encodeURIComponent(fileName);
						// 이미지 파일은 아니라도 파일명을 화면에 노출하기 위함인 듯.
						
						// uploadResult의 ul 태그 안에 넣을 html 작성
						str += `<li>
						<div>
							<a href="javascript:;">
								<img src = "` + contextPath + `/display?fileName=` + fileName + `" width='100'>
							</a>
						</div>
						</li>`;
						
					}else{ // 이미지가 아니라면
						str += `<li>
						<div>
							<a href="javascript:;">
								<img src = "` + contextPath + `/resources/images/attach.png" width='100'>
							</a>
						</div>
						</li>`;
					}
				});
				
				$('.uploadResult ul').html(str);
			}
			
			$("body").on("change", "input[type='file']", function(e){
				// enctype을 굳이 multipart/form-data로 설정하지 않고 ajax로 보내기 위해 FormData객체 생성
				var formData = new FormData();
				var $inputFile = $(this);
				var files = $inputFile[0].files; // 해당 파일 객체의 files를 불러옴
				console.log(files);
				
				for(let i=0; i<files.length; i++){
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					
					// 정상적으로 성공했으면
					formData.append("multipartFiles", files[i]); // multipartFiles 키값에 파일이 하나씩 배열로 들어가게끔 해준다.
				}
				
				$.ajax({
					url: contextPath + "/upload",
					data: formData,
					type: "POST",
					dataType: "JSON",
					processData: false, // multipart로 보내기 위해
					contentType: false, // multipart로 보내기 위해
					success: function(res){
						showUploadResult(res);
					},
					error: function(err){
						console.error(err);
					}
				});
				
			});

			// 업로드할 파일 유효성 검사
			function checkExtension(fileName, fileSize){
				if(regex.test(fileName)){
					alert("업로드 할 수 없는 파일의 형식입니다");
					return false;
				}
				
				if(fileSize >= maxSize){
					alert("파일 사이즈 초과입니다");
					return false;
				}
				
				return true;
			}
		});
	</script>
	
</html>














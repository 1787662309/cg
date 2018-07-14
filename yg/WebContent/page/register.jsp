<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
	$.validator.addMethod(
		//规则名称 用户唯一
		"checkUsername",
		//校验函数
		function(value,element,params){
			// 第一个输入的内容
			//alert(value);
			// 输入的整个元素
			//alert(element);
			// 验证的内容
			//alert(params);
			//定义 标记
			var tag = false;
			$.ajax({
				async:false,
				url:"findUserByUserName.action",
				type:"post",
				data:{"username":value},
				dataType:"json",
				cache:false,
				success:function(data){
					tag = !data;
				}
			}); 
			return tag;
		}
	);
		$(function(){
			$("#form1").validate({
				rules:{
					"username":{
						"required":true,
						"checkUsername":true
					},
					"userpwd":{
						"rangelength":[6,12],
						"required":true
					},
					"userpwd2":{
						"rangelength":[6,12],
						"required":true,
						"equalTo":"#inputPassword3"
					},
					"useremail":{
						"required":true,
						"email":true
					},
					"usersex":{
						"required":true
					}
				},
				messages:{
					"username":{
						"required":"用户名不能为空",
						"checkUsername":"该用户已经被注册"
					},
					"userpwd":{
						"rangelength":"密码长度必须在6-12之间",
						"required":"密码不能为空"
					},
					"userpwd2":{
						"rangelength":"密码长度必须在6-12之间",
						"required":"密码不能为空",
						"equalTo":"两次密码输入不一致"
					},
					"useremail":{
						"required":"邮箱不能为空",
						"email":"邮箱格式不正确"
					},
					"usersex":{
						"required":"必须选择性别"
					}
			    }
				
			});
		});
</script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}
.error{
	color:red;
}
.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form id="form1" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/page/regUser.action" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="username" id="username"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" name="userpwd" id="inputPassword3"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" name="userpwd2" class="form-control" id="confirmpwd"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" name="useremail" id="inputEmail3"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="usertruename" id="usercaption"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="usersex" id="inlineRadio1" value="1">
								男
							</label> <label class="radio-inline"> <input type="radio"
								name="usersex" id="inlineRadio2"  value="0">
								女
							</label>
							<label for="usersex" generated="true" style="display: none;" class="error">必须选择性别</label>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" name="userbirthday" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control">

						</div>
						<div class="col-sm-2">
							<img src="./image/captcha.jhtml" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>





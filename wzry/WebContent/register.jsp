<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8" />
    <title>王者荣耀论坛注册页</title>
    <link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/common-new.css" />
    <link rel="stylesheet" href="css/search.css" />
    <link rel="stylesheet" href="css/register.css" />
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
</head>
<body>
    <!-- 头部 -->
    <div class="hm-top-nav">
			<div class="hm-inner clearfix">
				<div class="hm-inner-l l">
				</div>
				<div class="hm-inner-r r">
					<div class="box">
						<a href="javascript:;" id="login" class="to-login">游客登录</a>
						<a href="">【新用户注册】</a>
						<div id="dialogBg"></div>
						<div id="dialog" class="animated">
							<img class="dialogIco" width="50" height="40" src="images/ico.png" />
							<div class="dialogTop" style="height:25px;">
								<a href="javascript:;" class="closeDialogBtn">关闭</a>
							</div>
							<form action="" method="post">
								<ul class="editInfos">
									<li>用户名：<input type="text" id="userName" name="userName"
										class="ipt" /></li>
									<li>密&nbsp;&nbsp;&nbsp;码：<input type="password"
										id="userPass" name="userPass" class="ipt" /></li>
									<li><input type="submit" value="登录" class="submitBtn" /></li>
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
    <div class="hm-header">
        <div class="hm-inner clearfix">
            <div class="hm-header-t clearfix">
                <h1 class="logo l">
                    <a href="javascript:;"><img src="images/logo.png" 
                    	height="64" width="168" alt="" /></a>    
                </h1>
                <div class="search-box l">
                    <form action="javascript:;">
                        <input type="text" class="txt l" placeholder="请输入关键字">
                        <input type="button" value="搜索" class="btn l" />
                    </form>
                </div>    
            </div>
            <div class="hm-header-b">
                <i class="hm-ico-home"></i>
                <a href="index.html">首页</a><span>></span>注册页面
            </div>
        </div>
    </div>
    <div class="hm-body hm-body-bgc">
        <div class="hm-inner">
            <div class="reg-box">
                <h2>用户注册<span>（红色型号代表必填）</span></h2>
                <div class="reg-info">
                 
                 
                 
                 
                    <form action="register2"  method="post" onsubmit="return checkForm();">
                        <ul>
                            <li>
                                <div class="reg-l"><span class="red">*</span> 用户名：</div>
                                <div class="reg-c">
                                    <input type="text" id="userName2" name="userName" onblur="checkUserName();" class="txt" value=""/>
                                </div>
                                <span id="userNameSpan" class="tips">用户名必须是由英文、数字、下划线组成</span>
                            </li>
                             <li>
                                <div class="reg-l"><span class="red">*</span> 密&nbsp;&nbsp;&nbsp;码：</div>
                                <div class="reg-c">
                                    <input type="password" id="userPass2" name="userPass" onblur="checkuserPass2();" class="txt" value=""/>
                                </div>
                                <span id="userPass2Span" class="tips">密码长度必须6~10位的英文或数字</span>
                            </li>
                            <li class="no-tips">
                                <div class="reg-l">&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱：</div> 
                                <div class="reg-c"><input type="text" id="email" onblur="checkEmail();" name="email" class="txt" value=""/></div>
                            	<span id="emailSpan" class="tips"></span>
                            </li>
                            <li>
                                <div class="reg-l"></div>
                                <div class="reg-c">
                                    <input type="submit" class="submit-btn" value="注册" /><br/>
                                    <span style="color:red;">${msg }</span>
                                </div>
                            </li>
                        </ul>
                    </form>  
                    
                      
                </div>
            </div>
        </div>
    </div>
		<!-- 底部 -->	
		<div class="hm-footer" style="padding-top:10px;">
			<div class="hm-inner">
				<div class="hm-footer-cpr">
					<p>Copyright@2006-2017 ITCAST. All Rights Reserved</p>
					<p>传智播客 版权所有</p>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
		//验证部分
		
			//验证整个表单
			function checkForm(){
				var flag1 = checkUserName();
				var flag2 = checkuserPass2();
				var flag3 = checkEmail();
				if(flag1 && flag2 && flag3){
					return true;
				}
				return false;
				
			}
		
			//验证用户名
			function checkUserName(){
				//标记是否验证通过，默认通过
				var flag = true;
				//获取用户输入的用户名
				var userName = $2("userName2").value;
				//验证的正则表达式
				var reg = /^\w{6,}$/;
				//初始化消息的字体颜色
				$2("userNameSpan").style.color="#666";
				//验证不通过
				if(!reg.test(userName)){
					flag = false;
					$2("userNameSpan").style.color="red";
				//验证通过
				}else{
					$2("userNameSpan").style.color="green";
				}
				return flag;
				
			}
			
			//验证注册密码
			function checkuserPass2(){
				//标记是否验证通过，默认通过
				var flag = true;
				//获取用户输入的用户名
				var userPass2 = $2("userPass2").value;
				//验证的正则表达式
				var reg = /^[a-zA-Z0-9]{6,10}$/;
				//初始化消息的字体颜色
				$2("userPass2Span").style.color="#666";
				//验证不通过
				if(!reg.test(userPass2)){
					flag = false;
					$2("userPass2Span").style.color="red";
				//验证通过
				}else{
					$2("userPass2Span").style.color="green";
				}
				return flag;
				
			}
			
			
			//checkEmail
			//验证邮箱
			function checkEmail(){
				//标记是否验证通过，默认通过
				var flag = true;
				//获取用户输入的用户名
				var email = $2("email").value;
				//验证的正则表达式
				//+,前面的字符至少出现1次
				//*,前面的字符0次或多次
				var reg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
				//验证不通过
				if(!reg.test(email)){
					flag = false;
					$2("emailSpan").style.color="red";
					$2("emailSpan").innerText = "邮箱验证格式失败";
				//验证通过
				}else{
					$2("emailSpan").style.color="green";
					$2("emailSpan").innerText = "邮箱验证格式成功";
				}
				return flag;
				
			}
			
			function $2(id){
				return document.getElementById(id);
			}
		
		</script>
</body>
</html>





<script type="text/javascript">
	var w,h,className;
	function getSrceenWH(){
		w = $(window).width();
		h = $(window).height();
		$('#dialogBg').width(w).height(h);
	}
	
	window.onresize = function(){  
		getSrceenWH();
	}  
	$(window).resize();  
	
	$(function(){
		getSrceenWH();
		
		//显示弹框
		$('.box #login').click(function(){
			className = $(this).attr('class');
			$('#dialogBg').fadeIn(300);
			$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
			$('#userName').focus();
			$("#j_fixedBar").hide();
		});
		
		//关闭弹窗
		$('.closeDialogBtn').click(function(){
			$('#dialogBg').fadeOut(300,function(){
				$('#dialog').addClass('bounceOutUp').fadeOut();
				$("#j_fixedBar").show();
			});
		});
	});
</script>

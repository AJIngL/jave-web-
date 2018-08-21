<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 头部 -->
	<div class="hm-top-nav">
		<div class="hm-inner clearfix">
			<div class="hm-inner-l l">
			</div>
			<div class="hm-inner-r r">
				<div class="box">
					<c:if test="${loginUser==null }">
					<a href="javascript:;" id="login" class="to-login">游客登录</a>
					<a href="register.jsp">【新用户注册】</a>
					</c:if>
					<c:if test="${loginUser!=null }">
					欢迎   <a href="user_info.html" style="margin-right:0px;padding:0px 5px;color:blue;">${loginUser.userName }</a>回来！
		               
		                <a href="logOut">【注销】</a>
		                
					</c:if>
					<div id="dialogBg"></div>
					<div id="dialog" class="animated">
						<img class="dialogIco" width="50" height="40" src="images/ico.png" />
						<div class="dialogTop" style="height:25px;">
							<a href="javascript:;" class="closeDialogBtn">关闭</a>
						</div>
						<form action="login" method="post">
							<ul class="editInfos">
								<li>用户名：<input type="text" id="userName" name="userName"
									class="ipt" /></li>
								<li>密&nbsp;&nbsp;&nbsp;码：<input type="password"
									id="userPass" name="userPass" class="ipt" /></li>
								<li><input type="submit" value="登录" class="submitBtn" /></li>
								<li><span style="color:red;position: relative;bottom:20px;">${loginMsg }</span></li>
							</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
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
		
		
		//登录失败的时候已进入这个页面就显示登录小窗口，${loginMsg}有值得时候就说明登录失败
		var loginMsg = "${loginMsg}";
		if(loginMsg!=""){
			//这里是“游客登录”的点击事件
			$('.box #login').click();
		}
		
		
	});
	
	//由于注销可能用户会后退，当用户点击后退了这里就前进一个页面，用户的后退就没有用了
	history.forward();
	
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="UTF-8" />
	<title>王者荣耀论坛</title>
	<link rel="stylesheet" href="css/common.css" />
	<link rel="stylesheet" href="css/common-new.css" />
	<link rel="stylesheet" href="css/index.css" />
	<link rel="stylesheet" href="css/search.css" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/hm-bbs.js"></script>
	<style>
		body {
	    background: url(images/bg.jpg) no-repeat;
		    background-position: center top;
		    height: 100%;
		}
		.hm-bbs-info {
			position: relative;
		}
		.search-box {
			width: 400px;
			position: absolute;
			right:15px;
			top:30px;
		}
		.search-box .txt {
			width: 380px;
		}
		.hm-header {
		    height: 350px;
		}
		.fixedBar {
			bottom:173px
		}	
	</style>	
</head>
<body>
	<!-- 头部 -->
	<%@ include file="common/head.jsp" %>
	<!-- Banner部分 -->
	<div class="hm-header">
	</div>
	<div class="hm-body hm-body-bgc">
		<div class="hm-inner">
			<div class="hm-banner">
			</div>
			<div class="hm-bbs-info">
				<div class="hm-bbs-icon l" style="width:130px;">
					<span><img src="images/bbs-icon.png" height="80" /></span>
				</div>
				<div class="hm-bbs-info-in l" style="margin-left:30px;">
					<div class="t clearfix">
						<h2 class="l">王者荣耀</h2>
					</div>
					
					
					<p>
						<span>今日帖子<strong>${articles.todayArticles }</strong></span> 
						<span>全部帖子<strong>${articles.allArticles }</strong></span>
					</p>
					
				</div>
				<div class="search-box l">
						<form action="index" method="post">
						<input type="hidden" name="zoneId" value="${zoneId }"/>
								<input type="text" class="txt l" name="title" placeholder="请输入关键字" value="${title}">
								<input type="submit" value="搜索" class="btn l" /> 
						</form>
				</div> 
			</div>
			
			<!-- 导航 -->
			<ul class="hm-bbs-nav border-lrb clearfix">
			<c:forEach items="${zoneList }" var="zone">
					<li 	<c:if test="${zone.zoneId==zoneId }">
								class="current"
							</c:if>
					
					>
						<a href="index?zoneId=${zone.zoneId }"><em></em>${zone.zoneName }</a>
					</li>
			</c:forEach>	
			</ul>
			
			<!-- 主体部分 -->
			<div class="hm-bbs-main border-lrb clearfix">
				<!-- 左侧列表 -->
				<div class="list-view l">
				<form action="" method="get">
					<ul>
					<c:forEach items="${articleList }" var="article">
							<li class="clearfix <c:if test="${article.isTop==1 }">ding</c:if>">
								<div class="hm-index-title">
									<i class="set-to-top">顶</i> <a href="detail?articleId=${article.articleId }">${article.title }</a>
								</div>
								<div class="hm-index-con">${article.content}</div>
								<div class="hm-index-info l">
									<span class="article-username">${article.posterName }</span><span
										class="post-time">${article.postTime }</span>
								</div>
								<div class="hm-index-fun r">
									<span class="icon-like"><i></i>${article.likeCount }</span>
									<span class="icon-talk"><i></i>${article.commentCount }</span>
								</div>
							</li>
						
					</c:forEach>	
					</ul>
				</form>
				</div>
				
				<!-- 右侧侧边栏 -->
				<div class="aside l">
					<div class="aside-box">
						<h3 class="t">
							<a ahref="javascript:;">在线用户(${onlineNums })</a>
						</h3>
						<ul class="b clearfix">
						<c:forEach items="${onlineUserList }" var="user">
							<li>
								<div>
										 <!-- 发帖人有图片显示自己的头像，没有头像的时候显示一个默认图片 -->
                            		<c:choose>
                            			<c:when test="${user.picUrl==null || user.picUrl=='' }">
                            				<img src="images/default.png" />
                            			</c:when>
                            			<c:otherwise>
                            				<img src="${user.picUrl}" />
                            			</c:otherwise>
                            		</c:choose>
								</div>
								<p>${user.userName }</p>
							</li>
							</c:forEach>
							
						</ul>
						
					</div>
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

	<div class="fixedBar" id="j_fixedBar">
			<!-- 只有登录的用户才有发帖  -->
		<c:if test="${loginUser!=null }">
			<a id="newTopicBtn" href="javascript:;" class="newTopic"><span></span>发帖</a>
		</c:if>

		<a href="#" class="goTop"><i></i><span>返回<br />顶部</span></a>
	</div>
	
	<!-- 发帖弹出框 -->
	<form action="postArticle" method="post">
		<!-- 增加当前发帖所属板块，用户不需要看到，但是需要提交给服务器 -->
		<input type="hidden" name='zoneId' value="${zoneId }" >
	
		<div class="pop-box ft-box">
			<div class="mask"></div>
			<div class="win">
				<div class="win_hd">
					<h4 class="l">主题帖</h4>
					<span class="close r">&times;</span>
				</div>
				<div class="win_bd">
					<div class="win_bd_t">
						<input type="text" id="title" name="title" placeholder="帖子标题" />
					</div>
					<div class="win_bd_b">
						<textarea id="content" name="content" placeholder="正文"></textarea>
					</div>
				</div>
				<div class="win_ft">
					<div class="win_ft_in">
						<input type="submit" class="btn" value="发表"/>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>


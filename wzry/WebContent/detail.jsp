<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>黑马程序员论坛详情页</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/common-new.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link rel="stylesheet" type="text/css" href="css/search.css" />
    <link rel="stylesheet" type="text/css" href="css/detail.css" />
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
			background-color: none;
		}
		.search-box .txt {
			width: 380px;
			height: 40px;			
		}		
		.hm-header {
		    height: 350px;
		}
		.hm-bbs-info-in h2 {		   
		    height: 100px;
		    line-height: 142px;
		}
		.hm-detail-fun {
		    height: 100px;
		    line-height: 142px;
		   margin-top: 0px;
		}
		.new-to-old {
			margin:0;
		}
		.fixedBar {
			bottom:173px
		}
		.detail-page-box a, .detail-page-box span {
			border:none;
			background:none;
			padding: 0 2px;
			font-size: 15px;
			margin:0px;
		}
		.detail-page-box .new-to-old{
			border: 1px solid #d9d9d9;
		}
		.detail-page-box {
			border:none;
			padding: 9px 15px 9px 20px;
		}
	</style>
</head>
<body>
    
    <!-- 头部 -->
    <%@ include file="common/head.jsp" %>
		<div class="hm-header">
    </div>
    <div class="hm-body hm-body-bgc">
        <div class="hm-inner">
        	<div class="hm-bbs-info">
				<div class="hm-bbs-icon l" style="width:130px;">
					<span><img src="images/bbs-icon.png"
						height="80" /></span>
				</div>
				<div class="hm-bbs-info-in l" style="margin-left:30px;">
					<div class="t clearfix">
						<h2 class="l">${article.title }</h2>
						<div class="hm-detail-fun l">
								<span class="icon-like">
										<a href="#"><i></i>${article.likeCount }</a>
								</span>
								<span class="icon-talk">
										<i></i>${article.commentCount }
								</span>
						</div>
					</div>					
				</div>
				<div class="search-box l">
						<form action="index" method="post">
						<input type="hidden" name="zoneId" value="${zoneId }"/>
								<input type="text" class="txt l" name="title" placeholder="请输入关键字" value="${title}">
								<input type="submit" value="搜索" class="btn l" /> 
						</form>
				</div> 
			</div>
            <div class="detail-page-box clearfix">
            	
            	<a href="index"><i class="hm-ico-home"></i>首页</a><span>></span><a href="#">${article.title }</a>
                 <a class="new-to-old r" href="" style="font-size:12px;float: right;">
	               <i></i>从新到旧查看 </a>
            </div>
            <div class="detail-box">
                <ul class="detail-floors">
                    <li class="floor clearfix">
                        <div class="floorer-info l">
                            <div class="floorer-photo">
                            <!-- 发帖人有图片显示自己的头像，没有头像的时候显示一个默认图片 -->
                            		<c:choose>
                            			<c:when test="${poster.picUrl==null || poster.picUrl=='' }">
                            				<img src="images/default.png" />
                            			</c:when>
                            			<c:otherwise>
                            				<img src="${poster.picUrl}" />
                            			</c:otherwise>
                            		</c:choose>
                            
                            </div>
                            <div class="floorer-name">${article.posterName }</div>
                        </div>
                        <div class="floor-con l">
                            <div class="floor-info clearfix">
                                <div class="floor-time l">发帖时间：${article.postTime }</div>                                
                                <div class="r">${article.readCount }次查看</div>
                            </div>
                            <div class="floor-art-ans">
                                <div class="floor-art">
                                    <p>
                                    	${article.content }
                                </div>
                                <div class="floor-ans"></div>
                            </div>
                            <span class="icon-comment"> 
                            	<a href="#comment"> <i ></i> 评论</a> 
                            </span>
                        </div>
                    </li>
                  
                     <!-- 评论部分 
                    						varStatus="status" ,forEach标签属性，varStatus封装了循环的信息，有循环索引和序号信息
                    									index,循环索引，从0开始的
                    									count,循环序号，从1开始的
                    									如果想获取循环的序号，${status.count} -->
                    
                    				<c:forEach items="${commentList }" var="comment" varStatus="status">
										<li class="floor clearfix">
												<div class="floorer-info l">
														<div class="floorer-photo">
															<c:choose>
						                            			<c:when test="${comment.picUrl==null || comment.picUrl=='' }">
						                            				<img src="images/default.png" />
						                            			</c:when>
						                            			<c:otherwise>
						                            				<img src="${comment.picUrl}" />
						                            			</c:otherwise>
						                            		</c:choose>
														</div>
														<div class="floorer-name">
															${comment.commentUserName }
														</div>
												</div>
												<div class="floor-con l">
														<div class="floor-info clearfix">
																<div class="floor-time l">回贴时间：${comment.commentTime }</div>
																<div class="r">${status.count }楼</div>
														</div>
														<div class="floor-art-ans">
																<div class="floor-art">
																		<p>${comment.commentContent }</p>
																</div>
																<div class="floor-ans">
																		<ul>
																				<!-- 回复部分 -->
																				<c:forEach items="${comment.commentReplies }" var="reply">
																				<li class="clearfix">
																						<div class="floor-ans-pho l">
																						<c:choose>
													                            			<c:when test="${reply.picUrl==null || reply.picUrl=='' }">
													                            				<img src="images/default.png" />
													                            			</c:when>
													                            			<c:otherwise>
													                            				<img src="${reply.picUrl}" />
													                            			</c:otherwise>
													                            		</c:choose>
																						<div class="floor-ans-con l">
																						         
																								<span class="name">${reply.replyName }</span>:${reply.replyContent } <span class="ans-time">${reply.replyTime }</span>
																						</div>
																				</li>
																				</c:forEach>
																		</ul>
																</div>
																<span class="icon-feedback">
																<c:if test="${loginUser!=null }">
										
																		<a href="javascript:;" onclick="showDialog(${status.count},${comment.commentId })"> <i ></i> 回复</a>
																	</c:if>
																	</span>
														</div>
												</div>
										</li>
										</c:forEach>
                </ul>
            </div>
            <div class="detail-to-comment">
                <div class="tit"><a name="comment">发表评论</a></div>
                
								<!-- 未登录时候显示-->
	              
							<c:if test="${loginUser==null }">
				
							<div class="con">您没有登录论坛，请登录后再进行回复</div>
							</c:if>	
                <!-- 登录后显示评论输入框-->
                
                
                <c:if test="${loginUser!=null }">
								<form action="comment" method="post">
								<input type="hidden" name="articleId" value="${article.articleId }" />
									<div class="con con-loged">
											<div class="con-t">
													<textarea id="content" name="content" placeholder="请在此输入您要回复的信息"></textarea>
											</div>
											<div class="con-b">
													<input type="submit" class="btn" />
													<span class="num">不能超过5000字</span>
											</div>
									</div>
								</form>
								</c:if>	
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

    <!-- 回复弹出框 -->
	<form action="commentReply" method="post">
		<input type="hidden" id="commentId" name="commentId" value="commentId">
		<input type="hidden"  name="articleId" value="${article.articleId }">
		
		<div class="pop-box ft-box">
			<div class="mask"></div>
			<div class="win">
				<div class="win_hd">
					<h4 class="l">回复<span id="floorSpan"></span>楼</h4>
					<span class="close r">&times;</span>
				</div>
				<div class="win_bd">
					<div class="win_bd_b">
						<textarea id="replyContent" name="content" placeholder="回复内容限于40字以内"></textarea>
					</div>
				</div>
				<div class="win_ft">
					<div class="win_ft_in">
						<input type="submit" class="btn" value="回复"/>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<div class="fixedBar" id="j_fixedBar">
			<a href="#comment" class="newTopic"><span></span>回复</a>
			<a href="#" class="goTop"><i></i><span>返回<br />顶部</span></a>
	</div>
</body>
</html>

<script type="text/javascript">
	
	//弹出回复框
	function showDialog(num,commentId) {
		$('.pop-box').css('display','block');
		$("#floorSpan").html(num);	
		document.getElementById("commentId").value=commentId;
			
	}
</script>
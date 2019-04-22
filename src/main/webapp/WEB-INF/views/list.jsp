<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="<%=request.getContextPath()%>/resources/lib/css/page.css" rel="stylesheet">
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/jquery-3.4.0.min.js"></script>
		<script type="text/javascript">
			$(function(){
				
				$("#searchdv select option").each(function(){
					
					var searchT = $("input[name=searchT]").val();
					
				    if($(this).val() == searchT){
				      $(this).prop("selected","selected");
				    }
				
				});
				
				$("#searchdv input[type=button]").click(function(){
					var searchT = $("select[name=searchType]").val();
					
					if(searchT == "전체"){
						$("input[name=searchValue]").val("");
					}
						
					$("#searchdv form").attr("action","golist").attr("method","get").submit();
				});
			});
		
			function goPage(pg){
				//$(location).attr("href","golist?nowPage="+pg);
				$("input[name=nowPage]").val(pg);
				$("#searchdv input[type=button]").click();
			}
		</script>
	</head>
	<body> 
		<div style="width: 850px; margin: auto;">
			<div id="searchdv">
				<form>
					<select name="searchType">
						<option value="전체">전체</option>
						<option value="제목">제목</option>
						<option value="아이디">아이디</option>
						<option value="내용">내용</option>
					</select>
					<input type="text" name="searchValue" value="${searchValue}">
					<input type="button" value="검색">
					<input type="hidden" name="nowPage">
				</form>
					<input type="hidden" name="searchT" value="${searchType}">
			</div>
			<br>
			<input type="button" value="삭제">
			<input type="button" value="글쓰기"> 
			<div id="listdv">
				<table	border="1">
					<colgroup>
						<col width="50px;">
						<col width="100px;">
						<col width="250px;">
						<col width="150px;">
						<col width="150px;">
						<col width="150px;">
					</colgroup>
					<thead align="center">
						<tr>
							<td>삭제</td>
							<td>글번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>등록일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody align="center">
					<c:choose>
						<c:when test="${list ne null}">
							<c:forEach items="${list}" var="item">
								<tr>
									<td><input type="checkbox" name="delchk" value="${item.seq }"> </td>
									<td>${item.seq }</td>
									<td><a href="godetail?seq=${item.seq }"><c:out value="${item.subject }"></c:out></a></td>
									<td>${item.id}</td>
									<td><fmt:formatDate value="${item.rDate }" pattern="yyyy-MM-dd"/></td>
									<td>${item.vCnt }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5">
									<h2>검색된 게시물이 없습니다.</h2>
								</td>
							</tr>
						</c:otherwise>
					</c:choose>	
					</tbody>
				</table>
				${pageCode} 
			</div>
		</div>
	</body>
</html>
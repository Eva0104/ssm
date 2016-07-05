<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h3>图书列表</h3>
        </div>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
        <a class="btn btn-success" href="/books/new">添加书籍</a>
        <table class="table">
            <thead>
                <tr>
                    <th>书名</th>
                    <th>作者</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>出版社</th>
                    <th>分类</th>
                    <th>#</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${page.items}" var="book">
                    <tr>
                        <td>${book.bookname}</td>
                        <td>${book.bookauthor}</td>
                        <td>${book.bookprice}</td>
                        <td>${book.booknum}</td>
                        <td>${book.publisher.pubname}</td>
                        <td>${book.bookType.booktype}</td>
                        <td>
                            <a href="/books/${book.id}/update">修改</a>
                            <a href="/books/${book.id}/del">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <ul id="page" class="pagination"></ul>
    </div>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/js/jquery.twbsPagination.min.js"></script>
    <script>
        $(function(){
            $(function(){
                $("#page").twbsPagination({
                    totalPages:${page.totalPageSize},
                    first:'首页',
                    prev:'<<',
                    next:'>>',
                    last:'末页',
                    visiblePages:10,
                    href:'?p={{number}}'
                })
            })
        });
    </script>
</body>
</html>

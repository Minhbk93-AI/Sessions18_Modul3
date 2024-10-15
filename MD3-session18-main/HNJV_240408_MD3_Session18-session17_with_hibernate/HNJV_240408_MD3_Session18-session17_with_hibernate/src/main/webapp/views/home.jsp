<%--
  Created by IntelliJ IDEA.
  User: BuiThanhHai
  Date: 8/2/2024
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>List Products</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>DANH SÁCH SẢN PHẨM</h1>
        <table class="table table-bordered">
            <tr>
                <th>Product id</th>
                <th>Image</th>
                <th>Product name</th>
                <th>Producer</th>
                <th>Year making</th>
                <th>Expire date</th>
                <th>Price</th>
                <th>Unit price</th>
                <th>Color</th>
            </tr>

            <c:forEach items="${list}" var="p">
                <tr>
                    <td>${p.proId}</td>
                    <td>
                        <img src="resources/images/${p.imageName}"/>
                    </td>
                    <td>${p.proName}</td>
                    <td>${p.producer}</td>
                    <td>${p.yearMaking}</td>
                    <td>${p.expireDate}</td>
                    <td>${p.price}</td>
                    <td>${p.unitPrice}</td>
                    <td>${p.color}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="initInsertProduct">Add New Product</a>
    </div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>

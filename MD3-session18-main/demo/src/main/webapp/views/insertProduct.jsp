<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/6/2024
  Time: 8:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Insert Product</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>INSERT PRODUCT</h1>
    <form:form modelAttribute="p" action="insertProduct" method="post" enctype="multipart/form-data">
        <table class="table table-bordered">
            <tr>
                <td>Product Name:</td>
                <td><form:input path="proName"/>
                    <br/><form:errors path="proName" cssClass="text-danger"/></td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td><form:input path="producer"/>
                    <br/><form:errors path="producer" cssClass="text-danger"/></td>
            </tr>
            <tr>
                <td>Year making:</td>
                <td><form:input type="number" path="yearMaking"/>
                    <br/><form:errors path="yearMaking" cssClass="text-danger"/></td>
            </tr>
            <tr>
                <td>Primary Image: </td>
                <td>
                    <input type="file" name="primaryImage"/>
                </td>
            </tr>
            <tr>
                <td>Secondary Images: </td>
                <td>
                    <input type="file" name="secondaryImages" multiple/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Insert"/>
                    <input type="reset" value="Clear"/>
                </td>
            </tr>
        </table>
    </form:form>
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

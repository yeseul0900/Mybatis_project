<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ page import="com.example.SuggestionDAO" %>
<%@ page import="com.example.SuggestionVO" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>건의사항 페이지</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <title>yeseul's CRUD</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/dashboard/">


    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"/>


    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/4.6/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/4.6/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/4.6/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/4.6/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/4.6/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
    <link rel="icon" href="/docs/4.6/assets/img/favicons/favicon.ico">
    <meta name="msapplication-config" content="/docs/4.6/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">


    <style>
        main {
            margin: auto !important;
        }
        .btn {
            color: black;
            background-color: orange;
            margin-left: 0.5rem;
        }

        .btn:hover {
            color: white;
            background-color: lightsalmon;
        }
        legend {
            text-align: center;
            color: #002F63;
        }

        fieldset {
            border-radius: 0.5rem;
            border: 2px solid lightpink;
            padding: 10px;
        }

        input, select, textarea {
            border-radius: 0.5rem;
            border: 1px solid lightpink;
            margin-bottom: 2px;
        }

        input:focus, select:focus, textarea:focus {
            outline: 1px solid lightpink !important;
        }

        #add_modal h1 {
            text-align: center;
            color: white;
            background-color: lightpink;
            border-radius: 0.5rem;
            margin-bottom: 0.5rem;
        }
        a {
            padding: 2px;
            margin: 2px;
            background-color: orange;
            color: black;
            cursor: pointer;
            border-radius: 0.5rem;
            border: 1px solid orange;
            text-decoration: none;
        }

        a:hover {
            background-color: salmon;
            color: white;

        }
    </style>
    <script>
        function delete_ok(id) {
            var a = confirm("정말로 삭제하겠습니까?");
            if (a) location.href = 'deletepost.jsp?id=' + id;
        }
    </script>
</head>
<body>
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
            </ul>

            <div class="text-end">
                <button type="button" onclick="location.href = 'https://hisnet.handong.edu/' " class="btn btn-warning">
                    Hisnet
                </button>
            </div>
        </div>
    </div>
</header>
<div class="container-fluid">
    <div class="row">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="chartjs-size-monitor">
                <div class="chartjs-size-monitor-expand">
                    <div class=""></div>
                </div>
                <div class="chartjs-size-monitor-shrink">
                    <div class=""></div>
                </div>
            </div>
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">건의 게시판</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <button type="button" id="add" class="btn" onclick="location.href = 'add'">Add
                    </button>
                </div>
            </div>

            <h2>목록</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>No.</th>
                        <th>닉네임</th>
                        <th>소속학부</th>
                        <th>건의 카테고리</th>
                        <th>건의사항</th>
                        <th>등록일자</th>
                        <th>수정/삭제</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${list}" var="u">
                        <tr>
                            <td>${u.getPersonID()}</td>
                            <td>${u.getNickname()}</td>
                            <td>${u.getMajor()}</td>
                            <td>${u.getCategory()}</td>
                            <td>${u.getSuggestions()}</td>
                            <td>${u.getRegdate()}</td>
                            <td>
                                <a href="editform/${u.getPersonID()}">수정</a>
                                <a href="javascript:delete_ok('${u.getPersonID()}')">삭제</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
<script>
    function delete_ok(id){
        var a = confirm("정말로 삭제하겠습니까?");
        if(a) location.href='deleteok/' + id;
    }
</script>
</body>
</html>
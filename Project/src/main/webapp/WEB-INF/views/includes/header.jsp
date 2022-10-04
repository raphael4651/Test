<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="icon" type="image/x-icon" href="../resources/logo_B.png">
<title>우동: 우리동네</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../resources/css/header.css">
</head>
<body>

<div class="wrap">
    <header>
      <div class="header_top">
        <div class="header_topMain">
          <div class="header_topMain_imgBox">
            <img src="../resources/img/logo_all.png" alt="home"/>
          </div>

        </div>
        <div class="header_topLogin">
        	<sec:authorize access="isAnonymous()">
            <button onclick="location.href='/customLogin'" class="header_login">로그인</button>
            <button onclick="location.href='/user/register'" class="header_join">회원가입</button>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
            <span class="welcome"><sec:authentication property="principal.user.userName"/>님 반갑습니다.</span>
            <ul>
            <li>
            <button onclick="location.href='/logout'" class="header_logout">로그아웃</button>
            </li>
            <li>
            <button onclick="location.href='/user/myPage'" class="header_myPage">마이페이지</button>
            </li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li>
            <button onclick="location.href='/admin/adminPage'" class="header_myPage">관리자페이지</button>
            </li>
            </sec:authorize>
            </sec:authorize>
            </ul>
        </div>
      </div>
         <div class="header_bottom">
          <ul id="main_menu">
            <li><a href="#">게시판</a> 
            	<ul id="sub_menu">
            	<li><a href="/board/list">전체게시판</a> </li>
                <li><a href="/board_f/list_f">자유게시판</a></li>
                <li><a href="/board_h/list_h">취미게시판</a></li>
                <li><a href="/board_i/list_i">정보공유</a></li>
              	</ul>
            </li>
            <li><a href="#">가게홍보</a>
            	<ul id="sub_menu">
             	<li><a href="/pr_board/list_r">식당</a></li>
                <li><a href="/pr_board/list_c">카페</a></li>
                <li><a href="/pr_board/list_l">생활</a></li>
                <li><a href="/pr_board/list_b">뷰티</a></li>
                <li><a href="/pr_board/list_g">기타</a></li>
                </ul>            	
            </li>
            <li><a href="#">거래</a>
              <ul id="sub_menu">
                <li><a href="/trade/list">판매게시판</a> </li>
                <li><a href="/trade/list2">구매게시판</a> </li>
              </ul>
            </li>            
            <li><a href="#">고객센터</a>
              <ul id="sub_menu">
                <li><a href="/trade/notice">공지사항</a> </li>
              </ul>
            </li>

          </ul>          
        </div>
    </header>
  </div>
  


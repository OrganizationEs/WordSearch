<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> EWESS</title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <link href="css/override.css" rel="stylesheet" />
  </head>
  <body>

<!-- ナビゲーションバーをトップに固定 -->
    <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <!-- グリッドシステムを入れ子状に配置 -->
    <div class="col-sm-12">
      <!-- タイトル -->
      <div class="col-sm-6">
        <a class="navbar-brand">Engineer Word Search System</a>
      </div>
      <!-- 検索欄 -->
      <div class="col-sm-6">
        <form class ="navbar-form navbar-lef" action="result" method="post" target="result_frame">
          <div class="input-group">
            <input type="text" class="form-control" name="message" placeholder="Search">
              <span class="input-group-btn">
                <button class="btn btn-default" type="submit">
                  <i class='glyphicon glyphicon-search'></i>
                </button>
              </span>
            </div>
          </form>
      </div>
    </div>

  </div>
</nav>

<!-- カテゴリリンク -->
  <div class="icon-wrapper">
    <!-- カテゴリを２段表示 -->
    <br />
    <div class="col-sm-12">
      <a class="col-sm-2"><h3 class="categories_link color1">入社時</h3></a>
      <a class="col-sm-2"><h3 class="categories_link color2">面談用</h3></a>
      <a class="col-sm-2"><h3 class="categories_link color3">常駐開始</h3></a>
      <a class="col-sm-2"><h3 class="categories_link color4">常駐先での営業</h3></a>
      <a class="col-sm-2"><h3 class="categories_link color5">リーダー就任</h3></a>
      <a class="col-sm-2"><h3 class="categories_link color6">汎用知識</h3></a>
    </div>
  </div>

    		<iframe src="manual" name="result_frame" width="100%" height="400">
    この部分はインラインフレームを使用しています。
    </iframe>


  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page session="false" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
                    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

                    <title>登入畫面</title>

					<script type="text/javascript">
					
						$(function(){
							
								var status = "${STATUS}";
								
								if(status!=""){
									
									alert("${MESSAGE}");
									
									
								}
							
						});
					
					
					</script>
              
                </head>

                <body>

                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <hr>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <header class="col-md-12">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <img src="/resources/images/dogLogo.jpg" alt="Logo" class="rounded img-fluid" />
                                        </div>
                                        <div class="col-md-6"></div>
                                        <div class="col-md-1">
                                            <a href="/" role="button" class="btn btn-outline-warning btn-lg"> <img
								src="/resources/images/dogHand.jpg" alt="首頁" class="img-fluid"  style="max-height:30px;max-width:40px" />
							</a>
                                        </div>
                                        <div class="col-md-1">
                                            <a href="/loginPage" role="button" class="btn btn-outline-warning btn-lg">登入</a>
                                        </div>
                                        <div class="col-md-1">
                                            <a href="/registerPage" role="button" class="btn btn-outline-warning btn-lg">註冊</a>
                                        </div>
                                        <div class="col-md-1">
                                            <a href="/contactPage" role="button" class="btn btn-outline-warning btn-lg">聯絡我們</a>
                                        </div>
                                    </div>
                                </div>
                            </header>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <hr>
                            </div>
                        </div>
                    </div>

                    <form action="/loginAction"  method="post" class="form-inline">
                    
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="media">
                                        <div class="container">
                                            <img src="/resources/images/dog.jpg" alt="dog" class="rounded-circle img-fluid align-self-center mr-3 ">
                                        </div>
                                        <div class="media-body">
                                            <div class="container">
                                                <div class="row">
                                                    <div>
                                                        <div class="form-group">
                                                            <input type="email" class="form-control" placeholder="EMAIL:EMAIL:name@name.com" name="email" id="EMAIL" value="${EMAIL}" >
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div>
                                                        <div>
                                                            <input type="password" class="form-control" placeholder="密碼" name="password" id="PASSWORD">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div>
                                                        <div>
                                                            <br>
                                                            <button id="SUBMIT" type="submit" class="btn btn-md btn-primary">登入</button>
                                                            <a href="/forgetAccPage" role="button" class="btn btn-md btn-primary">忘記密碼</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </form>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <hr/>
                            </div>
                        </div>
                    </div>

                    <div class="container">
                        <footer class="row">
                            <div class="col-md-2  offset-md-6">
                                <img src="/resources/images/dogLogo.jpg" alt="Logo" class="rounded img-fluid" />
                            </div>

                            <div class="col-md-4">
                                <address>
                <strong>狗狗<small>集團</small></strong>
                <br>
                地址:動物園哺乳路四隻腳巷1號
                <br>
                TEL:<abbr title="Phone">(02)123456789</abbr>
            </address>
                            </div>
                        </footer>

                    </div>


                </body>

                </html>

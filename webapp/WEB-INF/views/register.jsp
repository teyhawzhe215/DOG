<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <%@ page session="false"%>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
                    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 					<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
					<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
                    
                    <title>註冊</title>
					
					<script type="text/javascript">
					
						$(function(){
							
							var test= "${test}";
							
							if(test.trim().length>0){
								alert("${test}");
							}
							
							if( "${STATUS}"== "REDIRECT" ){
								/*$.blockUI();
								$.unblockUI();*/
								setTimeout(window.location.replace("/loginPage"),3000);
								
							}
							
							
							$('#EMAIL').keyup(function(){
								$.ajax({
									type: "POST" ,
									async: false ,
									url : "/validationEmailAction",
									dataType : 'json',
									data:{email:$('#EMAIL').val()},
									success:function(data){
										if(data.KEY == "Y"){
											$('#ALERT_BLOCK_EMAIL').show();
										}else{
											$('#ALERT_BLOCK_EMAIL').hide();
										 
										}
									}
								});
							});
							
							$('#TEL').keydown(function(event){
								 if ( event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 27 || event.keyCode == 13 || 
							             // Allow: Ctrl+A
							            (event.keyCode == 65 && event.ctrlKey === true) || 
							             // Allow: home, end, left, right
							            (event.keyCode >= 35 && event.keyCode <= 39)) {
							                 // let it happen, don't do anything
							                 return;
							        }else {
										 if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 ) ){
								                event.preventDefault(); 
								         } 
									} 
							});
							
							$("#PASSWORD,#REPASSWORD").blur(function(){
								
								if($(this).val().length>0){
								
									if($(this).val().length<6){
										$('#ALERT_BLOCK_'+$(this).attr('id')).show();
										$('#ALERT_BLOCK_'+$(this).attr('id')).html("密碼不能小於6位");
									}else{
										$('#ALERT_BLOCK_'+$(this).attr('id')).html("");
										$('#ALERT_BLOCK_'+$(this).attr('id')).hide();
									}
									
								}
								
								if($("#PASSWORD").val()!="" && $("#REPASSWORD").val()!=""){
									if($("#PASSWORD").val() !=  $("#REPASSWORD").val() ){
										$('#ALERT_BLOCK_'+$(this).attr('id')).show();
										$('#ALERT_BLOCK_'+$(this).attr('id')).html("密碼不一致");
									}else{
										$('#ALERT_BLOCK_'+$(this).attr('id')).html("");
										$('#ALERT_BLOCK_'+$(this).attr('id')).hide();
									}
								}
							});
							
							$("#SUBMIT").click(function(){
								
							
								
								var col_valid=["#ALERT_BLOCK_EMAIL","#ALERT_BLOCK_PASSWORD","#ALERT_BLOCK_REPASSWORD"];
								
								for(var i=0;i<col_valid.length;i++){
									
									if(validationAlertBlock(col_valid[i])){
										alert("請輸入正確的資料!");
										return false;
									}else{
										console.log(validationAlertBlock([i]));
									}
									
								}
								
					
								
								if( ! ($("#MALE").prop("checked") || $("#FEMALE").prop("checked")) ){
									alert("請選擇性別!");
									return false;
								}
								
								return true;
								
								
							});
							
							$("#RESET").click(function(){
								
								$('div[id^=ALERT_BLOCK_]').hide();
								
								
							});
							
							
						});
					
						function validationAlertBlock(id){
							console.log(id);
							return $(id).is(":visible");
						}
						
					
					
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

                    <form id="USER" action="registerAction" method="post">
                        <div class="container form-group">
                            <div class="row">
                                <div class="col-md-5">
                                    <input type="email" placeholder="EMAIL:name@name.com" class="form-control" value="${email}" name="email" id="EMAIL" required="required">
                                    <div id="ALERT_BLOCK_EMAIL" role="alert" class="alert alert-danger" style="display: none;">此EMAIL已經被註冊了!</div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <input type="text" placeholder="姓名" class="form-control" value="${name}" name="name" id="NAME"  required="required">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <input type="radio" name="sex" value="0" id="MALE">男 &nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="sex" value="1" id="FEMALE">女
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <input type="password" placeholder="password" class="form-control" name="password" id="PASSWORD"  required="required">
                                     <div id="ALERT_BLOCK_PASSWORD" role="alert" class="alert alert-danger" style="display: none;"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <input type="password" placeholder="repassword" class="form-control" name="repassword" id="REPASSWORD"  required="required">
                                    <div id="ALERT_BLOCK_REPASSWORD" role="alert" class="alert alert-danger" style="display: none;"></div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-3">
                                    <input type="tel" placeholder="電話" class="form-control" value="${tel}" name="tel" id="TEL"  required="required" >
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-7">
                                    <input type="text" placeholder="地址" class="form-control" value="${address}" name="address" id="ADDRESS"  required="required">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-1">
                                    <button id="SUBMIT" type="submit" class="btn btn-lg btn-primary">註冊</button>
                                </div>
                                <div class="col-md-1">
                                    <button id="RESET" type="reset" class="btn btn-lg btn-primary">清空</button>
                                </div>
                            </div>
                        </div>
                    </form>

                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <hr />
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
					<strong>狗狗<small>集團</small></strong> <br> 地址:動物園哺乳路四隻腳巷1號 <br>
					TEL:<abbr title="Phone">(02)123456789</abbr>
				</address>
                            </div>
                        </footer>
                    </div>
                  
                </body>
                </html>

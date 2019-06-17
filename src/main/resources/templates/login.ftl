<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>login</title>
    <style type="text/css">
        *{
            margin:0;
            padding:0;
        }
        body{
            background-image: url("	https://school-1258358792.cos.ap-beijing.myqcloud.com/backend/bgi.png");
            background-repeat:space ;
            background-color: #faf9f8;

        }
        .header{
            width:100%;
            height:200px;
            line-height: 200px;
            text-align: center;
            font-size: 48px;
            /*border:2px salmon solid;*/
        }
        .wrap{
            width:900px;
            height:400px;
            margin:  0 auto;
            background-color: rgb(255,255,255,1);
            border-radius:30px;
            margin-top:50px;
        }
        .login_title{
            width:300px;
            height:50px;
            margin-left:720px ;
            font-size:40px;
            line-height: 50px;
            padding-left:10px ;
            border-left:10px #EE7700 solid;

        }
        .get_name,.get_password{
            width:800px;
            height:100px;
            font-size:32px;
            font-weight: 100;
            /*margin-top:20px;*/
        }
        .logoGet{
            margin-left:220px;
            padding-top:60px;
        }
        input{
            width:200px;
            height:40px;
            line-height: 40px;
            border:#bbb 1px solid;
            margin-left: 10px;
        }
        button{
            width:300px;
            height:60px;
            font-size: 30px;
            margin-left:300px ;
            margin-top:20px;
            boder:none;
            background-color: #EE7700;
            color: #fff;
            border:hidden;

        }
        .footer{
            position: absolute;
            width:100%;
            height:40px;
            font-size:16px;
            text-align: center;
            line-height: 40px;
            border-top:1px #ddd dashed;
            bottom: 0px;
        }
    </style>
</head>
<body>
<form role="form" method="post" action="/portal/user/login.do">
    <div class="header" id="head">
        <div class="title">
        </div>
    </div>
    <div class="login_title">
        登录
    </div>
    <div class="wrap" id="wrap">
        <div class="logoGet">
            <!--头部提示信息-->
            <div class="get_name">
                请输入用户名：
                <input type="text" name="username" id="username" placeholder="输入用户名"  />
            </div>
            <div class="get_password">
                请输入密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password" placeholder="输入密码"  />
            </div>
        </div>
        <button type="submit" class="sub">登录</button>
        <a href="">注册</a>
    </div>
    <div class="footer">

    </div>
</form>
</body>
</html>

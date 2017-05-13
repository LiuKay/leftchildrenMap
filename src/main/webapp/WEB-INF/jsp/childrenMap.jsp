<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>childrenMap</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <link href="https://cdn.bootcss.com/jspanel3/3.8.0/jquery.jspanel.min.css" rel="stylesheet">

    <style type="text/css">
    html,body{
        margin:0;
        width:100%;
        height:100%;
        background:#333;
    }
    .anchorBL{ 
        display:none; 
    } 
    .BMap_CityListCtrl{
        right: 133px!important;
        top: 9px!important;
    }
    .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
    </style>
     
</head>
<body style="overflow:scroll;overflow-y:hidden;overflow-x: hidden;">
<!--todo 导航栏 -->

<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 1px;">
    <div class="navbar-header">
        <img src="${pageContext.request.contextPath}/resources/img/children_48px_1176086_easyicon.net.png" height="48" width="48"/>
        <a class="navbar-brand" href="#">WebGIS留守儿童信息社区</a>
     </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"
         style="background-color:#CCD993;">
        <ul class="nav navbar-nav">
            <!--class="active"-->
            <li>
                <a href="#"><span class="glyphicon glyphicon-globe"></span> 留守儿童地图</a>
            </li>
            <li>
                <a href="childrenChart.jsp"><span class="glyphicon glyphicon-signal"></span> 专题图表</a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-heart"></span>
                    爱心援助<strong class="caret"></strong></a>
                <ul class="dropdown-menu" >
                    <li>
                        <a href="#">爱心传递</a>
                    </li>
                 
                    </li>
                    <li>
                        <a href="#">我要献爱心</a>
                    </li>
    
                    </li>
                    <li>
                        <a href="#">认领留守儿童点</a>
                    </li>

                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control"/>
            </div>
            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>搜索</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a data-toggle="modal" href='#registerModal'><span class="glyphicon glyphicon-user"></span> 注册</a></li>
            <li><a data-toggle="modal" href='#loginModal'><span class="glyphicon glyphicon-log-in"></span> 登录 &nbsp;&nbsp;</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a  href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-list-alt"></span>
                    菜单<strong class="caret"></strong></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#">Action</a>
                    </li>
                    <li>
                        <a href="#">Another action</a>
                    </li>
                    <li>
                        <a href="#">Something else here</a>
                    </li>
                    <li class="divider">
                    </li>
                    <li>
                        <a href="#">Separated link</a>
                    </li>
                    <li class="divider">
                    </li>
                    <li>
                        <a href="#">One more separated link</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<!-- 地图模块-->
<div id="mapdiv" style="width: auto;height:584px;margin-top: 50px"></div>


<!-- 登录窗口-->
  <!-- Modal -->
  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">    
      <!-- 登录Modal -->
      <div class="modal-content" style="width: 500px;margin-left: 75px;">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> 登录</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
              <label for="loginId"><span class="glyphicon glyphicon-user"></span> 账号</label>
              <input type="text" class="form-control" id="loginId" placeholder="输入身份证号或手机号">
            </div>
            <div class="form-group">
              <label for="loginpassword"><span class="glyphicon glyphicon-eye-open"></span> 密码</label>
              <input type="password" class="form-control" id="loginpassword" placeholder="输入密码">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>记住我</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> 登录</button>
          </form>
        </div>
      </div>      
    </div>
  </div> 

<!-- 注册窗口-->
<div class="modal fade" id="registerModal">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 380px;margin-left: 120px;">
            <div class="modal-header" style="text-align: center;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">用户注册</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" style="padding: 0px 10px;">
                    <div class="input-group">
                        <span class="input-group-addon">姓名</span>
                        <input type="text" class="form-control" placeholder="请输入姓名">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">性别</span>
                        <label class="radio-inline" style="margin-left: 27px">
                        <input type="radio" name="optradio">男</label>
                        <label class="radio-inline"><input type="radio" name="optradio">女</label>
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">身份证号</span>
                        <input type="text" class="form-control" placeholder="请输入身份证号">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">联系电话</span>
                        <input type="text" class="form-control" placeholder="请输入联系电话">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">联系地址</span>
                        <input type="text" class="form-control" placeholder="请输入联系地址">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">登录密码</span>
                        <input id="password" type="password" class="form-control" placeholder="请设置密码">
                    </div><br>
                    <div class="input-group">
                        <span class="input-group-addon">重复密码</span>
                        <input id="password2" type="password" class="form-control" placeholder="请输入密码">
                    </div><br>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-primary" style="margin-right:50px;">提交
                            </button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>                         
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://libs.baidu.com/jqueryui/1.9.2/jquery-ui.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jspanel3/3.8.0/jquery.jspanel.min.js"></script>
<!-- 引入百度地图-->
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=dSnvyGmh8qbnGzPxO5N7f7LLqYOj56jD"></script>
<!-- 百度地图的弧线js-->
<script type="text/javascript" src="http://api.map.baidu.com/library/CurveLine/1.5/src/CurveLine.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/init.js"></script>

<script type="text/javascript">
$(document ).ready(function(){     
    $.jsPanel({ 
        //todo  发送ajax请求
        // contentAjax: {
        //         url: 'https://api.github.com/repos/Flyer53/jsPanel3/releases/latest',
        //         method: 'GET',
        //         dataType: 'json',
        //         done: function (data, textStatus, jqXHR, panel) {
        //             panel.content.css({padding: '10px'});
        //             // uses jquery-jsonview - https://github.com/yesmeck/jquery-jsonview
        //             $('#json').JSONView(data, {collapsed: true});
        //         }
        //     }，
        id:'resultPanel',
        contentSize: {width: 550, height: 300},
        theme:       'royalblue filledlight',
        headerTitle: '结果列表',
        contentOverflow: {vertical: 'scroll'}, //允许滚动条
        callback:    function() {
            // this.content.css('padding', '10px');
        },
        position:{top:86,right:10},
        content:" <div class='list-group'>"+
                "<a href='#' class='list-group-item'>First item</a>"+
                "<a href='#' class='list-group-item'>Second item</a>"+
                "<a href='#' class='list-group-item'>Third item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "<a href='#' class='list-group-item'>Fourth item</a>"+
                "</div>"
    });
});

    childrenMap.init.loadmap("重庆"); //默认重庆
</script>
</html>

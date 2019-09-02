$(function(){
    var userInfo = localApi.getLoginUser();
    //载入用户信息
    $(".top-info").first()
        .append("<span>"+userInfo.user.nickname+"</span>")
        .append("<a href='javascript:;' onclick='localApi.exit()'>退出</a>");

    //载入菜单
    var menus = null;
    for(var i=0; i<userInfo.menus.length; i++) {
        var obj = userInfo.menus[i];
        if(obj.type == consts.MENU_TYPE_SYSTEM) {
            //系统菜单就赋值
            menus = obj;
        }
    }
    if(!!menus && !!menus.childMenus) {
        for(var i=0; i<menus.childMenus.length; i++) {
            //1级菜单
            var lv1 = menus.childMenus[i];
            var str='';
            str += '<div>';
            str += '	<div class="menu1" onclick=\'to("'+lv1.url+'")\' rel="'+lv1.url+'">'+lv1.name+'<\/div>';
            //2级菜单
            if(!!lv1.childMenus && lv1.childMenus.length > 0) {
                str += '<div class="menu2">';
                for(var j=0; j<lv1.childMenus.length; j++) {
                    var lv2 = lv1.childMenus[j];
                    str += '<div onclick="to(\''+lv2.url+'\')">'+lv2.name+'<\/div>';
                }
                str += '<\/div>';
            }
            str += '<\/div>';
            $(".top-menu").first().append(str);
        }
    }


    $(".menu1").on("mousemove", function() {
        var showMenu2 = $(".menu2[style='display: block;']").first();
        if(!!showMenu2) {
            var parentDiv = showMenu2.prev("div[class='menu1']").first();
            if(parentDiv != $(this)) {
                showMenu2.hide();
            }
        }

        var menu2 = $(this).next("div[class='menu2']").first();
        if(!!menu2.length) {
            $(".menu2").each(function() {
                $(this).hide();
            });
            menu2.show();
        }
    });
    $(".menu2").on("mouseout", function(e) {
        var mouseX = e.clientX;
        var mouseY = e.clientY;
        var thisLeft = $(this).offset().left;
        var thisTop = $(this).offset().top;
        var thisWidth = $(this).width() + thisLeft;
        var thisHeight = $(this).height() + thisTop;
        if(mouseX > thisWidth || mouseY > thisHeight
            || mouseX < thisLeft || mouseY < thisTop) {
            $(this).hide();
        }
    });

    //判断是否给标签页加上选中效果
    var href = location.href;
    $(".menu1").each(function() {
        if(href.indexOf($(this).attr("rel")) > -1) {
            $(this).attr("class", "menu1 top-menu-sel");
        }
    });
});
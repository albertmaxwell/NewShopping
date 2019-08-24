
$(function(){
    getCookie();
})

//判断用户名和密码是否存在//登录
$(".login button").click(function(){
    var name = $(".int1").val();
    var password = $(".int2").val();
    if (name == ""||password=="") {
        alert('请输入用户名或密码！')
    }
    else {
        var data={
        "username": name,
        "password": password
    };
        var checked = $("input[name='checkbox']").prop("checked");
        $.base64.utf8encode = true;
        $.ajax({
            type: "Post",
            url: "/shopping/loginController/login",
            async: true,
            data:JSON.stringify(data),
            dataType: "json",
            contentType: 'application/json',
            success: function(data) {
                if(data.ok) {
                    window.location.href="index.html";
                    localStorage.setItem("name",data.data.userCode);

                    if(checked){
                        localStorage.setItem("name",data.data.userCode);
                        localStorage.setItem("loginTab","1");
                        localStorage.setItem("password",$.base64.encode(data.data.passWord));
                    }else{
                        localStorage.removeItem("password");
                    }
                }else{
                    alert("用户名或密码错误");
                }
            },
            error: function() {
                console.log("出错了");
            }
        })
    }

})

//记住用户名和密码
function getCookie(){ //获取cookie
    var name1 = localStorage.getItem("name");
    var password1 = localStorage.getItem("password");
    if(password1&&name1){
        $("[name='checkbox']").attr("checked","true");
        $(".int1").val(name1);
        $(".int2").val($.base64.decode(password1));
    }else{
        $("[name='checkbox']").attr("checked","false");
        $(".int1").val("");
        $(".int2").val("");
    }
}

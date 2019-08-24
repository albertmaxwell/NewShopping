$(function () {

    var app = new Vue({
        el: '#app',
        data(){
            return {
                people:'',
                openeds:["1","2"],
                DispClose:true
            };
        },
    created(){
        var name1 = localStorage.getItem("name");
        this.people=name1;
        var tab = localStorage.getItem("loginTab");
        if(tab!=="1"){
            alert("请先登录！")
            window.location.href="login.html";
        }
    },
        methods: {

            //退出登录
            exit(){
                this.$confirm('确认退出登录吗？', '提示', {}).then(() => {
                    window.location.href="login.html";
                    // localStorage.removeItem("name");
                    // localStorage.removeItem("password")
                    localStorage.removeItem("loginTab");
                });
            },
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            goAlert(){
                var newHeight=$(window).height();
                $('#my_frame').css({'height': newHeight});
                document.getElementById("my_frame").src="alert.html";
                // window.location.href="alert.html";
            },
            goUser(){
                var newHeight=$(window).height();
                $('#my_frame').css({'height': newHeight});
                // window.location.href="warnUser.html";
                document.getElementById("my_frame").src="warnUser.html";
            },
            goStage(){
                var newHeight=$(window).height();
                $('#my_frame').css({'height': newHeight});
                // window.location.href="stage.html";
                document.getElementById("my_frame").src="stage.html";
            },
            goManage(){
                var newHeight=$(window).height();
                $('#my_frame').css({'height': newHeight});
                document.getElementById("my_frame").src="user.html";
                // window.location.href="user.html";
            },
            goServe(){
                var newHeight=$(window).height();
                $('#my_frame').css({'height': newHeight});
                document.getElementById("my_frame").src="serve.html";
                // window.location.href="user.html";
            },
        },
        mounted(){
            // 关闭浏览器窗口的时候清空浏览器缓存在localStorage的数据
            // window.onbeforeunload = function (e) {
            //     var storage = window.localStorage;
            //     storage.removeItem("loginTab")
            // }
            window.onunload=function(){
                localStorage.removeItem("loginTab");
            }
        }
   
    })
})
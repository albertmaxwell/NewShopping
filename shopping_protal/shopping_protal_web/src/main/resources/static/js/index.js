$(function () {

    var app = new Vue({
        el: '#app',
        data(){
            return {
                people:'',
                openeds:["1","2"]
            };
        },
    created(){
        var name1 = localStorage.getItem("name");
        this.people=name1;
    },
        methods: {
            //退出登录
            exit(){
                this.$confirm('确认退出登录吗？', '提示', {}).then(() => {
                    window.location.href="login.html";
                    localStorage.removeItem("name");
                    localStorage.removeItem("password")
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
            }
        },

    })
})
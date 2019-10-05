function getGoodsClass(obj) {
    var pid=$(obj).attr("id");
    var level=$(obj).attr("level");
    var next=parseInt($(obj).attr("next"));
    var param={'pid':pid};
    $.ajax({
        async: false,
        type: 'GET',
        url: '/requestGoods/loadGoodsclass',
        dataType:'json',
        data: param, //请求参数
        beforeSend: function () {
            //把这个节点的下下所有的都隐藏
            for(var i=4;i>=next;i--){
                jQuery("#goodClass"+i).empty();
                jQuery("#class_"+i).hide();
            }
        },
        success: function (data) {
            var count=next+1;
            for ( var i = 0; i <data.data.length; i++){
                console.log(data.data[i].id);
                var str="<li id='"+data.data[i].id+"'  level='"+next+"' onclick='getGoodsClass(this)' name='"+data.data[i].className+"' next='"+count+"'>'"+data.data[i].className+"'</li>";
                $("#goodClass"+next).append(str);
                jQuery("#class_"+next).show();
            }
        }
    });
}
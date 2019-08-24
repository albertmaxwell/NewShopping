$(function () {
    let detailStage=[];
    var app = new Vue({
        el: '#app',
        data(){
            return {
                url: {
                    getApply: '/monitor/applySetController/queryApplyWarn',
                    doAdd:'/monitor/warnApplyController/add',
                    doUpdate:'/monitor/warnApplyController/update',

                },
                value:false,
                activeIndex: '1',
                detailStage:[],
                detailPeople:[],
                favourableForm:[],
                favourableForm2:[],
                checked1:false,
                checked:false,
                obj1:{},
                obj2:{},
                sels1:[],
                sels2:[],
                id:"",
                radio:"",
                formInline: {
                    user: '',
                    region: ''
                },
                total: 0,
                page: 1,
                pageSize:10,
                sort:{
                    sort:'id',
                    order:'desc'
                },
                rules:{},
                cang:true,
                tableData: [],
                ruleForm: {
                },
                formTitle:"新增",
                formLoading:false,
                or:""
            };
        },
        created:function(){
            this.detail();
        },
        methods: {
            //单选
            handleSelectionChange (row) {
                $(this.detailStage).each(function(index, ele){
                        if (ele.warntacticId !== row.warntacticId) {
                            ele.checked = false;
                                }else{
                            ele.checked = true;
                        }

                });
                this.selsChange1(0,row)

            },
            //分页
            handleCurrentChange(val) {
                this.page = val;
                this.detail();
            },
            handleSizeChange(val) {
                this.pageSize = val;
                this.page = 1;
                this.detail();
            },
            //编辑/新增提交
            changeUpdate(index, row){
                this.formTitle='编辑';
                this.cang = false;
                var other=Object.assign({}, row);
                this.id =other.id;
                var _this = this;
                var url="/monitor/warnApplyController/queryByOpenId"+"/"+this.id;
                this.$http.get(url).then((res) => {

                    if (res.data.ok) {
                        this.detailPeople=res.data.data.warnuser;
                        this.detailStage=res.data.data.warntactic;

                        // this.detailStage.forEach(function(item, index){
                        //     if (item.seted === 1) {
                        //         item.checked=true;
                        //         _this.sels1.push(item.warntacticId);
                        //     }
                        // });
                        for(var i=0;i<this.detailStage.length;i++){
                            if (this.detailStage[i].seted === 1) {
                                this.detailStage[i].checked=true;
                                _this.sels1.push(this.detailStage[i].warntacticId);
                            }
                        }
                        for(var i=0;i<this.detailPeople.length;i++){
                            if (this.detailPeople[i].seted === 1) {
                                this.detailPeople[i].checked1=true;
                                _this.sels2.push(this.detailPeople[i].warnUserId);
                            }
                        }
                        // this.detailPeople.forEach(function(item, index){
                        //     if (item.seted === 1) {
                        //         item.checked1=true;
                        //         _this.sels2.push(item.warnUserId);
                        //     }
                        // });
                        console.log(this.sels1);
                        console.log(this.sels2);
                    } else {
                        console.log("不ok");
                    }
                });
            },
            //预警配置详细信息
            handleEdit: function (index, row) {
                this.formTitle='预警配置';
                this.cang = false;
                var other=Object.assign({}, row);
                this.id =other.id;
                var url="/monitor/warnApplyController/queryByOpenId"+"/"+this.id;
                this.$http.get(url).then((res) => {
                    if (res.data.ok) {
                        this.detailPeople=res.data.data.warnuser;
                        this.detailStage=res.data.data.warntactic;
                    } else {
                        console.log("不ok");
                    }

                });

            },

            //新增
            formSubmit(){
                        this.$confirm('确认提交吗？', '提示', {}).then(() => {
                            var userId=[];
                            for (var i=0;i<this.sels2.length;i++) {
                                userId.push(this.sels2[i])
                            }
                            var data1={
                                "applyId": this.id,
                                "warnId": this.sels1[0],
                                "warnUserId": userId
                            };
                            this.$http.post(this.url.doUpdate,data1).then((res) => {
                                if (res.data.ok) {
                                    this.or=true;
                                    this.formLoading = false;
                                    this.$message({
                                        message: '提交成功',
                                        type: 'success',
                                        duration:1500
                                    });
                                    this.cang = true;
                                    this.detail();
                                } else {
                                    this.$message({
                                        message: '提交失败',
                                        type: 'error',
                                        duration:1500
                                    });
                                    this.cang = true;
                                    this.detail();
                                    console.log("不ok");
                                }
                            });
                            });

            },


            //选中项
            selsChange1: function (index, row) {
                let sels1=[];
                if(row.checked){
                    sels1.push(row.warntacticId)
                }
                this.sels1 = sels1;
                console.log(this.sels1);
            },
            selsChange2: function (index, row) {
                let _this=this;
                if(row.checked1){
                    this.sels2.push(row.warnUserId);
                }else{
                    // row.checked1=false;
                    for(var index=0;index<this.sels2.length;index++){
                        if (this.sels2[index] === row.warnUserId) {
                            _this.sels2.splice(index,1);
                        }
                    };
                }
                console.log(this.sels2);
            },
            //查询
            query(){

            },
            //下拉服务状态
            formatterColumn(row, column) {
                switch(row.serveSta){
                    case "0":
                        row.value=false;
                        return '正常';
                        break;
                    default:
                        row.value=true;
                        return '异常';
                        break;
                }
            },
            //获取列表信息
            detail(){
                var data1={params:{
                        page:this.page-1,
                        size:this.pageSize,
                        openSta:1
                    }};
                this.$http.get(this.url.getApply,data1).then((res) => {
                    if (res.data.message) {
                        this.total = res.data.data.totalElements;
                        //表单数据
                        this.tableData=res.data.data;

                    } else {
                        console.log("不ok");
                    }

                });

            },
            // //获取分页，rowKeys
            // getRowKeys(row) {
            //     return row.id;
            // },

            //新增页面是否显示
            cancel(){
                this.cang=true;
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
        },


    })

})
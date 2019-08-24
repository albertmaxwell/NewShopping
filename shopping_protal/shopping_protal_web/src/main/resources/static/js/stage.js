$(function () {
    var id ;
    var app = new Vue({
        el: '#app',
        data(){
            return {
                url: {
                    getStage: '/monitor/warnTacticController/getWarnTacticPage',
                    doAdd:'/monitor/warnTacticController/add',
                    doUpdate:'/monitor/warnTacticController/update',
                    doDelete:'/monitor/warnTacticController/deleteById'
                },
                activeIndex: '1',
                //查询条件
                formInline: {
                    user: '',
                    region: ''
                },
                formLoading:false,
                tableData: [],
                total: 0,
                page: 1,
                user:"",
                pageSize:10,
                sort:{
                    sort:'id',
                    order:'desc'
                },
                ruleForm: {
                },
                rules:{

                },
                formTitle:"新增",
                init0:false,
            };
        },
        methods: {

            handleCurrentChange(val) {
                this.page = val;
                this.detail();
            },
            handleSizeChange(val) {
                this.pageSize = val;
                this.page = 1;
                this.detail();
            },
            //提交新增
            formSubmit(){
                var _this = this;
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        this.$confirm('确认提交吗？', '提示', {}).then(() => {
                            this.formLoading = false;
                            this.user=localStorage.getItem("name");
                        if(this.ruleForm.id!=""&&this.ruleForm.id!=undefined&&this.ruleForm.id!=null){
                            this.ruleForm.updateBy=this.user;
                        }else{
                            this.ruleForm.createBy=this.user;
                        }
                            let para = Object.assign({}, this.ruleForm)
                            var paras = JSON.stringify(Object.assign({}, this.ruleForm));
                            this.$http.post(!!para.id?this.url.doUpdate:this.url.doAdd,paras).then((res) => {
                                _this.formLoading = true;
                                _this.$message({
                                    message: '提交成功',
                                    type: 'success',
                                    duration:1500
                                });
                                _this.formLoading = false;
                                _this.detail();
                            });
                        });
                    }
                });
            },
            cancel(){
                this.formLoading = false;
                this.detail();
            },
            //删除
            handleDel: function (row) {
                var _this = this;
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    var delUrl = this.url.doDelete + "/" + row.id;
                    this.$http.post(delUrl).then((res) => {
                        if(res.ok)
                        {
                            _this.$message({
                                message: '删除成功',
                                type: 'success',
                                duration: 1500
                            });
                            _this.detail();
                        }else{
                            _this.$message({
                                message: '删除失败',
                                type: 'success',
                                duration: 1500
                            });
                            _this.detail();
                        }
                    });
                }).catch(() => {

                });
            },
            //获取列表信息
            detail(){
                this.init0 = true;
                var _this = this;
                var data={params:{
                        page:this.page-1,
                        size:this.pageSize
                    }};
                this.$http.get(this.url.getStage,data).then((res) => {

                    if (res.ok) {
                        _this.total = res.data.data.totalElements;
                        _this.tableData = res.data.data.content;
                        console.log(_this.tableData);
                    } else {
                        console.log("不ok");
                    }

                });

            },
            query(){

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
            handleClick(row) {
                console.log(row);
            },
            //显示新增页面
            goAdd() {
                this.formTitle = "新增";
                this.formLoading=true;
                this.ruleForm = {
                    warnName:'',
                    reminNum:'',
                    intervalDate:'',
                    notePad:'',
                    abnormalTime:'',

                    createBy:'',
                    createName:'',
                    createDate:'',
                    updateBy:'',
                    updateName:'',
                    updateDate:'',
                };
            },
            goEdit: function (row) {
                this.formLoading=true;
                this.formTitle = "编辑"
                this.ruleForm = Object.assign({}, row);
            },

        },
        mounted() {
            this.detail();
        }
    })
})
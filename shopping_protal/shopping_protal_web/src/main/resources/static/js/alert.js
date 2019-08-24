$(function () {
    var app = new Vue({
        el: '#app',
        data(){
            return {
                url: {
                    getApply: '/monitor/applySetController/getApplyPage',
                    doAdd:'/monitor/applySetController/add',
                    doUpdate:'/monitor/applySetController/update',

                },
                value:false,
                activeIndex: '1',
                formInline: {
                    user: '',
                    region: ''
                },
                user:"",
                total: 0,
                page: 1,
                pageSize:10,
                sort:{
                    sort:'id',
                    order:'desc'
                },
                rules:{
                    heartKey:[
                        {required: true, message: '请填写分配唯一key值：【xxxx】', trigger: 'blur'},
                    ]
                },
                cang:true,
                tableData: [],
                ruleForm: {
                },
                formTitle:"新增",
                formLoading:false
            };
        },
        created:function(){
            this.detail();
        },
        methods: {
            //检验heartKey唯一性
            checkCode(){
                var params = this.ruleForm.heartKey;
                if(!!params){
                    var url="/monitor/applySetController/isExist/"+params;
                    this.$http.post(url).then((res) => {
                        if(res.data.ok)
                        {
                            if (res.data.data==="存在") {
                                this.$message({
                                    message: '该HeartKey已存在',
                                    type: 'error',
                                    duration:1500
                                });
                                this.ruleForm.heartKey="";
                            } else {

                            }
                        }else{

                        }

                    });
                }
            },

            handleCurrentChange(val) {
                this.page = val;
                this.detail();
            },
            handleSizeChange(val) {
                this.pageSize = val;
                this.page = 1;
                this.detail();
            },
            //删除
            handleDel: function (index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    this.listLoading = true;
                    var id=row.id;
                    var del="/monitor/applySetController/deleteById/"+id+"";
                    console.log(del);
                    this.$http.post(del,{emulateJSON: true}).then((res) => {
                        this.listLoading = false;
                        this.$message({
                            message: '删除成功',
                            type: 'success',
                            duration:1500
                        });
                        this.detail();
                    });
                }).catch(() => {

                });
            },
            //编辑
            handleEdit: function (index, row) {
                this.formTitle='编辑';
                this.cang = false;
                this.ruleForm=Object.assign({}, row);
                delete this.ruleForm["serveSta"];
                console.log(this.ruleForm);
                // this.ruleForm.ip=form.ip;
                // this.ruleForm.port=form.port;
                // this.ruleForm.proName=form.proName;
                // this.ruleForm.domain=form.domain;
                // this.ruleForm.heartKey=form.heartKey;
                // this.ruleForm.notePad=form.notePad;
                // this.ruleForm.testLine=form.testLine;
            },
            //提交新增
            formSubmit(){
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        this.$confirm('确认提交吗？', '提示', {}).then(() => {
                            this.user=localStorage.getItem("name");
                            console.log(this.user);
                            this.formLoading = true;
                            if(this.ruleForm.id!=""&&this.ruleForm.id!=undefined&&this.ruleForm.id!=null){
                                this.ruleForm.updateBy=this.user;
                            }else{
                                this.ruleForm.createBy=this.user;
                            }
                            let para = Object.assign({}, this.ruleForm);
                            this.$http.post(!!para.id?this.url.doUpdate:this.url.doAdd,JSON.stringify(para),{emulateJSON: true}).then((res) => {
                                this.formLoading = false;
                                this.$message({
                                    message: '提交成功',
                                    type: 'success',
                                    duration:1500
                                });
                                this.$refs['ruleForm'].resetFields();
                                this.cang = true;
                                this.detail();
                            });
                        });
                    }
                });
            },
            query(){

            },
            //下拉服务状态
            formatterColumn(row) {
                switch(row.serveSta){
                    case "0":
                        return "正常";
                        break;
                    case "1":
                        return "异常";
                        break;
                    default:
                        return '';
                }
            },
            //获取列表信息
            detail(){
                var data1={params:{
                        page:this.page-1,
                        size:this.pageSize
                    }};
                this.$http.get(this.url.getApply,data1).then((res) => {
                    if (res.data.message) {
                        this.total = res.data.data.totalElements;
                        this.tableData=res.data.data.content;
                        this.tableData.forEach(row => {
                               if(row.openSta==="1"){
                                   row.value=true;
                               }else {
                                   row.value=false;
                                   row.serveSta="";
                               }
                        });

                    } else {
                        console.log("不ok");
                    }

                });

            },
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
            //开启状态
            handleClick(index,row) {
                var changeStatu='/monitor/applySetController/openStatus';
                var id=this.tableData[index].id;
                var statu;
                if(row.value){
                    statu=1;
                    changeStatu=changeStatu+"/"+id+"/"+statu;
                    this.$http.post(changeStatu).then((res) => {

                        if (res.data.ok) {
                            row.serveSta=res.data.data;
                            row.value=true;
                                         } else {
                            //console.log("不ok");
                        }

                    });
                }else {
                    statu=0;
                    changeStatu=changeStatu+"/"+id+"/"+statu;
                    this.$http.post(changeStatu).then((res) => {
                        if (res.data.ok) {
                            row.serveSta="";
                            row.value=false;
                        } else {
                            //console.log("不ok");
                        }

                    });
                }

            },
            //显示新增页面
            goAdd() {
                this.formTitle="新增";
                this.cang=false;
                this.ruleForm = {
                    ip:'',
                    domain:'',
                    port:'',
                    heartKey:'',
                    notePad:'',
                    proName:'',
                    testLine:'',

                };
            }
        }
    })
})
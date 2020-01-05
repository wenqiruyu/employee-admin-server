webpackJsonp([7],{AeWw:function(e,t){},"N+KJ":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l={name:"basetable",data:function(){return{url:"./vuetable.json",tableData:[],cur_page:1,multipleSelection:[],select_cate:"",select_word:"",del_list:[],is_search:!1,editVisible:!1,delVisible:!1,form:{name:"",date:"",address:""},idx:-1}},created:function(){var e=this,t=this;this.$axios.post("/employee-admin-server/menu/getMenu",{username:localStorage.getItem("employee_username")}).then(function(a){1==a.data.status?(t.tableData=a.data.data.slice(),console.log(a.data.data),e.$message({message:"恭喜你，这是一条成功消息",type:"success"})):e.$message.error(a.data.msg)})},computed:{data:function(){var e=this;return this.tableData.filter(function(t){for(var a=0;a<e.del_list.length;a++)if(t.name===e.del_list[a].name){!0;break}})}},methods:{handleCurrentChange:function(e){this.cur_page=e,this.getData()},getData:function(){var e=this;this.$axios.post(this.url,{page:this.cur_page}).then(function(t){e.tableData=t.data.list})},search:function(){this.is_search=!0},formatEmail:function(e,t){return null===e.email?"为绑定":e.email},formatQQ:function(e,t){return null===e.qq?"为绑定":e.qq},formatBirthday:function(e,t){return null===e.birthday?"为绑定":e.birthday},formatSex:function(e,t){return 1===e.sex?"男":2===e.sex?"女":"保密"},formatDate:function(e,t){return e.createTime},filterTag:function(e,t){return t.tag===e},handleEdit:function(e,t){this.idx=e;var a=this.tableData[e];this.form={name:a.name,date:a.date,address:a.address},this.editVisible=!0},handleDelete:function(e,t){this.idx=e,this.delVisible=!0},delAll:function(){var e=this.multipleSelection.length,t="";this.del_list=this.del_list.concat(this.multipleSelection);for(var a=0;a<e;a++)t+=this.multipleSelection[a].name+" ";this.$message.error("删除了"+t),this.multipleSelection=[]},handleSelectionChange:function(e){this.multipleSelection=e},saveEdit:function(){this.$set(this.tableData,this.idx,this.form),this.editVisible=!1,this.$message.success("修改第 "+(this.idx+1)+" 行成功")},deleteRow:function(){this.tableData.splice(this.idx,1),this.$message.success("删除成功"),this.delVisible=!1}}},i={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"table"},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"iconfont icon-wen-book"}),e._v(" 图书管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("图书列表")])],1)],1),e._v(" "),a("div",{staticClass:"container"},[a("div",{staticClass:"handle-box"},[a("el-button",{staticClass:"handle-del mr10",attrs:{type:"primary",icon:"delete"},on:{click:e.delAll}},[e._v("批量删除")]),e._v(" "),a("el-select",{staticClass:"handle-select mr10",attrs:{placeholder:"筛选省份"},model:{value:e.select_cate,callback:function(t){e.select_cate=t},expression:"select_cate"}},[a("el-option",{key:"1",attrs:{label:"广东省",value:"广东省"}}),e._v(" "),a("el-option",{key:"2",attrs:{label:"湖南省",value:"湖南省"}})],1),e._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}}),e._v(" "),a("el-button",{attrs:{type:"primary",icon:"search"},on:{click:e.search}},[e._v("搜索")])],1),e._v(" "),a("el-table",{ref:"multipleTable",staticClass:"table",attrs:{data:e.tableData,border:""},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"书名",width:"180"}}),e._v(" "),a("el-table-column",{attrs:{prop:"author",label:"作者",width:"100"}}),e._v(" "),a("el-table-column",{attrs:{prop:"press",label:"出版社",width:"120"}}),e._v(" "),a("el-table-column",{attrs:{prop:"publishDate",label:"出版时间",sortable:"",width:"110"}}),e._v(" "),a("el-table-column",{attrs:{prop:"price",label:"价格",sortable:"",width:"80"}}),e._v(" "),a("el-table-column",{attrs:{prop:"stock",label:"库存",width:"60"}}),e._v(" "),a("el-table-column",{attrs:{prop:"grade",label:"评分",sortable:"",width:"80",sortable:""}}),e._v(" "),a("el-table-column",{attrs:{prop:"commentNum",label:"评论",sortable:"",width:"80"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",label:"上架时间",sortable:"",width:"160"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"160",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",icon:"iconfont icon-wen-update1"},on:{click:function(a){return e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{staticClass:"red",attrs:{type:"text",icon:"iconfont icon-wen-custom-delete"},on:{click:function(a){return e.handleDelete(t.$index,t.row)}}},[e._v("下架")])]}}])})],1),e._v(" "),a("div",{staticClass:"pagination"},[a("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:1e3},on:{"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"编辑",visible:e.editVisible,width:"30%"},on:{"update:visible":function(t){e.editVisible=t}}},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"50px"}},[a("el-form-item",{attrs:{label:"日期"}},[a("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.form.date,callback:function(t){e.$set(e.form,"date",t)},expression:"form.date"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"姓名"}},[a("el-input",{model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"地址"}},[a("el-input",{model:{value:e.form.address,callback:function(t){e.$set(e.form,"address",t)},expression:"form.address"}})],1)],1),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.editVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.saveEdit}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"提示",visible:e.delVisible,width:"300px",center:""},on:{"update:visible":function(t){e.delVisible=t}}},[a("div",{staticClass:"del-dialog-cnt"},[e._v("删除不可恢复，是否确定删除？")]),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.delVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.deleteRow}},[e._v("确 定")])],1)])],1)},staticRenderFns:[]};var s=a("VU/8")(l,i,!1,function(e){a("AeWw")},"data-v-2c3cd202",null);t.default=s.exports}});
//# sourceMappingURL=7.151179487febbf45615a.js.map
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0d5f"],{"2d44":function(e,t,a){"use strict";var r=a("9082"),i=a.n(r);i.a},"50ad":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("Input",{staticStyle:{width:"300px","margin-bottom":"10px",float:"left"},attrs:{search:"","enter-button":"查询",placeholder:"请输入查询关键字，如所属楼栋、业主"},on:{"on-search":e.searchButton},model:{value:e.searchData,callback:function(t){e.searchData=t},expression:"searchData"}}),a("Button",{staticStyle:{float:"right"},attrs:{icon:"md-download",loading:e.exportLoading},on:{click:e.exportExcelModel}},[e._v("模板下载")]),a("Button",{staticStyle:{float:"right"},attrs:{icon:"md-download",loading:e.exportLoading},on:{click:e.exportExcel}},[e._v("导出文件")]),a("Upload",{staticStyle:{float:"right"},attrs:{action:"","before-upload":e.handleBeforeUpload,accept:".xls, .xlsx"}},[a("Button",{attrs:{icon:"ios-cloud-upload-outline",loading:e.uploadLoading},on:{click:e.handleUploadFile}},[e._v("上传文件")])],1),a("Button",{staticStyle:{float:"right"},attrs:{icon:"md-add"},on:{click:function(t){e.isAddNewData=!0}}},[e._v("新增")]),a("Button",{staticStyle:{float:"right"},attrs:{type:"primary"},on:{click:e.showEmptyRoom}},[e._v("空闲房间")]),a("div",{staticStyle:{clear:"both"}}),a("Modal",{attrs:{closable:!1,"mask-closable":!1,title:"新增办公室信息填写"},model:{value:e.isAddNewData,callback:function(t){e.isAddNewData=t},expression:"isAddNewData"}},[a("Form",{ref:"formValidate",attrs:{model:e.formValidate,rules:e.ruleValidate,"label-width":100}},[a("FormItem",{attrs:{label:"所属办公楼",prop:"buildingName"}},[a("Select",{staticStyle:{width:"200px"},attrs:{"transfer:true":""},model:{value:e.formValidate.buildingName,callback:function(t){e.$set(e.formValidate,"buildingName",t)},expression:"formValidate.buildingName"}},e._l(e.buildingData,function(t){return a("Option",{key:t.buildingName,attrs:{value:t.buildingName}},[e._v(e._s(t.buildingName))])}))],1),a("FormItem",{attrs:{label:"房号",prop:"roomNumber"}},[a("Input",{attrs:{clearable:""},model:{value:e.formValidate.roomNumber,callback:function(t){e.$set(e.formValidate,"roomNumber",t)},expression:"formValidate.roomNumber"}})],1),a("FormItem",{attrs:{label:"计租面积",prop:"rentArea"}},[a("Input",{attrs:{clearable:"",placeholder:"单位(㎡)"},model:{value:e.formValidate.rentArea,callback:function(t){e.$set(e.formValidate,"rentArea",t)},expression:"formValidate.rentArea"}})],1),a("FormItem",{attrs:{label:"建筑面积",prop:"buildingArea"}},[a("Input",{attrs:{clearable:"",placeholder:"单位(㎡)"},model:{value:e.formValidate.buildingArea,callback:function(t){e.$set(e.formValidate,"buildingArea",t)},expression:"formValidate.buildingArea"}})],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("Button",{attrs:{type:"text",size:"large"},on:{click:function(t){e.handleReset("formValidate")}}},[e._v("取消")]),a("Button",{attrs:{type:"primary",size:"large"},on:{click:function(t){e.handleSubmit("formValidate")}}},[e._v("确定")])],1)],1),a("Table",{ref:"table",attrs:{border:"",columns:e.dataColumns,data:e.pageData,height:"522"},scopedSlots:e._u([{key:"id",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.id))])]}},{key:"buildingName",fn:function(t){var r=t.row;t.index;return[a("span",[e._v(e._s(r.buildingName))])]}},{key:"roomNumber",fn:function(t){var r=t.row;t.index;return[a("span",[e._v(e._s(r.roomNumber))])]}},{key:"rentArea",fn:function(t){var r=t.row,i=t.index;return[e.editIndex===i?a("Input",{attrs:{type:"text"},model:{value:e.editRentArea,callback:function(t){e.editRentArea=t},expression:"editRentArea"}}):a("span",[e._v(e._s(r.rentArea))])]}},{key:"buildingArea",fn:function(t){var r=t.row,i=t.index;return[e.editIndex===i?a("Input",{attrs:{type:"text"},model:{value:e.editBuildingArea,callback:function(t){e.editBuildingArea=t},expression:"editBuildingArea"}}):a("span",[e._v(e._s(r.buildingArea))])]}},{key:"owner",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.owner))])]}},{key:"action",fn:function(t){var r=t.row,i=t.index;return[e.editIndex===i?a("div",[a("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"primary"},on:{click:function(t){e.handleSave(i)}}},[e._v("保存")]),a("Button",{attrs:{type:"error"},on:{click:function(t){e.handleCancel(i)}}},[e._v("取消")])],1):a("div",[a("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"primary"},on:{click:function(t){e.handleEdit(r,i)}}},[e._v("修改")]),a("Button",{attrs:{type:"error"},on:{click:function(t){e.handleDelete(i)}}},[e._v("删除")])],1)]}}])}),a("span",[e._v("记录总共 "+e._s(this.dataCount)+" 条")]),a("Page",{attrs:{total:e.dataCount,"show-sizer":"",current:e.pageCurrent,"page-size-opts":[10,20,50,100],align:"center"},on:{"on-change":e.changePage,"on-page-size-change":e.changePageNumber}})],1)},i=[],n=(a("28a5"),a("7f7f"),a("66df")),o=a("0a21"),l={data:function(){return{dataType:"仓办",isAddNewData:!1,buildingData:[],formValidate:{roomNumber:"",buildingName:"",rentArea:"",buildingArea:"",insertTime:""},ruleValidate:{roomNumber:[{required:!0,message:"请输入正确的房间号",trigger:"blur",transform:function(e){var t=/^\d+$/;return!!t.test(e)&&String(e)}}],buildingName:[{required:!0,message:"所属办公楼不得为空",trigger:"change"}],rentArea:[{required:!0,message:"请输入正确的面积大小",trigger:"blur",transform:function(e){var t=/^\d*\.?\d+$/;return!!t.test(e)&&String(e)}}],buildingArea:[{required:!0,message:"请输入正确的面积大小",trigger:"blur",transform:function(e){var t=/^\d*\.?\d+$/;return!!t.test(e)&&String(e)}}]},searchData:"",uploadLoading:!1,file:null,uploadTableData:[],exportLoading:!1,excelDataModel:[{roomNumber:"必须是数字，例如:101",buildingName:"必须是楼栋管理里存在的名称",rentArea:"必须是数字，单位(㎡)",buildingArea:"必须是数字，单位(㎡)"}],editIndex:-1,editRentArea:"",editBuildingArea:"",pageCurrent:1,pageStart:0,dataCount:0,pageSize:10,pageData:[],dataColumns:[{type:"index",width:60,align:"center",indexMethod:function(e){return e._index+1+(e.pageCurrent-1)*e.pageSize}},{title:"所属楼栋",key:"buildingName",align:"center",slot:"buildingName"},{title:"房号",key:"roomNumber",align:"center",slot:"roomNumber"},{title:"业主",key:"owner",align:"center",slot:"owner"},{title:"计租面积(㎡)",key:"rentArea",align:"center",slot:"rentArea"},{title:"建筑面积(㎡)",key:"buildingArea",align:"center",slot:"buildingArea"},{title:"添加时间",key:"insertTime",align:"center"},{title:"修改时间",key:"updateTime",align:"center"},{title:"操作",width:180,align:"center",slot:"action"}]}},methods:{showEmptyRoom:function(){this.searchData="空闲",this.getRequestData(1)},handleSubmit:function(e){var t=this;this.$refs[e].validate(function(a){if(a){var r=t,i=t.formValidate;i.insertTime=t.getFormatDate(),n["a"].request({url:"/room/insertRoomList",method:"post",headers:{"Content-Type":"application/json;charset=UTF-8"},data:i}).then(function(e){1==e.data?(r.$Message.success("添加成功"),r.getRequestData(r.pageCurrent)):-1==e.data?r.$Message.error("已有该房间存在"):r.$Message.error("添加失败")}).then(function(){r.$refs[e].resetFields()}),t.isAddNewData=!1}})},handleReset:function(e){this.$refs[e].resetFields(),this.isAddNewData=!1},uploadExcelData:function(e){for(var t in e)e[t].roomNumber=e[t].房号,e[t].buildingName=e[t].所属楼栋,e[t].rentArea=e[t].计租面积,e[t].builtUpArea=e[t].建筑面积,e[t].insertTime=this.getFormatDate(),delete e[t].房号,delete e[t].所属楼栋,delete e[t].计租面积,delete e[t].建筑面积;var a=0;for(var t in e)""==e[t].roomNumber||null==e[t].roomNumber||void 0==e[t].roomNumber||""==e[t].buildingName||null==e[t].buildingName||void 0==e[t].buildingName||""==e[t].rentArea||null==e[t].rentArea||void 0==e[t].rentArea||""==e[t].builtUpArea||null==e[t].builtUpArea||void 0==e[t].builtUpArea?a+=1:a+=0;if(0==a){var r=this;n["a"].request({url:"/room/uploadRoomList",method:"post",headers:{"Content-Type":"application/json;charset=UTF-8"},data:e}).then(function(t){if(0==t.data)r.$Message.error("未知原因，导入失败");else if(-1==t.data)r.$Message.error("导入失败，表内无数据");else if(-2==t.data)r.$Message.error("导入失败，数据全部存在");else{if(t.data==e.length)r.$Message.success("导入成功");else if(t.data<e.length){var a=e.length-t.data;r.$Message.info(a+"条数据因无效而未导入")}r.getRequestData(r.pageCurrent)}})}else this.$Message.error("该表内有"+a+"行数据有空项"),a=0},initUpload:function(){this.file=null,this.uploadTableData=[]},handleUploadFile:function(){this.initUpload()},handleBeforeUpload:function(e){var t=e.name.split(".").pop().toLocaleLowerCase();return"xlsx"===t||"xls"===t?(this.readFile(e),this.file=e):this.$Notice.warning({title:"文件类型错误",desc:"文件："+e.name+"不是EXCEL文件，请选择后缀为.xlsx或者.xls的EXCEL文件。"}),!1},readFile:function(e){var t=this,a=new FileReader;a.readAsArrayBuffer(e),a.onloadstart=function(e){t.uploadLoading=!0},a.onprogress=function(e){t.progressPercent=Math.round(e.loaded/e.total*100)},a.onerror=function(e){t.$Message.error("文件读取出错")},a.onload=function(e){var a=e.target.result,r=o["a"].read(a,"array"),i=(r.header,r.results);t.uploadTableData=i,t.uploadLoading=!1,t.uploadExcelData(t.uploadTableData)}},exportExcelModel:function(){if(this.excelDataModel.length){this.exportLoading=!0;var e={title:["房号","所属楼栋","计租面积","建筑面积"],key:["roomNumber","buildingName","rentArea","buildingArea"],data:this.excelDataModel,autoWidth:!0,filename:"仓办管理信息表模板"};o["a"].export_array_to_excel(e),this.exportLoading=!1}else this.$Message.info("表格数据不能为空！")},exportExcel:function(){if(this.pageData.length){this.exportLoading=!0;var e={title:["房号","所属楼栋","计租面积","建筑面积"],key:["roomNumber","buildingName","rentArea","buildingArea"],data:this.pageData,autoWidth:!0,filename:"仓办管理信息表"};o["a"].export_array_to_excel(e),this.exportLoading=!1}else this.$Message.info("表格数据不能为空！")},searchButton:function(e){this.searchData=e,this.pageCurrent=1,this.getRequestData(this.pageCurrent)},handleDelete:function(e){var t=this;this.$Modal.confirm({title:"删除提示",content:"<p>是否确认删除该条记录？</p>",onOk:function(){var a=t,r=t.pageData[e];n["a"].request({url:"/room/deleteRoomList",method:"post",headers:{"Content-Type":"application/json;charset=UTF-8"},data:r}).then(function(e){1==e.data?(a.$Message.success("删除成功"),a.pageData.length<=1&&1!=a.pageCurrent&&(a.pageCurrent=a.pageCurrent-1),a.getRequestData(a.pageCurrent)):a.$Message.error("删除失败")})},onCancel:function(){}}),this.editIndex=-1},handleEdit:function(e,t){this.editRentArea=e.rentArea,this.editBuildingArea=e.buildingArea,this.editIndex=t},handleCancel:function(e){this.editIndex=-1},handleSave:function(e){var t=this,a=this.pageData;this.pageData[e].rentArea=this.editRentArea,this.pageData[e].buildingArea=this.editBuildingArea,""==this.pageData[e].rentArea||null==this.pageData[e].rentArea||void 0==this.pageData[e].rentArea||""==this.pageData[e].buildingArea||null==this.pageData[e].buildingArea||void 0==this.pageData[e].buildingArea?this.$Message.error("有内容未填写"):(this.pageData[e].updateTime=this.getFormatDate(),a=this.pageData[e],n["a"].request({url:"/room/updateRoomList",method:"post",headers:{"Content-Type":"application/json;charset=UTF-8"},data:a}).then(function(e){1==e.data?t.$Message.success("保存成功"):-1==e.data?t.$Message.error("该楼已有该房号"):t.$Message.error("保存失败"),t.getRequestData(t.pageCurrent)}).then(function(){t.changePage(t.pageCurrent)}),this.editIndex=-1)},changePageNumber:function(e){this.pageSize=e,1===this.pageCurrent&&this.changePage(this.pageCurrent)},changePage:function(e){this.pageCurrent=e,this.getRequestData(e)},getRequestData:function(e){var t=this;this.pageStart=(e-1)*this.pageSize,n["a"].request({url:"/room/getSearchList",method:"get",params:{search:this.searchData,dataStart:this.pageStart,dataSize:this.pageSize,dataType:this.dataType}}).then(function(e){t.pageData=e.data.roomList,t.dataCount=e.data.dataCount,t.addPageCurrentAndPageSize(t.pageData)})},getBuildingData:function(){var e=this;n["a"].request({url:"/room/getBuildingList",method:"get",params:{dataType:this.dataType}}).then(function(t){e.buildingData=t.data})},getFormatDate:function(){var e=new Date,t=e.getMonth()+1,a=e.getDate();t>=1&&t<=9&&(t="0"+t),a>=0&&a<=9&&(a="0"+a);var r=e.getFullYear()+"-"+t+"-"+a+" "+e.getHours()+":"+e.getMinutes()+":"+e.getSeconds();return r},addPageCurrentAndPageSize:function(e){for(var t in e)e[t].pageCurrent=this.pageCurrent,e[t].pageSize=this.pageSize}},mounted:function(){this.getRequestData(this.pageCurrent),this.getBuildingData()}},s=l,d=(a("2d44"),a("2877")),u=Object(d["a"])(s,r,i,!1,null,"4aa491d5",null);u.options.__file="warehouse.vue";t["default"]=u.exports},9082:function(e,t,a){}}]);
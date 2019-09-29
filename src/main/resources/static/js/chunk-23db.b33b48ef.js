(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-23db"],{3453:function(e,t,a){"use strict";var r=a("67f2"),i=a.n(r);i.a},"60a3":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("Tooltip",{attrs:{content:"EXCEL导入导出",placement:"top"}},[a("Button",{staticClass:"btn",attrs:{type:"primary"},on:{click:function(t){e.value2=!0}}},[e._v("EXCEL")])],1),a("Tooltip",{attrs:{content:"添加新数据",placement:"top"}},[a("Button",{staticClass:"btn",attrs:{type:"primary"},on:{click:e.addForm}},[e._v("新增数据")])],1)],1),a("Drawer",{attrs:{title:"EXCEL",placement:"left",closable:!1},model:{value:e.value2,callback:function(t){e.value2=t},expression:"value2"}},[a("Card",{attrs:{title:"导入EXCEL"}},[a("Row",[a("Upload",{attrs:{action:"","before-upload":e.handleBeforeUpload,accept:".xls, .xlsx"}},[a("Button",{attrs:{type:"primary",icon:"ios-cloud-upload-outline",loading:e.uploadLoading},on:{click:e.handleUploadFile}},[e._v("上传文件")])],1)],1),a("Row",[null!==e.file?a("div",{staticClass:"ivu-upload-list-file"},[a("Icon",{attrs:{type:"ios-stats"}}),e._v("\n          "+e._s(e.file.name)+"\n          "),a("Icon",{directives:[{name:"show",rawName:"v-show",value:e.showRemoveFile,expression:"showRemoveFile"}],staticClass:"ivu-upload-list-remove",attrs:{type:"ios-close"},nativeOn:{click:function(t){e.handleRemove()}}})],1):e._e()]),a("Row",[a("transition",{attrs:{name:"fade"}},[e.showProgress?a("Progress",{attrs:{percent:e.progressPercent,"stroke-width":2}},[100==e.progressPercent?a("div",[a("Icon",{attrs:{type:"ios-checkmark-circle"}}),a("span",[e._v("成功")])],1):e._e()]):e._e()],1)],1)],1),a("Card",{attrs:{title:"导出EXCEL"}},[a("Row",{staticStyle:{"padding-bottom":"8px"}},[a("Button",{attrs:{type:"primary",icon:"md-download",loading:e.exportLoading},on:{click:e.exportExcel}},[e._v("导出文件")])],1)],1),a("Card",{attrs:{title:"导出EXCEL模板"}},[a("Row",{staticStyle:{"padding-bottom":"8px"}},[a("Button",{attrs:{type:"primary",icon:"md-download",loading:e.exportLoadingTemplate},on:{click:e.exportExcelTemplate}},[e._v("导出文件")])],1)],1)],1),a("Drawer",{attrs:{title:"新增数据",width:"360","mask-closable":!1,styles:e.styles},model:{value:e.value3,callback:function(t){e.value3=t},expression:"value3"}},[a("Form",{ref:"formData",attrs:{model:e.formData,rules:e.ruleformData}},[a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"18"}},[a("FormItem",{attrs:{label:"楼栋","label-position":"top"}},[a("Select",{on:{"on-change":e.building},model:{value:e.formData.buildingName,callback:function(t){e.$set(e.formData,"buildingName",t)},expression:"formData.buildingName"}},e._l(e.formData.buildingList,function(t){return a("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1)],1)],1),a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"18"}},[a("FormItem",{attrs:{label:"房号","label-position":"top"}},[a("Select",{on:{"on-change":e.room},model:{value:e.formData.roomNumber,callback:function(t){e.$set(e.formData,"roomNumber",t)},expression:"formData.roomNumber"}},e._l(e.formData.roomList,function(t){return a("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1)],1)],1),a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"18"}},[a("FormItem",{attrs:{label:"企业 ","label-position":"top"}},[a("h4",[e._v("\n              :\n              "),a("span",[e._v(e._s(e.formData.owner))])])])],1)],1),a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"18"}},[a("FormItem",{attrs:{label:"水表读数","label-position":"top",prop:"waterNumber"}},[a("Input",{attrs:{placeholder:"请输入水表读数，必须为数字",clearable:"",precision:"2",number:"",maxlength:15},model:{value:e.formData.waterNumber,callback:function(t){e.$set(e.formData,"waterNumber",t)},expression:"formData.waterNumber"}})],1)],1)],1),a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"18"}},[a("FormItem",{attrs:{label:"电表读数","label-position":"top",prop:"electricityNumber"}},[a("Input",{attrs:{placeholder:"请输入电表读数，必须为数字",clearable:"",precision:"2",number:"",maxlength:15},model:{value:e.formData.electricityNumber,callback:function(t){e.$set(e.formData,"electricityNumber",t)},expression:"formData.electricityNumber"}})],1)],1)],1),a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"18"}},[a("FormItem",{attrs:{label:"开始时间","label-position":"top",prop:"startTime"}},[a("DatePicker",{attrs:{type:"month",placeholder:"选择开始时间"},model:{value:e.formData.startTime,callback:function(t){e.$set(e.formData,"startTime",t)},expression:"formData.startTime"}})],1)],1)],1),a("Row",{attrs:{gutter:32}},[a("Col",{attrs:{span:"18"}},[a("FormItem",{attrs:{label:"结束时间","label-position":"top",prop:"endTime"}},[a("DatePicker",{attrs:{type:"month",placeholder:"选择结束时间"},model:{value:e.formData.endTime,callback:function(t){e.$set(e.formData,"endTime",t)},expression:"formData.endTime"}})],1)],1)],1)],1),a("div",{staticClass:"demo-drawer-footer"},[a("Button",{staticStyle:{"margin-right":"8px"},on:{click:function(t){e.value3=!1}}},[e._v("取消")]),a("Button",{attrs:{type:"primary"},on:{click:function(t){e.add("formData")}}},[e._v("确定")])],1)],1),a("Row",[a("Col",{attrs:{offset:""}},[a("Card",{attrs:{shadow:""}},[a("p",{attrs:{slot:"title"},slot:"title"},[e._v("数据展示")]),a("Table",{attrs:{height:"520",columns:e.columns,data:e.data,loading:e.tableLoading},scopedSlots:e._u([{key:"buildingName",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.buildingName))])]}},{key:"roomNumber",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.roomNumber))])]}},{key:"owner",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.owner))])]}},{key:"waterNumber",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.waterNumber))])]}},{key:"waterNumberPrevious",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.waterNumberPrevious))])]}},{key:"waterDifference",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.waterDifference))])]}},{key:"waterCost",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.waterCost))])]}},{key:"electricityNumber",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.electricityNumber))])]}},{key:"electricityNumberPrevious",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.electricityNumberPrevious))])]}},{key:"electricityDifference",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.electricityDifference))])]}},{key:"electricityCost",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.electricityCost))])]}},{key:"total",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.total))])]}}])}),a("Page",{staticClass:"margin-top-10",attrs:{total:e.dataCount,"show-total":"","show-sizer":"","page-size":e.pageSize,"page-size-opts":[10,20,50,100],current:e.pageCurrent},on:{"on-change":e.changePage,"on-page-size-change":e.changePageNumber}})],1)],1)],1),a("Row",[a("Card",{attrs:{shadow:""}},[e._v("\n      单位：元\n      "),e.value4?a("example",{staticStyle:{height:"310px"},attrs:{exampleData:e.exampleData}}):e._e(),a("div",{attrs:{slot:"title"},slot:"title"},[a("p",[e._v("水电费使用数据报表")]),a("Poptip",{staticClass:"text-center a",attrs:{title:"时间线"},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[a("a",{attrs:{href:"#"}},[a("Icon",{attrs:{type:"ios-funnel"}}),e._v("\n            选择时间线"+e._s(e.timeText)+"\n          ")],1),a("div",{staticStyle:{height:"90px"},attrs:{slot:"content"},slot:"content"},[a("Divider",{attrs:{size:"small"}},[a("a",{attrs:{href:"#"},on:{click:function(t){e.getReport(1)}}},[e._v("年")])]),a("Divider",{attrs:{size:"small"}},[a("a",{attrs:{href:"#"},on:{click:function(t){e.getReport(2)}}},[e._v("季")])]),a("Divider",{attrs:{size:"small"}},[a("a",{attrs:{href:"#"},on:{click:function(t){e.getReport(3)}}},[e._v("月")])])],1)])],1)],1)],1)],1)},i=[],o=(a("28a5"),a("7f7f"),a("c5f6"),a("ee1d"),a("cadf"),a("551c"),a("097d"),a("0a21")),n=a("66df"),s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{ref:"dom"})},l=[],u=a("313e"),m=a.n(u),c=a("90de"),p={name:"serviceRequests",props:["exampleData"],data:function(){return{dom:null}},methods:{resize:function(){this.dom.resize()}},mounted:function(){var e=this,t={tooltip:{trigger:"axis",axisPointer:{type:"cross",label:{backgroundColor:"#6a7985"}}},grid:{top:"3%",left:"1.2%",right:"2%",bottom:"3%",containLabel:!0},xAxis:[{type:"category",boundaryGap:!1,data:this.exampleData.timeData}],yAxis:[{type:"value"}],series:[{name:"水费",type:"line",stack:"总量",areaStyle:{normal:{color:"#2d8cf0"}},data:this.exampleData.waterData},{name:"电费",type:"line",stack:"总量",areaStyle:{normal:{color:"#10A6FF"}},data:this.exampleData.electricityData}]};this.$nextTick(function(){e.dom=m.a.init(e.$refs.dom),e.dom.setOption(t),Object(c["f"])(window,"resize",e.resize)})},beforeDestroy:function(){Object(c["e"])(window,"resize",this.resize)}},d=p,g=a("2877"),f=Object(g["a"])(d,s,l,!1,null,null,null);f.options.__file="example.vue";var h=f.exports,b={components:{Example:h},data:function(){var e=function(e,t,a){if(!t)return a(new Error("请输入数字！"));setTimeout(function(){Number.isNaN(t)?a(new Error("存在中英文，请重新输入数字！")):a()},100)};return{exampleData:{timeData:[],waterData:[],electricityData:[]},columns:[{type:"index",width:60,align:"center"},{title:"楼栋名",slot:"buildingName",key:"buildingName",align:"center"},{title:"房号",slot:"roomNumber",key:"roomNumber",align:"center"},{title:"企业",slot:"owner",key:"owner",align:"center"},{title:"上期水表读数（吨）",slot:"waterNumberPrevious",key:"waterNumberPrevious",align:"center"},{title:"本期水表读数（吨）",slot:"waterNumber",key:"waterNumber",align:"center"},{title:"水表读数差值（吨）",slot:"waterDifference",key:"waterDifference",align:"center"},{title:"水费（元）",slot:"waterCost",key:"waterCost",align:"center"},{title:"上期电表读数（度）",slot:"electricityNumberPrevious",key:"electricityNumberPrevious",align:"center"},{title:"本期电表读数（度）",slot:"electricityNumber",key:"electricityNumber",align:"center"},{title:"电表读数差值（度）",slot:"electricityDifference",key:"electricityDifference",align:"center"},{title:"电费（元）",slot:"electricityCost",key:"electricityCost",align:"center"},{title:"水电费总金额（元）",slot:"total",key:"total",align:"center"}],data:[],uploadLoading:!1,progressPercent:0,showProgress:!1,showRemoveFile:!1,file:null,tableLoading:!1,exportLoading:!1,exportLoadingTemplate:!1,value2:!1,value3:!1,styles:{height:"calc(100% - 55px)",overflow:"auto",paddingBottom:"53px",position:"static"},formData:{waterNumber:"",electricityNumber:"",owner:"",buildingName:"",roomNumber:"",startTime:"",endTime:"",buildingList:[],roomList:[]},ruleformData:{buildingName:[{required:!0,message:"请选择楼栋",trigger:"blur"}],roomNumber:[{required:!0,message:"请选择房号",trigger:"blur"}],waterNumber:[{required:!0,validator:e,trigger:"blur"}],electricityNumber:[{required:!0,validator:e,trigger:"blur"}],startTime:[{required:!0,type:"date",message:"选择开始时间",trigger:"blur"}],endTime:[{required:!0,type:"date",message:"选择结束时间",trigger:"blur"}]},timeText:"",value4:!0,visible:!1,pageCurrent:1,pageStart:0,dataCount:0,pageSize:10,errorCount:0,excelLoading:1}},mounted:function(){this.getPaymentDataPage(this.pageCurrent),this.getReport(1)},methods:{initAddForm:function(){this.formData.owner="",this.formData.roomNumber=""},addForm:function(){this.value3=!0,this.getBuilding(),this.initAddForm()},building:function(){this.addTime(),this.getRoomList(),this.formData.owner="",this.formData.roomNumber=""},room:function(){this.getEnterpriseNumber()},getBuilding:function(){var e=this;n["a"].request({url:"/payment/getBuildingList",method:"get"}).then(function(t){var a=t.data,r=a.map(function(e){return{value:e,label:e}});e.formData.buildingList=r})},getRoomList:function(){var e=this;n["a"].request({url:"/payment/getRoomList",method:"get",params:{building:this.formData.buildingName}}).then(function(t){var a=t.data,r=a.map(function(e){return{value:e,label:e}});e.formData.roomList=r})},getEnterpriseNumber:function(){var e=this;n["a"].request({url:"/payment/getEnterpriseNumber",method:"get",params:{building:this.formData.buildingName,room:this.formData.roomNumber}}).then(function(t){e.formData.owner=t.data})},add:function(e){var t=this;this.$refs[e].validate(function(e){e&&(t.value3=!1,n["a"].request({url:"/payment/insertPaymentData",method:"post",headers:{"Content-Type":"application/json"},data:t.formData}).then(function(e){1==e.data&&(t.getPaymentDataPage(t.pageCurrent),t.getReport(1),t.$Message.success("添加成功！")),0==e.data&&(t.getPaymentDataPage(t.pageCurrent),t.getReport(1),t.$Message.error("添加失败！数据小于上期数据！"))}).catch(function(e){e&&(t.getPaymentDataPage(t.pageCurrent),t.getReport(1),t.$Message.error("添加失败，服务器错误！"))}))})},exportExcel:function(){if(this.value2=!1,this.data.length){this.exportLoading=!0;var e={data:this.data,title:["楼栋","房号","企业","上期水表读数（吨）","本期水表读数（吨）","水表读数差值（吨）","水费（元）","上期电表读数（度）","本期电表读数（度）","电表读数差值（度）","电费（元）","水电总金额（元）","开始时间","结束时间"],key:["buildingName","roomNumber","owner","waterNumberPrevious","waterNumber","waterDifference","waterCost","electricityNumberPrevious","electricityNumber","electricityDifference","electricityCost","total","startTime","endTime"],autoWidth:!0,filename:"缴费管理数据总汇"};o["a"].export_array_to_excel(e),this.exportLoading=!1,this.$Message.info("excel已导出！")}else this.$Message.error("表格数据不能为空！")},exportExcelTemplate:function(){this.value2=!1,this.exportLoadingTemplate=!0;var e={data:[{buildingTemplate:"1号楼",roomTemplate:"101",ownerTemplate:"钉钉",waterNumberTemplate:"15",electricityNumberTemplate:"20",startTimeTemplate:"2018-09-08",endTimeTemplate:"2018-10-08"},{buildingTemplate:"2号楼",roomTemplate:"101",ownerTemplate:"钉钉",waterNumberTemplate:"15",electricityNumberTemplate:"20",startTimeTemplate:"2019-09-08",endTimeTemplate:"2019-10-08"}],title:["楼栋","房号","企业","水表读数","电表读数","开始时间","结束时间"],key:["buildingTemplate","roomTemplate","ownerTemplate","waterNumberTemplate","electricityNumberTemplate","startTimeTemplate","endTimeTemplate"],autoWidth:!0,filename:"缴费管理模板"};o["a"].export_array_to_excel(e),this.exportLoadingTemplate=!1,this.$Message.success("excel模板已导出！")},initUpload:function(){this.file=null,this.showProgress=!1,this.loadingProgress=0},handleUploadFile:function(){this.initUpload()},handleRemove:function(){this.initUpload(),this.$Message.success("上传的文件已删除！")},handleBeforeUpload:function(e){var t=e.name.split(".").pop().toLocaleLowerCase();return"xlsx"===t||"xls"===t?(this.readFile(e),this.file=e):this.$Notice.warning({title:"文件类型错误",desc:"文件："+e.name+"不是EXCEL文件，请选择后缀为.xlsx或者.xls的EXCEL文件。"}),!1},readFile:function(e){var t=this,a=new FileReader;a.readAsArrayBuffer(e),a.onloadstart=function(e){t.uploadLoading=!0,t.tableLoading=!0,t.showProgress=!0},a.onprogress=function(e){t.progressPercent=Math.round(e.loaded/e.total*100)},a.onerror=function(e){t.$Message.error("文件读取出错")},a.onload=function(e){var a=e.target.result,r=o["a"].read(a,"array"),i=(r.header,r.results);for(var s in t.excelLoading=i.length,i)i[s].waterNumber=i[s].水表读数,i[s].electricityNumber=i[s].电表读数,i[s].owner=i[s].企业,i[s].buildingName=i[s].楼栋,i[s].roomNumber=i[s].房号,i[s].startTime=i[s].开始时间,i[s].endTime=i[s].结束时间;""!=i[s].waterNumber&&""!=i[s].electricityNumber&&""!=i[s].owner&&""!=i[s].buildingName&&""!=i[s].roomNumber&&""!=i[s].startTime&&""!=i[s].endTime&&(t.handleSpinCustom(),t.value2=!1,n["a"].request({url:"/payment/insertPaymentDataExcel",method:"post",headers:{"Content-Type":"application/json"},data:i}).then(function(e){1==e.data.excelFlag&&(t.$Message.success("上传成功！"),t.getPaymentDataPage(t.pageCurrent),t.getReport(1)),0==e.data.excelFlag&&(t.$Message.error("上传失败，excel中存在本期期数据小于上期数据!"),t.getPaymentDataPage(t.pageCurrent),t.getReport(1))}).catch(function(e){e&&(t.$Message.error("上传失败,服务器错误！"),t.getPaymentDataPage(t.pageCurrent),t.getReport(1),t.value2=!1)})),t.uploadLoading=!1,t.tableLoading=!1,t.showRemoveFile=!0}},handleSpinCustom:function(){var e=this,t=115*this.excelLoading;this.$Spin.show({render:function(e){return e("div",[e("Icon",{class:"demo-spin-icon-load",props:{type:"ios-loading",size:28}}),e("div","Loading")])}}),setTimeout(function(){e.$Spin.hide()},t)},getPaymentDataPage:function(e){var t=this;this.pageNum=e,this.pageStart=(e-1)*this.pageSize,n["a"].request({url:"/payment/getPaymentList",method:"get",params:{dataStart:this.pageStart,dataEnd:this.pageSize}}).then(function(e){t.data=e.data.paymentInfos,t.dataCount=e.data.dataCount})},changePageNumber:function(e){this.pageSize=e,1===this.pageCurrent&&this.changePage(this.pageCurrent)},changePage:function(e){this.pageCurrent=e,this.getPaymentDataPage(e)},getReport:function(e){var t=this;1==e?this.timeText=" > 年":2==e?this.timeText=" > 季":3==e&&(this.timeText=" > 月"),this.value4=!1,n["a"].request({url:"/payment/getReportList",method:"get",params:{reportState:e}}).then(function(e){t.exampleData.timeData=e.data.timeList,t.exampleData.waterData=e.data.waterList,t.exampleData.electricityData=e.data.electricityList,t.value4=!0}),this.visible=!1},cancel:function(){},addTime:function(){this.formData.startTime=(new Date).getFullYear()+"/"+((new Date).getMonth()+1),this.formData.endTime=(new Date).getFullYear()+"/"+((new Date).getMonth()+2)}}},v=b,y=(a("3453"),Object(g["a"])(v,r,i,!1,null,null,null));y.options.__file="payment.vue";t["default"]=y.exports},"67f2":function(e,t,a){},ee1d:function(e,t,a){var r=a("5ca1");r(r.S,"Number",{isNaN:function(e){return e!=e}})}}]);
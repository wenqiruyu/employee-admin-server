webpackJsonp([8],{"5Nxy":function(t,e){},tXPn:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a={name:"WeChat",data:function(){return{username:"",chatMessage:"",webSocket:null,chatAllMessage:[]}},created:function(){this.initWebSocket()},methods:{initWebSocket:function(){var t=this;this.username=localStorage.getItem("venus_username"),this.webSocket=new WebSocket("ws://localhost:10001/venus-admin-server/chat/"+this.username),this.webSocket.onopen=function(){console.log("WebSocket已连接")},this.webSocket.onmessage=function(e){var s=JSON.parse(e.data);200==s.code&&t.chatAllMessage.push(s.data),console.log(e.data),console.log("数据已接收...")},this.webSocket.onclose=function(){console.log("WebSocket连接已关闭...")},window.onbeforeunload=function(){this.websocket.close()}},sendMessage:function(){""!=this.chatMessage&&(this.webSocket.send(this.chatMessage),this.chatMessage="")},userFriend:function(){var t=this;this.$axios.post("/venus-admin-server/user/login",params).then(function(e){200==e.data.code?(localStorage.setItem("venus_username",t.ruleForm.username),localStorage.setItem("venus_token",e.data.data),t.$router.push("/index")):t.msg=e.data.msg})}}},n={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",{staticClass:"crumbs"},[s("el-breadcrumb",{attrs:{separator:"/"}},[s("el-breadcrumb-item",[s("i",{staticClass:"iconfont icon-wen-home"}),t._v(" 系统首页")])],1)],1),t._v(" "),s("div",{staticClass:"container"},[t._m(0),t._v(" "),s("div",{staticClass:"index-chat"},[s("div",{staticClass:"now-chat-list"},[s("el-card",{staticClass:"now-chat-list-card"})],1),t._v(" "),s("div",{staticClass:"chat-center"},[s("div",{staticClass:"chat-user-info"},[s("el-card",{staticClass:"chat-user-info-card"})],1),t._v(" "),s("div",{staticClass:"chat-content-show"},[s("el-card",{staticClass:"chat-content-show-card"},t._l(t.chatAllMessage,function(e,a,n){return s("div",{key:n},["venus"==e.username?s("div",{staticClass:"chat-content-show-card-tips"},[s("span",[t._v(t._s(e.chatMessage))])]):t._e(),t._v(" "),e.username==t.username?s("div",{staticClass:"chat-content-show-card-msg"},[s("el-tag",{staticStyle:{float:"right"},attrs:{type:"success"}},[t._v("\n                                    "+t._s(e.username)+"："+t._s(e.chatMessage)+"\n                                ")]),t._v(" "),s("br")],1):t._e(),t._v(" "),e.username!=t.username&&"venus"!=e.username?s("div",{staticClass:"chat-content-show-card-msg"},[s("el-tag",{staticStyle:{float:"left"}},[t._v("\n                                    "+t._s(e.username)+"："+t._s(e.chatMessage)+"\n                                ")]),t._v(" "),s("br")],1):t._e()])}),0)],1),t._v(" "),s("div",{staticClass:"chat-content-input"},[s("el-card",{staticClass:"chat-content-input-card"},[s("div",{staticClass:"chat-content-input-message"},[s("el-input",{attrs:{type:"textarea",placeholder:"请输入内容",maxlength:"200","show-word-limit":"",resize:"none",size:"medium",rows:"4"},model:{value:t.chatMessage,callback:function(e){t.chatMessage=e},expression:"chatMessage"}})],1),t._v(" "),s("div",{staticClass:"chat-content-input-button"},[s("el-button",{staticClass:"button",attrs:{type:"text"},on:{click:t.sendMessage}},[t._v("发送")])],1)])],1)]),t._v(" "),s("div",{staticClass:"chat-user-list"},[s("el-card",{staticClass:"chat-user-list-card"})],1)])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"index-title"},[e("span",[this._v("启明星在线聊天室")])])}]};var c=s("VU/8")(a,n,!1,function(t){s("5Nxy")},null,null);e.default=c.exports}});
//# sourceMappingURL=8.e9584760a5312f0a22de.js.map
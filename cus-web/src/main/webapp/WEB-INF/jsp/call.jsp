<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品售后跟踪管理系统</title>
</head>
<script type="text/javascript">
	var myType = '${sessionScope.hunmanType}'; 
	var cssType = '${hunmanTypeCusService}';   
	var customerType = '${hunmanTypeCustomer}';
	var managerType = '${hunmanTypeManager}';
	var mainmanType = '${hunmanTypeMainMan}';
	var myId = '${sessionScope.myInfo.id}';
	var websocket = null;
	var isConnect = false;
	//判断当前浏览器是否支持WebSocket
	if(myType!=managerType){
	    if (  'WebSocket' in window) {
		    websocket = new WebSocket("ws://localhost:8080"+"${ctx}"+"/websocket/"+myType+"/"+myId);
		    isConnect = true;
		    binding(websocket);
		}
		else {
		    console.log('当前浏览器 Not support websocket')
		}
	}
	//连接关闭的回调方法
    function onclose() {
        console.log("WebSocket连接关闭");
    }

    
  	//绑定WebSocket对象的各回调函数
    function binding(ws){
	   	ws.onerror = onerror;
	   	ws.onopen = onopen;
	   	ws.onmessage = onmessage; 
	   	ws.onbeforeunload = onbeforeunload;
	   	ws.onclose = onclose;
   }
    
  	//连接发生错误的回调方法
    function onerror() {
        console.log("WebSocket连接发生错误")
    };

    //连接成功建立的回调方法
    function onopen() {
        console.log("WebSocket连接成功")
    }
	/****************************************/
	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    function onbeforeunload() {
        closeWebSocket();
    } 
  	//关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
        isConnect = false;
    }

    //发送消息
    function send() {
        /* var message = document.getElementById('text').value;
        websocket.send(message); */
    }
	/***************************/
    
  	//按钮点击事件
    function closeOrNewWebSocket(){
    	if(isConnect){
    		closeWebSocket()
    	}
    	else{
    		newWebSocket()
    	}
    }
    
  	//新建WebSocket连接
    function newWebSocket() {
    	websocket = new WebSocket("ws://localhost:8080"+"${ctx}"+"/websocket/"+myType+"/"+myId);
        isConnect = true;
        binding(websocket);
    }
  	
    
    /*****************************************/
  	
    function showInfoByDialog(message){
		console.log('showInfoByDialog:'+message);
		
		var messageDialog = $('#popId');
		var res = new Array();
		res = message.split(',');
		//
		//客服接受消息后
        if(myType==cssType){
            if(res[0]=='A'){
			    messageDialog.append('客户【'+res[1]+'】-->申请售后<br>');
			    messageDialog.dialog('open');
			}else if(data == 'AToB'){
			}
			else{}
        }
      	//客户接受消息后
        else if(myType==customerType){
           if( res[0] == 'E'){
				 messageDialog.append('维修已完成，请评价<br>');
				 messageDialog.dialog('open');
		  	}else if(res[0] == 'B'){
		  	 	 messageDialog.append('一个申请已被同意,正在分配维修人员<br>');
				 messageDialog.dialog('open');
			}else if(res[0] == 'C'){
		  	 	 messageDialog.append('维修人员【'+res[1]+'】已确认，出发中<br>');
				 messageDialog.dialog('open');
			}
			else{}
        }
      	//维修人员接受消息后
        else if(myType==mainmanType){
            if( res[0] == 'B'){
				 messageDialog.append('有新的维修申请正在分配中<br>');
				 messageDialog.dialog('open');
		  	}else if(res[0] == 'D'){
		  	 messageDialog.append('维修已开始<br>');
			 messageDialog.dialog('open');
			}
			else{}
        }
        else {
            console.log('当前用户接受提醒无效或接受不了提醒')
        }
		
		//
		
    }
    //接收到消息的回调方法
    function onmessage(event) {
        //myType cssType customerType managerType mainmanType
        //A申请中,B分配中,C动身中,D维修中,E维修完成
        var data = event.data;
        console.log('onmessage:'+data);
        showInfoByDialog(data);
        
    }

    /********************************/
    /*  隐藏推送*/
    function closeMessage(){
		$('#popId').empty()
		//$('#popId').dialog('close')
    }
</script>
<body>
	<div id='popId' class='easyui-dialog' style='z-index: 2'  data-options="closed:true,iconCls:'icon-large-smartart',modal:true,width:400,
				    height:200,title:'Info',onClose:closeMessage"></div>
	<iframe src="main" width=100% height=100% marginwidth=0>
</body>
</html>
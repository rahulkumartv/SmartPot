function postServlet(method,url,callback,datapair)
{
	var xhr;
	if( typeof XMLHttpRequest !== 'undefined')
	{
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function()
		{	
	   		if(xhr.readyState == 4 && xhr.status == 200)
	    	{
	   			if (typeof(callback) !== "undefined" && callback)
	   			{
	   				callback.call(xhr.responseText);
	   			}
	   			
	   			return;
	    	}
		}
		
	}
	else
	{
		var versions = ['MSXML2.XmlHttp.5.0','MSXML2.XmlHttp.4.0','MSXML2.XmlHttp.3.0','MSXML2.XmlHttp.2.0','Microsoft.XmlHttp'];
		for( var i=0,len=versions.length;i<len;i++)
		{
				xhr = new ActiveXObject(versions[i]);
		}
	}
	
	xhr.open(method, url, true);
	xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	xhr.send(JSON.stringify(datapair));
}

function onLogin(){
	var username = $("#username").val();
	var password = $("#inputPassword").val();
	$("#errlabel").text("");
	
	if(username == "" || password ==""){
	$("#errlabel").text("Fields cannot be blank");
		return;
	}
	
	var data = {username:username, password:password};
}

/**
 * This method clear the login form
 */
function cleanLoginform(){
	$("#errlabel").text("");
	$("#username").text("");
	$("#inputPassword").text("");
}
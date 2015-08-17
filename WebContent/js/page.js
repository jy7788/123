var ie;
if (document.all) ie=1;
else ie=0;

function isnull(str){if(str==null||str==""||str=="undefine")return true;
 return false;
}

function killErrors() { 
return true; 
} 
window.onerror = killErrors; 


function commonJump(){
	skipToPage(document.getElementById('page.currentPage').value);
}

//-----------------·ÖÒ³-----------------------------------------------

function skipToPage(page)
{

	document.getElementById('page.currentPage').value=page;
	document.form1.submit();
}
function SetOrder(str)
{
	var orderFlag=0;
	document.getElementById('page.orderString').value=str;
	if(!isnull(document.getElementById('page.orderFlag').value)) 
		orderFlag=document.getElementById('page.orderFlag').value;
	document.getElementById('page.orderFlag').value=1 - orderFlag;
	document.form1.submit();
}
function $() {
  var elements = new Array();
  for (var i = 0; i < arguments.length; i++) {
    var element = arguments[i];
    if (typeof element == 'string')
      element = document.getElementById(element);
    if (arguments.length == 1)
      return element;
    elements.push(element);
  }
  return elements;
}
String.prototype.allTrim=function(){
	return this.replace(/(\s*)/g, "");
}
function querySubmit(){
	$('keyword').value=$('keyword').value.allTrim();
	$('cid').value=$('cid').value.allTrim();
	document.form1.submit();
}
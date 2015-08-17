function showDateTime(){
var sWeek = new Array("日","一","二","三","四","五","六");
var myDate = new Date();
var sYear = myDate.getFullYear();
var sMonth = myDate.getMonth()+1;
var sDate = myDate.getDate();
var sDay = sWeek[myDate.getDay()];
var h = myDate.getHours();
var m = myDate.getMinutes();
var s = myDate.getSeconds();

h=formatTwoDigits(h);
m=formatTwoDigits(m);
s=formatTwoDigits(s);
document.getElementById("date").innerHTML=sYear+"年"+sMonth+"月"+sDate+"日"+"&nbsp;"+"星期"+sDay+"&nbsp;"+h+":"+m+":"+s;
setTimeout("showDateTime()",1000);
}
window.onload=showDateTime;

function formatTwoDigits(s){
  if(s<10) return "0"+s;
  else return s;
}
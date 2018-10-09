var req;
var f;
var t;
function validatePreference(){
  //f = $("#drpnoticeMessage");
  //t = $("#drpnotice");
  f = document.getElementById("drpnoticeMessage");
  t = document.getElementById("drpnotice");
  var url =
    "http://localhost:8080/WebApp/Servlet?drpnotice="+t.value;
  req = new XMLHttpRequest();
  req.open("GET",url,true);
  req.onreadystatechange = preferenceValidation;
  req.send(null);
}

function preferenceValidation(){
  if(req.readyState == 4 && req.status == 200){
    if(req.responseText != "good"){
      //f.text(req.responseText);
      f.innerHTML = req.responseText;
      t.focus();
    }
    else{
      //f.text("Response is OK");
      f.innerHTML = "response is OK";
      document.getElementById("form1").submit();
    }
  }
}

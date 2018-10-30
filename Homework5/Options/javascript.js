var req;
var f;
var t;
var canSend = false;
function validatePreference(){
  //f = $("#drpnoticeMessage");
  //t = $("#drpnotice");

  //step one, check if is just library card stuff filled out.
  if(!canSend){
    c = document.getElementById("cnum");
    n = document.getElementById("nickname");
    var url="http://localhost:8080/CardWebService/Cse336/Cards/"+c.value+"/"+n.value;
    req = new XMLHttpRequest();
    req.open("GET",url,true)
    req.onreadystatechange = preferenceValidation;
    req.send(null);
    return false;
  }
  return true;
  //step two, if there is more than just those two filled out, check this...
  // f = document.getElementById("drpnoticeMessage");
  // t = document.getElementById("drpnotice");
  // url =
  //   "http://localhost:8080/WebApp/Servlet?drpnotice="+t.value;
  // req = new XMLHttpRequest();
  // req.open("GET",url,true);
  // req.onreadystatechange = preferenceValidation;
  // req.send(null);
}

function preferenceValidation(){
  if(req.readyState == 4 && req.status == 200){
    if(req.responseText.length > 0){
      //f.text(req.responseText);
      var obj = JSON.parse(req.responseText);
      localStorage.setItem("cardJson",req.responseText);
      document.location.href = "../Views/Submit.html";
    }
    else{
      //later will be to send info.
      alert("Can't find that name/number combination!");
      // canSend = true;
      // var form = document.getElementById("form1");
      // form.action="http://localhost:8080/CardWebService/Cse336/Cards/AddCard";
      // form.submit();
    }
  }
}

/*dropdown menu*/

function myFunction() {
    var x = document.getElementById("myMenu");
    if (x.className === "menu") {
        x.className += " dropdown";
    } else {
        x.className = "menu";
    }
}


/*Login screen popup*/

var modal = document.getElementById('login-popup');

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
};

/*Logout screen popup*/

var logOut = document.getElementById('logout-popup');

window.onclick = function (event) {
    if (event.target == logOut) {
        logOut.style.display = "none";
    }
};

    console.log(document.cookie);
if (document.cookie == null || document.cookie == "") {
    console.log("tää vittu toimii")
}
else{
    var not = document.querySelector('.not');
    not.setAttribute("id", "logged-in");
    var on = document.querySelector('.on');
    on.setAttribute("id", "login-icon");

    console.log(not);
    console.log(on);
}
var userprkl = document.querySelector("#userv");
userprkl.innerHTML = getnamefromcookie();

/*Home page secondary navigation*/

function sortBy() {
    var sb = document.getElementById("sort");

    if (sb.className === "sort-by-menu") {
        sb.className += " dropdown";
    } else {
        sb.className = "sort-by-menu";
    }
}

document.querySelector("#login-form").addEventListener('submit', function (event) {
    event.preventDefault();
    console.log($("#login-form").serialize());
    var data = $("#login-form").serialize();
    //var form = new FormData(document.getElementById('login-form'));
    var searchParams = new URLSearchParams(data);
    var parameter = {
        method: "POST",
        body: searchParams

    };

    fetch("http://10.114.32.48:8080/Projekti/webresources/User/valid", parameter)
            .then(function (response) {
                return response.json();
                console.log(response.json());
            }).then(function (userar) {
        console.log(userar);
        var test = userar;

        console.log(test);
        if (test.length <= 0 || test[0] == "") {
            document.getElementById('login-error').innerHTML = "";
            var code = document.createTextNode("Username or password is incorrect.");

            var err = document.querySelector('#login-error');
            err.appendChild(code);
        } else {


            console.log(userar);
            var cookieid = "" + userar[0].id;
            console.log(cookieid);
            var cookieuser = userar[0].username;
            console.log(cookieuser);
            createCookie(cookieid, cookieuser, 0);

            var jotain = readCookie(cookieid);
            console.log(jotain);
            document.location.href = "index.html";
        }
    });



});

//document.getElementById("MyElement").className = "MyClass";


 document.querySelector("#logout-form").addEventListener('submit', function (event) {
 event.preventDefault();
 
 var keksi = getidfromcookie();
 console.log(keksi);
 eraseCookie(keksi);
 document.location.href = "index.html";
 });
 
 








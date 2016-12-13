/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Create XMLHttpRequest object. Name it xhr.
var xhr = new XMLHttpRequest();
// Create function 'showImages' which
var getMainContent = function () {
    // checks that loaded content is ready (readyState and status) and
    if (this.readyState == 4 && this.status == 200) {
        // then converts the JSON loaded from the server to JavaScript object.
        var array = JSON.parse(this.responseText);
        // Create a loop which builds the following HTML from every image:
        for (var i = 0; i < array.length; i++) {
            /*
             <li>
             <article class="post-content">
             <div class="post-title">
             <a href="#" id="open-post">What is the interpretation? Try to figure it out.</a>
             </div>
             <div class="post-author">
             <p><span>@</span>KanZiiDokata</p>
             </div>
             <div class="post-date">
             <p>28.11.2016</p>
             </div>
             </article>
             </li>
             */
            // Make the HTML elements by using createElement-method and
            // add the attributes by using setAttribute method or element.attribute syntax.
            // Nest the elements with appendChild-method.

            //title and link
            var title = document.createTextNode(array[i].postMed.title);
            var link = document.createElement('a');
            link.setAttribute("href", i);
            link.setAttribute("id", "open-post");
            link.appendChild(title);

            //div for title 
            var titdiv = document.createElement('div');
            titdiv.setAttribute("class", "post-title");
            titdiv.appendChild(link);

            //at character to span 
            var atc = document.createTextNode('@');
            var at = document.createElement('span');
            at.appendChild(atc);

            //author paragraph 
            var paut = document.createTextNode(array[i].postMed.postUserID.username);
            var pa = document.createElement('p');
            pa.appendChild(at);
            pa.appendChild(paut);
            //div for author 
            var autdiv = document.createElement('div');
            autdiv.setAttribute("class", "post-author");
            autdiv.appendChild(pa);

            //date to paragraph
            var time = document.createTextNode(array[i].postMed.posttimestamp);
            var timep = document.createElement('p');
            timep.appendChild(time);

            //div for postdate
            var datediv = document.createElement('div');
            datediv.setAttribute("class", "post-date");
            datediv.appendChild(timep);


            //adding article elements to li element
            var arc = document.createElement('article');
            arc.setAttribute("class", "post-content");
            arc.appendChild(titdiv);
            arc.appendChild(autdiv);
            arc.appendChild(datediv);
            //adding divs to article element
            var lis = document.createElement('li');
            lis.appendChild(arc);



            // Finally place the elements into <ul> element to print them to the HTML page
            var ul = document.querySelector('.post-list');
            ul.appendChild(lis);





        } // end for

        /*Open post modal*/

        var modaali = document.getElementById('post_modal');

        var open = document.querySelectorAll('#open-post');

        console.log(open);

        var span = document.querySelectorAll(".close-post")[0];

        console.log(span);

        var openPost = function (evt) {
            evt.preventDefault();
            modaali.style.display = "block";
            console.log(this.href);

            var num = this.href.split('/')[4];
            /*
             <div class="post-screen-title">
             <p id="pop-title">What is the interpretation? Try to figure it out.</p>
             </div>
             <div class="post-screen-img"><img id="pop-image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlcxPLLYRObzbNs4zs6WGg0ChPDvQJV9oOQ0r0mqqn91nemElU"></div>
             <div class="post-screen-description">
             <p id="pop-content">Nunc ac porta justo. Suspendisse accumsan ante sit amet dui mollis, quis ullamcorper nibh venenatis. Quisque commodo odio eget ultricies pretium. Fusce nec elit id justo imperdiet efficitur. Morbi in erat in ipsum dignissim pharetra bibendum in justo. Nam arcu nisl, euismod id sollicitudin vitae, iaculis non diam. Integer ac rutrum magna.</p>
             </div>
             <div class="post-info">
             <div class="author_and_date">
             <p id="pop-author">@KanZiiDokata</p>
             <p id="pop-date">10.12.2016</p>
             </div>
             <div class="dislike">
             <i class="fa fa-thumbs-down" id="thumb-down"></i>
             <p>71</p>
             </div>
             <div class="like">
             <i class="fa fa-thumbs-up" id="thumb-up"></i>
             <p>138</p>
             </div>
             </div>
             
             
             */
            //adding new title and deleting old one.
            var poptit = document.createTextNode(array[num].postMed.title);
            document.getElementById('pop-title').innerHTML = "";
            document.getElementById('pop-title').appendChild(poptit);

            var popcont = document.createTextNode(array[num].postMed.content);
            document.getElementById('pop-content').innerHTML = "";
            document.getElementById('pop-content').appendChild(popcont);

            var popaut = document.createTextNode(array[num].postMed.postUserID.username);
            document.getElementById('pop-author').innerHTML = "";
            document.getElementById('pop-author').append('@');
            document.getElementById('pop-author').appendChild(popaut);

            var popdate = document.createTextNode(array[num].postMed.posttimestamp);
            document.getElementById('pop-date').innerHTML = "";
            document.getElementById('pop-date').appendChild(popdate);

            var popimageurl = array[num].medPost.url;
            var popimagepath = array[num].medPost.path;
            console.log(array[num].medPost.url);
            console.log(array[num].medPost.path);
            document.getElementById('pop-image').setAttribute('src', '');
            document.getElementById('pop-image').setAttribute('src', '' + popimageurl + '/' + popimagepath);




            var addown = document.querySelector('#comuserid');
            console.log(getidfromcookie());
            if (getidfromcookie() != null) {
                addown.innerHTML = "";
                addown.append(getidfromcookie());
            }

            var addpost = document.querySelector('#compostid');
            addpost.innerHTML = "";
            addpost.append(array[num].postMed.postID);





        };


//open.addEventListener("click", openPost);
        for (var i = 0; i < open.length; i++) {
            open[i].addEventListener('click', openPost);
        }

        var closePost = function (evt) {
            evt.preventDefault();
            modaali.style.display = "none";
        };

        span.addEventListener("click", closePost);
        // for (var j = 0; j < span.length; j++) {
        //   span[j].addEventListener('click', closePost);
        //}

        window.onclick = function (event) {
            if (event.target == modaali) {
                modaali.style.display = "none";
            }
        };


        // Create XMLHttpRequest object. Name it xhr.
        var xhr2 = new XMLHttpRequest();
// Create function 'showImages' which
        var getComments = function () {
            // checks that loaded content is ready (readyState and status) and
            if (this.readyState == 4 && this.status == 200) {
                // then converts the JSON loaded from the server to JavaScript object.
                var comar = JSON.parse(this.responseText);
                // Create a loop which builds the following HTML from every image:
                for (var k = 0; k < comar.length; k++) {
                    console.log(comar);
                    console.log(comar[k].postid.postID);
                    /*
                     <div class="comment">
                     <p id="pop-comment">Tapahtumat viime aikoina osoittavat, että kirjallisiin tehtäviin kohdistuva suunnaton mielenkiinto aurinkoisena kevätpäivänä pakottaa kohderyhmää huomioimaan reaktiota tämänhetkisen tilanteen suhteen. </p>
                     <div class="comment-info">
                     <div class="comment-author_and_date">
                     <p id="pop-comaut">@peraroori</p>
                     <p id="pop-comdat">11.12.2016</p>
                     </div>
                     
                     </div>
                     </div>' */
                    var kokeil = document.querySelector("#compostid");
                    
                    console.log(kokeil);
                    if(comar[k].postid.postID == null ){
                        
                    
                        
                    
                    //pop content
                    var ppc = document.createTextNode(comar[k].content);
                    var pask = document.createElement('p');
                    pask.setAttribute("id", "pop-comment");
                    pask.appendChild(ppc);

                    //div comment-author...
                    var cautdiv = document.createElement('div');
                    cautdiv.setAttribute("class", "comment-author_and_date");
                    cautdiv.appendChild(pa);

                    // pop comaut paragraph
                    var popaut = document.createTextNode(comar[k].comUserID.username);
                    var per = document.createElement('p');
                    per.setAttribute("id", "pop-comaut");
                    per.appendChild(popaut);

                    // pop comdate paragraph
                    var moi = document.createTextNode(comar[k].commenttimestamp);
                    var joo = document.createElement('p');
                    joo.setAttribute("id", "pop-comdat");
                    joo.appendChild(moi);

                    //add paragraphs to div
                    cautdiv.appendChild(per);
                    cautdiv.appendChild(joo);

                    //div comment info...
                    var infoautdiv = document.createElement('div');
                    infoautdiv.setAttribute("class", "comment-info");
                    infoautdiv.appendChild(cautdiv);
                    
                    //div comment
                    var comm = document.createElement('div');
                    comm.setAttribute("class", "comment");
                    comm.appendChild(pask);
                    comm.appendChild(infoautdiv);
                    
                    //add to html comments div 
                    document.querySelector('.comments').appendChild(comm);
                }
                }
            }
        };
// Open XMLHttpRequest connection to load images.html, use get method.
        xhr2.open("GET", "http://10.114.32.48:8080/Projekti/webresources/Post/comments", true);
// When ready state changes, call showImages function.
        xhr2.onreadystatechange = getComments;
// Send XMLHttpRequest.
        xhr2.send();






    } // end if
}; // Function ends.

// Open XMLHttpRequest connection to load images.html, use get method.
xhr.open("GET", "http://10.114.32.48:8080/Projekti/webresources/Post/collection", true);
// When ready state changes, call showImages function.
xhr.onreadystatechange = getMainContent;
// Send XMLHttpRequest.
xhr.send();

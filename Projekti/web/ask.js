/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//adds author box id of the current user
var addaut = document.querySelector('#author');

if (getidfromcookie() !== null) {
    addaut.append(getidfromcookie());
}


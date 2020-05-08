// show navbar-toggler........
$(".navbar-toggler").click(function() {
    $('.overlay').addClass('overlay-show');
    $('.overlay .navbar-collapse').addClass('navbar-collapse-show');
    $('body').css("overflow", "hidden");
});

//remove navbar-toggler...(close button,body,link)
$('.overlay, .close-button,.nav-link').click(function() {
    $('.overlay').removeClass('overlay-show');
    $('.overlay .navbar-collapse').removeClass('navbar-collapse-show');
    $('body').css("overflow", "auto");
});

$('.navbar-nav').on("click", function() {
    $('#dropdown-menu');
});

$('.nav-item').click(function() {
    $('.nav-item').removeClass('active');
    $(this).addClass('active');
});

//stopPropagation on menu......
let selectDropdown = $(".side-nav .navbar-nav li:nth-child(3)").children();
$(selectDropdown).click(function(event) {
    event.stopPropagation();
})
$('.navbar-nav').click(function(event) {
    event.stopPropagation();
});

function ValidateEmail(inputText)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(inputText.value.match(mailformat))
{
document.form1.text1.focus();
return true;
}
else
{
alert("You have entered an invalid email address!");
document.form1.text1.focus();
return false;
}
}

function formValidation()
{
var firstname = document.registration.txtFirstName;
var lastname = document.registration.txtLastName;
var passid = document.registration.passid;
var uname = document.registration.username;
var uadd = document.registration.address;
var ucountry = document.registration.country;
var uzip = document.registration.zip;
var useremail = document.registration.useremail;
var umsex = document.registration.msex;
var ufsex = document.registration.fsex; if(userid_validation(uid,5,12))
{
if(passid_validation(passid,7,12))
{
if(allLetter(firstname))
{
if (allLetter(lastname))
{
if(alphanumeric(uadd))
{ 
if(countryselect(ucountry))
{
if(allnumeric(uzip))
{
if(ValidateEmail(uemail))
{
if(validsex(umsex,ufsex))
{
}
} 
}
} 
}
}
}
}
}
return false;
}

//user name validation
function allLetter(firstname)
{ 
var letters = /^[A-Za-z]+$/;
if(firstname.value.match(letters))
{
return true;
}
else
{
alert('Username must have alphabet characters only');
firstname.focus();
return false;
}
}

//smooth scrolling....
let anchorlinks = document.querySelectorAll('a[href^="#"]')
for (let item of anchorlinks) { // relitere
    item.addEventListener('click', (e) => {
        e.preventDefault();
        let hashval = item.getAttribute('href')
        let target = document.querySelector(hashval)
        target.scrollIntoView({
            behavior: 'smooth',
            block: 'start'
        });
        history.pushState(null, null, hashval)
    });
}
//user email
function ValidateEmail(useremail)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(useremail.value.match(mailformat))
{
return true;
}
else
{
alert("You have entered an invalid email address!");
useremail.focus();
return false;
}
}
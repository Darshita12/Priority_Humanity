
//on scroll changeing the logo and background color and also show fix-button..........
if (window.scrollY > 50) { //dectact page scroll on page reload
    $(".header").removeClass("transparent-header");
    $(".header").addClass("grey-header");
    $(".header .navbar .navbar-toggler svg path").attr("stroke", "rgba(25, 25, 25, 1)")
    $('.fix-button').css("display", "block");
}
$(window).scroll(function() {
    if ($(window).scrollTop() > 50) {
        $(".header").removeClass("transparent-header");
        $(".header").addClass("grey-header");
        $(".header .navbar .navbar-toggler svg path").attr("stroke", "rgba(25, 25, 25, 1)")
        $('.fix-button').css("display", "block");
    } else {
        $(".header .navbar .navbar-toggler svg path").attr("stroke", "rgba(255, 255, 255, 1)")
        $(".header").addClass("transparent-header");
        $(".header").removeClass("grey-header");
        $('.fix-button').css("display", "none");
    }
});

/* $(document).ready(function () {
        $("#sidebar").mCustomScrollbar({
            theme: "minimal"
        });

        $('#dismiss, .overlay').on('click', function () {
            // hide sidebar
            $('#sidebar').removeClass('active');
            // hide overlay
            $('.overlay').removeClass('active');
        });

        $('#sidebarCollapse').on('click', function () {
            // open sidebar
            $('#sidebar').addClass('active');
            // fade in the overlay
            $('.overlay').addClass('active');
            $('.collapse.in').toggleClass('in');
            $('a[aria-expanded=true]').attr('aria-expanded', 'false');
        });
}); */

/* window.onscroll = function() {staticHeader()};
var sticky = header.offsetTop;
function staticHeader() {
  if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
} */

var winX = null;
var winY = null;

window.addEventListener('scroll', function () {
    if (winX !== null && winY !== null) {
        window.scrollTo(winX, winY);
    }
});

function disableWindowScroll() {
    winX = window.scrollX;
    winY = window.scrollY;
}

function enableWindowScroll() {
    winX = null;
    winY = null;
}
var headState = new Boolean(false);
console.log(headState);
function toggleHeader() {
	var header = document.getElementById("staticHead");
	console.log(header);
  if (headState === false) {
    header.style.display = "block";
    enableWindowScroll();
    headState = true;
  } else {
    header.style.display = "none";
    disableWindowScroll();
    headState=false;
  }
}





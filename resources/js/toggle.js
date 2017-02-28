$(function(){
  $(".edit").on("click", function(e) {
     $(".settings").toggleClass("hidden");
     e.target.innerHTML = e.target.innerHTML === "Cancel" ? "Change Settings" : "Cancel";
     $(".editsettings").toggleClass("hidden");
  });
});

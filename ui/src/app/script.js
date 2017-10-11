
jQuery('#myModal').modal('show')

jQuery("#myModal").on("show",function(){
    jQuery("#myModal").css("z-index", "1000");
});

jQuery("#myModal").on("hide",function(){
    jQuery("#myModal").css("display", "none");
    jQuery("#myModal").css("z-index", "-999");
});
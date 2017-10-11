
jQuery('#myModal').modal('show')

jQuery("#myModal").on("show",function(){
    jQuery("#myModal").css("z-index", "1000");
});

jQuery("#myModal").on("hide",function(){
    jQuery("#myModal").css("display", "none");
    jQuery("#myModal").css("z-index", "-999");
});

jQuery('#mapModal').modal('show')

jQuery("#mapModal").on("show",function(){
    jQuery("#mapModal").css("z-index", "1000");
});

jQuery("#mapModal").on("hide",function(){
    jQuery("#mapModal").css("display", "none");
    jQuery("#mapModal").css("z-index", "-999");
});
jQuery(document).ready(function(){
    $(".tile").mousedown(function(){      
        $(this).addClass("selecionado");
    });
  
    $(".tile").mouseup(function(){    
        $(this).removeClass("selecionado");
    });
});

jQuery(document).ready(function(){
	jQuery(window).resize(function(){
		setListaProductosTBodyHeight();
	});
});

/* Setting the height of the lista productos table */
function setListaProductosTBodyHeight(){
	jQuery("#listaProductos tbody").height(function(){
		return (jQuery(window).height() - jQuery("#listaProductos").position().top) - 68;
	});
}
/* End Setting */

/* Setting the height of the lista productos table of Ingresar Productos */
function setLPTBodyHeight(tableID, footerID){
	jQuery("#"+tableID+" tbody").height(function(){
		return (jQuery(window).height() - jQuery("#"+tableID).position().top) - jQuery("#"+footerID).height() - 139;
	});
}
/* End Setting */
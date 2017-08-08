
$(document).ready(function(){

	mostrarDatosCarShop();
	
	$("#compraform").submit(function(event){
		event.preventDefault();
	    passData();
	    console.log("funcion prevent");
	});
	
});


function addCarShop(precio, id, nombre, imagen){
 console.log(imagen);
var datosProducto;
      productoId = parseInt(id);
      productoPrecio = parseFloat(precio);
     var productoCantidad =parseFloat(1);
      productoNombre = nombre;
      productoImagen = imagen;

      var proexiste = JSON.parse(sessionStorage.getItem(productoId));
      if(proexiste != null){
        productoCantidad = productoCantidad + proexiste.cantidad;

      }
      datosProducto = {
          nombre: productoNombre,
          cantidad: productoCantidad,
          precio: productoPrecio,
          imagen: productoImagen
      }
      var producto = JSON.stringify(datosProducto);
      sessionStorage.setItem(productoId, producto);

     //limpiarCampos();
     mostrarDatos();


}
function mostrarDatos(){
  var total = 0;
    $("#bodyCarshop").html('');
    for (var i in sessionStorage) {
        detalleProducto = JSON.parse(sessionStorage.getItem(i));
        total = total + detalleProducto.cantidad*detalleProducto.precio;
        $("#bodyCarshop").prepend('<tr> <td>' + detalleProducto.nombre + '</td> <td>' + detalleProducto.cantidad + '</td> <td>' + detalleProducto.precio + '</td> <td>'+(detalleProducto.precio*detalleProducto.cantidad).toFixed(2)+'</td> <td><button type="button" id="' + i + '" class="btn btn-sm btn-danger eliminar-producto" >Eliminar</button>  <input id="productos_'+i+'" name="producto['+i+']" type="hidden" value="'+i+'--'+detalleProducto.cantidad+'--'+detalleProducto.precio+'"> </td>  <tr>');
        $(".eliminar-producto").on("click", function () {
            var id = $(this).attr("id");
            sessionStorage.removeItem(id);
            mostrarDatos();
        });
    }

}



function mostrarDatosCarShop(){
  var total = 0;
    $("#datosCarShop").html('');
    for (var i in sessionStorage) {
        detalleProducto = JSON.parse(sessionStorage.getItem(i));
        total = total + detalleProducto.cantidad*detalleProducto.precio;
          $("#datosCarShop").prepend('<tr class="rem1" > <td class="invert">1</td><td class="invert-image"><a href="#"><img src="'+ detalleProducto.imagen +'" alt=" " class="img-responsive" /></a></td><td class="invert"> <div class="quantity"><div class="quantity-select"> <div class="entry value"><span>'+ detalleProducto.cantidad +'</span></div> </div> </div></td><td class="invert">'+ detalleProducto.nombre +'</td>  <td class="invert">'+ detalleProducto.precio +'</td> </td>  <td class="invert">'+(detalleProducto.precio*detalleProducto.cantidad).toFixed(2)+'</td> <td class="invert"> <div class="rem"> <button type="button" id="' + i + '" class="btn btn-sm btn-danger eliminar-producto" >Eliminar</button></div> </div><input id="listaProductos_'+i+'" name="listaProductos['+i+'].producto" type="hidden" value="'+i+'--'+detalleProducto.cantidad+'--'+detalleProducto.precio+'"> </td> </tr>');
        $(".eliminar-producto").on("click", function () {
            var id = $(this).attr("id");
            sessionStorage.removeItem(id);
            mostrarDatosCarShop();
        });
    }

}

function limpiarCampos() {
        find('#bodyCarshop').html('');
    }



 function passData() {
	 var datos = {};
	 var carrito = [];
	 for (var i in sessionStorage) {
        detalleProducto = JSON.parse(sessionStorage.getItem(i));
        if(sessionStorage.getItem(i) != "null"){
        	 carrito[i] = { id: i, cantidad: detalleProducto.cantidad};
        }
	 }
    nuevoCarrito= carrito.filter(Boolean);
	 datos= nuevoCarrito;
	 console.log(nuevoCarrito);

	 $.ajax({
         type : "POST",
         contentType : "application/json",
         url : "/compra/pago",
         data : JSON.stringify(datos),
         dataType : 'json',
         success : function(result) {
           console.log("Exitoooo");
           location.assign("http://localhost:8080/compra/success");
           sessionStorage.clear();
         },
         error : function(e) {
           console.log("ERROR: ", e);
           sessionStorage.clear();
           location.assign("http://localhost:8080/compra/success");
         }
	 	});

  }






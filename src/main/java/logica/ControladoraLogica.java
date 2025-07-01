
package logica;

import Persistencia.ControladoraPersistencia;
import java.math.BigDecimal;
import java.util.List;






public class ControladoraLogica {
    


 
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();

    public void guardar(String nombre, BigDecimal precioCompra, BigDecimal precioVenta, int cantidad, Categoria categoria, String nombrecat) {
        
         boolean seguardocat = false;
        
        /*Chequeamos si la categoria esta registrada en la bd, si está,
        solo le sumamos +1 a la cantidad de productos que contiene la categoria encontrada en la lista y actualizamos.
         Asignamos la variable categoria = a cat, que es la categoria ya registrada en la bd para luego setearsela al producto.
        */

        List<Categoria> listacat = controlpersis.traerCategorias();
        for(Categoria cat:listacat){
           if(cat.getNombre().equals(nombrecat)){
        cat.setCantidadDeProductos(cat.getCantidadDeProductos()+1);      
        controlpersis.editCat(cat);
        categoria = cat;
        seguardocat = true;
        }
        }
        
        
        /*
        Si no esta registrada, le seteamos los atributos correspondientes,
        y la persistimos en la base de datos

        */
        if(seguardocat==false){
        categoria.setNombre(nombrecat);
        categoria.setCantidadDeProductos(categoria.getCantidadDeProductos()+1);
        try {
            controlpersis.guardar(categoria);// Persistís primero la categoría
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
           
      //Creamos el producto y asignamos sus valores enviados en la IGU
        Producto prod = new Producto();
        prod.setNombre(nombre);
        prod.setPrecio_compra(precioCompra);
        prod.setPrecio_venta(precioVenta);
        prod.setCantidad(cantidad);
        prod.setCategoria(categoria);
        controlpersis.guardar(prod);
        
        
        
        
        }

    public void verlista() {
        for(Categoria var:controlpersis.traerCategorias()){
            System.out.println(var.getCantidadDeProductos());
        }
    }

    public List<Producto> traerprod() {
        return controlpersis.traerprod();
    }

    public Producto traerproducto(int idProd) {
        return controlpersis.traerproducto(idProd);
    }


    public void modificarprod(Producto prod, String nombre, BigDecimal precioCompra, BigDecimal precioVenta, int cantidad, Categoria categoria, String nombrecat) {
        
        /*Si categoria == null significa que se modifico la categoria anteorior
        a una no existente, creamos una instancia de Categoria y la persistimos     
        */
        categoria = controlpersis.findcatbynom(nombrecat);
        
        
        if (categoria == null) {
        categoria = new Categoria();
        categoria.setNombre(nombrecat);
        categoria.setCantidadDeProductos(0);
        controlpersis.guardar(categoria);

}
        
        
        
        
        /*
        Preguntamos si la Categoria nueva es diferente a la anterior,
        si es asi, en la categoria nueva actualizamos la cantidadDeProductos
        en +1 y -1 en la vieja.
        
        Si es igual no se modifica la categoria
        */
        
        if(!prod.getCategoria().getNombre().equals(categoria.getNombre())){ 
            Categoria catant = prod.getCategoria();
            catant.setCantidadDeProductos(catant.getCantidadDeProductos()-1);
            categoria.setCantidadDeProductos(categoria.getCantidadDeProductos()+1);
            controlpersis.editCat(catant);
            controlpersis.editCat(categoria);
            prod.setCategoria(categoria);
        }
        
        /*
        Seteamos los valores obtenidos de la IGU
        */
        
        prod.setCantidad(cantidad);
        prod.setNombre(nombre);
        prod.setPrecio_compra(precioCompra);
        prod.setPrecio_venta(precioVenta);
        
        
        controlpersis.modificarprod(prod);
        
        
    }

    public List<Categoria> traerCategorias() {
        return controlpersis.traerCategorias();
    }

    public void eliminarprod(int idProd) {
        
        Producto prod = controlpersis.traerproducto(idProd);
        Categoria cat = prod.getCategoria();
        cat.setCantidadDeProductos(cat.getCantidadDeProductos()-1);
        
        controlpersis.editCat(cat);
        controlpersis.eliminarprod(idProd);
    }
          
        }
  
    


    
   
    


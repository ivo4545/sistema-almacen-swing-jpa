
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Categoria;
import logica.Producto;


public class ControladoraPersistencia {

    ProductoJpaController prodjpa = new ProductoJpaController();
    CategoriaJpaController catjpa = new CategoriaJpaController();
    
    public void guardar(Producto prod, Categoria cat) {
        prodjpa.create(prod);
                        
    }

    public List <Categoria> traerCategorias() {
       return catjpa.findCategoriaEntities();
    }

    public void editCat(Categoria cat) {
        try {
            catjpa.edit(cat);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void guardar(Producto prod) {
        prodjpa.create(prod);
    }

    public void guardar(Categoria cat) {
        catjpa.create(cat);
    }

    public void editProd(Producto prod){
        try {
            prodjpa.edit(prod);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteCat(Categoria cat){
        try {
            catjpa.destroy(cat.getIdCategoria());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Categoria traercat(int idCat){
        return catjpa.findCategoria(idCat);
    }



    public List<Producto> traerprod() {
        return prodjpa.findProductoEntities();
    }

    public Producto traerproducto(int idProd) {
        return prodjpa.findProducto(idProd);
    }

    public void modificarprod(Producto prod) {
        try {
            prodjpa.edit(prod);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void eliminarprod(int idProd) {
        try {
            prodjpa.destroy(idProd);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Categoria findcatbynom(String nombrecat) {
        return catjpa.findCategoriaByNombre(nombrecat);
    }
    
    
    
}

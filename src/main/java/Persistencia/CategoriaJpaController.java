/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import logica.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Categoria;

/**
 *
 * @author ivost
 */
public class CategoriaJpaController implements Serializable {
    
    private EntityManagerFactory emf;
    
    public CategoriaJpaController(EntityManagerFactory emf){
        this.emf = emf;
    }
    
        public CategoriaJpaController(){
        emf = Persistence.createEntityManagerFactory("AlmacenPU");
    }
        
         public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
         
         public void create (Categoria categoria){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } finally {
            if (em!=null){
            em.close();
        }
        }
     }
         
             // Método para buscar una categoría por nombre
    public Categoria findCategoriaByNombre(String nombre) {
EntityManager em = getEntityManager();
    try {
        return em.createQuery("SELECT c FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
                 .setParameter("nombre", nombre)
                 .getSingleResult();
    } catch (NoResultException e) {
        return null;
    } finally {
        em.close();
    }
    }
         
     
     public void edit(Categoria categoria) throws NonexistentEntityException, Exception{
         EntityManager em = null;
         try{
            em = getEntityManager();
            em.getTransaction().begin();
            categoria = em.merge(categoria);
            em.getTransaction().commit();
         } catch (Exception ex) {
             String msg = ex.getLocalizedMessage();
             if (msg == null || msg.length() == 0){
                 int id = categoria.getIdCategoria();
                 if (findCategoria(id) == null){
                     throw new NonexistentEntityException("El categoria con id "+ id + "no existe");
                 }
             }
             throw ex;
         } finally {
             if (em != null){
                 em.close();
             }
         }
         
     }
     
     public void destroy(int id) throws NonexistentEntityException{
         EntityManager em = null;
         try{
            em = getEntityManager();
            em.getTransaction().begin(); 
            Categoria categoria;
            try{
                categoria = em.getReference(Categoria.class, id);
                categoria.getIdCategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El dueño con la id "+ id + " no existe");
            }
            em.remove(categoria);
            em.getTransaction().commit();
         } finally {
             if (em != null){
                 em.close();
             }
         }
     }
     
     public List<Categoria> findCategoriaEntities(){
         return findCategoriaEntities(true, -1, -1);
     }
     
     public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
         return findCategoriaEntities(false, maxResults, firstResult);
     }
     
     private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
         EntityManager em = getEntityManager();
         try{
             CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
             cq.select(cq.from(Categoria.class));
             Query q = em.createQuery(cq);
             if(!all){
                 q.setMaxResults(maxResults);
                 q.setFirstResult(firstResult);
             }
             return q.getResultList();
         } finally {
             em.close();
         }
     }
     
    public Categoria findCategoria (int id){
        EntityManager em = getEntityManager();
        try{
            return em.find(Categoria.class, id);
        } finally{
            em.close();
        }
    }
    

    
 
    
    
    public int getCategoriaCount(){
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
  
    
}

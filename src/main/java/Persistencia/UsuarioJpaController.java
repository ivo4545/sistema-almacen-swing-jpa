/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Usuario;

/**
 *
 * @author ivost
 */
public class UsuarioJpaController implements Serializable{
    
    private EntityManagerFactory emf;
    
    public UsuarioJpaController (EntityManagerFactory emf){
        this.emf = emf;
    }
    
    public UsuarioJpaController(){
        emf = Persistence.createEntityManagerFactory("AlmacenPU");
    }
    
    
         public void create (Usuario usuario){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            if (em!=null){
            em.close();
        }
        }
     }
     
     public void edit(Usuario usuario) throws NonexistentEntityException, Exception{
         EntityManager em = null;
         try{
            em = getEntityManager();
            em.getTransaction().begin();
            usuario = em.merge(usuario);
            em.getTransaction().commit();
         } catch (Exception ex) {
             String msg = ex.getLocalizedMessage();
             if (msg == null || msg.length() == 0){
                 int id = usuario.getIdUsuario();
                 if (findUsuario(id) == null){
                     throw new NonexistentEntityException("El usuario con id "+ id + "no existe");
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
            Usuario usuario;
            try{
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El dueño con la id "+ id + " no existe");
            }
            em.remove(usuario);
            em.getTransaction().commit();
         } finally {
             if (em != null){
                 em.close();
             }
         }
     }
     
     public List<Usuario> findUsuarioEntities(){
         return findUsuarioEntities(true, -1, -1);
     }
     
     public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
         return findUsuarioEntities(false, maxResults, firstResult);
     }
     
     private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
         EntityManager em = getEntityManager();
         try{
             CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
             cq.select(cq.from(Usuario.class));
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
     
    public Usuario findUsuario (int id){
        EntityManager em = getEntityManager();
        try{
            return em.find(Usuario.class, id);
        } finally{
            em.close();
        }
    } 
    
    public int getUsuarioCount(){
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
}

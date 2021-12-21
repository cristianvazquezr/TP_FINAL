/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.TipoDeServicio;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Cristian
 */
public class TipoDeServicioJpaController implements Serializable {

    public TipoDeServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TipoDeServicioJpaController() {
        emf = Persistence.createEntityManagerFactory("TP_FinalPU");
    }

    
    
    
    public void create(TipoDeServicio tipoDeServicio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoDeServicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoDeServicio tipoDeServicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoDeServicio = em.merge(tipoDeServicio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoDeServicio.getId();
                if (findTipoDeServicio(id) == null) {
                    throw new NonexistentEntityException("The tipoDeServicio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoDeServicio tipoDeServicio;
            try {
                tipoDeServicio = em.getReference(TipoDeServicio.class, id);
                tipoDeServicio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoDeServicio with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoDeServicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoDeServicio> findTipoDeServicioEntities() {
        return findTipoDeServicioEntities(true, -1, -1);
    }

    public List<TipoDeServicio> findTipoDeServicioEntities(int maxResults, int firstResult) {
        return findTipoDeServicioEntities(false, maxResults, firstResult);
    }

    private List<TipoDeServicio> findTipoDeServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoDeServicio.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoDeServicio findTipoDeServicio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoDeServicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoDeServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoDeServicio> rt = cq.from(TipoDeServicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import logica.FormaDePago;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Cristian
 */
public class FormaDePagoJpaController implements Serializable {

    public FormaDePagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public FormaDePagoJpaController() {
        emf= Persistence.createEntityManagerFactory("TP_FinalPU");
    }

    public void create(FormaDePago formaDePago) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(formaDePago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FormaDePago formaDePago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            formaDePago = em.merge(formaDePago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = formaDePago.getId();
                if (findFormaDePago(id) == null) {
                    throw new NonexistentEntityException("The formaDePago with id " + id + " no longer exists.");
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
            FormaDePago formaDePago;
            try {
                formaDePago = em.getReference(FormaDePago.class, id);
                formaDePago.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formaDePago with id " + id + " no longer exists.", enfe);
            }
            em.remove(formaDePago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FormaDePago> findFormaDePagoEntities() {
        return findFormaDePagoEntities(true, -1, -1);
    }

    public List<FormaDePago> findFormaDePagoEntities(int maxResults, int firstResult) {
        return findFormaDePagoEntities(false, maxResults, firstResult);
    }

    private List<FormaDePago> findFormaDePagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FormaDePago.class));
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

    public FormaDePago findFormaDePago(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FormaDePago.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormaDePagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FormaDePago> rt = cq.from(FormaDePago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

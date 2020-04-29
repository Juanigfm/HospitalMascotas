package spring.clasesDao;

import javax.persistence.Query;
import java.util.List;
import java.io.Serializable;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import spring.interfacesDAO.GenericDAO;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
    protected Class<T> persistentClass;
    private EntityManager entityManager;
    
    @PersistenceContext
    public void setEntityManager(final EntityManager em) {
        this.entityManager = em;
    }
    
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public Class<T> getPersistentClass() {
        return this.persistentClass;
    }
    
    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
    
    public GenericDAOHibernateJPA(Class<T> clase) {
        this.persistentClass = clase;
    }
    
    public T actualizar(final T entity) {
        this.getEntityManager().merge((Object)entity);
        return entity;
    }
    
    public void borrar(final T entity) {
        final EntityManager em = this.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.contains((Object)entity) ? entity : em.merge((Object)entity));
            tx.commit();
        }
        catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            em.close();
        }
        em.close();
    }
    
    public T borrar(final Serializable id) {
        final T entity = (T)this.getEntityManager().find((Class)this.getPersistentClass(), (Object)id);
        if (entity != null) {
            this.borrar(entity);
        }
        return entity;
    }
    
    public boolean existe(final Serializable id) {
        final T obj = this.recuperar(id);
        return obj != null;
    }
    
    public T persistir(final T entity) {
        this.getEntityManager().persist((Object)entity);
        return entity;
    }
    
    public List<T> recuperarTodos(final String columnOrder) {
        final Query consulta = this.getEntityManager().createQuery("select e from " + this.getPersistentClass().getSimpleName() + " e order by e." + columnOrder);
        final List<T> resultado = (List<T>)consulta.getResultList();
        return resultado;
    }
    
    public List<T> recuperarTodos() {
        final Query consulta = this.getEntityManager().createQuery("select e from " + this.getPersistentClass().getSimpleName() + " e");
        final List<T> resultado = (List<T>)consulta.getResultList();
        return resultado;
    }
    
    public List<T> recuperarLista(final String innerj, final String condicion) {
        final Query consulta = this.getEntityManager().createQuery("select e from " + this.getPersistentClass().getSimpleName() + " e " + innerj + ' ' + condicion);
        final List<T> resultado = (List<T>)consulta.getResultList();
        return resultado;
    }
    
//    public T recuperar(final String innerj, final String condicion) {
//        Query consulta = this.getEntityManager().createQuery("select e from " + this.getPersistentClass().getSimpleName() + " e " + innerj + ' ' + condicion);
//        T resultado = (T)consulta.getResultList();
//        return resultado;
//    }
    
    public T recuperar(final Serializable id) {
        final T resultado = (T)this.getEntityManager().find((Class)this.getPersistentClass(), (Object)id);
        return resultado;
    }
}
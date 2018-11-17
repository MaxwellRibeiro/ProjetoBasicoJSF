package modelo;

import java.util.List;

import javax.persistence.EntityManager;

import beans.Grupo;
import jpa.JPAUtil;
import util.UtilErros;
import util.UtilMensagem;

public class GrupoDAO {
	private EntityManager em;

	public GrupoDAO() {
		em = JPAUtil.getEntityManager();
	}
	
	public List<Grupo> ListarTodos(){
		return em.createQuery("from Grupo order by nome").getResultList();
	}
	
	public boolean gravar(Grupo obj) {
		try {
			em.getTransaction().begin();
			if(obj.getId() == null) {
				em.persist(obj);
			}
			else {
				em.merge(obj);
			}
			em.getTransaction().commit();
			UtilMensagem.mensagemInformacao("Objeto persistido com sucesso!");
			
			return true;
				
		} catch (Exception e) {
			if(em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagem.mensagemErro(UtilErros.getMensagemErro(e));
			
			return false;
		}
	}
	
	public boolean excluir(Grupo obj) {
		try {
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			UtilMensagem.mensagemInformacao("objeto removido com sucesso!");
			
			return true;
				
		} catch (Exception e) {
			if(em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagem.mensagemErro(UtilErros.getMensagemErro(e));
			
			return false;
		}
	}
	
	public Grupo localizar(Integer id) {
		return em.find(Grupo.class, id);
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}

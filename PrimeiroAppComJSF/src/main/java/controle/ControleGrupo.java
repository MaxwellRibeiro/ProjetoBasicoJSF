package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Grupo;
import modelo.GrupoDAO;

@ManagedBean(name = "controleGrupo")
@SessionScoped
public class ControleGrupo {
	private GrupoDAO dao;
	private Grupo objeto;
	
	public ControleGrupo() {
		dao = new GrupoDAO();
	}
	
	public String listar() {
		return "/privado/grupo/listar?faces-redirect=true";
	}
	
	public String novo(){
		objeto = new Grupo();
		return "form";
	}
	
	public String cancelar() {
		return "listar";
	}
	
	public String gravar() {
		if(dao.gravar(objeto)) {
			return "listar";
		}else {
			return "form";
		}
	}
	
	public String alterar(Grupo obj) {
		objeto = obj;
		return "form";
	}
	
	public String excluir(Grupo obj) {
		dao.excluir(obj);
		return "listar";
	}
	
	public GrupoDAO getDao() {
		return dao;
	}
	public void setDao(GrupoDAO dao) {
		this.dao = dao;
	}
	public Grupo getObjeto() {
		return objeto;
	}
	public void setObjeto(Grupo objeto) {
		this.objeto = objeto;
	}
	
	

}

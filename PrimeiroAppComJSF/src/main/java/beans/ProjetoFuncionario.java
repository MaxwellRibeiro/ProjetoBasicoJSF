package beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProjetoFuncionario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer id;
	@Column(nullable=false)
	private Integer cargaHoraria;
	@Column(nullable=false)
	private Boolean gestor;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar inicioParticipacao;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar fimParticipacao;
	@ManyToOne
	@JoinColumn(name="funcionario", referencedColumnName="id", nullable=false)
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name="projeto", referencedColumnName="id", nullable=false)
	private Projeto projeto;
	
	public ProjetoFuncionario()	{
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Boolean getGestor() {
		return gestor;
	}
	public void setGestor(Boolean gestor) {
		this.gestor = gestor;
	}
	public Calendar getInicioParticipacao() {
		return inicioParticipacao;
	}
	public void setInicioParticipacao(Calendar inicioParticipacao) {
		this.inicioParticipacao = inicioParticipacao;
	}
	public Calendar getFimParticipacao() {
		return fimParticipacao;
	}
	public void setFimParticipacao(Calendar fimParticipacao) {
		this.fimParticipacao = fimParticipacao;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjetoFuncionario other = (ProjetoFuncionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

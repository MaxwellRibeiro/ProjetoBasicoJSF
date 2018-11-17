package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

@Entity
public class Projeto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String descrecao;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar inicio;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar fim;
	@Column(nullable=false)
	private Boolean ativo;
	@ManyToOne
	@JoinColumn(name="setor", referencedColumnName="id", nullable=false)
	private Setor setor;
	
	@OneToMany(mappedBy="projeto", cascade = {CascadeType.ALL}, orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OrderBy(value="id asc")
	private List<ProjetoFuncionario> funcionarios = new ArrayList<>();
	
	public Projeto() {
		
	}
	
	public List<ProjetoFuncionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<ProjetoFuncionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrecao() {
		return descrecao;
	}
	public void setDescrecao(String descrecao) {
		this.descrecao = descrecao;
	}
	public Calendar getInicio() {
		return inicio;
	}
	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}
	public Calendar getFim() {
		return fim;
	}
	public void setFim(Calendar fim) {
		this.fim = fim;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Projeto [nome=" + nome + "]";
	}
	
	public void adicionarFuncionario(ProjetoFuncionario obj) {
		obj.setProjeto(this);
		this.funcionarios.add(obj);
	}
	
	public void removeFuncionario(ProjetoFuncionario obj) {
		if(this.funcionarios.contains(obj)) {
			this.funcionarios.remove(obj);
		}
	}
	
	public void removeTodosFuncionario(ProjetoFuncionario obj) {
		this.funcionarios.clear();
	}
	
	
	
}

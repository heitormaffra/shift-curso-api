package br.com.fiap.avaliarcurso;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_avaliarcurso")
public class AvaliarCursoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int cursoId;
	private int alunoId;
	private int nota;
	
	
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}
	public int getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public Double gerarMediaDoCurso (List<AvaliarCursoEntity> avaliacoes) {
		
		Integer somaDasnotas = 0;
		
		for(AvaliarCursoEntity avaliacao : avaliacoes) {
			somaDasnotas += avaliacao.getNota();
		}
		
		if(avaliacoes.size() == 0) {
			return 0d;
		}
		
		
		return (double) (somaDasnotas / avaliacoes.size());
	}
	
}



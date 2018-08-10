package br.com.fiap.avaliarcurso;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AvaliarCursoDao extends JpaRepository<AvaliarCursoEntity, Long>{
	@Query("SELECT a FROM AvaliarCursoEntity a WHERE a.cursoId = ?1")
	List<AvaliarCursoEntity> findAllCursos(Integer id);
}
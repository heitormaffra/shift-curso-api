package br.com.fiap.avaliarcurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/avaliarcurso")
public class AvaliarCursoController {
	
	@Autowired
	private AvaliarCursoDao avaliarCursoDao;
	
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	public ResponseEntity<AvaliarCursoEntity> gerarAvaliacao(@RequestBody AvaliarCursoEntity avaliacao) {
		
		avaliacao.setAlunoId(avaliacao.getAlunoId());
		avaliacao.setCursoId(avaliacao.getCursoId());
		avaliacao.setNota(avaliacao.getNota());		
		
		avaliarCursoDao.save(avaliacao);
		
		return new ResponseEntity<AvaliarCursoEntity>(avaliacao, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/mediaPorCurso/{cursoId}", method = RequestMethod.GET)
	public ResponseEntity<Media> mediaDeNotasDoCurso(@PathVariable("cursoId") Integer cursoId) {
		
		//Integer id = Integer.valueOf(cursoId);
		
		AvaliarCursoEntity avaliacoes = new AvaliarCursoEntity();	
		
		Media media = new Media();
		media.setMedia(avaliacoes.gerarMediaDoCurso(avaliarCursoDao.findAllCursos(cursoId)));
		
	    return new ResponseEntity<Media>(media, HttpStatus.OK);
	}
	
}

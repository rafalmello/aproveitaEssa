package udesc.pin1.AproveitaEssaJpa2.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.pin1.AproveitaEssaJpa2.Repository.AlunoRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Aluno;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        aluno.setIdAluno(id);
        return ResponseEntity.ok(alunoRepository.save(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


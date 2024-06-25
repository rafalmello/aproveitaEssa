package udesc.pin1.AproveitaEssaJpa2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.pin1.AproveitaEssaJpa2.Repository.ModuloRepository;
import udesc.pin1.AproveitaEssaJpa2.Repository.ProfessorRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Modulo;
import udesc.pin1.AproveitaEssaJpa2.model.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    private ModuloRepository moduloRepository;

    @PostMapping("/fazerLogin")
    public ResponseEntity<Professor> fazerLoginProfessor(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String senha = loginData.get("senha");
        Professor professor = professorRepository.findByEmail(email);
        if (professor != null && professor.getSenha().equals(senha)) {
            return ResponseEntity.ok(professor);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }





    public List<Modulo> acessarModulosProfessor(Long id){
        List<Modulo> modulosDoProfessor = new ArrayList<>();
        Optional<Professor> professor = professorRepository.findById(id);
        for (Modulo modulo :moduloRepository.findAll()) {
            if (modulo.getIdModulo() == professor.get().getIdProfessor()){
                modulosDoProfessor.add(modulo);
            }
        }
        return modulosDoProfessor;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        return professorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}


package udesc.pin1.AproveitaEssaJpa2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.pin1.AproveitaEssaJpa2.Repository.AlunoRepository;
import udesc.pin1.AproveitaEssaJpa2.Repository.ModuloRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Aluno;
import udesc.pin1.AproveitaEssaJpa2.model.Modulo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ModuloRepository moduloRepository;




    @PutMapping("/TopicoTeito")
    public ResponseEntity<Modulo>fazerTopicoModulo(){



        return null;
    }

    // fazer a autentição do login
    @PostMapping("/fazerLogin")//
    public ResponseEntity<Aluno> fazerLogin(/* String email, String senha */ /**/@RequestParam Map<String, String> loginData) {
        String email = loginData.get("email");
        String senha = loginData.get("senha");

        Aluno aluno = alunoRepository.findByEmail(email);

        aluno.getSenha();
        if (aluno != null && aluno.getSenha().equals(senha)) {
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/criarModulo")
    public Optional<Modulo> criarModulo(){

        //Só chamar o metodo da classe adm controller pq o metodo precisa de
        // muitos dados importantes então o aluno pode criar mas ele só vai
        // chamar de ADM para não ter acesso a tantos dados importantes

        try {
            // chamar aq o metodo
        }catch (Exception exception){

        }

            return null;
    }



    @GetMapping("acessarModulosDoAluno")
    public List<Modulo> acessarModulosAluno(Long id){
        List<Modulo> modulosDoAluno = new ArrayList<>();
        Optional<Aluno> aluno = alunoRepository.findById(id);
        for (Modulo modulo :moduloRepository.findAll()) {
            if (modulo.getIdModulo() == aluno.get().getIdAluno()){
                modulosDoAluno.add(modulo);
            }
        }
        return modulosDoAluno;
    }

    @PostMapping("/cadastrarAluno")
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }

    @GetMapping("/buscarAluno/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




}


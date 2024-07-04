package udesc.pin1.AproveitaEssaJpa2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import udesc.pin1.AproveitaEssaJpa2.Repository.AlunoRepository;
import udesc.pin1.AproveitaEssaJpa2.Repository.ModuloRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Aluno;
import udesc.pin1.AproveitaEssaJpa2.model.Modulo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;
    private ModuloRepository moduloRepository;


   // private final PasswordEncoder passwordEncoder;

    @Autowired
    public AlunoController(/*AlunoService userService, PasswordEncoder passwordEncoder*/) {
        //this.userAlunoService = userService;
       // this.passwordEncoder = passwordEncoder;
    }




    @PutMapping("/TopicoTeito")
    public ResponseEntity<Modulo>fazerTopicoModulo(){



        return null;
    }

    // fazer a autentição do login

    //Controller
   /* @PostMapping("/fazerLogin")
    public String login(@RequestBody Aluno aluno) {
       /* Aluno existingAluno = userAlunoService.findByEmail(aluno.getEmail());
        if (existingAluno != null && passwordEncoder.matches(aluno.getSenha(), existingAluno.getSenha())){
            return "login realizado com sucesso";
        } else {
            return "Credências Invalidas";
        }
    }*/

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


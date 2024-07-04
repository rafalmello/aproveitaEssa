package udesc.pin1.AproveitaEssaJpa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.pin1.AproveitaEssaJpa2.Exception.ExeceptionCriarModulo;
import udesc.pin1.AproveitaEssaJpa2.Repository.*;
import udesc.pin1.AproveitaEssaJpa2.model.*;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AlunoRepository alunoRepository;

    private AdministradorRepository administradorRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    private ModuloRepository moduloRepository;


    private TopicoRepository topicoRepository;


    @Autowired
    private DisciplinaRepository disciplinaRepository;


    //este método precisa receber uma lista de tópicos para add ao modulo,
    //uma lista de professores para escolher o professor, o id do aluno para add ele
    //e uma disciplina que precisa ser criada antes para que o modulo seja feito a partir dela
    @PostMapping("/criarModulo") //fazer algo semelhante a pagina 122 da apostila do professor
    public Optional<Modulo> criarModulo( @RequestBody  Long iDaluno,@RequestBody TopicoRepository topicoRepository ){

        Modulo modulo = new Modulo();
        try{
            Long idDoAluno = 0L; // concertar dps esta gambiarra

            Disciplina disciplina = new Disciplina();


            Aluno aluno = new Aluno(); //achar o aluno certo
            Professor professorResponsavel = new Professor();//achar o professor certo

            int tamanhoMenorLista = Integer.MAX_VALUE;
            double porcentagemAtendida = 0;
            int quantTopicos = 0;
            int cargaHoraria = 0;



            // modulo.setAlunoModulo(alunoRepository.findById(idDoAluno));
            for (Professor professorEscolhido : getAllProfessores()) {
                if (professorEscolhido.getAlunos().size() <= tamanhoMenorLista ){
                    professorResponsavel = professorEscolhido;
                    tamanhoMenorLista = professorResponsavel.getAlunos().size();
                }

            }

            modulo.setProfessorResponsavel(professorResponsavel);//modulo recebe professor
            professorResponsavel.getModulos().add(modulo); // dar acesso ao modulo para o professor

            modulo.setAlunoModulo(aluno); //o modulo vai ter acesso ao modulo
            aluno.getModulos().add(modulo);//o aluno vai ter acesso ao modulo

            professorResponsavel.getAlunos().add(aluno);// o professor ganha acesso ao aluno
            aluno.getProfessores().add(professorResponsavel);// o aluno ganha acesso ao professor


            //para adicionar os Topícos corretos(aqueles com mesmo nome), a lista de topicos do modulo
            for (String nomeConteudo: disciplina.getConteudos()) {
                for (Topico topico: topicoRepository.findAll()) {
                    if (nomeConteudo == topico.getNome()){
                         modulo.getTopicos().add(topico);
                         cargaHoraria += topico.getCargaHoraria();
                         quantTopicos++;

                    }

                }

            }
            modulo.setCargaHoraria(cargaHoraria);
            modulo.setNomeModulo(disciplina.getNomeDisciplina());
            porcentagemAtendida = (quantTopicos / disciplina.getConteudos().size());
            if ( porcentagemAtendida > 0.7){

                new ExeceptionCriarModulo("a porcentagem mínima de " +
                        "70% dos conteúdos da disciplina não foi atentida");

                System.out.println("entrou no if dos 70% ");


            }

            return Optional.of(modulo);

        }catch (Exception exception){
            System.out.println("catch");
            new ExeceptionCriarModulo("Não foi Possível criar o módulo");
        }



        //modulo.setProfessorResponsavel();

        //Só chamar o metodo da classe adm controller pq o metodo precisa de
        // muitos dados importantes então o aluno pode criar mas ele só vai
        // chamar de ADM para não ter acesso a tantos dados importantes



        return Optional.of(moduloRepository.save(modulo));
    }




    @PostMapping("/criarModulo3")
    public ResponseEntity<Modulo> criarModulo34(@RequestBody Map<String, Long> moduloData) {
        try {
            Long idAluno = moduloData.get("idAluno");
            Long idProfessor = moduloData.get("idProfessor");
            Long idDisciplina = moduloData.get("idDisciplina");

            Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);
            if (!alunoOptional.isPresent()) {
                return ResponseEntity.badRequest().body(null);
            }

            Optional<Professor> professorOptional = professorRepository.findById(idProfessor);
            if (!professorOptional.isPresent()) {
                return ResponseEntity.badRequest().body(null);
            }

            Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(idDisciplina);
            if (!disciplinaOptional.isPresent()) {
                return ResponseEntity.badRequest().body(null);
            }

            Aluno aluno = alunoOptional.get();
            Professor professor = professorOptional.get();
            Disciplina disciplina = disciplinaOptional.get();

            Modulo modulo = new Modulo();
            modulo.setAlunoModulo(aluno);
            modulo.setProfessorResponsavel(professor);
            modulo.setNomeModulo(disciplina.getNomeDisciplina());
           // modulo.setDisciplinaModulo(disciplina);

            //Set<Topico> topicosDoModulo = new HashSet<>();
            for (Topico topico : topicoRepository.findAll()) {
                if (disciplina.getConteudos().contains(topico.getNome())) {
                    //topicosDoModulo.add(topico);
                }
            }
           // modulo.setTopicos(topicosDoModulo);
           // modulo.setCargaHoraria(topicosDoModulo.stream().mapToInt(Topico::getCargaHoraria).sum());

            Modulo savedModulo = moduloRepository.save(modulo);

            // Atualiza as relações no aluno e professor
            aluno.getModulos().add(savedModulo);
            alunoRepository.save(aluno);

            professor.getModulos().add(savedModulo);
            professorRepository.save(professor);

            return ResponseEntity.ok(savedModulo);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Outros métodos permanecem os mesmos




    // Outros métodos permanecem os mesmos





    @PostMapping("/loginAdm")
    public void fazerLoginAdm(String email, String senha){
        if (email =="rafa123" && email =="rafa123"){
            //entrar na tela principal de professor
        }
    }


    @GetMapping("/todosProfessores")
    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    @PostMapping("/cadastrarProfessor")
    public Professor cadastrarProfessor(@RequestBody Professor professor ){
        return professorRepository.save(professor);
    }

    @PostMapping("criarProfessor")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("atualizarProfessor/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        if (!professorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        professor.setIdProfessor(id);
        return ResponseEntity.ok(professorRepository.save(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        if (!professorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        return professorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/cadastrarAluno")
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }


    @PutMapping("atualizarAluno/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
         aluno.setIdAluno(id);
        return ResponseEntity.ok(alunoRepository.save(aluno));
    }

    @DeleteMapping("deletarAluno/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("todosAlunos")
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }



}

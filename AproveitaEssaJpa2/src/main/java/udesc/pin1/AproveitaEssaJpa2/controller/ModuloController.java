package udesc.pin1.AproveitaEssaJpa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.pin1.AproveitaEssaJpa2.Repository.ModuloRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Modulo;

import java.util.List;

@RestController
@RequestMapping("/modulos")
public class ModuloController {

    @Autowired
    private ModuloRepository moduloRepository;

    @GetMapping
    public List<Modulo> getAllModulos() {
        return moduloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> getModuloById(@PathVariable Long id) {
        return moduloRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Modulo createModulo(@RequestBody Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulo> updateModulo(@PathVariable Long id, @RequestBody Modulo modulo) {
        if (!moduloRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        modulo.setIdModulo(id);
        return ResponseEntity.ok(moduloRepository.save(modulo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModulo(@PathVariable Long id) {
        if (!moduloRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        moduloRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}




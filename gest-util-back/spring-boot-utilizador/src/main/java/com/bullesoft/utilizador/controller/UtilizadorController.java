package com.bullesoft.utilizador.controller;

import com.bullesoft.utilizador.model.Utilizador;
import com.bullesoft.utilizador.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UtilizadorController {

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    // Mostrar utilizadore
    @GetMapping("/utilizadores")
    public List<Utilizador> getUtilizadores(){
        return utilizadorRepository.findAll();
    }

    //Criar utilizadores
    @PostMapping("/utilizadores")
    public Utilizador criarUtilizador(@RequestBody Utilizador utilizador){
        return utilizadorRepository.save(utilizador);
    }

    //
    @GetMapping("/utilizadores/{id}")
    public ResponseEntity<Utilizador> getUtilizadorById(@PathVariable Long id){

        Utilizador utilizador = utilizadorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Utilizador não existe " + id));

        return ResponseEntity.ok(utilizador);
    }

    //

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/utilizadores/{id}")
    public ResponseEntity<Utilizador> atualizarUtilizador(@PathVariable Long id, @RequestBody Utilizador utilizadorDetalhe){

        Utilizador utilizador = utilizadorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Utilizador não existe " + id));

        utilizador.setNome(utilizadorDetalhe.getNome());
        utilizador.setSobreNome(utilizadorDetalhe.getSobreNome());
        utilizador.setEmail(utilizadorDetalhe.getEmail());

        Utilizador atualizadoUtilizador = utilizadorRepository.save(utilizador);
        return ResponseEntity.ok(atualizadoUtilizador);
    }

    //
    @DeleteMapping("/utilizadores/{id}")
    public ResponseEntity <Map<String, Boolean>> apagarUtilizador(@PathVariable Long id){

        Utilizador utilizador = utilizadorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Utilizador não existe " + id));

        utilizadorRepository.delete(utilizador);
        Map<String, Boolean> response= new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }
}

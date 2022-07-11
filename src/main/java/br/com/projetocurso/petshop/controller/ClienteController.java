package br.com.projetocurso.petshop.controller;

import br.com.projetocurso.petshop.model.Cliente;
import br.com.projetocurso.petshop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> incluir(@RequestBody Cliente cliente) {
        Cliente clienteIncluido = clienteService.salvar(cliente);
        URI localizacao = URI.create("cliente/" + clienteIncluido.getId());
        return ResponseEntity.created(localizacao).body(clienteIncluido);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        Cliente clienteAtualizado = clienteService.salvar(cliente);
        return ResponseEntity.ok().body(clienteAtualizado);
    }


}

package br.com.projetocurso.petshop.service;

import br.com.projetocurso.petshop.model.Cliente;
import br.com.projetocurso.petshop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo;
    }

    public Cliente recuperarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> recuperarTodos() {
        return clienteRepository.findAll();
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
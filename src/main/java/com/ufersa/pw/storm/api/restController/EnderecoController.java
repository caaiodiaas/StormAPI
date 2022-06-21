package com.ufersa.pw.storm.api.restController;

import com.ufersa.pw.storm.api.dto.EnderecoDTO;
import com.ufersa.pw.storm.domain.entity.Endereco;
import com.ufersa.pw.storm.domain.service.EnderecoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

  EnderecoService service;

  @GetMapping
  public List<EnderecoDTO> listar() {
    return service.listarTodos();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EnderecoDTO cadastrar(@Valid @RequestBody Endereco endereco) {
    return service.adicionar(endereco);
  }

  @PutMapping("/{enderecoId}")
  public ResponseEntity<Endereco> editar(
    @PathVariable Long enderecoId,
    @RequestBody Endereco endereco
  ) {
    return service.editar(enderecoId, endereco);
  }

  @GetMapping("/{enderecoId}")
  public ResponseEntity<Endereco> buscar(@PathVariable Long enderecoId) {
    return service.buscar(enderecoId);
  }
}

package br.com.projetocrud.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.projetocrud.produtos.modelo.ProdutoModelo;
import br.com.projetocrud.produtos.modelo.RespostaModelo;
import br.com.projetocrud.produtos.repositorio.ProdutoRepositorio;

public class ProdutoServico {

  @Autowired
  private RespostaModelo rm;

  @Autowired
  private ProdutoRepositorio pr;

  public Iterable<ProdutoModelo> listar() {
    return pr.findAll();

  }

  public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao) {
    if (pm.getNome().equals("")) {
      rm.setResposta("O nome do produto é obrigatório!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else if (pm.getMarca().equals("")) {
      rm.setResposta("A marca do produto é obrigatório!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else {
      if (acao.equals("cadastrar")) {
        return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
      } else {
        return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);

      }
    }
  }

  public ResponseEntity<RespostaModelo> remover(long codigo) {
    pr.deleteById(codigo);
    rm.setResposta("O produto foi removido com sucesso!");
    return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

  }

}
package br.com.projetocrud.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetocrud.produtos.modelo.ProdutoModelo;
import br.com.projetocrud.produtos.repositorio.ProdutoRepositorio;

public class ProdutoServico {
  @Autowired
  private ProdutoRepositorio pr;

  public Iterable<ProdutoModelo> listar() {
    return pr.findAll();

  }
}

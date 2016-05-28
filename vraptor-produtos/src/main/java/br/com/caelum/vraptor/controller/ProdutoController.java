package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Patch;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;

@Controller
public class ProdutoController {

	private final Result result;
	private final ProdutoDao dao;

	@Deprecated
	public ProdutoController() {
		this(null, null);
	}

	@Inject
	public ProdutoController(Result result, ProdutoDao dao) {
		this.result = result;
		this.dao = dao;
	}

	@Patch("/produto")
	public void inicio() {
	}

	@Path("/produto/lista")
	@Get
	public List<Produto> lista() {
		return dao.lista();
	}

	@Path("/produto/sobre")
	public void sobre() {
	}

	@Path("/produto/formulario")
	public void formulario() {
	}

	@Path("/produto/adiciona")
	@Post
	public void adiciona(Produto produto) {
		dao.adiciona(produto); // preciso de um produto aqui!!!
		result.redirectTo(this).lista();
	}

	@Path("/produto/remove")
	@Delete
	public void remover(Produto produto) {
		dao.remove(produto);
	}

}

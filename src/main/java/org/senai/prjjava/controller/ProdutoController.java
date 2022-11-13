package org.senai.prjjava.controller;

import java.util.Optional;

import org.senai.prjjava.entity.Produto;
import org.senai.prjjava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/produto")
@CrossOrigin("*")
public class ProdutoController 
{

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/")
    public @ResponseBody Integer addProduto(@RequestBody Produto produto) 
    {
        produtoRepository.save(produto);
        return produto.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Produto> buscarProdutos() 
    {
        return produtoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody Optional<Produto> buscarProduto(@PathVariable Integer id)
    {
        return produtoRepository.findById(id);
    }

    @PutMapping("/")
    public @ResponseBody Produto atualizar(@RequestBody Produto produto)
    {
        produtoRepository.save(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id)
    {
        produtoRepository.deleteById(id);
        return "Ok ao apagar!";
    }

}

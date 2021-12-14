package Controller;

import Model.Produto;
import Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository pr;

    @RequestMapping(value="/cadastrarProduto", method= RequestMethod.GET)
    public String form(){
        return "/formProduto";
    }

    @RequestMapping(value="/cadastrarProduto", method=RequestMethod.POST)
    public String form(@Valid Produto produto, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarProduto";
        }

        pr.save(produto);
        attributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
        return "redirect:/cadastrarProduto";
    }

    @RequestMapping("/listar")
    public ModelAndView listaProdutos(){
        ModelAndView mv = new ModelAndView("listaProdutos");
        Iterable<Produto> produtos = pr.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesProduto(@PathVariable("codigo") long codigo){
        Produto produto = pr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("produto/detalhesProduto");
        mv.addObject("produto", produto);
        return mv;
    }

    @RequestMapping("/deletarProduto")
    public String deletarEvento(long codigo){
        Produto produto = pr.findByCodigo(codigo);
        pr.delete(produto);
        return "redirect:/produtos";
    }
    }

package carrinho;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

	private Carrinho carr;
	
	@DisplayName("Inicializando classe para teste do carrinho")
	@BeforeEach
	public void inicializa() {
		carr = new Carrinho();
		
		Produto item1 = new Produto("item 1 - Smart Tv", 1000.00);
		Produto item2 = new Produto("item 2 - Smart Watch", 200.00);
		Produto item3 = new Produto("item 3 - Smartfone", 2000.00);
		
		carr.addItem(item1);
		carr.addItem(item2);
		carr.addItem(item3);				
	}
	
	@DisplayName("Testa valor total de produtos no carrinho")
	@Test
	public void testValorTotalCarrinho() {
		double total = carr.getValorTotal();		
		Assertions.assertEquals(3200, total);	
	}
		
	@DisplayName("Testa adicionar item no carrinho")
	@Test
	public void testAddItemCarrinho() {
		Produto item4 = new Produto("item 4 - Fone de ouvido bluetooth", 300.00);		
		carr.addItem(item4);		
		assertEquals(carr.getQtdeItems(), 4);		
	}
	
	@DisplayName("Testa remover item no carrinho")
	@Test
	public void testRemoverItemCarrinho() {
		Produto item = new Produto("item 2 - Smart Watch", 220.00);		
		try {
			assertEquals(carr.getQtdeItems(), 3);
			carr.removeItem(item);
			assertEquals(carr.getQtdeItems(), 2);
			assertEquals(carr.getQtdeItems(), 4); //Failures			
		} catch (ProdutoNaoEncontradoException e) {
			assertTrue(e instanceof ProdutoNaoEncontradoException);
		}		
	}
	
	@DisplayName("Testa esvaziar o carrinho")
	@Test
	public void testEsvaziarCarrinho() {
		carr.esvazia();
		assertEquals(carr.getQtdeItems(), 0);		
	}

}

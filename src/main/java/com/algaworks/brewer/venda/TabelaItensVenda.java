package com.algaworks.brewer.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.brewer.model.ItemVenda;

public class TabelaItensVenda {

	private List<ItemVenda> itens = new ArrayList<>();
	
	public BigDecimal getValorTotal() {
		return itens.stream()
				.map(ItemVenda::getValorTotal)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
	
	/**
	 * Obs:
	 * stream() - é uma espécie de iterador do java 8
	 * map() - mappear é pegar o atributo ali dentro que quero verificar
	 * reduce() - reduz somando, reduce retorna um optional de bigdecimal
	 * se não encontrar nada retora como 0
	 */
}

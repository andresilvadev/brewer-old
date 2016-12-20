package com.algaworks.brewer.controller.pager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

public class PageWrapper<T> {

	private Page<T> page;
	private UriComponentsBuilder uriBuilder;
	
	public PageWrapper(Page<T> page, HttpServletRequest httpServletRequest){
		this.page = page;
		this.uriBuilder = ServletUriComponentsBuilder.fromRequest(httpServletRequest);
	}
	
	public List<T> getContent(){
		return page.getContent();
	}
	
	public boolean isEmpty(){
		return page.getContent().isEmpty();
	}
	
	public int getAtual(){
		return page.getNumber();
	}
	
	public boolean isFirst(){
		return page.isFirst();
	}	
	
	public boolean isLast(){
		return page.isLast();
	}
	
	public int getTotal(){
		return page.getTotalPages();
	}
	
	public String urlParaPagina(int pagina){
		return uriBuilder.replaceQueryParam("page", pagina).build(true).encode().toUriString();
	}
}

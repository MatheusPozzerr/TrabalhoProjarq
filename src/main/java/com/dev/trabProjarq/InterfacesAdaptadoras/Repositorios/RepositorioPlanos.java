package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import com.dev.trabProjarq.dominio.services.IPlanosRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositorioPlanos implements IPlanosRep {
	private IPlanosCrud planosCrud;

	@Autowired
	public RepositorioPlanos(IPlanosCrud planosCrud) {
		this.planosCrud = planosCrud;
	}

	@Override
	public List<PlanoDeVoo> findPlanos() {
		return this.planosCrud.findAll();
	}

}

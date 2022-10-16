package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import com.dev.trabProjarq.dominio.services.IOcupacaoAeroviaRep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioOcupacaoAerovia implements IOcupacaoAeroviaRep {
	private IOcupacaoAeroviaCrud ocupacaoAeroviaCrud;

	@Autowired
	public RepositorioOcupacaoAerovia(IOcupacaoAeroviaCrud ocupacaoAeroviaCrud) {
		this.ocupacaoAeroviaCrud = ocupacaoAeroviaCrud;
	}

	@Override
	public List<OcupacaoAerovia> findAll() {
		return ocupacaoAeroviaCrud.findAll();
	}

}

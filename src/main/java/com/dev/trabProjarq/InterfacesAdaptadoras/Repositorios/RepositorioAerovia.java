package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.services.IAeroviaRep;

@Component
public class RepositorioAerovia implements IAeroviaRep {
	private IAeroviaCrud aeroviaCrud;

	@Autowired
	public RepositorioAerovia(IAeroviaCrud aeroviaCrud) {
		this.aeroviaCrud = aeroviaCrud;
	}

	@Override
	public Optional<Aerovia> findAerovia(int aeroviaId) {
		return this.aeroviaCrud.findById(aeroviaId);
	}

}

package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.dev.trabProjarq.dominio.services.IOcupacaoAeroviaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;

@Component
public class RepositorioOcupacaoAerovia implements IOcupacaoAeroviaRep {
	private IOcupacaoAeroviaCrud ocupacaoAeroviaCrud;

	@Autowired
	public RepositorioOcupacaoAerovia(IOcupacaoAeroviaCrud ocupacaoAeroviaCrud) {
		this.ocupacaoAeroviaCrud = ocupacaoAeroviaCrud;
	}

	@Override
	public List<OcupacaoAerovia> findOcupadasSlots(int aeroviaId, Date data, List<Integer> slotsHorarios) {
		return ocupacaoAeroviaCrud.findAll().stream()
			.filter(oa -> oa.aerovia.id == aeroviaId)
			.filter(oa -> oa.data.equals(data))
			.filter(oa -> slotsHorarios.contains(oa.slotHorario))
			.collect(Collectors.toList());
	}

}

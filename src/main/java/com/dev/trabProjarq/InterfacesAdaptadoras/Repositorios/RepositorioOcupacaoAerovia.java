package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	public List<OcupacaoAerovia> findOcupadasSlots(int aeroviaId, Date data, List<Float> slotsHorarios) {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return ocupacaoAeroviaCrud.findAll().stream()
			.filter(oa -> oa.aerovia.id == aeroviaId)
			.filter(oa -> formatter.format(oa.data).equals(formatter.format(data)))
			.filter(oa -> slotsHorarios.contains((float) oa.slot_horario))
			.collect(Collectors.toList());
	}

}

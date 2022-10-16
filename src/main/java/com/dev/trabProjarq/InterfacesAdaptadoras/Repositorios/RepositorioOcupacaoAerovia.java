package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import com.dev.trabProjarq.dominio.services.IOcupacaoAeroviaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepositorioOcupacaoAerovia implements IOcupacaoAeroviaRep {
	private IOcupacaoAeroviaCrud ocupacaoAeroviaCrud;

	@Autowired
	public RepositorioOcupacaoAerovia(IOcupacaoAeroviaCrud ocupacaoAeroviaCrud) {
		this.ocupacaoAeroviaCrud = ocupacaoAeroviaCrud;
	}

	@Override
	public List<OcupacaoAerovia> findOcupadasSlots(int aeroviaId, LocalDate data, List<Float> slotsHorarios) {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return ocupacaoAeroviaCrud.findAll().stream()
			.filter(oa -> oa.aerovia.id == aeroviaId)
			.filter(oa -> oa.data.equals(data))
			.filter(oa -> slotsHorarios.contains((float) oa.slot_horario))
			.collect(Collectors.toList());
	}
}

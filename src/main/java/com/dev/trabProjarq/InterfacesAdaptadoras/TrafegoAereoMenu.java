package com.dev.trabProjarq.InterfacesAdaptadoras;

import com.dev.trabProjarq.Aplicacao.ConsultarRotas;
import com.dev.trabProjarq.Aplicacao.ConsultarSlots;
import com.dev.trabProjarq.Aplicacao.DTO.PlanoVooDTO;
import com.dev.trabProjarq.Aplicacao.DTO.RotaDTO;
import com.dev.trabProjarq.Aplicacao.VerificarPlanoVoo;
import com.dev.trabProjarq.dominio.entities.Aerovia;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trafegoMenu")
public class TrafegoAereoMenu {
    private ConsultarRotas consultarRotas;
    private ConsultarSlots consultarSlots;

    private VerificarPlanoVoo verificarPlanoVoo;

    @Autowired
    public TrafegoAereoMenu(ConsultarRotas consultarRotas, ConsultarSlots consultarSlots, VerificarPlanoVoo verificarPlanoVoo) {
        this.consultarRotas = consultarRotas;
        this.consultarSlots = consultarSlots;
        this.verificarPlanoVoo = verificarPlanoVoo;
    }

    @GetMapping("/rotas")
    @CrossOrigin(origins = "*")
    public List<RotaDTO> consultaRotasDestinos(@RequestParam("destino") String destino, @RequestParam("origem") String origem) {
        return this.consultarRotas.buscaRotasDestino(destino, origem);
    }

    @GetMapping("/altitudes-livres/{aeroviaId}")
    @CrossOrigin(origins = "*")
    public List<Integer> consultaAltitudesLivres(@PathVariable int aeroviaId, @RequestParam("data") String data,@RequestParam("horario") float horario, @RequestParam("velocidade") float velCruzeiro){
        LocalDate dataObj = LocalDate.parse(data);
        return this.consultarSlots.consultaAltitudesLivres(aeroviaId, dataObj, horario, velCruzeiro);
    }

    @PostMapping("/verifica-plano-voo")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Aerovia>> verificaPlanoDeVoo(@RequestBody PlanoVooDTO planoVoo){
        List<Aerovia> lista = this.verificarPlanoVoo.verificaPlanoDeVoo(planoVoo);

        if(lista.size() >0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lista);
        }
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
}

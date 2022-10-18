package com.dev.trabProjarq.Aplicacao.DTO;

import java.util.ArrayList;
import java.util.List;

public class RelatorioDto {
    
    public List<PorcentagemOcupacao> listaOcupacao;
    
    public RelatorioDto(List<PorcentagemOcupacao> listaOcupacao){
        this.listaOcupacao = listaOcupacao;
    }

}

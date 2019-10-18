package com.digitel.restFull.ws.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.digitel.restFull.ws.entity.tablaNotas;
import com.digitel.restFull.ws.model.MtablaNotas;

@Component("convertidor")
public class Convertidor {
	
	public List<MtablaNotas> convertirLista(List<tablaNotas> tablaNotass){
		
		List<MtablaNotas> mtablanotas = new ArrayList<>();
		
		for(tablaNotas tablanotas : tablaNotass) {
			
			mtablanotas.add(new MtablaNotas(tablanotas));
			
		}
		
		return mtablanotas;
		
	}

}

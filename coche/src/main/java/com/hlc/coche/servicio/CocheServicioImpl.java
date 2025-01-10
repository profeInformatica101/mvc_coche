package com.hlc.coche.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hlc.coche.entidad.Coche;
import com.hlc.coche.repositorio.CocheRepostorio;

@Service
public class CocheServicioImpl implements CocheServicio {
	
	private CocheRepostorio cocheRepositorio;

	public CocheServicioImpl(CocheRepostorio cocheRepositorio) {
		this.cocheRepositorio = cocheRepositorio;
	}

	@Override
	public List<Coche> obtenerTodosLosCoches() {
		return cocheRepositorio.findAll();
	}

	@Override
	public Coche obtenerCochePorId(Long id) {
		return cocheRepositorio .findById(id).orElseThrow(() -> new RuntimeException("Coche no encontrado con ID: "+ id));
	}

	@Override
	public Coche guardarCoche(Coche coche) {
		return cocheRepositorio.save(coche);
	}

	@Override
	public void eliminarCoche(Long id) {
		cocheRepositorio.deleteById(id);
		
	}

}

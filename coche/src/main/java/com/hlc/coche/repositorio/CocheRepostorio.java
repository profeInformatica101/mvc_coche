/**
 * 
 */
package com.hlc.coche.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hlc.coche.entidad.Coche;

/**
 * 
 */
@Repository
public interface CocheRepostorio extends JpaRepository<Coche, Long> {
	
}

package com.pe.proyecto.api_jersey.escuelaConductores.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.proyecto.api_jersey.escuelaConductores.entity.EscuelaConductorEntity;

public interface EscuelaConductorRepository extends JpaRepository<EscuelaConductorEntity, Integer>{

}

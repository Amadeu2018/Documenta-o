package com.bullesoft.utilizador.repository;

import com.bullesoft.utilizador.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {
}

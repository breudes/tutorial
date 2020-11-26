package br.com.brendasilva.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import br.com.brendasilva.webapp.entity.GrupoEntity;
import br.com.brendasilva.webapp.entity.UsuarioEntity;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity, Long> {
	List<GrupoEntity> findByUsuariosIn(List<UsuarioEntity> usuarioEntity);
}

package br.com.brendasilva.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brendasilva.webapp.entity.GrupoEntity;
import br.com.brendasilva.webapp.entity.PermissaoEntity;

@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {
	List<PermissaoEntity> findByGruposIn(List<GrupoEntity> grupoEntity);
}

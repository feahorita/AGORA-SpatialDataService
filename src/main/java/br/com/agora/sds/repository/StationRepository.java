package br.com.agora.sds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.agora.sds.domain.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, String> {

	@Query("select s from Station s where s.id = :id")
	List<Station> listProperty(@Param("id") String id);

}

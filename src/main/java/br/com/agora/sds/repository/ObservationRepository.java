package br.com.agora.sds.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.agora.sds.domain.Observation;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, String> {

	@Query("SELECT o " + 
		   "FROM Observation o " + 
		   "WHERE o.stationId = :id AND o.datetime >= :sDate AND o.datetime <= :eDate ")
	List<Observation> listByStation(
			@Param("id") 	String id, 
			@Param("sDate") Date sDate, 
			@Param("eDate") Date eDate);

}

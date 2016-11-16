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

	
	@Query(value = "SELECT * " + 
			"FROM ((select station_id, " +
			"    datetime, " +
			"    measure, " +
			"    date, " +
			"    time, " +
			"    cemaden_stations.city, " +
			"    cemaden_stations.state, " +
			"    NULL as \"moffset\", " +
			"    cemaden_stations.coordinates " +
			"from cemaden_rainfall " +
			"join cemaden_stations on cemaden_stations.id = cemaden_rainfall.station_id " +
			"where cemaden_stations.id = :id and cemaden_rainfall.datetime >= :sDate and cemaden_rainfall.datetime <= :eDate " +
			"and cemaden_stations.stype = :property) " +
			"UNION " +
			"(select station_id, " +
			"    datetime, " +
			"    measure, " +
			"    date, " +
			"    time, " +
			"    cemaden_stations.city, " +
			"    cemaden_stations.state, " +
			"    moffset, " +
			"    cemaden_stations.coordinates " +
			"from cemaden_waterlevel " +
			"join cemaden_stations on cemaden_stations.id = cemaden_waterlevel.station_id " +
			"where cemaden_stations.id = :id and cemaden_waterlevel.datetime >= :sDate and cemaden_waterlevel.datetime <= :eDate " +
			"and cemaden_stations.stype = :property)) as observations ", nativeQuery = true)
	List<Observation> listByStation(
			@Param("id") 	String id, 
			@Param("sDate") Date sDate, 
			@Param("eDate") Date eDate,
			@Param("property") String property);
	
	
	
	
	
}

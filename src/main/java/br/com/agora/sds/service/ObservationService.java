package br.com.agora.sds.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agora.sds.domain.Observation;
import br.com.agora.sds.repository.ObservationRepository;

@Service
public class ObservationService {

	@Autowired
	private ObservationRepository observationRepository;

	public List<Observation> listByStation(String id, Date sDate, Date eDate) {
		return observationRepository.listByStation(id, sDate, eDate);
	}
	
	public List<Observation> listByStation(String id, Date sDate, Date eDate, String property) {
		return observationRepository.listByStation(id, sDate, eDate, property);
	}

}
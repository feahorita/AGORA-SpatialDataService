package br.com.agora.sds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agora.sds.domain.Station;
import br.com.agora.sds.repository.StationRepository;

@Service
public class StationService {

	@Autowired
	private StationRepository stationRepository;

	public Station get(String id) {
		return stationRepository.findOne(id);
	}

	public List<Station> listProperty(String id) {
		return stationRepository.listProperty(id);
	}

	public List<Station> findAll() {
		return stationRepository.findAll();
	}

}
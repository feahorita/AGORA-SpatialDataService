package br.com.agora.sds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.agora.sds.domain.Station;
import br.com.agora.sds.service.StationService;

@RestController
@RequestMapping("/station")
public class StationController {

	@Autowired
	private StationService sService;

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	@ResponseBody
	public Station find(@RequestBody String id) {
		System.out.println("In: Station Find");	
		return sService.get(id);
	}

	@RequestMapping(value = "/listProperty", method = RequestMethod.POST)
	@ResponseBody
	public List<Station> listProperty(@RequestBody String id) {
		System.out.println("In: Station Property");
		return sService.listProperty(id);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Station> findAll() {
		System.out.println("In: Station All");
		return sService.findAll();
	}

}

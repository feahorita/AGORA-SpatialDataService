package br.com.agora.sds.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.agora.sds.domain.Observation;
import br.com.agora.sds.domain.ObservationRequest;
import br.com.agora.sds.service.ObservationService;

@RestController
@RequestMapping("/observation")
public class ObservationController {

	@Autowired
	private ObservationService oService;

	@RequestMapping(value = "/listByStation", method = RequestMethod.POST)
	@ResponseBody
	public List<Observation> listByStation(@RequestBody ObservationRequest obs) {
		System.out.println("entrou!!");
		System.out.println(obs.getId());
		System.out.println(obs.getsDate());
		System.out.println(obs.geteDate());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:m:s");

		try {
			System.out.println(formatter.parse(obs.getsDate()));
			System.out.println(formatter.parse(obs.geteDate()));

			return oService.listByStation(obs.getId(), formatter.parse(obs.getsDate()), formatter.parse(obs.geteDate()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

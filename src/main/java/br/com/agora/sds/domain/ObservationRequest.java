package br.com.agora.sds.domain;

import javax.persistence.Id;

public class ObservationRequest {

	@Id
	private String id;

	private String sDate;

	private String eDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

}

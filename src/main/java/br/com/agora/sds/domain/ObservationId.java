package br.com.agora.sds.domain;

import java.io.Serializable;
import java.util.Date;

public class ObservationId implements Serializable {

	private static final long serialVersionUID = -7941505280966113148L;

	String stationId;
	Date datetime;

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}

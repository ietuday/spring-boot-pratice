package com.uday.flightcheckin.integration;

import com.uday.flightcheckin.integration.dto.Reservation;
import com.uday.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);

}

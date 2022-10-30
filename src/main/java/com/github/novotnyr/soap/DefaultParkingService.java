package com.github.novotnyr.soap;

import jakarta.jws.WebService;
import org.example.parking.ParkingRequest;
import org.example.parking.ParkingService;
import org.example.parking.ParkingTicket;

@WebService(endpointInterface = "org.example.parking.ParkingService")
public class DefaultParkingService implements ParkingService {
    @Override
    public ParkingTicket getTicket(ParkingRequest part) {
        return new ParkingTicket();
    }
}

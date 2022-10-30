package com.github.novotnyr.soap;

import jakarta.xml.ws.Endpoint;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingSoapServer {
    public static void main(String[] args) {
        List<Source> metadata = new ArrayList<Source>(); //<1>

        var wsdlSource = new StreamSource(DefaultParkingService.class.getResourceAsStream("/parking.wsdl")); //<2>
        wsdlSource.setSystemId("http://www.example.org/parking/parking.wsdl"); //<3>
        metadata.add(wsdlSource); //<4>

        var xsdSource = new StreamSource(DefaultParkingService.class.getResourceAsStream("/parking.xsd"));//<2>
        xsdSource.setSystemId("http://www.example.org/parking/parking.xsd");//<3>
        metadata.add(xsdSource);//<4>

        var filter = new HashMap<String, Object>();
        filter.put(Endpoint.WSDL_SERVICE, new QName("http://www.example.org/parking", "ParkingServices")); //<5>
        filter.put(Endpoint.WSDL_PORT, new QName("http://www.example.org/parking", "ParkingService")); //<6>

        var endpoint = Endpoint.create(new DefaultParkingService());
        endpoint.setProperties(filter);
        endpoint.setMetadata(metadata);
        endpoint.publish("http://localhost:8888/parking"); //<10>
    }
}

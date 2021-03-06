package ar.com.grupoesfera.capacitacion.enviospostales;

import java.util.List;

public class TransportSelector {
    public Transport selectTransport(List<Package> packageList){
        double weight = 0;

        for (Package pkg: packageList) {
            weight += pkg.getWeight();
        }

        if(packageList.size() == 1 && weight < 0.5){
            return Transport.DRONE;
        }else if(weight < 5){
            return Transport.BICYCLE;
        }else if(weight < 10){
            return Transport.CAR;
        }else if(weight < 150){
            return Transport.VAN;
        }

        throw new Error("The dispatch is so heavy. Impossible to send.");
    }
}

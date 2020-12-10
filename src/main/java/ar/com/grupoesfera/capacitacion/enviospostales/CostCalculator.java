package ar.com.grupoesfera.capacitacion.enviospostales;

public class CostCalculator {
    public double calculateCost(int packagesQty){

        if(packagesQty < 1){
            throw new Error("Debe enviarse al menos un paquete");
        }

        double value = 0;
        if(packagesQty < 5){
            value =  50;
        }else if(packagesQty < 10){
            value = 80;
        }else {
            value = 80;
            value += (packagesQty-10) * 15;
            value = value * 1.1;
        }

        return value;
    }
}

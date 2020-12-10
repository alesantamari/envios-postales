package ar.com.grupoesfera.capacitacion.enviospostales;

public class Dispatcher {
    CostCalculator costCalculator;
    TransportSelector transportSelector;

    public Dispatch sendDispatch(Dispatch dispatch){

        dispatch.setCost(costCalculator.calculateCost(dispatch.getPackageList().size()));
        dispatch.setTransport(transportSelector.selectTransport(dispatch.getPackageList()));

        return dispatch;
    }

    public Dispatcher(CostCalculator costCalculator, TransportSelector transportSelector) {
        this.costCalculator = costCalculator;
        this.transportSelector = transportSelector;
    }

}
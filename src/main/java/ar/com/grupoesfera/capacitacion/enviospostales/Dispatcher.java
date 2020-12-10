package ar.com.grupoesfera.capacitacion.enviospostales;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Dispatcher {
    CostCalculator costCalculator;
    TransportSelector transportSelector;
    List<Dispatch> sentDispatches;

    public List<String> getSentDispatches(){
        return sentDispatches.stream().map(dispatch -> dispatch.toString()).collect(Collectors.toList());
    };

    public Dispatch sendDispatch(Dispatch dispatch){

        dispatch.setCost(costCalculator.calculateCost(dispatch.getPackageList().size()));
        dispatch.setTransport(transportSelector.selectTransport(dispatch.getPackageList()));
        dispatch.setSentDate(LocalDate.now());
        sentDispatches.add(dispatch);

        return dispatch;
    }

    public Dispatcher(CostCalculator costCalculator, TransportSelector transportSelector) {
        this.costCalculator = costCalculator;
        this.transportSelector = transportSelector;
        this.sentDispatches = new LinkedList<>();
    }

}
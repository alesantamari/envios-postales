package ar.com.grupoesfera.capacitacion.enviospostales;

import java.util.List;

public class Dispatch {
    private List<Package> packageList;
    private Double cost;
    private String address;
    private Transport transport;

    public Dispatch(List<Package> packageList, Double cost, String address, Transport transport) {
        this.packageList = packageList;
        this.cost = cost;
        this.address = address;
        this.transport = transport;
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<Package> packageList) {
        this.packageList = packageList;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
package ar.com.grupoesfera.capacitacion.enviospostales;

import java.time.LocalDate;
import java.util.List;

public class Dispatch {
    private List<Package> packageList;
    private Double cost;
    private String address;
    private Transport transport;
    private LocalDate sentDate;

    public Dispatch(List<Package> packageList, Double cost, String address, Transport transport) {
        this.packageList = packageList;
        this.cost = cost;
        this.address = address;
        this.transport = transport;
        this.sentDate = null;
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

    public LocalDate getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return "Dispatch{" +
                "weight=" + packageList.stream().mapToDouble(Package::getWeight).sum() +
                ", packagesQty=" + packageList.size() +
                ", transport=" + transport +
                ", sentDate=" + sentDate +
                '}';
    }
}
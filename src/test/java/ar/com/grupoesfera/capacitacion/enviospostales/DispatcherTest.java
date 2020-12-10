package ar.com.grupoesfera.capacitacion.enviospostales;

import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DispatcherTest {

    Dispatcher dispatcher;

    @Before
    public void dadoQueTenemosUnDespachador() {
        CostCalculator costCalculator = new CostCalculator();
        TransportSelector transportSelector = new TransportSelector();
        dispatcher = new Dispatcher(costCalculator, transportSelector);
    }

    //<5 paquetes (0 paquetes?)
    @Test
    public void testearCuatroPaquetesYCuatroKilos() {
        Dispatch dispatch = dadoQueTenemosUnEnvioConCuatroPaquetesYCuatroKilos();
        cuandoDespachamosElEnvio(dispatch);
        entoncesSeEnviaEnConCostoDe(Transport.BICYCLE, 50.0, dispatch);
    }

    //<10 paquetes
    @Test
    public void testearOchoPaquetesYOchoKilos() {
        Dispatch dispatch = dadoQueTenemosUnEnvioConOchoPaquetesYOchoKilos();
        cuandoDespachamosElEnvio(dispatch);
        entoncesSeEnviaEnConCostoDe(Transport.CAR, 80.0, dispatch);
    }

    //>10 paquetes (+ costo administrativo)
    @Test
    public void testearDieciseisPaquetesYDieciseisKilos() {
        Dispatch dispatch = dadoQueTenemosUnEnvioConDieciseisPaquetesYDieciseisKilos();
        cuandoDespachamosElEnvio(dispatch);
        entoncesSeEnviaEnConCostoDe(Transport.VAN, 187.0, dispatch);
    }

    private Dispatch dadoQueTenemosUnEnvioConDieciseisPaquetesYDieciseisKilos() {
        List<Package> packageList = new LinkedList<>();
        for(int i = 0; i<16; i++) {
            packageList.add(new Package(1));
        }
        Dispatch dispatch = new Dispatch(packageList, 0.0, "RandomAddress", null);
        return dispatch;
    }

    private void entoncesSeEnviaEnConCostoDe(Transport transport, double cost, Dispatch dispatch) {
        assertThat(dispatch.getCost()).isCloseTo(cost, Percentage.withPercentage(0.1));
        assertThat(dispatch.getTransport()).isEqualByComparingTo(transport);
    }

    private void cuandoDespachamosElEnvio(Dispatch dispatch) {
        dispatcher.sendDispatch(dispatch);
    }

    private Dispatch dadoQueTenemosUnEnvioConCuatroPaquetesYCuatroKilos() {
        List<Package> packageList = new LinkedList<>();
        packageList.add(new Package(1));
        packageList.add(new Package(1));
        packageList.add(new Package(1));
        packageList.add(new Package(1));
        Dispatch dispatch = new Dispatch(packageList, 0.0, "RandomAddress", null);
        return dispatch;
    }

    private Dispatch dadoQueTenemosUnEnvioConOchoPaquetesYOchoKilos() {
        List<Package> packageList = new LinkedList<>();
        for(int i = 0; i<8; i++) {
            packageList.add(new Package(1));
        }
        Dispatch dispatch = new Dispatch(packageList, 0.0, "RandomAddress", null);
        return dispatch;
    }
}

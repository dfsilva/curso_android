package br.com.diegosilva.smarthome.api;

import br.com.diegosilva.smarthome.model.Sensor;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 98379720172 on 10/06/2016.
 */
public interface SensorService {

    @GET("/sesores")
    Observable<Sensor> getSensores();

}

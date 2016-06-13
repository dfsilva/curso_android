package br.com.diegosilva.smarthome.api;


import retrofit2.Retrofit;

/**
 * Created by 98379720172 on 13/06/2016.
 */
public class ServiceFactory {

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endPoint)
                .build();

        T service = restAdapter.create(clazz);

        return service;
    }
}

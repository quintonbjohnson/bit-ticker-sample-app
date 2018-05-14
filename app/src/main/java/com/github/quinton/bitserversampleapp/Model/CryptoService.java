package com.github.quinton.bitserversampleapp.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class used to create and access Retrofit instance
 */
public class CryptoService {

    /**
     * Retrofit instance
     */
    private Retrofit rfService = null;

    /**
     * Setting up retrofit service and endpoint class
     * @return the API class that holds the endpoint calls
     */
    public CryptoAPI getEndpoint() {

        String url = "https://api.bitfinex.com/v1/pubticker/";

        if (rfService == null) {
            rfService = new Retrofit
                    .Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return rfService.create(CryptoAPI.class);
    }

}

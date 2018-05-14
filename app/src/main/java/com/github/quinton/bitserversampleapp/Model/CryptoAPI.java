package com.github.quinton.bitserversampleapp.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Interface for API endpoint calls
 */
public interface CryptoAPI {

    // Bitcoin call
    @GET("BTCUSD")
    Call<Currency> getBitcoin();

    // Ethereum call
    @GET("ETHUSD")
    Call<Currency> getETH();

    // Litecoin call
    @GET("LTCUSD")
    Call<Currency> getLTC();

    // Neo call
    @GET("NEOUSD")
    Call<Currency> getNEO();
}

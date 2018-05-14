package com.github.quinton.bitserversampleapp.Controller;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.quinton.bitserversampleapp.Model.CryptoAPI;
import com.github.quinton.bitserversampleapp.Model.CryptoService;
import com.github.quinton.bitserversampleapp.Model.Currency;
import com.github.quinton.bitserversampleapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Main screen for displaying cryptocurrency prices
 */
public class MainActivity extends AppCompatActivity {

    /**
     * TextView for current Bitcoin price
     */
    @BindView(R.id.BitText) TextView bitcoinText;

    /**
     * TextView for current Ethereum price
     */
    @BindView(R.id.ETHText) TextView ethText;

    /**
     * TextView for current Litecoin price
     */
    @BindView(R.id.LTCText) TextView ltcText;

    /**
     * TextView for current Neo price
     */
    @BindView(R.id.NEOText) TextView neoText;

    /**
     * Service for specific endpoint
     */
    private CryptoService bitIndexService;

    /**
     * API call from model package to use for Retrofit instance
     */
    private CryptoAPI bitIndexAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind view to controller
        ButterKnife.bind(this);

        // Creating service instance to access endpoint
        bitIndexService = new CryptoService();

        // Retrieving endpoint
        bitIndexAPI = bitIndexService.getEndpoint();

        // Make API endpoint calls to the correct crypotcurrency targets
        makeAPICalls();
    }

    /**
     * Make 4 asynchronous endpoint calls for the different cryptocurrencies
     */
    private void makeAPICalls() {
        // Asynchronous call to API endpoints
        // BTCUSD
        Call<Currency> bitcoinCall = bitIndexAPI.getBitcoin();
        bitcoinCall.enqueue(new Callback<Currency>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                int statusCode = response.code();
                Currency bitcoinTick = response.body();
                if (bitcoinTick != null) {
                    bitcoinText.setText("BTC: " + Double.toString(bitcoinTick.getPrice()));
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.v("BTC", "Error with Bitcoin call", t);
            }
        });

        // ETHUSD
        Call<Currency> ethCall = bitIndexAPI.getETH();
        ethCall.enqueue(new Callback<Currency>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                int statusCode = response.code();
                Currency ethTick = response.body();
                if (ethTick != null) {
                    ethText.setText("ETH: " + Double.toString(ethTick.getPrice()));
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.v("ETH", "Error with Ethereum call", t);
            }
        });


        // LTCUSD
        Call<Currency> ltcCall = bitIndexAPI.getLTC();
        ltcCall.enqueue(new Callback<Currency>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                int statusCode = response.code();
                Currency ltcTick = response.body();
                if (ltcTick != null) {
                    ltcText.setText("LTC: " + Double.toString(ltcTick.getPrice()));
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.v("LTC", "Error with Litecoin call", t);
            }
        });

        // NEOUSD
        Call<Currency> neoCall = bitIndexAPI.getNEO();
        neoCall.enqueue(new Callback<Currency>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                int statusCode = response.code();
                Currency neoTick = response.body();
                if (neoTick != null) {
                    neoText.setText("NEO: " + Double.toString(neoTick.getPrice()));
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.v("NEO", "Error with Neo call", t);
            }
        });
    }
}

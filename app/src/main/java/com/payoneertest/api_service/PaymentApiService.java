package com.payoneertest.api_service;

import com.payoneertest.model.PaymentMethods;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface  PaymentApiService {
    @GET("listresult.json")
    Single<PaymentMethods> getPaymentMethods();
}

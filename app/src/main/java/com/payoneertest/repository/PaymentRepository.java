package com.payoneertest.repository;

import com.payoneertest.api_service.PaymentApiService;
import com.payoneertest.model.PaymentMethods;


import javax.inject.Inject;

import io.reactivex.Single;

public class PaymentRepository {
    private final PaymentApiService apiService;

    @Inject
    public PaymentRepository(PaymentApiService apiService) {
        this.apiService = apiService;
    }

    public Single<PaymentMethods> getPaymentMethods(){
        return apiService.getPaymentMethods();
    }
}

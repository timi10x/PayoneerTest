package com.payoneertest.view_models;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.payoneertest.model.Applicable;
import com.payoneertest.model.PaymentMethods;
import com.payoneertest.repository.PaymentRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class PaymentsMethodsViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable;

    private PaymentRepository paymentsMethodsRepository;

    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Applicable>> paymentMethods = new MutableLiveData<>();


    public LiveData<ArrayList<Applicable>> getPayments() {
        return paymentMethods;
    }

    public LiveData<Boolean> getError() {
        return repoLoadError;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    private void setPaymentMethods(ArrayList<Applicable> paymentMethods){
        this.paymentMethods.setValue(paymentMethods);
    }

    @Inject
    public PaymentsMethodsViewModel(PaymentRepository paymentsMethodsRepository) {
        this.paymentsMethodsRepository = paymentsMethodsRepository;
        compositeDisposable = new CompositeDisposable();
    }

    public void getPaymentMethods() {
        loading.setValue(true);

        paymentsMethodsRepository.getPaymentMethods()
                .subscribeOn(Schedulers.io())
                .doOnError(error -> {
                    repoLoadError.setValue(true);
                    loading.setValue(false);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<PaymentMethods>() {
                    @Override
                    public void onSuccess(@NonNull PaymentMethods paymentMethods) {
                        repoLoadError.setValue(false);
                        setPaymentMethods(paymentMethods.getNetworks().getApplicable());
                        loading.setValue(false);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                });
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }
}

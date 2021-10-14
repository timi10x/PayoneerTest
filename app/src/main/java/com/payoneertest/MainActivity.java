package com.payoneertest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import dagger.hilt.android.AndroidEntryPoint;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.payoneertest.adapter.PaymentMethodsAdapter;
import com.payoneertest.databinding.ActivityMainBinding;
import com.payoneertest.model.Applicable;
import com.payoneertest.view_models.PaymentsMethodsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private PaymentsMethodsViewModel paymentsMethodsViewModel;
    private PaymentMethodsAdapter adapter;
    private List<Applicable> applicableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        paymentsMethodsViewModel = new ViewModelProvider(this).get(PaymentsMethodsViewModel.class);
        setupObservers();

        paymentsMethodsViewModel.getPaymentMethods();

    }

    private void setupRecyclerview(ArrayList<Applicable> applicables) {
        adapter = new PaymentMethodsAdapter(applicables, this);
        activityMainBinding.paymentsRv.setAdapter(adapter);
    }

    private void setupObservers() {
        paymentsMethodsViewModel.getPayments().observe(this, applicables -> {
            activityMainBinding.progressBar.setVisibility(View.GONE);
            setupRecyclerview(applicables);
        });
        paymentsMethodsViewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                if (isLoading) {
                    activityMainBinding.progressBar.setVisibility(View.VISIBLE);
                }else {

                }
            }
        });
        paymentsMethodsViewModel.getError().observe(this, isError -> {
            if (isError != null)
                if (isError) {
                    activityMainBinding.progressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(getBaseContext(), ServerUtil.NETWORK_ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                }
        });

    }
    
}
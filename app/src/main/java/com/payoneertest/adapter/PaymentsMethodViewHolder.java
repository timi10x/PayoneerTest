package com.payoneertest.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.payoneertest.databinding.PaymentItemBinding;

public class PaymentsMethodViewHolder extends RecyclerView.ViewHolder {
    public PaymentItemBinding paymentItemBinding;

    public PaymentsMethodViewHolder(PaymentItemBinding paymentItemBinding) {
        super(paymentItemBinding.getRoot());
        this.paymentItemBinding = paymentItemBinding;
    }
}

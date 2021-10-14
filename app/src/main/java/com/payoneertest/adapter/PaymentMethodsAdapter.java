package com.payoneertest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.payoneertest.databinding.PaymentItemBinding;
import com.payoneertest.model.Applicable;

import java.util.List;

public class PaymentMethodsAdapter extends RecyclerView.Adapter<PaymentsMethodViewHolder> {
    private Context context;
    private PaymentItemBinding paymentItemBinding;
    private List<Applicable> applicableList;

    public PaymentMethodsAdapter(List<Applicable> applicableList, Context context) {
        this.applicableList = applicableList;
        this.context = context;
    }

    public void setList(List<Applicable> applicableList) {
        applicableList = applicableList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PaymentsMethodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        paymentItemBinding = PaymentItemBinding.inflate(inflater, parent, false);
        return new PaymentsMethodViewHolder(paymentItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentsMethodViewHolder holder, int position) {
        Glide.with(context).load(applicableList.get(position).getLinks().getLogo())
                .into(holder.paymentItemBinding.paymentMethodImg);
        holder.paymentItemBinding.paymentTextLabel.setText(applicableList.get(position).getLabel());
    }

    @Override
    public int getItemCount() {
        return applicableList == null ? 0 : applicableList.size();
    }
}

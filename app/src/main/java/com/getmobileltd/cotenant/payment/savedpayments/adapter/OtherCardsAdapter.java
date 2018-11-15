package com.getmobileltd.cotenant.payment.savedpayments.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getmobileltd.cotenant.AppInstance;
import com.getmobileltd.cotenant.R;
import com.getmobileltd.cotenant.payment.ChooseCardType;
import com.getmobileltd.cotenant.payment.EmptyPayment;
import com.getmobileltd.cotenant.payment.savedpayments.helper.Operations;
import com.getmobileltd.cotenant.payment.savedpayments.model.OtherCardsModel;

import java.util.List;

public class OtherCardsAdapter extends RecyclerView.Adapter<OtherCardsAdapter.MyViewHolder> {
    private List<OtherCardsModel> modelList;
    private Context context;

    public OtherCardsAdapter(Context context, List<OtherCardsModel> modelList) {
        this.context = context;
        this.modelList = modelList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other_cards,parent,false);
        return new OtherCardsAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.card  = modelList.get(position);
        holder.cardType.setImageResource(modelList.get(position).getCardType());
        holder.firstTwo.setText(modelList.get(position).getMonth());
        holder.lastFour.setText(modelList.get(position).getLastFourDigits());

        holder.editCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AppInstance app = AppInstance.getInstance();
               app.setCheckCardID(modelList.get(position).getId());
                Context context = view.getContext();
                Intent intent = new Intent(context, ChooseCardType.class);
                new AppInstance().setCheckCardID(modelList.get(position).getId());
                context.startActivity(intent);


            }
        });

        holder.removeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Operations.deleteCard(holder.card.getId());
                notifyDataSetChanged();
                if (modelList.size() == 0) {
                    view.getContext().startActivity(new Intent(view.getContext(),EmptyPayment.class));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != modelList ? modelList.size() : 0);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView lastFour;
    private TextView firstTwo;
    private ImageView cardType;
    private TextView editCard;
    private TextView removeCard;
         OtherCardsModel card;
        public MyViewHolder(View itemView) {
            super(itemView);
            lastFour = itemView.findViewById(R.id.lastfour);
            firstTwo = itemView.findViewById(R.id.firsttwo);
            cardType = itemView.findViewById(R.id.cardType);
            editCard = itemView.findViewById(R.id.edit_card);
            removeCard = itemView.findViewById(R.id.remove_card);
        }
    }
}

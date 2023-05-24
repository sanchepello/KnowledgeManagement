package com.example.knowledgemanagement;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder> {

    List <Card>cards;

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;

        CardViewHolder(CardView cv) {
            super(cv);
            cardView = cv;
        }
    }

    RVAdapter(List cards){
        this.cards = cards;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new CardViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int position) {
        CardView cardView = cardViewHolder.cardView;
        TextView title = (TextView)cardView.findViewById(R.id.title);
        TextView content = (TextView)cardView.findViewById(R.id.content);
        TextView username = (TextView)cardView.findViewById(R.id.login);

        title.setText(cards.get(position).getTitle());
        content.setText(cards.get(position).getContent());
        username.setText(cards.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
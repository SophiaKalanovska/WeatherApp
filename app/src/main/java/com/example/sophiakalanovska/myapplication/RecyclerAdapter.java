package com.example.sophiakalanovska.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sophiakalanovska.myapplication.data.Icon;
import com.example.sophiakalanovska.myapplication.data.Day;

import java.util.List;


/**
 * Created by sophiakalanovska on 27/06/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public interface DayClickListener {
        void onDayClicked(Day day);
    }


    private List<Day> days;
    private Context context;
    private DayClickListener dayClickListener;

    public Context getContext() {
        return context;
    }

    public RecyclerAdapter(List<Day> days, Context context, DayClickListener listener) {
        this.context = context;
        this.days = days;
        this.dayClickListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator;
        inflator = LayoutInflater.from(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(inflator.inflate(R.layout.row_layout, parent, false));
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Icon icon = days.get(position).getImage();

        holder.title.setText(days.get(position).getTitle());
        holder.title.setCompoundDrawablesWithIntrinsicBounds(Icon.smallIcon(icon), 0, 0, 0);
        holder.description.setText(days.get(position).getDescription());
        holder.maxtemp.setText(context.getString(R.string.maxtemp, days.get(position).getMaxtemp()));
        holder.mintemp.setText(context.getString(R.string.maxtemp, days.get(position).getMintemp()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Day day = days.get(position);
                dayClickListener.onDayClicked(day);
            }
        });


    }

    @Override
    public int getItemCount() {
        return days.size();
    }


    /**
     * Created by sophiakalanovska on 27/06/2017.
     */

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView title;
        final TextView description;
        final TextView maxtemp;
        final TextView mintemp;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textTitle);
            description = (TextView) itemView.findViewById(R.id.textDesc);
            maxtemp = (TextView) itemView.findViewById(R.id.textmaxtemp);
            mintemp = (TextView) itemView.findViewById(R.id.textmintemp);


        }

    }

}

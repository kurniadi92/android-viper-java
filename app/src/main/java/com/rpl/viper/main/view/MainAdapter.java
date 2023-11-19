package com.rpl.viper.main.view;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.rpl.viper.R;
import com.rpl.viper.main.entity.University;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.UniversityViewHolder> {
    private List<University> universityList;
    public final UniversityListener listener;
    public MainAdapter(UniversityListener listener) {
        this.listener = listener;
    }
    public interface UniversityListener {
        void onUniversityClicked(Integer position);
        void onUniversityLongTap(Integer position);
    }

    public class UniversityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private Integer position;
        private final TextView textView;
        public UniversityViewHolder(View view) {
            super(view);
            this.textView = view.findViewById(R.id.name);
        }

        void bind(University university, Integer position) {
            this.position = position;
            this.textView.setText(university.name);
            itemView.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onUniversityClicked(position);
        }

        @Override
        public boolean onLongClick(View view) {
            listener.onUniversityLongTap(position);
            return true;
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<University> list) {
        universityList = list;
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public UniversityViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_university, viewGroup, false);

        return new UniversityViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NotNull UniversityViewHolder viewHolder, final int position) {
        viewHolder.bind(universityList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return universityList.size();
    }
}

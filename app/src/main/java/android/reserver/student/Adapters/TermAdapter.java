package android.reserver.student.Adapters;

//@+id/textView7

import android.content.Context;
import android.content.Intent;
import android.reserver.student.R;
import android.reserver.student.entities.Course;
import android.reserver.student.entities.Term;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    private List<Term> terms = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Term term);
    }

    class TermViewHolder extends RecyclerView.ViewHolder {

        private TextView termIDView;
        private TextView termTitleView;
        private TextView termStartDateView;
        private TextView termEndDateView;


        private TermViewHolder(@NonNull View itemView) {
            super(itemView);

            termTitleView = itemView.findViewById(R.id.termTitle);
            termStartDateView = itemView.findViewById(R.id.termStartDate);
            termEndDateView = itemView.findViewById(R.id.termEndDate);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(terms.get(position));
                }
            });

            /*
            public void onClick(View view) {
                int position = getAdapterPosition();
                final Term current=mTerms.get(position)
             */
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // public Term(int term_id, String term_title, String term_start, String term_end)

    @NonNull
    @Override
    public TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermViewHolder holder, int position) {
        Term currentTerm = terms.get(position);
        holder.termTitleView.setText(currentTerm.getTerm_title());
        holder.termStartDateView.setText(currentTerm.getTerm_start());
        holder.termEndDateView.setText(currentTerm.getTerm_end());
    }


    public void setTerms(List<Term> terms) {
        this.terms = terms;
        notifyDataSetChanged();
    }

    public Term getTermAt(int position) {
        return terms.get(position);
    }

    @Override
    public int getItemCount() {
        if(terms!=null) {
            return terms.size();
        }
        else return 0;
    }

}

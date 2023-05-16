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


        private TermViewHolder(View itemView) {
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
        }
    }

    // public Term(int term_id, String term_title, String term_start, String term_end)
    private List<Term> mTerms;
    private final Context context;
    private final LayoutInflater mInflater;

    public TermAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if (mTerms != null) {
            Term currentTerm = mTerms.get(position);
            holder.termTitleView.setText(currentTerm.getTerm_title());
            holder.termStartDateView.setText(currentTerm.getTerm_start());
            holder.termEndDateView.setText(currentTerm.getTerm_end());
        } else {
            holder.termTitleView.setText("No term title");
        }
    }

    public void setTerms(List<Term> terms) {
        mTerms = terms;
        notifyDataSetChanged();
    }

    public Term getTermAt(int position) {
        return terms.get(position);
    }

    @Override
    public int getItemCount() {
        if (mTerms != null) {
            return mTerms.size();
        } else return 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}

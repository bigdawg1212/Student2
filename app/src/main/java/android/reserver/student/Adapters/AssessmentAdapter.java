package android.reserver.student.Adapters;

import android.reserver.student.R;
import android.reserver.student.entities.Assessment;
import android.reserver.student.entities.Course;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder> {

    private List<Assessment> assessments = new ArrayList<>();
    public interface OnItemClickListener {
        void onItemClick(Assessment assessment);
    }
    private OnItemClickListener listener;

    class AssessmentViewHolder extends RecyclerView.ViewHolder {
        private TextView assessmentTitleView;
        private TextView assessmentDateView;

        public AssessmentViewHolder(@NonNull View itemView) {
            super(itemView);
            assessmentTitleView = itemView.findViewById(R.id.assessmentTitle);
            assessmentDateView = itemView.findViewById(R.id.assessmentDate);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(assessments.get(position));
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.assessment_list_item, parent, false);
        return new AssessmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssessmentViewHolder holder, int position) {
        Assessment currentAssessment = assessments.get(position);
        holder.assessmentTitleView.setText(currentAssessment.getAssessment_name());
        holder.assessmentDateView.setText(currentAssessment.getAssessment_date());
    }

    @Override
    public int getItemCount() {
        if (assessments!=null) {
            return assessments.size();
        }
        else return 0;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
        notifyDataSetChanged();
    }

    public Assessment getAssessmentAt(int position) {
        return assessments.get(position);
    }

}

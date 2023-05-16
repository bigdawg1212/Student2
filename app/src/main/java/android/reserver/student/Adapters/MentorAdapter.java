package android.reserver.student.Adapters;

import android.reserver.student.R;
import android.reserver.student.entities.Assessment;
import android.reserver.student.entities.Course;
import android.reserver.student.entities.Mentor;
import android.reserver.student.entities.Term;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MentorAdapter extends RecyclerView.Adapter<MentorAdapter.MentorViewHolder> {
    private List<Mentor> mentors = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Mentor mentor);
    }

    class MentorViewHolder extends RecyclerView.ViewHolder {
        private TextView mentorNameView;
        private TextView mentorEmailView;

        public MentorViewHolder(@NonNull View itemView) {
            super(itemView);
            mentorNameView = itemView.findViewById(R.id.mentorName);
            mentorEmailView = itemView.findViewById(R.id.mentorEmail);

            itemView.setOnClickListener(V -> {
                int position = getAdapterPosition();
                if(listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(mentors.get(position));
                }
            });

        }

    }

    public void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener; }

    @NonNull
    @Override
    public MentorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mentor_list_item, parent, false);
        return new MentorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MentorAdapter.MentorViewHolder holder, int position) {
        Mentor currentMentor = mentors.get(position);
        holder.mentorNameView.setText(currentMentor.getMentor_name());
        holder.mentorEmailView.setText(currentMentor.getMentor_email());
    }

    @Override
    public int getItemCount() {
        return mentors.size();
    }

    public void setMentors(List<Mentor> mentors) {
        this.mentors = mentors;
        notifyDataSetChanged();
    }

    public Mentor getMentorAt(int position) { return mentors.get(position); }


}

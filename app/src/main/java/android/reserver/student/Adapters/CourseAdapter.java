package android.reserver.student.Adapters;

import android.reserver.student.R;
import android.reserver.student.UI.CoursesMain;
import android.reserver.student.entities.Course;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private List<Course> courses = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Course course);
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        private TextView courseTitleView;
        private TextView courseEndDateView;
        private TextView courseStatusView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTitleView = itemView.findViewById(R.id.courseName);
            courseEndDateView = itemView.findViewById(R.id.courseEndDate);
            courseStatusView = itemView.findViewById(R.id.courseStatus);

            itemView.setOnClickListener(V -> {
                int position = getAdapterPosition();
                if(listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(courses.get(position));
                }
            });
        }

    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_list_item, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course currentCourse = courses.get(position);
        holder.courseTitleView.setText(currentCourse.getCourse_title());
        holder.courseEndDateView.setText(currentCourse.getCourse_end());
        holder.courseStatusView.setText(currentCourse.getCourse_status());
    }

    @Override
    public int getItemCount() {
        if(courses!=null) {
            return courses.size();
        }
        else return 0;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }

    public Course getCourseAt(int position) {
        return courses.get(position);
    }
}

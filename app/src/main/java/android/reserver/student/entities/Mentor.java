package android.reserver.student.entities;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "mentors",
        foreignKeys = @ForeignKey(entity = Course.class,
                parentColumns = "course_id",
                childColumns = "course_id", onDelete = ForeignKey.CASCADE))

public class Mentor {
    @PrimaryKey(autoGenerate = true)
    private int mentor_id;

    private String mentor_name;

    private String mentor_phone;

    private String mentor_email;

    private int course_id;

    //Constructor
    public Mentor(int mentor_id, String mentor_name, String mentor_phone, String mentor_email, int course_id) {
        this.mentor_id = mentor_id;
        this.mentor_name = mentor_name;
        this.mentor_phone = mentor_phone;
        this.mentor_email = mentor_email;
        this.course_id = course_id;
    }

    // Blank Constructor
    public Mentor() {
    }

    // Setters and Getters
    public int getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(int mentor_id) {
        this.mentor_id = mentor_id;
    }

    public String getMentor_name() {
        return mentor_name;
    }

    public void setMentor_name(String mentor_name) {
        this.mentor_name = mentor_name;
    }

    public String getMentor_phone() {
        return mentor_phone;
    }

    public void setMentor_phone(String mentor_phone) {
        this.mentor_phone = mentor_phone;
    }

    public String getMentor_email() {
        return mentor_email;
    }

    public void setMentor_email(String mentor_email) {
        this.mentor_email = mentor_email;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }


}

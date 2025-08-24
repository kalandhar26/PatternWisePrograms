package altimetrik;

public class Subject {

    private int id;
    private int marks;

    public Subject(int marks, int id) {
        this.marks = marks;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", marks=" + marks +
                '}';
    }
}

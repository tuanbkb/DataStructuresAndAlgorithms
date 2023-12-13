import java.util.Comparator;
import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCgpa() {
        return cgpa;
    }
    
    @Override
    public int compareTo(Student b) {
        if (this.getId() != b.getId()) return Integer.compare(this.getId(), b.getId());
        if (!this.getName().equals(b.getName())) return this.getName().compareTo(b.getName());
        return Double.compare(this.getCgpa(), b.getCgpa());
    }
}

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        Student a = new Student(1, "Tuan", 7);
        Student b = new Student(2, "Phu", 10);
        System.out.println(a.compareTo(b));
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(a);
        pq.add(b);
        System.out.println(pq.poll().getName());
    }
}
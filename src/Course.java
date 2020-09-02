public class Course {
    private String name;
    private int cost;

    public Course(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void printCourse() {
        System.out.println("\t\t\t" + name + "\t\tCost $" + cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

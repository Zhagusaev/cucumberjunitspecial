package Pojo;

public class Reques {

    String name;

    String job;

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public Reques(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "This is the name of object " + this.name + " This is the job  of the object " + this.job;
    }
}

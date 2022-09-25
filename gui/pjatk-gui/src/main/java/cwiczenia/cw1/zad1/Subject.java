package cwiczenia.cw1.zad1;

public class Subject {
    private String name;
    private Person[] personCollection = new Person[15];
    private Person teacher;
    private int counter;

    public Subject(String name) {
        this.name = name;
        this.counter = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person[] getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Person[] personCollection) {
        this.personCollection = personCollection;
    }

    public Person getTeacher() {
        return teacher;
    }

    public int getCounter() {
        return counter;
    }

    public void setTeacher(Person person) {
        this.teacher = person;
    }

    public void addStudent(Student student) throws TooManyStudentsException {
        if (counter > personCollection.length){
            throw new TooManyStudentsException("Za duża liczba studentów");
        }
        personCollection[counter++] = student;
    }
}

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Human{
    private String name;
    private String surname;
    private int year;                   //date of birth
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    static {
        System.out.println("A new human is being loaded");
    }

    {
        System.out.println("A new human object is created");
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, Map<String, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String getSchedule() {
        StringBuilder sb = new StringBuilder("[");
        if(schedule == null) return "There's no schedule";
        else {
            schedule.forEach((key, value) -> sb.append(String.format("[%s, %s], ", key, value)));

            sb.append("]");
            sb.deleteCharAt(sb.length() - 3);
            sb.deleteCharAt(sb.length() - 2);

            return sb.toString();
        }
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + this.getSchedule() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && name.equals(human.name) && surname.equals(human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family);
    }

    @Override
    protected void finalize() {
        System.out.println("Human object is destroyed");
    }

    public void greetPets(){
        Iterator<Pet> iterator = family.getPets().iterator();
        while(iterator.hasNext()) {
            Pet element = iterator.next();
            System.out.printf("Hello, %s! I'm your owner.\n", element.getNickname());
        }
    }
    public void describePets(){
        Iterator<Pet> iterator = family.getPets().iterator();
        while (iterator.hasNext()) {
            String message;
            Pet element = iterator.next();
            if (element.getTrickLevel() > 50) message = "very sly";
            else message = "almost not sly";
            System.out.printf("I have a %s, he is %d years old, he is %s.\n", element.getSpecies().toString().toLowerCase(), element.getAge(), message);
        }
    }
    public boolean feedPets(boolean isItTimeForFeeding){
        Iterator<Pet> iterator = family.getPets().iterator();
        boolean result = true;
        while(iterator.hasNext()) {
            Random random = new Random();
            Pet element = iterator.next();
            int randomNumber = random.nextInt(1, 101);
            if (isItTimeForFeeding) {
                System.out.printf("Hm... I will feed %s's %s.%n", this.name, element.getSpecies().toString().toLowerCase());
            } else {
                if (element.getTrickLevel() > randomNumber) {
                    System.out.printf("Hm... I will feed %s's %s.%n", this.name, element.getSpecies().toString().toLowerCase());
                } else {
                    System.out.printf("I think %s's %s is not hungry.%n", this.name, element.getSpecies().toString().toLowerCase());
                    result = false;
                }
            }
        }
        return result;
    }
}

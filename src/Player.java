public class Player {
    private String first_name;
    private String surname;
    private String team;
    private String position;
    private String country;
    private int age;
    private int id;

    public Player(String first_name ,String surname , String team , String position , String country , int age , int id){
        this.setFirst_name(first_name);
        this.setSurname(surname);
        this.setTeam(team);
        this.setPosition(position);
        this.setCountry(country);
        this.setAge(age);
        this.setId(id);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

import java.time.LocalDate;

public class Client {

    private String name;
    private String lastNames;
    private String address;
    private String city;
    private LocalDate birthDate ;


    public String fullName(){
        return name + " " + lastNames;
    }
    public String fullAddress(){
        return  address;
    }

    public Client (String name,String lastNames ,String address,String city ,String birthDate){
        this.name=name;
        this.lastNames=lastNames;
        this.address=address;
        this.city=city;
        this.birthDate = LocalDate.parse(birthDate);
    }

}

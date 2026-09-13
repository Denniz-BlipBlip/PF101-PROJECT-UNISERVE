package Users;

public class Data 
{
  private Data(String name,String location, int phone_number,int password, int id)
  {
    this.name=name;
    this.password=password;
    this.id=id;
    this.phone_number=phone_number;
    this.location=location;
  }

  private String name,location;
  private int password,id,phone_number;
}

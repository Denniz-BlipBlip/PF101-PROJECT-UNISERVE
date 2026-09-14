package Users;

public class Data 
{
  public int get_phone_number(){return this.phone_number;}
  public int get_password(){return this.password;}
  public int get_id(){return this.id;}
  public String get_user_name(){return this.name;}
  public String get_location(){return this.location;}

  public static class Inserter
  {
    public Data insert()
    {
      return new Data(this);
    }

    public Inserter insert_phone_number(int phone_number)
    {
      this.phone_number=phone_number;
      return this;
    }

    public Inserter insert_password(int pass)
    {
      this.password=pass;
      return this;
    }

    public Inserter insert_id(int id)
    {
      this.id=id;
      return this;
    }

    public Inserter insert_location(String loc)
    {
      this.location=loc;
      return this;
    }

    public Inserter insert_name(String name)
    {
      this.name=name;
      return this;
    }

    private String name,location;
    private int password,id,phone_number;
  }

  private Data(Inserter insert)
  {
    this.name=insert.name;
    this.password=insert.password;
    this.id=insert.id;
    this.phone_number=insert.phone_number;
    this.location=insert.location;
  }

  private String name,location;
  private int password,id,phone_number;
}

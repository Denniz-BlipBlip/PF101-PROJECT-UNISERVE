package Data.Users;

public class UserData
{
  public void setUserMobileNumber(int UserMobileNumber){this.userMobileNumber=userMobileNumber;}
  public void setUserId(int userId){this.userId=userId;}
  public void setUserPassword(String userPassword){this.userPassword=userPassword;}
  public void setUserLoction(String userLocation){this.userLocation=userLocation;}
  public void setUserName(String userName){this.userName=userName;}

  public int getUserMobileNumber(){return this.userMobileNumber;}
  public int getUserId(){return this.userId;}
  public String getUserPassword(){return this.userPassword;}
  public String getUserLocation(){return this.userLocation;}
  public String getUserName(){return this.userName;}

  public UserData(String userName,String userLocation,String userPassword,int userId,int userMobileNumber)
  {
    this.userId=userId;
    this.userPassword=userPassword;
    this.userName=userName;
    this.userLocation=userLocation;
    this.userMobileNumber=userMobileNumber;
  }
  
  private int userId,userMobileNumber;
  private String userName,userLocation,userPassword;
}

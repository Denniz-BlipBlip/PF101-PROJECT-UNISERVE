package Data.Users;

public class UserData
{
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

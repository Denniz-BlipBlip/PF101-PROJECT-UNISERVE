package Backend.DataManager;

import java.util.Random;

import Backend.DataHandling.AVL;
import Backend.FileHandler.FileHandler;

public class DataManager implements FileHandler
{
  private void registerUser(String userName,String userLocation,String userPassword,String userEmail,int userMobileNumber)
  {
    this.userData.insert(userName, userPassword, userLocation, userEmail, this.idGenerator(), userMobileNumber);
  }

  private int idGenerator()
  {
    int userId;
    do 
    {
      userId=this.randomizer.nextInt(900000)+100000;
    }while(userData.validUserId(userId));
    return userId;
  }

  private DataManager()
  {
    this.randomizer=new Random();
    this.userData=new AVL();
  }
  
  private Random randomizer;
  private AVL userData;
}

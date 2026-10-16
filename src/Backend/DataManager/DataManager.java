package Backend.DataManager;
import java.awt.List;
import java.util.Random;
import Backend.DataHandling.AVL;
import Backend.FileHandler.FileHandler;

public class DataManager implements FileHandler
{
  @Override 
  public void saveOrderData(List<String>order)
  {

  }

  @Override
  public void loadData()
  {

  }

  @Override 
  public void saveData()
  {

  }

  private boolean validateLogin(String userEmail,String userPassword)
  {
    return this.userData.search(userEmail, userPassword);
  }

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

  public static synchronized DataManager getInstance()
  {
    if(manager==null)manager=new DataManager();
    return manager;
  }

  private DataManager()
  {
    this.randomizer=new Random();
    this.userData=new AVL();
  }
  
  private static DataManager manager;
  private Random randomizer;
  private AVL userData;
}

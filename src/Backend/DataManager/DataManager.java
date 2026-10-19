package Backend.DataManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import Backend.DataHandling.AVL;
import Backend.FileHandler.FileHandler;
import Helper.FilePathHelper;

public class DataManager implements FileHandler
{
  @Override 
  public void saveOrderData(List<String>order)
  {
    File file=new File(FilePathHelper.ordersFilePath);
    try 
    {
      BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
      for(String orderLog:order)writer.write(orderLog);
      writer.close();
    }
    catch(IOException e){System.out.println(e);return;}
  }

  @Override
  public void loadData()
  {
    File file=new File(FilePathHelper.accFilePath);
    try 
    {
      BufferedReader reader=new BufferedReader(new FileReader(file));
      String line;
      while((line=reader.readLine())!=null)
      {
        String[] parts=line.split(",");
        int userId=Integer.parseInt(parts[0]);
        String userName=parts[1],userEmail=parts[2],userLocation=parts[3],userPassword=parts[4];
        int userMobileNumber=Integer.parseInt(parts[5]);
        userData.insert(userName, userPassword, userLocation, userEmail, userId, userMobileNumber);
      }
      reader.close();
    }
    catch(IOException e){System.out.println(e);return;}
  }

  @Override 
  public void saveData()
  {
    File file=new File(FilePathHelper.accFilePath);
    try 
    {
      BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
      userData.saveUserData(writer);
      writer.close();
    }
    catch(IOException e){System.out.println(e);return;}
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

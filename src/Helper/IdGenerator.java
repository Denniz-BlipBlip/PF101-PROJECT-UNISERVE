package Helper;
import java.util.Random;
import Backend.DataHandling.AVL;

public class IdGenerator
{
  
  public static int idGenerator()
  {
    int userId=0;
    do 
    {
      userId=randomizer.nextInt(900000)+100000;
    }
    while(userData.validUserId(userId));
  }

  private static AVL userData=new AVL(); 
  private static Random randomizer=new Random();
}

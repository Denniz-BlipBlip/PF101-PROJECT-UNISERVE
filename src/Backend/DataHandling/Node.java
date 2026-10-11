package Backend.DataHandling;
import Data.Users.UserData;

public class Node
{
  public void setHeight(int height){this.height=height;}
  public void setUserData(UserData data){this.userData=data;}
  public void setLeftNode(Node node){this.left=node;}
  public void setRightNode(Node node){this.right=node;}

  public UserData getUserData(){return this.userData;}
  public int getHeight(){return this.height;}
  public Node getLeftNode(){return this.left;}
  public Node getRightNode(){return this.right;}

  public Node(UserData userData)
  {
    this.userData=userData;
    this.right=null;
    this.left=null;
    this.height=0;
  }

  private int height;
  private Node right,left;
  private UserData userData;
}

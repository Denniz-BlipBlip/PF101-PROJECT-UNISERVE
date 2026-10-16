package Backend.DataHandling;
import Data.Users.UserData;

public class AVL
{
  public boolean validateUserId(int userId)
  {
    return this.userIdChecker(this.root, userId);
  }

  public boolean search(String userEmail,String userPassword)
  {
    return this.search(this.root, userEmail, userPassword);
  }

  public void insert(String userName,String userPassword,String userLocation,String userEmail,int userId,int userMobileNumber)
  {
    this.root=this.insert(this.root, userName, userPassword, userLocation, userEmail, userId, userMobileNumber);
  }

  private boolean search(Node node,String userEmail,String userPassword)
  {
    if(this.isEmpty(node))return false;
    if(node.getUserData().getUserEmail().equals(userEmail)&&node.getUserData().getUserPassword().equals(userPassword))return true;
    return this.search(node.getRightNode(), userEmail, userPassword)||this.search(node.getLeftNode(), userEmail, userPassword);
  }

  private Node insert(Node node,String userName,String userPassword,String userLocation,String  userEmail,int userId,int userMobileNumber)
  {
    if(this.isEmpty(node))return new Node(new UserData(userName, userLocation, userPassword,  userEmail, userId, userMobileNumber));
    if(userId>node.getUserData().getUserId()){node.setRightNode(this.insert(node.getRightNode(), userName, userPassword, userLocation, userEmail, userId, userMobileNumber));}
    if(userId<node.getUserData().getUserId()){node.setLeftNode(this.insert(node.getLeftNode(), userName, userPassword, userLocation, userEmail, userId, userMobileNumber));}
    return this.rebase(node);
  }

  private Node findMin(Node node)
  {
    while(!this.isEmpty(node)&&!this.isEmpty(node.getLeftNode()))node=node.getLeftNode();
    return node;
  }

  private Node rebase(Node node)
  {
    this.updateHeight(node);
    int balance=this.balanceFactor(node);
    if(balance>1)
    {
      if(this.balanceFactor(node.getLeftNode())<0)
      {
        node.setLeftNode(this.rotateLeft(node.getLeftNode()));
      }
      return this.rotateRight(node);
    }

    if(balance<-1)
    {
      if(this.balanceFactor(node.getRightNode())>0)
      {
        node.setRightNode(this.rotateRight(node.getRightNode()));
      }
      return this.rotateLeft(node);
    }
    return node;
  }

  private Node rotateLeft(Node x)
  {
    Node y=x.getRightNode(),t2=y.getLeftNode();
    y.setLeftNode(x);
    x.setRightNode(t2);
    this.updateHeight(x);
    this.updateHeight(y);
    return y;
  }

  private Node rotateRight(Node y)
  {
    Node x=y.getLeftNode(),t2=x.getRightNode();
    x.setRightNode(y);
    y.setLeftNode(t2);
    this.updateHeight(y);
    this.updateHeight(x);
    return x;
  }

  private void updateHeight(Node node){node.setHeight(1+Math.max(this.height(node.getLeftNode()), this.height(node.getRightNode())));}

  private int balanceFactor(Node node)
  {
    return !this.isEmpty(node)?(this.height(node.getLeftNode())-this.height(node.getRightNode())):0;
  }

  private boolean userIdChecker(Node node,int userId)
  {
    if(this.isEmpty(node))return false;
    if(userId>node.getUserData().getUserId())return this.userIdChecker(node.getRightNode(), userId);
    else if(userId<node.getUserData().getUserId())return this.userIdChecker(node.getLeftNode(), userId);
    else return true;
  }

  private int height(Node node){return !this.isEmpty(node)?node.getHeight():0;}
  private boolean isEmpty(Node node){return node==null;}
  private Node root;
}

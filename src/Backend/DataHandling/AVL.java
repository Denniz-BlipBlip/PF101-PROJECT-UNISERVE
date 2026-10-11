package Backend.DataHandling;
import Data.Users.UserData;

public class AVL
{
  private Node delete(Node node,String userName,String userPassword)
  {

  }

  private Node insert(Node node,String userName,String userPassword,String userLocation,int userId,int userMobileNumber)
  {
    if(this.isEmpty(node))return new Node(new UserData(userName, userLocation, userPassword, userId, userMobileNumber));
    if(userId>node.getUserData().getUserId()){node.setRightNode(this.insert(node.getRightNode(), userName, userPassword, userLocation, userId, userMobileNumber));}
    if(userId<node.getUserData().getUserId()){node.setLeftNode(this.insert(node.getLeftNode(), userName, userPassword, userLocation, userId, userMobileNumber));}
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

  private int height(Node node){return !this.isEmpty(node)?node.getHeight():0;}
  private boolean isEmpty(Node node){return node==null;}
  private Node root;
}

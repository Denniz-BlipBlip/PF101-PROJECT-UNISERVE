package Data_Handling;
import Users.Data;

public class Tree 
{
  private int balance_factor(Node node){return !this.is_empty(node)?node.get_height():0;}
  private int height(Node node){return !this.is_empty(node)?node.get_height():0;}
  public Tree(){this.root=null;}
  
  private boolean is_empty(Node node){return node==null;}
  private Node root;
}

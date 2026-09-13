package Data_Handling;
import Users.Data;

public class Tree 
{

  private void uodate_height(Node node)
  {
    node.set_height(1+this.get_max_node(node));
  }

  private int get_max_node(Node node)
  {
    return Math.max(this.height(node.get_left()),this.height(node.get_right()));
  }

  private int balance_factor(Node node)
  {
    return !this.is_empty(node)?this.get_difference(node):0;
  }

  private int get_difference(Node node)
  {
    return this.height(node.get_left())-this.height(node.get_right());
  }

  private int height(Node node)
  {
    return !this.is_empty(node)?node.get_height():0;
  }

  private boolean is_empty(Node node){return node==null;}
  public Tree(){this.root=null;}
  private Node root;
}

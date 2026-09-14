package Data_Handling;
import Users.Data;

public class Tree 
{

  private Node re_balance(Node node)
  {
    this.update_height(node);
    int balance=this.balance_factor(node);

    if(balance>0)
    {
      if(this.balance_factor(node.get_left())<0)
      {
        node.set_left(this.rotate_left(node.get_left()));
      }
      return rotate_right(node);
    }

    if(balance<-1)
    {
      if(this.balance_factor(node.get_right())>0)
      {

      }
    }

    return node;
  }

  private Node rotate_left(Node x)
  {
    Node y=x.get_right(),t2=y.get_left();
    y.set_left(x);
    x.set_right(t2);
    this.update_height(x);
    this.update_height(y);
    return y;
  }

  private Node rotate_right(Node y)
  {
    Node x=y.get_left(),t2=x.get_right();
    x.set_right(y);
    y.set_left(t2);
    this.update_height(y);
    this.update_height(x);
    return x;
  }

  private void update_height(Node node)
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

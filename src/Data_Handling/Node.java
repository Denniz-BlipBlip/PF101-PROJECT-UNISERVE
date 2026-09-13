package Data_Handling;
import Users.Data;

public class Node 
{
  public int get_height(){return this.height;}
  public Node get_left(){return this.left;}
  public Node get_right(){return this.right;}
  public Data get_data(){return this.data;}
  public void set_height(int height){this.height=height;}
  public void set_data(Data data){this.data=data;}
  public void set_left(Node node){this.left=node;}
  public void set_right(Node node){this.right=node;}

  public Node(Data data)
  {
    this.data=data;
    this.right=null;
    this.left=null;
    this.height=0;
  }

  private Data data;
  private Node right,left;
  private int  height;
}

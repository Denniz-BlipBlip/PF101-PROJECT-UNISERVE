package Backend.FileHandler;
import java.util.List;

public interface FileHandler
{
  void saveData();
  void loadData();
  void saveOrderData(List<String>order);
}

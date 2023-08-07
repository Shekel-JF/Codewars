import java.util.*;
public class PaginationHelper<I>
{
    private List<I> collection = new ArrayList<>();
    private int items;

    public PaginationHelper(List<I> collection, int itemsPerPage)
    {
        this.collection = collection;
        this.items = itemsPerPage;
    }
  
    public int itemCount()
    {
        return this.collection.size();
    }
  
    public int pageCount()
    {
        int result = itemCount()/this.items;
        if(this.collection.size() % this.items != 0)
        {
            return result + 1;
        }
        else
        {
            return result;
        }
    }
  
    public int pageItemCount(int pageIndex)
    {
        if(pageIndex >= pageCount() || pageIndex < 0)
        {
            return -1;
        }
        else if(pageIndex == pageCount() - 1 && itemCount() % this.items !=0)
        {
            return itemCount() % this.items;
        }
        return this.items;
    }
  
    public int pageIndex(int itemIndex)
    {
        if(itemIndex < 0 || itemIndex >= itemCount())
        {
            return -1;
        }
        return (itemIndex)/this.items;
    }
}
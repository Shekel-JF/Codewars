// TODO: create the User class/object
// it must support rank, progress, and the incProgress(int rank) method
public class User
{
    private int[] ranks = new int[]{-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8};  
    int rank;
    int progress;
  
    public User()
    {
        this.rank = -8;
        this.progress = 0;
    }
  
    public int rankIndex()
    {
        for(int i = 0; i < 16; i++)
        {
            if(this.rank == ranks[i])
            {
                return i;
            }
        }
        return -1;
    }
  
    public int progress()
    {
        return this.progress;
    }
  
    public void incProgress(int value) throws IllegalArgumentException
    {
        int weight = 0;
        for(int i = 0; i < 16; i++)
        {
            if(ranks[i] == value)
            {
                weight = i - rankIndex();
                if(weight == -1)
                {
                    this.progress++;
                }
                else if(weight == 0)
                {
                    this.progress += 3;
                }
                else if(weight > 0)
                {
                    this.progress = this.progress + weight * weight * 10;
                }
                
                while(this.progress >= 100)
                {
                    this.progress-=100;
                    if(this.rank == -1)
                    {
                        this.rank += 2;
                    }
                    else if(this.rank != 8)
                    {
                        this.rank++;
                    }                   
                }
              
                if(this.rank == 8)
                {
                    this.progress = 0;
                }   
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
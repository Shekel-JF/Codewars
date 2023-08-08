public class Car
{
    public Body body;
    public Chassis chassis;
    
    public Car(int length, int doors) throws Exception
    {
        if(length < 7 || doors < 1 || doors > length / 2 - 2)
        {
            throw new Exception();
        }
        this.body = new Body(length, doors);
        this.chassis = new Chassis(length);
    }
}


class Body
{
    public String component;
  
    public Body(int length, int doors)
    {   
        component = " ";
        for(int i = 0; i < length - 3; i++)
        {
            component+="_";
        }
        component+="\n|";
        
        int backDoor = doors/2;
        int frontDoor = doors - backDoor;
        int mid = length - 3 - doors * 2;
      
        for(int a = 0; a < backDoor; a++)
        {
            component+= "[]";
        }
        for(int b = 0; b < mid; b++)
        {
            component+= " ";
        }
        for(int c = 0; c < frontDoor; c++)
        {
            component+= "[]";
        }
        component += "\\\n";      
    }
}

class Chassis
{
    public String component;
  
    public Chassis(int length)
    {
        int wheels = 2;
        int tmp = length;
        while(tmp >= 12)
        {
            wheels++;
            tmp-=2;
        }     
        int frontWheels = wheels / 2;
        int backWheels = wheels - frontWheels;
        int mid = length - wheels * 2 - 2;
      
        component = "";
        for(int a = 0; a < backWheels; a++)
        {
            component+= "-o";
        }
        for(int b = 0; b < mid; b++)
        {
            component+= "-";
        }
        for(int c = 0; c < frontWheels; c++)
        {
            component+= "-o";
        }
        component += "-'";
    }
}
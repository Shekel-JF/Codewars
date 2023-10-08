package codewars;
public final class PeanoNumbers
{
	  interface Peano
    {
		    final class Zero implements Peano
        {
			      static Zero INSTANCE = new Zero();
			      private Zero() {}
		    }

		    final class Succ implements Peano
        {
			      final Peano peano;
			      Succ(Peano peano)
            {
				        this.peano = peano;
			      }
		    }
	  }

	  enum Ordering {GT, LT, EQ}

	  static Peano add(Peano a, Peano b)
    {
        if(a instanceof Peano.Zero)
        {
            return b;
        }
        return add(((Peano.Succ) a).peano, new Peano.Succ(b));
	  }

	  static Peano sub(Peano a, Peano b)
    {
        if(b instanceof Peano.Zero)
        {
            return a;
        }
        else if(a instanceof Peano.Zero)
        {
            throw new ArithmeticException("negative number");
        }
        return sub(((Peano.Succ) a).peano, ((Peano.Succ) b).peano);
    }
  
    static Peano mul(Peano a, Peano b)
    {
        if(a instanceof Peano.Zero || b instanceof Peano.Zero)
        {
            return new Peano.Zero();
        }
    
        Peano.Succ bSucc = (Peano.Succ) b;
        return add(a, mul(a, bSucc.peano));
    }
  
    static Peano div(Peano a, Peano b)
    {
        if(b instanceof Peano.Zero)
        {
            throw new ArithmeticException("divide by 0");
        }
        Peano result = new Peano.Zero();
         
        while(true)
        {
            try
            {
                a = sub(a, b);
                result = new Peano.Succ(result);
            }
            catch(ArithmeticException e)
            {
                break;
            }
        } 
        return result;
    }
  
    static boolean even(Peano peano)
    {
        while(peano instanceof Peano.Succ)
        {
            peano = ((Peano.Succ) peano).peano;
            if(peano instanceof Peano.Zero)
            {
                return false;
            }
            peano = ((Peano.Succ) peano).peano;
            if(peano instanceof Peano.Zero)
            {
                return true;
            }
        }
        return true;
    }
  
    static boolean odd(Peano peano)
    {
        while(peano instanceof Peano.Succ)
        {
            peano = ((Peano.Succ) peano).peano;
            if(peano instanceof Peano.Zero)
            {
                return true;
            }
            peano = ((Peano.Succ) peano).peano;
            if(peano instanceof Peano.Zero)
            {
                return false;
            }
        }
        return false;
    }
  
    static Ordering compare(Peano a, Peano b)
    {
        try
        {
            Peano res = sub(a, b);
            if(res instanceof Peano.Zero)
            {
                return Ordering.EQ;
            }
            else if(res instanceof Peano.Succ)
            {
                return Ordering.GT;
            }
        }
        catch(ArithmeticException e)
        {}      
        return Ordering.LT;
    }
}

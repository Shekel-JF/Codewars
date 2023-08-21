import java.util.*;
import java.time.LocalDate;

public class Inspector
{   
    private LocalDate today = LocalDate.parse("1982-11-23");
    private Map<String, String> detainInfo;
    private Map<String, String> denyInfo;
    private Map<String, HashSet<String>> vaccines = new HashMap<>();
  
    private boolean IDcard;
    private boolean passport;
    private boolean access_permit;
    private boolean work_pass;
    private String wanted;
    private String[] foreigners = new String[]{"Antegria", "Impor", "Kolechia", "Obristan", "Republia", "United Federation"};   
    Set<String> Allow = new HashSet<>(); 
  
    public Inspector()
    {
        detainInfo = new HashMap<>();
        detainInfo.put("ID#", "Detainment: ID number mismatch.");
        detainInfo.put("NATION", "Detainment: nationality mismatch.");
        detainInfo.put("NAME", "Detainment: name mismatch.");
        Allow.add("Arstotzka");
      
        for (String country : foreigners)
        {
            vaccines.put(country, new HashSet<>());
        }
        vaccines.put("Arstotzka", new HashSet<>());
    }
    
    public void receiveBulletin(String bulletin)
    {   
        //this.today = this.today.plusDays(1);
        String[] rules = bulletin.split("\n");
        for(String s : rules)
        {
            if(s.contains("Entrants require passport"))
            {
                this.passport = true;
            }
            else if(s.contains("Foreigners require access permit"))
            {
                this.access_permit = true;
            }
            else if(s.contains("Citizens of Arstotzka require ID card"))
            {
                this.IDcard = true;
            }
            else if(s.contains("Workers require work pass"))
            {
                this.work_pass = true;
            }
            else if(s.contains("Allow"))
            {
                s = s.replace("Allow citizens of ", "");
                String[] nations = s.split(", ");
                for(String n : nations)
                {
                    this.Allow.add(n);
                }
            }
            else if(s.contains("Deny"))
            {
                s = s.replace("Deny citizens of ", "");
                String[] nations = s.split(", ");
                for(String n : nations)
                {
                    this.Allow.remove(n);
                }
            }
            else if(s.contains("Wanted"))
            {
                s = s.replace("Wanted by the State: ", "");
                String[] name = s.split(" ");
                this.wanted = name[1] + ", " + name[0];
            }
            else if(s.contains("vaccination"))
            {
                s = s.replace(" vaccination", "");
                if(s.contains("Entrants require"))
                {
                    s = s.replace("Entrants require ", "");
                    for(String f : this.foreigners)
                    {
                        this.vaccines.get(f).add(s);
                    }
                    this.vaccines.get("Arstotzka").add(s);
                }
                else if(s.contains("Foreigners require"))
                {
                    s = s.replace("Foreigners require ", "");
                    for(String f : this.foreigners)
                    {
                        this.vaccines.get(f).add(s);
                    }
                }
                else if(s.contains("Entrants no longer"))
                {
                    s = s.replace("Entrants no longer require ", "");
                    for(String f : this.foreigners)
                    {
                        this.vaccines.get(f).remove(s);
                    }
                    this.vaccines.get("Arstotzka").remove(s);
                }
                else if(s.contains("Foreigners no longer"))
                {
                      s = s.replace("Foreigners no longer require ", "");
                      for(String f : this.foreigners)
                      {
                          this.vaccines.get(f).remove(s);
                      }
                }
                else if(s.contains("Citizens of "))
                {
                    s = s.replace("Citizens of ", "");
                    if(s.contains("no longer"))
                    {
                        s = s.replace("no longer require ", "");
                        String[] nations = s.split(", ");
                        String[] last = nations[nations.length - 1].split(" ", 2);
                        nations[nations.length - 1] = last[0];
                        for(String n : nations)
                        {
                            this.vaccines.get(n).remove(last[1]);
                        }
                    }
                    else
                    {
                        s = s.replace("require ", "");
                        String[] nations = s.split(", ");
                        String[] last = nations[nations.length - 1].split(" ", 2);
                        nations[nations.length - 1] = last[0];
                        for(String n : nations)
                        {
                            this.vaccines.get(n).add(last[1]);
                        }
                    }
                } 
            } 
        }
    }

    public String inspect(Map<String, String> person)
    {
        Map<String, String> dates = new HashMap<>();
        Map<String, HashSet<String>> data = new HashMap<>();
        for (Map.Entry<String, String> entry : person.entrySet())
        {
            String[] information = entry.getValue().split("\n");
            for (int s = 0; s < information.length; s++)
            {
                String[] pair = information[s].split(": ");
                if (!data.containsKey(pair[0]))
                {
                    data.put(pair[0], new HashSet<>());
                }
              
                if(information[s].contains("NAME") && information[s].contains(wanted))
                {
                    return "Detainment: Entrant is a wanted criminal.";     
                }
                else if(information[s].contains("EXP"))
                {   
                    dates.put(entry.getKey(), pair[1]);
                    continue;
                }
                else if(information[s].contains("ACCESS") || information[s].contains("VACCINES"))
                {
                    String[] values = pair[1].split(", ");
                    if(values.length > 0)
                    {
                        for(String a : values)
                        {
                            data.get(pair[0]).add(a);      
                        }
                    }
                    continue;
                }               
                data.get(pair[0]).add(pair[1]);          
            }
        }
              
        for(Map.Entry<String, HashSet<String>> entry1 : data.entrySet())
        {
            if(entry1.getValue().size() > 1 && !entry1.getKey().equals("EXP") && !entry1.getKey().equals("ACCESS") && !entry1.getKey().equals("VACCINES"))
            {
                return detainInfo.get(entry1.getKey().toString());
            }
        }
        
        Map<String, Boolean> expired = new HashMap<>();
        for(Map.Entry<String, String> time : dates.entrySet())
        {
            String[] date = time.getValue().split("\\.");
            if(this.today.getYear() > Integer.parseInt(date[0]))
            {
                expired.put(time.getKey(), true);
            }
            else if(this.today.getYear() == Integer.parseInt(date[0]))
            {
                if(this.today.getMonthValue() > Integer.parseInt(date[1]))
                {
                    expired.put(time.getKey(), true);
                }
                else if(this.today.getMonthValue() == Integer.parseInt(date[1]))
                {
                    if(this.today.getDayOfMonth() > Integer.parseInt(date[2]))
                    {
                        expired.put(time.getKey(), true);
                    }
                }
            }
        }
              
        if(data.containsKey("NATION") && data.get("NATION").contains("Arstotzka") && this.vaccines.get("Arstotzka").size() > 0)
        {
            if(!data.containsKey("VACCINES"))
            {
                return "Entry denied: missing required certificate of vaccination.";
            }
            else if(!data.get("VACCINES").containsAll(this.vaccines.get("Arstotzka")))
            {
                return "Entry denied: missing required vaccination.";
            }
        }
           
        if(passport)
        {
            if(!person.containsKey("passport"))
            {
                return "Entry denied: missing required passport.";
            }
            else if(expired.containsKey("passport"))
            {
                return "Entry denied: passport expired.";
            }
            else if(data.get("NATION").contains("Arstotzka"))
            {
                if(IDcard && !person.containsKey("ID_card"))
                {
                    return "Entry denied: missing required ID card.";
                }
                return "Glory to Arstotzka.";
            }       
        }
        
        if(data.containsKey("PURPOSE") && data.get("PURPOSE").contains("WORK"))
        {
            if(dates.containsKey("work_pass"))
            {
                if(expired.containsKey("work_pass"))
                {
                    return "Entry denied: work pass expired.";
                }
            }
            else if(work_pass)
            {
                return "Entry denied: missing required work pass.";
            }
        }
  
        boolean allow = false;
        for(String s : this.Allow)
        {
            if(data.containsKey("NATION") && data.get("NATION").contains(s))
            {
                allow = true;
                break;
            }    
        }
        if(!allow)
        {
            return "Entry denied: citizen of banned nation.";
        }
      
        if(this.access_permit)
        {
            if(person.containsKey("access_permit"))
            {
                if(expired.containsKey("access_permit"))
                {            
                    if(!person.containsKey("grant_of_asylum"))
                    {
                        return "Entry denied: access permit expired."; 
                    }
                    else if(expired.containsKey("grant_of_asylum"))
                    {
                        if(!person.containsKey("work_pass"))
                        {
                            return "Entry denied: grant of asylum expired.";
                        }
                        else if(expired.containsKey("work_pass")&& !data.get("PURPOSE").contains("WORK"))
                        {
                            return "Entry denied: work pass expired.";
                        }
                    }              
                }
            }
            else if(person.containsKey("grant_of_asylum"))
            {
                if(expired.containsKey("grant_of_asylum"))
                {
                    if(!person.containsKey("work_pass"))
                    {
                        return "Entry denied: grant of asylum expired.";
                    }
                    else if(expired.containsKey("work_pass")&& !data.get("PURPOSE").contains("WORK"))
                    {
                        return "Entry denied: work pass expired.";
                    }
                  
                }
            }
            else if(person.containsKey("work_pass")&& !data.get("PURPOSE").contains("WORK"))
            {
                if(expired.containsKey("work_pass"))
                {
                    return "Entry denied: work pass expired.";
                }
            }   
            else if(!person.containsKey("diplomatic_authorization"))
            {
                return "Entry denied: missing required access permit.";
            }
            else if(data.containsKey("ACCESS") && !data.get("ACCESS").contains("Arstotzka"))
            {
                return "Entry denied: invalid diplomatic authorization.";
            }
            else if(expired.containsKey("diplomatic_authorization"))
            {
                return "Entry denied: diplomatic authorization expired.";
            }
        } 
         
        String nat = " ";
        for(String val : data.get("NATION"))
        {
            nat = val;
            break;
        }
       
        if(data.containsKey("NATION") && this.vaccines.get(nat).size() > 0)
        {
            if(!person.containsKey("certificate_of_vaccination"))
            {
                return "Entry denied: missing required certificate of vaccination.";
            }
            else if(!data.get("VACCINES").containsAll(this.vaccines.get(nat)))
            {
                System.out.println(this.vaccines.get(nat));
                System.out.println(data.get("VACCINES"));
                return "Entry denied: missing required vaccination.";
            }
        } 
        return "Cause no trouble.";
    }             
}
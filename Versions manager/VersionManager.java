import java.util.*;

public class VersionManager
{
    private int major = 0;
    private int minor = 0;
    private int patch = 0;
    private List<int[]> backup = new ArrayList<>();

    public VersionManager()
    {
        this("0.0.1");
        backup.add(new int[]{-1, -1, -1});
    }
    public VersionManager(String version)
    {
        if (version.isEmpty())
        {
            version = "0.0.1";
        }
        String[] values = version.split("\\.");
        if (values.length >= 1 && isNumeric(values[0]))
        {
            this.major = Integer.parseInt(values[0]);
        }

        if (values.length >= 2 && isNumeric(values[1]))
        {
            this.minor = Integer.parseInt(values[1]);
        }

        if (values.length >= 3 && isNumeric(values[2]))
        {
            this.patch = Integer.parseInt(values[2]);
        }
        backup.add(new int[]{-1, -1, -1});
    }

    public VersionManager major()
    {
        backup.add(new int[]{this.major, this.minor, this.patch});
        this.major += 1;
        this.minor = 0;
        this.patch = 0;
        return this;
    }

    public VersionManager minor()
    {
        backup.add(new int[]{this.major, this.minor, this.patch});
        this.minor += 1;
        this.patch = 0;
        return this;
    }

    public VersionManager patch()
    {
        backup.add(new int[]{this.major, this.minor, this.patch});
        this.patch += 1;
        return this;
    }

    public VersionManager rollback() throws Exception
    {
        if (Arrays.equals(backup.get(backup.size() - 1), new int[]{-1, -1, -1}))
        {
            throw new Exception("Cannot rollback!");
        }
        else
        {
            int[] val = backup.get(backup.size() - 1);
            backup.remove(backup.size() - 1);
            this.major = val[0];
            this.minor = val[1];
            this.patch = val[2];   
            return this;
        }
    }

    public String release()
    {
        return this.major + "." + this.minor + "." + this.patch;
    }

    private boolean isNumeric(String str)
    {
        if (!str.matches("\\d+"))
        {
            throw new IllegalArgumentException("Error occured while parsing version!");
        }
        return true;
    }
}
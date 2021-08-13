import java.time.LocalTime;
import java.util.Date;

public class Miid {

    public String sn;
    public String vn;
    public String va;
    public long time;

    public Miid(String id)
    {
        String[] miidValues = parseMiid(id);
        this.sn = miidValues[0];
        this.vn = miidValues[1];
        this.va = miidValues[2];
        this.time = Long.parseLong(miidValues[3]);
    }

    /**
     * Parses out the properties of an MIID from a string
     * @param id The string containing the properties of an MIID.
     * @return An Array contain all properties.
     */
    public String[] parseMiid(String id) {

        String sn;
        String vn;
        String va = "";
        String t = "";

        if(!sanityCheck(id))
            return new String[4];

        String[] snSplit = id.split("/");

        sn = snSplit[0];
        String workingString = snSplit[1];

        if(workingString.contains("/")) {
            String[] vnSplit = workingString.split("/");
            vn = vnSplit[0];

            workingString = vnSplit[1];
            String[] tSplit =workingString.split("%");
            va = tSplit[0];
            t = tSplit[1];

        }
        else
        {
            String[] tSplit =workingString.split("%");
            vn = tSplit[0];
            t = tSplit[1].substring(0, tSplit.length -2);
        }

        return new String[] {sn, vn, va, t};
    }

    @Override
    public String toString()
    {
        String s = this.sn + "/" + this.vn;
        if(!this.va.equals(""))
            s = s.concat("/"+ va);
        s = s.concat("%"+this.time+"s");
        return s;
    }

    /**
     * Set the epoch time value given a Date time
     * @param time The date time value to convert.
     */
    public void setEpoch(long time)
    {
       this.time = time;
    }

    /**
     * Checks if string can be parsed to miid
     * @param miid The string to check.
     * @return True if the string can be parsed.
     */
    public boolean sanityCheck(String miid)
    {
        if(!miid.contains("%"))
            return false;
        if(!miid.endsWith("s"))
            return false;
        int counter = countSlash(miid);
        if(counter < 1 || counter > 3)
            return false;
        if(miid.contains("+") || miid.contains("(") || miid.contains(")"))
            return false;
        return true;
    }

    private int countSlash(String miid) {
        int count = 0;
        for (char c:miid.toCharArray()) {
            if(c == '/')
                count++;
        }
        return count;
    }
}

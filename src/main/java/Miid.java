import java.util.Date;

public class Miid {

    public String sn;
    public String vn;
    public String va;
    public long time;

    public Miid(String id)
    {
        //TODO: call san check and throw exception if it fails
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
    //TODO: implement Parser
    public String[] parseMiid(String id) {
        return new String[0];
    }

    @Override
    //TODO: implement toString
    public String toString()
    {
        return null;
    }

    /**
     * Set the epoch time value given a Date time
     * @param time The date time value to convert.
     */
    public void setEpoch(Date time)
    {
       this.time = time.getTime();
    }

    /**
     * Checks if string can be parsed to miid
     * @param miid The string to check.
     * @return True if the string can be parsed.
     */
    //TODO: implement sanityCheck
    public boolean sanityCheck(String miid)
    {
        return false;
    }
}

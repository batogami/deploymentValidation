import java.util.List;

public class Ciid {

    public List<Ciid> ciids;
    public Miid miid;

    public Ciid(String id)
    {
        List<Object> parsedValues =  parseCiid(id);
        this.ciids = (List<Ciid>) parsedValues.get(0);
        this.miid = (Miid) parsedValues.get(1);
    }

    /**
     * Gets a string with the textual information about this CIID an extract all properties
     * @param id The string representation of this CIID
     * @param <T>
     * @return Returns a list where the first entry is the list of all other CIIDs an the second is the MIID
     */
    //TODO: implement parser
    public <T> List<T> parseCiid(String id) {
        return null;
    }

    @Override
    //TODO: Implement toString
    public String toString()
    {
        return null;
    }

}

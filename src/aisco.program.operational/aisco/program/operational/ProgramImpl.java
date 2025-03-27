package aisco.program.operational;
import aisco.program.core.ProgramDecorator;

public class ProgramImpl extends ProgramDecorator {

    // delta removes attributes, create a new constructor
    public ProgramImpl(int idProgram, String name, String description, String target) {
        this.idProgram = idProgram;
        this.name = name;
        this.description = description;
        this.target = target;
    }

    // disable all getter setter for removed attributes
    public void setPartner(String partner) {
        throw new UnsupportedOperationException();
    }

    public String getPartner() {
        throw new UnsupportedOperationException();
    }

    public void setLogoUrl(String logoUrl) {
        throw new UnsupportedOperationException();
    }

    public String getLogoUrl() {
        throw new UnsupportedOperationException();
    }

    // delta removes method
    public void setExecutionDate(String date)
    {
        throw new UnsupportedOperationException();
    }

    public String toString(){
        return " Operational " + name + "";
    }

}

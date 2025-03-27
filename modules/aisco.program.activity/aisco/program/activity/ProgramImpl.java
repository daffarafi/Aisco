package aisco.program.activity;
import aisco.program.core.*;


public class ProgramImpl extends ProgramComponent {

    public ProgramImpl(int idProgram, String name, String description, String target, String partner, String logoUrl)
    {
        super(idProgram, name, description, target, partner, logoUrl);
    }

    public String toString(){
        return " " + name + "";
    }
}


package aisco.program.category;

import aisco.program.core.ProgramComponent;
import aisco.program.core.ProgramDecorator;
import aisco.program.core.Program;

public class ProgramImpl extends ProgramDecorator{
    private String category;

    public ProgramImpl (ProgramComponent program, String category)
    {
        super(program);
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String toString()
    {
        return program + ", Category: " +category+ ".";
    }
}

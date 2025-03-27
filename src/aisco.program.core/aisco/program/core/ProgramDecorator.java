package aisco.program.core;

public abstract class ProgramDecorator extends ProgramComponent
{
    public ProgramComponent program;

    public ProgramDecorator()
    {
        
    }

    public ProgramDecorator (ProgramComponent program)
    {
        this.program = program;
    }

    
    public String toString(){
        return program.getProgramName();
    }
}
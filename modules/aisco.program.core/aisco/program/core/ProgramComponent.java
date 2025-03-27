package aisco.program.core;

public abstract class ProgramComponent implements Program{

    protected int idProgram;
    protected String name;
    protected String description;
    protected String target;
    protected String partner;
    protected String logoUrl;
    protected String executionDate;

    public ProgramComponent()
    {

    }

    public ProgramComponent(int idProgram, String name, String description, String target, String partner, String logoUrl)
    {
        this.idProgram = idProgram;
        this.name = name;
        this.description = description;
        this.target = target;
        this.partner = partner;
        this.logoUrl = logoUrl;
    }

    public void setProgramName(String name) {
        this.name = name;
    }

    public String getProgramName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getPartner() {
        return partner;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        System.out.println(logoUrl);
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setExecutionDate(String date)
    {
        System.out.println(date);
        this.executionDate = date;
    }

}

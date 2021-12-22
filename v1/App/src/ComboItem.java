class ComboItem
{
    private Integer id;
    private String value;

    public ComboItem(int key, String value)
    {
        this.id = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value;
    }

    public Integer getId()
    {
        return id;
    }

    public String getValue()
    {
        return value;
    }
}
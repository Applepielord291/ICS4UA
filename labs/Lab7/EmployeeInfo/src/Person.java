public class Person {
    private String name;
    public String getSetPerson(String realName)
    {
        if (realName != null)
        {
            name = realName;
        }
        return name;
    }
}

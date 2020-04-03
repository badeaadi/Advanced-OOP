import java.util.ArrayList;

public class Town extends Node {

    private String name;

    Town(String newName) {
        name = newName;
        names.add(name);
        allIndex++;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String newName) {
        name = newName;
    }
}

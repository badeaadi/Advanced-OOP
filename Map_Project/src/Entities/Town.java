package Entities;

public class Town extends Node {

    private String name;

    public Town(String newName) {
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

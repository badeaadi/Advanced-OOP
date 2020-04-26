package Entities;

import java.util.ArrayList;

public abstract class Node {


    public String name;
    public static ArrayList<String> names = new ArrayList<>();
    protected static int allIndex = 0;


    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    static int getIndex(String name) {
        for (int i = 0; i < names.size(); i++)
            if (name.equals(names.get(i)))
                return i;
        return -1;
    }
}

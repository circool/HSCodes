package ru.tsurkanenko.vladimir.hscodes.database;



class ItemsScopeDemo {
    public static void main(String[] args) {
        ItemsScope demo = new ItemsScope();
        Item dem = demo.getItem("0101210002");
        System.out.println(dem.toString());


        for (Item x:demo.startsWith("2095")
             ) {
            System.out.println(x);
        }

    }


}
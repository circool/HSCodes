package ru.tsurkanenko.vladimir.hscodes.database;



class ItemsScopeDemo {
    public static void main(String[] args) {
        Item[] scope = new ItemsScope().getAll();

        for (Item curItem:scope
             ) {
            if(curItem.toString().startsWith("2503"))
                System.out.println(curItem.nestlingLevel + ": " + curItem);
        }
    }
}
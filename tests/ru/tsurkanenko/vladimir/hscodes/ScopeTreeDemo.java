package ru.tsurkanenko.vladimir.hscodes;

/**
 * Демонстрация возможностей класса ScopeTree
 */
public class ScopeTreeDemo {
    public static void main(String[] args) {
        ScopeItems group = new ScopeItems("dic/TNVED3.TXT"); group.add("dic/TNVED3.ADD.TXT");
        ScopeItems item = new ScopeItems("dic/TNVED4.TXT"); item.add("dic/TNVED4.ADD.TXT");
        Items[] allItems = group.startsWith("0102");
        for (int i = 0; i < 1; i++) {
            System.out.println(allItems[0].toString());
            for (Items l1: item.startsWith(allItems[0].getCode(),1)) {
                System.out.println(StringTools.toHuman(l1.toString()));
                for(Items l2 : item.getChild(l1)) {
                    System.out.println("\t" + StringTools.toHuman(l2.toString()));
                    for(Items l3 : item.getChild(l2)) {
                        System.out.println("\t\t" + StringTools.toHuman(l3.toString()));
                        for(Items l4 : item.getChild(l3)) {
                            System.out.println("\t\t\t" + StringTools.toHuman(l4.toString()));
                            for(Items l5 : item.getChild(l4)) {
                                System.out.println("\t\t\t\t" + StringTools.toHuman(l5.toString()));
                                for(Items l6 : item.getChild(l5)) {
                                    System.out.println("\t\t\t\t\t" + StringTools.toHuman(l6.toString()));
                                }
                            }
                        }
                    }
                }

            }
        }
    }

}

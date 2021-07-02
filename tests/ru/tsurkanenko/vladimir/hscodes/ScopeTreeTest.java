package ru.tsurkanenko.vladimir.hscodes;

/**
 * Демонстрация использования ScopeTree
 */
public class ScopeTreeTest {
    public static void main(String[] args) {

        ScopeItems group = new ScopeItems("dic/TNVED3.TXT"); group.add("dic/TNVED3.ADD.TXT");
        ScopeItems item = new ScopeItems("dic/TNVED4.TXT"); item.add("dic/TNVED4.ADD.TXT");
        Items[] parent = item.startsWith("0102");
        for (Items a:parent
             ) {
            System.out.println(StringTools.toHuman(a.toString()));
            Items[] scope = item.getChild(a);
            for (Items x:scope
            ) {
                System.out.println("\t" + StringTools.toHuman(x.toString()));
            }
        }
        for (Items items:item.get()
             ) {
            System.out.println(items.toString());
        }


    }
}

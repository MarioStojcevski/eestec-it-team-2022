/*
Листа прв колоквиум 2019 термин2 – lab3 DLL mislam deka e zadacava
• Дадени две сортирани двојно поврзани листи. Да се направе трета двојно поврзана
листа која ќе ги содржи непарните броеви од првата листа и парните броеви од
втората листа и ќе биде сортирана.
Na primer : 
integerDLL1: 9<->10<->11<->12<->13<->14<->
integerDLL2: 1<->2<->3<->4<->5<->6<->7<->8<->
2<->4<->6<->8<->9<->11<->13<->
 */

public class osmaZadacha {
    public static void main(String[] args) {

        DLL<Integer> integerDLL1 = new DLL<>();
        DLL<Integer> integerDLL2 = new DLL<>();
        integerDLL1.insertLast(9);
        integerDLL1.insertLast(10);
        integerDLL1.insertLast(11);
        integerDLL1.insertLast(12);
        integerDLL1.insertLast(13);
        integerDLL1.insertLast(14);

        integerDLL2.insertLast(1);
        integerDLL2.insertLast(2);
        integerDLL2.insertLast(3);
        integerDLL2.insertLast(4);
        integerDLL2.insertLast(5);
        integerDLL2.insertLast(6);
        integerDLL2.insertLast(7);
        integerDLL2.insertLast(8);

        System.out.println("integerDLL1: " + integerDLL1);
        System.out.println("integerDLL2: " + integerDLL2);

        DLL<Integer> thirdList = new DLL<Integer>();
        DLLNode<Integer> tempNodeDLL1 = integerDLL1.getFirst();
        DLLNode<Integer> tempNodeDLL2 = integerDLL2.getFirst();

        while (tempNodeDLL1 != null && tempNodeDLL2 != null) {
            if (tempNodeDLL1.element % 2 == 0) {
                tempNodeDLL1 = tempNodeDLL1.succ;
                continue;
            }
            if (tempNodeDLL2.element % 2 != 0) {
                tempNodeDLL2 = tempNodeDLL2.succ;
                continue;
            }
            if (tempNodeDLL1.element < tempNodeDLL2.element) {
                thirdList.insertLast(tempNodeDLL1.element);
                tempNodeDLL1 = tempNodeDLL1.succ;
            } else {
                thirdList.insertLast(tempNodeDLL2.element);
                tempNodeDLL2 = tempNodeDLL2.succ;
            }
        }
        while (tempNodeDLL1 != null) {
            if (tempNodeDLL1.element % 2 != 0)
                thirdList.insertLast(tempNodeDLL1.element);
            tempNodeDLL1 = tempNodeDLL1.succ;
        }
        while (tempNodeDLL2 != null) {
            if (tempNodeDLL2.element % 2 == 0)
                thirdList.insertLast(tempNodeDLL2.element);
            tempNodeDLL2 = tempNodeDLL2.succ;
        }

        System.out.println(thirdList);
    }
}
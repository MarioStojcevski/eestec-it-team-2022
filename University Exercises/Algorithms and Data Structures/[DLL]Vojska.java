//Војска Problem 2 (1 / 2)
//        Пред командантот на војската наредени се сите војници и во двојно поврзана листа дадени
//        се нивните ID-a. На командантот не му се допаѓа како се наредени војниците и решава да
//        одбере два под-интервали од војници и да им ги замени местата, односно војниците што се
//        наоѓаат во едниот под-интервал ќе ги смести во другиот, и обратно.
//
//        Влез: Во првиот ред даден е бројот на војници. Во вториот ред дадени се ID-то на секој
//        од војниците. Во третиот ред дадени се два броеви, ID на првиот војник и ID на последниот
//        војник од првиот интервал. Во четвртиот ред дадени се два броеви, ID на првиот војник и
//        ID на последниот војник од вториот интервал.
//
//        Излез: Да се испечати новиот редослед на војниците (т.е. на нивните ID-a)
//        Забелешка 1: Интервалите никогаш нема да се преклопуваат и ќе содржат барем еден војник.
//        Целата низа ќе содржи најмалку два војника. Забелешка 2: Обратете посебно внимание кога
//        интервалите се еден до друг и кога некој од интервалите почнува од првиот војник или
//        завршува со последниот војник.
//        Име на класата: DLLVojska

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return "<-"+element.toString()+"->";
    }
}

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            DLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if(after==last){
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if(before == first){
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        // else throw Exception
        return null;
    }


    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp + "<->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

}

public class Vojska {

    public static DLL<Integer> vojska(DLL<Integer> lista, int a, int b, int c, int d){
        DLL<Integer> result = new DLL<>();
        DLLNode<Integer> node = lista.getFirst();
        DLLNode<Integer> nodeA = null;
        DLLNode<Integer> nodeB = null;
        DLLNode<Integer> nodeC = null;
        DLLNode<Integer> nodeD = null;

        while(node != null) {
            if(node.element == a) {
                nodeA = node;
            }
            if(node.element == b) {
                nodeB = node;
            }
            if(node.element == c) {
                nodeC = node;
            }
            if(node.element == d) {
                nodeD = node;
            }
            node = node.succ;
        }

        node = lista.getFirst();

        while(node != null) {
            while(node != nodeA) {
                result.insertLast(node.element);
                node = node.succ;
            }
            node = nodeC;
            while(node != nodeD) {
                result.insertLast(node.element);
                node = node.succ;
            }
            result.insertLast(nodeD.element);
            node = nodeB.succ;
            while(node != nodeC) {
                result.insertLast(node.element);
                node = node.succ;
            }
            node = nodeA;
            while(node != nodeB) {
                result.insertLast(node.element);
                node = node.succ;
            }
            result.insertLast(nodeB.element);
            node = nodeD.succ;
            while(node != null) {
                result.insertLast(node.element);
                node = node.succ;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        DLL<Integer> lista = new DLL<>();
        String[] stringArray = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(stringArray[i]));
        }
        String[] stringArrayOfInterval = br.readLine().split(" ");
        int a = Integer.parseInt(stringArrayOfInterval[0]);
        int b = Integer.parseInt(stringArrayOfInterval[1]);

        stringArrayOfInterval = br.readLine().split(" ");
        int c = Integer.parseInt(stringArrayOfInterval[0]);
        int d = Integer.parseInt(stringArrayOfInterval[1]);

        DLL<Integer> vojskaSortedLista = vojska(lista, a, b, c, d);

        DLLNode<Integer> node = vojskaSortedLista.getFirst();
        while(node != null) {
            System.out.print(node.element + " ");
            node = node.succ;
        }
    }

}
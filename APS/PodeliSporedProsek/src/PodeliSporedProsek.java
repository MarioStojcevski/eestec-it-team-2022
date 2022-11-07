// Дадена е еднострано поврзана листа чии што јазли содржат по еден природен број.
// Листата треба да се подели на две резултантни листи,
// т.ш. во првата листа треба да се сместат сите јазли кои содржат броеви помали
// или еднакви на просекот на листата (просек на листа претставува математички просек
// од сите природни броеви кои се јавуваат во листата), а во втората сите јазли кои
// содржат броеви поголеми од просекот на листата.
// Јазлите во резултантните листи се додаваат според редоследот по кој се појавуваат
// во дадената листа.
//
// Во првиот ред од влезот е даден бројот на јазли во листата, а во вториот ред
// се дадени броевите од кои се составени јазлите по редослед во листата.
// Во првиот ред од излезот треба да се испечатат јазлите по редослед од
// првата резултантна листа (броеви помали или еднакви на просекот на листата),
// во вториот ред од втората (броеви поголеми од просекот на листата) .
//
// Име на класа (за Java): PodeliSporedProsek
//
// Забелешка: При реализација на задачите МОРА да се користат дадените структури,
// а не да користат помошни структури како низи или сл.
// Sample input
// 5
// 4 2 1 5 3
//
// 2 1 3
// 4 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + " ";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

}

public class PodeliSporedProsek {

    public static void splitByAvg(SLL<Integer> lista) {
        int sum = 0;
        int prosek;
        SLLNode<Integer> node = lista.getFirst();
        while(node != null) {
            sum += node.element;
            node = node.succ;
        }
        prosek = sum/lista.length();

        SLL<Integer> lessThanAvg = new SLL<>();
        SLL<Integer> biggerThanAvg = new SLL<>();

        node = lista.getFirst();
        while(node != null) {
            if (node.element <= 3) {
                lessThanAvg.insertLast(node.element);
            } else {
                biggerThanAvg.insertLast(node.element);
            }
            node = node.succ;
        }

        node = lessThanAvg.getFirst();
        System.out.print(node.element);
        node = node.succ;
        while(node != null) {
            System.out.print(" " + node.element);
            node = node.succ;
        }

        node = biggerThanAvg.getFirst();
        System.out.println("\nBigger than avg:");

        while(node != null) {
            System.out.print(node.element + " ");
            node = node.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SLL<Integer> lista = new SLL<>();
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(line[i]));
        }

        splitByAvg(lista);

    }
}
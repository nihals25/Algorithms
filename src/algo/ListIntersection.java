/**
 * @author Nihal Abdulla PT
 * Class to find the intersection of two lists. Assumed that the lists are in sorted order
 */
package algo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListIntersection<T extends Comparable<T>> {
    /**
     * Static method to find the next element of an iterator
     * @param it Iterator<T>
     * @return T
     */
    public static<T> T next(Iterator<T> it) {
        return it.hasNext() ? it.next() : null;
    }

    /**
     * Member method to find intersection of two sets
     * @param lst1 List<T>
     * @param lst2 List<T>
     * @return List<T>
     */
    public List<T> intersect(List<T> lst1, List<T> lst2) {
        Iterator<T> it1 = lst1.iterator(), it2 = lst2.iterator();
        LinkedList<T> out = new LinkedList<>();
        T x1 = next(it1), x2 = next(it2);
        while(x1 != null && x2 != null) {
            if(x1.compareTo(x2) < 0)
                x1 = next(it1);
            else if(x2.compareTo(x1) < 0)
                x1 = next(it2);
            else {
                out.offer(x1);
                x1 = next(it1);
                x2 = next(it2);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        LinkedList<Integer> lst1 = new LinkedList<>();
        lst1.offer(1);
        lst1.offer(2);
        lst1.offer(3);
        lst1.offer(4);
        lst1.offer(5);
        LinkedList<Integer> lst2 = new LinkedList<>();
        lst2.offer(1);
        lst2.add(4);
        ListIntersection li = new ListIntersection();
        List<Integer> out = li.intersect(lst1, lst2);
        for(Integer i: out)
            System.out.println(i);
    }
}

package february21;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> it;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = next;
        if (it.hasNext()) {
            next = (Integer) it.next();
        } else {
            next = null;
        }
        return temp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
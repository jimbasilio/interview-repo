package com.basilio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Merge 2 sorted lists together, be sure to not add the same number twice to
 * the list
 */
public class CreateSortedList {

    public List<Integer> createdLargerSortedList(List<Integer> firstSortedList,
            List<Integer> secondSortedList) {
        List<Integer> combinedList = new ArrayList<>();

        // iterate over both lists picking off the next item to compare and add
        // to result
        Iterator<Integer> currentInFirst = firstSortedList.iterator();
        Iterator<Integer> currentInSecond = secondSortedList.iterator();
        Integer nextFirst = currentInFirst.next();
        Integer nextSecond = currentInSecond.next();
        while (true) {
            if (nextFirst.equals(nextSecond)) {
                // 2 elements are the same .. add to list and attempt to advance
                // both iterators
                combinedList.add(nextFirst);
                if (currentInFirst.hasNext() && currentInSecond.hasNext()) {
                    // advance both iterators
                    nextFirst = currentInFirst.next();
                    nextSecond = currentInSecond.next();
                } else if (!currentInFirst.hasNext()) {
                    // we don't have any more items in first list .. append all
                    // second list to combined (advance second since it's same
                    // as first currently)

                    nextSecond = currentInSecond.next();
                    drainList(combinedList, currentInSecond, nextSecond);

                    break;

                } else if (!currentInSecond.hasNext()) {
                    // we don't have any more items in second list .. append all
                    // first list to combined

                    nextFirst = currentInFirst.next();
                    drainList(combinedList, currentInFirst, nextFirst);

                    break;
                }

            } else if (nextFirst.compareTo(nextSecond) > 0) {
                // first is bigger than second .. add second to the list and
                // advance second iterator
                combinedList.add(nextSecond);

                if (!currentInSecond.hasNext()) {
                    // we don't have any more items in second list .. append all
                    // first list to combined

                    drainList(combinedList, currentInFirst, nextFirst);

                    break;
                } else {
                    nextSecond = currentInSecond.next();
                }

            } else {
                combinedList.add(nextFirst);

                if (!currentInFirst.hasNext()) {
                    // we don't have any more items in first list .. append all
                    // second list to combined

                    drainList(combinedList, currentInSecond, nextSecond);

                    break;

                } else {
                    nextFirst = currentInFirst.next();
                }
            }
        }

        return combinedList;
    }

    private void drainList(List<Integer> combinedList,
            Iterator<Integer> current, Integer next) {
        combinedList.add(next);
        while (current.hasNext()) {
            combinedList.add(current.next());
        }
    }

}

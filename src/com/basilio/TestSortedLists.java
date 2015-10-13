package com.basilio;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSortedLists {

    CreateSortedList sut = new CreateSortedList();

    @Test
    public void testStartSame() {
        List<Integer> bothTogether = sut.createdLargerSortedList(
                Arrays.asList(1, 4, 7, 9, 13),
                Arrays.asList(1, 2, 5, 9, 15, 19, 21));

        bothTogether.stream().forEach(x -> System.out.println(x));

        Assert.assertArrayEquals(
                new Integer[] { 1, 2, 4, 5, 7, 9, 13, 15, 19, 21 },
                bothTogether.toArray());
        Assert.assertEquals(10, bothTogether.size());
    }

    @Test
    public void testEndOneSame() {
        List<Integer> bothTogether = sut.createdLargerSortedList(
                Arrays.asList(1, 4, 7, 9, 15),
                Arrays.asList(1, 2, 5, 9, 15, 19, 21));

        bothTogether.stream().forEach(x -> System.out.println(x));

        Assert.assertArrayEquals(new Integer[] { 1, 2, 4, 5, 7, 9, 15, 19, 21 },
                bothTogether.toArray());
        Assert.assertEquals(9, bothTogether.size());
    }

    @Test
    public void testEndBothSame() {
        List<Integer> bothTogether = sut.createdLargerSortedList(
                Arrays.asList(1, 4, 7, 9, 21),
                Arrays.asList(1, 2, 5, 9, 15, 19, 21));

        bothTogether.stream().forEach(x -> System.out.println(x));

        Assert.assertArrayEquals(new Integer[] { 1, 2, 4, 5, 7, 9, 15, 19, 21 },
                bothTogether.toArray());
        Assert.assertEquals(9, bothTogether.size());
    }

}

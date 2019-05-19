package com.arun.didemo.Autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ByNameAutowired {

    /**
     * Autowired by Name
     */
    @Autowired
    private Sort bubbleSort;
}

interface Sort {
    void sort(int[] numbers);
}

@Component
class BubbleSort implements Sort {

    @Override
    public void sort(int[] numbers) {

    }
}

@Component
class QuickSort implements Sort {

    @Override
    public void sort(int[] numbers) {

    }
}

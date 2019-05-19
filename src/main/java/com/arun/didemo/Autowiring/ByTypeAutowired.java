package com.arun.didemo.Autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ByTypeAutowired {
    /**
     * ByType, here we have only one bean which qualifies to be autowired
     */
    @Autowired
    private SortAlgorithm sortAlgorithm;
}


interface SortAlgorithm {
    void sort(int[] numbers);
}

@Component
class QuickSortAlgortihm implements SortAlgorithm {
    @Override
    public void sort(int[] numbers) {

    }
}








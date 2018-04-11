package com.yuliang.tutorial.mum.parallelprogramming.part1;

public class SortedListMerge {

    public static final int n = 20000000;

    public static int[] source1 = new int[n];
    public static int[] source2 = new int[n];

    public static void init() {
        for(int i=0;i<n;i++) {
            source1[i] = 2 * i;
            source2[i] = 2 * i + 1;
        }
    }

    public static void main(String[] args) {
        int[] target = new int[2 * n];
        init();
        int[] sequentialMerge = sequentialMerge(source1, source2, target);

        int[] parallelMerge = new SortedListMerge().parallelMerge(source1, source2, target);

        for(int i=0;i<2*n;i++) {
            if(sequentialMerge[i] != parallelMerge[i]) {
                System.out.println("There is number not equal to each other: " + sequentialMerge[i]);
            }
        }
    }

    private class MergeRunnable implements Runnable {
        int[] source1;
        int[] source2;
        int[] target;

        public MergeRunnable(int[] source1, int[] source2, int[] target) {
            this.source1 = source1;
            this.source2 = source2;
            this.target = target;
        }

        @Override
        public void run() {
            int j = 0;
            for(int i=0;i<source1.length;i++) {
                while(source1[i]<source2[j] && j<n-1) {
                    j++;
                }

                target[i + j] = source1[i];
            }
        }
    }


    private int[] parallelMerge(int[] source1, int[] source2, int[] target) {
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new MergeRunnable(source1, source2, target));
        Thread thread2 = new Thread(new MergeRunnable(source2, source1, target));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time used by parallel merge is: " + (System.currentTimeMillis() - start));
        return target;
    }

    public static int[] sequentialMerge(int[] source1, int[] source2, int[] target) {
        long start = System.currentTimeMillis();
        int x = 0, y = 0;
        for(int i=0;i<2*n;i++) {
            if (x < n && y < n) {
                if(source1[x] < source2[y]) {
                    target[i] = source1[x++];
                } else {
                    target[i] = source2[y++];
                }
            } else if (x < n ) {
                target[i] = source1[x++];

            } else {
                target[i] = source2[y++];
            }
        }
        System.out.println("Time used for sequential merge is: " + (System.currentTimeMillis() - start));
        return target;
    }
}

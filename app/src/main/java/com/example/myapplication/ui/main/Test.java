package com.example.myapplication.ui.main;

import android.util.Log;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {

    static void main(int [] A, int K) {


        HashMap map = new HashMap();
        LinkedHashMap lMap = new LinkedHashMap();
        TreeSet tSet = new TreeSet();
        LinkedHashSet lSet = new LinkedHashSet();

        Scanner sc = new Scanner(System.in);
        String [] com = sc.nextLine().split(" ");

        int result = 0;


        //int[] a = Arrays.stream(com).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i <= A.length - 1; i++) {
            if (Arrays.stream(A).toArray()[i] > result && A[i] < K) {
                result = A[i];
            }
        }

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            Log.d("::::", Thread.currentThread().getName() + "start");
            synchronized ((lock1)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    // notjing
                }
            }
            Log.d("::::", Thread.currentThread().getName() + "end");
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            Log.d("::::", Thread.currentThread().getName() + "start");
            synchronized ((lock2)) {
                synchronized (lock1) {
                    // notjing
                }
            }
            Log.d("::::", Thread.currentThread().getName() + "end");
        }, "Thread2");

        thread1.start();
        thread2.start();
    }

    static class Ext implements Externalizable {

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            throw new RuntimeException();

        }

        @Override
        public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {

        }
    }


}

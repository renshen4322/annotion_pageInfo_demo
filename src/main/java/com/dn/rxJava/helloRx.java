package com.dn.rxJava;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class helloRx {
    public static void main(String[] args) {
        //rxJavaMergeWith();

        //RxmergeDelayError();
        
    }

    private static void RxmergeDelayError() {
        Observable<String> observable1 = Observable.error(new IllegalArgumentException(""));
        Observable<String> observable2 = Observable.just("Four", "Five", "Six");
        Observable.mergeDelayError(observable1, observable2)
                .subscribe(item -> System.out.println(item));
    }

    private static void rxJavaMergeWith() {
        Observable.just(1, 2, 3)
                .mergeWith(Observable.just(4, 5, 6))
                .subscribe(item -> System.out.println(item));
    }

    private static void rxZipwithTest() {
        Observable<String> firstNames = Observable.just("James", "Jean-Luc", "Benjamin");
        Observable<String> lastNames = Observable.just("Kirk", "Picard", "Sisko");
        firstNames.zipWith(lastNames, (first, last) -> first + " " + last)
                .subscribe(item -> System.out.println(item));
    }
}

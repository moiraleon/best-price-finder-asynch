package com.javapackage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {


   public static void main(String[] args) {

       var service = new FlightService();
//       service.getQuote("site 1")
//               .thenAccept(System.out::println);
       service.getQuotes()
               .map(future -> future.thenAccept(System.out::println))
               .collect(Collectors.toList());

       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {

       }
   }
}

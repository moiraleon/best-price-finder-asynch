package com.javapackage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {


   public static void main(String[] args) {

       var service = new FlightService();
       service.getQuote("site 1")
               .thenAccept(System.out::println);

       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {

       }


//
//        var site1 = CompletableFuture.supplyAsync(()->{
//            return 1;
//        });
//
//        var site2 = CompletableFuture.supplyAsync(()->{
//            return 2;
//        });
//
//        var site3 = CompletableFuture.supplyAsync(()->{
//            return 3;
//        });
//
//        var all = CompletableFuture.allOf(site1,site2,site3);
//        all.thenRun(()->{
//
//            try {
//                var firstResult = site1.get();
//                var secondResult = site2.get();
//                var thirdResult = site3.get();
//                System.out.println(firstResult);
//                System.out.println(secondResult);
//                System.out.println(thirdResult);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Retrieved all quotes in ");
//        });
   }
}

package com.javapackage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {


   public static void main(String[] args) {
       var start = LocalTime.now();

       var service = new FlightService();
      var futures = service.getQuotes()
               .map(future -> future.thenAccept(System.out::println))
               .collect(Collectors.toList());

      CompletableFuture
              .allOf(futures.toArray(new CompletableFuture[0]))
              .thenRun(()-> {
                  var end = LocalTime.now();
                  var duration = Duration.between(start,end);
                  System.out.println("Retieved all quotes in "+duration.toMillis()+ " milliseconds.");
              });

       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {

       }
   }
}

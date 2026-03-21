package org.interviewquestions.agoda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientExample {


    private static final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
            .build();


    public static void main(String[] args) {
        try {
            // Synchronous GET
            System.out.println("=== Synchronous GET ===");
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .header("User-Agent", "Java HttpClient Example")
                    .GET()
                    .build();
            HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status: " + getResponse.statusCode());
            System.out.println("Body: " + getResponse.body().substring(0, Math.min(500, getResponse.body().length())) + "...");

            // Synchronous POST with JSON
            System.out.println("\n=== Synchronous POST ===");
            String json = "{\"name\":\"Ajay Rajput\",\"city\":\"Delhi\"}";
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/post"))
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "Java HttpClient Example")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
            HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status: " + postResponse.statusCode());
            System.out.println("Body: " + postResponse.body().substring(0, Math.min(500, postResponse.body().length())) + "...");

            // Asynchronous GET
            System.out.println("\n=== Asynchronous GET ===");
            HttpRequest asyncRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/json"))
                    .header("User-Agent", "Java HttpClient Example")
                    .GET()
                    .build();
            CompletableFuture<HttpResponse<String>> asyncResponse = client.sendAsync(asyncRequest, HttpResponse.BodyHandlers.ofString());
            asyncResponse.thenAccept(response -> {
                System.out.println("Async Status: " + response.statusCode());
                System.out.println("Async Body: " + response.body());
            }).join();  // Wait for completion in main

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }


}

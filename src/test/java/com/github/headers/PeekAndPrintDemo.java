package com.github.headers;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PeekAndPrintDemo {

    // const винаги с главни букви
    static final String BASE_URL = "https://api.github.com/";


    // peek помага когато има проблем - показва всички header-и накуп и response
    @Test
    void peek() {
        RestAssured.get(BASE_URL).peek();
    }

    // prettyPeek форматира (уж)
    @Test
    void prettyPeek() {
        RestAssured.get(BASE_URL).prettyPeek();
    }


    // показва response и body
    @Test
    void print() {
        RestAssured.get(BASE_URL).print();
    }


    @Test
    void prettyPrint() {
        RestAssured.get(BASE_URL).prettyPrint();
    }



}

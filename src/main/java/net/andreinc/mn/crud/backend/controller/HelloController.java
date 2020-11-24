package net.andreinc.mn.crud.backend.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import static io.micronaut.http.MediaType.TEXT_PLAIN;

@Controller("/hello")
public class HelloController {
    @Get
    @Produces(TEXT_PLAIN)
    public String index() {
        return "Hello world!";
    }
}

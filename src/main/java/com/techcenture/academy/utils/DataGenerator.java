package com.techcenture.academy.utils;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * Created by tairovich_jr on 2022-01-13.
 */
public class DataGenerator {

    private DataGenerator(){}

    public static String randomEmail(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String[] emails = {"gmail.com","yahoo.com", "icloud.com"};

        String email = (lastName +"."+firstName).toLowerCase()+"@"  + emails[(int) (Math.random() * (3) + 0)];
        return email;
    }

    public static String randomMessage(int size){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < size) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static void main(String[] args) {

        System.out.println(randomMessage(100));

    }

}

package com.bridgelabz.lambdaexpression;

import java.util.regex.Pattern;

@FunctionalInterface
interface IUserRegistration{
    String Validate(String input);
    static void printResult(String input, String function, IUserRegistration functionValidator){
        System.out.println(" ==> is the result of "+function+" which is "+functionValidator.Validate(input));
    }
}

public class UserRegistrationLambdaExpression {

    public static void main(String[] args) {
        System.out.println("Welcome to User Registration Using Lambda Expression");

        IUserRegistration firstNameValidate = (firstName) -> {
            System.out.print(Pattern.matches("^[A-Z][a-z]{2,}", firstName));
            return firstName;
        };

        IUserRegistration lastNameValidate = (lastName) -> {
            System.out.print(Pattern.matches("^[A-Z][a-z]{2,}$", lastName));
            return lastName;
        };

        IUserRegistration emailValidate = (emailAddress) -> {
            System.out.print(Pattern.matches("^[a-zA-Z][a-zA-Z0-9_\\-+]*[.]{0,1}[a-zA-Z0-9_\\-+]{1,}[@][a-zA-Z0-9]{1,}[.][a-zA-Z]{2,}[.]{0,}[a-zA-Z]*$", emailAddress));
            return emailAddress;
        };

        IUserRegistration phoneNumberValidate = (phoneNumber) -> {
            System.out.print(Pattern.matches("(0|91)?[\\s][0-9]{10}", phoneNumber));
            return phoneNumber;
        };

        IUserRegistration passwordValidate = (password) -> {
            System.out.print(Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[0-9]).{8,}$", password));
            return password;
        };

        IUserRegistration.printResult("Ritesh", "first name",firstNameValidate);
        IUserRegistration.printResult("Tiwari", "last name", lastNameValidate);
        IUserRegistration.printResult("ktritesh7@gmail.com", "email address", emailValidate);
        IUserRegistration.printResult("0 7066086690", "phone number", phoneNumberValidate);
        IUserRegistration.printResult("bridge#Labz1", "password", passwordValidate);
    }
}

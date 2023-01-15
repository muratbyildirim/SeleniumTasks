package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1(){
        //Creating Faker object to reach methods
        Faker faker=new Faker();
        Faker faker1=new Faker(new Locale("tr"));

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker1.name().fullName() = " + faker1.name().fullName());
        System.out.println("faker1.address() = " + faker1.address());
        System.out.println("faker.address() = " + faker.address());

        //numerify() method will generate random numbers in the format we want to get
        System.out.println("faker.numerify(\"####-##-#####\") = " + faker.numerify("####-##-#####"));
        System.out.println("faker.numerify(\"312-###-####\") = "
                + faker.numerify("312-###-####"));

        //letterify() method will return random letters where we pass "?"
        System.out.println("faker.letterify(\"???-?????-?\") = " + faker.letterify("???-?????-?"));

        System.out.println("faker.bothify(\"##??-#????-?####\") = " + faker.bothify("##??-#????-?####"));

        System.out.println("faker.chuckNorris() = " + faker.chuckNorris());
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.chuckNorris().fact().replaceAll(\"Chuck Norris\",\"Murat\") = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Murat"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replaceAll("-"," "));


    }


}

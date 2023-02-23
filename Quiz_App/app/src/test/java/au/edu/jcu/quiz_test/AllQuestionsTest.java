package au.edu.jcu.quiz_test;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class AllQuestionsTest extends TestCase {

    public void testGetQuestions() {

        List<Questions> actualList = new ArrayList<>();

        Questions question1 = new Questions("What is the default value of boolean variables?", "True", "False", "1", "0", "False", "");
        Questions question2 = new Questions("Which package is imported by default in every program?", "java.util", "java.lang", "java.io", "java.awt", "java.lang", "");
        Questions question3 = new Questions("How many primitive data types are there?", "8", "7", "6", "5", "8", "");
        Questions question4 = new Questions("What is the return type of 'compareTo' function?", "String", "boolean", "int", "double", "boolean", "");

        actualList.add(question1);
        actualList.add(question2);
        actualList.add(question3);
        actualList.add(question4);

        List<Questions> listOfQuestions =  AllQuestions.getQuestions("java");

        /** Comment off the other tests when testing one of the following assertions.**/
        /** The following tests check if the getQuestions function returns the correct list of questions.**/
        assertEquals(actualList.get(0).getOption1(), "True");
        assertEquals(actualList.get(2).getAnswer(), listOfQuestions.get(2).getAnswer());
        assertEquals(actualList.get(1).getOption2(), listOfQuestions.get(1).getOption2());
        assertNotNull(AllQuestions.getQuestions("java"));

    }
}

package au.edu.jcu.quiz_test;

import java.util.ArrayList;
import java.util.List;

public class AllQuestions {

    /**
     * Create a method to add the Java questions to the list of questions.**/
    private static List<Questions> javaQuestions(){

        List<Questions> listOfQuestions = new ArrayList<>();

        // Add each question, the four options, the correct answer and the user's choice to the list.
        Questions question1 = new Questions("What is the default value of boolean variables?", "True", "False", "1", "0", "False", "");
        Questions question2 = new Questions("Which package is imported by default in every program?", "java.util", "java.lang", "java.io", "java.awt", "java.lang", "");
        Questions question3 = new Questions("How many primitive data types are there?", "8", "7", "6", "5", "8", "");
        Questions question4 = new Questions("What is the return type of 'compareTo' function?", "String", "boolean", "int", "double", "boolean", "");

        // Add the questions individually to the list.
        listOfQuestions.add(question1);
        listOfQuestions.add(question2);
        listOfQuestions.add(question3);
        listOfQuestions.add(question4);

        return listOfQuestions;

    }

    /**
     * Create a method to add the Python questions to the list of questions.**/
    private static List<Questions> pythonQuestions(){

        List<Questions> listOfQuestions = new ArrayList<>();

        Questions question1 = new Questions("Which inbuilt module is used for GUI design?", "Kivy", "platform", "os", "random", "Kivy", "");
        Questions question2 = new Questions("Which datatype stores decimal values?", "int", "string", "float", "boolean", "float", "");
        Questions question3 = new Questions("Which module has the randint() function?", "random", "os", "math", "sys", "random", "");
        Questions question4 = new Questions("What is the name of the default constructor?", "init", "main", "sys", "none of the above", "init", "");

        listOfQuestions.add(question1);
        listOfQuestions.add(question2);
        listOfQuestions.add(question3);
        listOfQuestions.add(question4);

        return listOfQuestions;

    }

    /**
     * Create a method to add the Android questions to the list of questions.**/
    private static List<Questions> androidQuestions(){

        List<Questions> listOfQuestions = new ArrayList<>();

        Questions question1 = new Questions("Which markup language is used for UI design in android?", "HTML", "XML", "SQL", "none of the above", "XML", "");
        Questions question2 = new Questions("Which languages are used for developing in android?", "java and kotlin", "java and python", "python and C", "kotlin and C", "java and kotlin", "");
        Questions question3 = new Questions("Which class is used to display popups in android?", "Intent", "View", "Button", "Toast", "Toast", "");
        Questions question4 = new Questions("Which method is a lifecycle method?", "onCreate", "onRotation", "onTranslation", "onStart", "onStart", "");

        listOfQuestions.add(question1);
        listOfQuestions.add(question2);
        listOfQuestions.add(question3);
        listOfQuestions.add(question4);

        return listOfQuestions;

    }

    /**
     * Create a method to add the HTML questions to the list of questions.**/
    private static List<Questions> htmlQuestions(){

        List<Questions> listOfQuestions = new ArrayList<>();

        Questions question1 = new Questions("Are tags and elements the same?", "true", "false", "sometimes", "none of the above", "false", "");
        Questions question2 = new Questions("Which tag stores the starting information about a web page?", "footer", "header", "title", "nav", "header", "");
        Questions question3 = new Questions("Which tag is used for formatting?", "em", "nav", "section", "b", "em", "");
        Questions question4 = new Questions("The character set is defined under which tag?", "nav", "section", "meta", "sub", "meta", "");

        listOfQuestions.add(question1);
        listOfQuestions.add(question2);
        listOfQuestions.add(question3);
        listOfQuestions.add(question4);

        return listOfQuestions;

    }

    /**
     * Create the function to check which option is selected by the user and return the list of that respective topic.**/
    public static List<Questions> getQuestions(String topicName){

        if(topicName.equals("java"))
            return javaQuestions();

        else if(topicName.equals("python"))
            return pythonQuestions();

        else if(topicName.equals("android"))
            return androidQuestions();

        else
            return htmlQuestions();

    }

}

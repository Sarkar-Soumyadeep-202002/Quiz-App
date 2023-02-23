package au.edu.jcu.quiz_test;

import junit.framework.TestCase;

public class QuestionsTest extends TestCase {

    private Questions question = new Questions("Which markup language is used for UI design in android?", "HTML", "XML", "SQL", "None of the Above", "XML", "");

    public void testGetQuestion() {

        assertEquals("Which markup language is used for UI design in android?", question.getQuestion());

    }

    public void testGetOption1() {

        assertEquals("HTML", question.getOption1());

    }

    public void testGetOption2() {

        assertEquals("XML", question.getOption2());

    }

    public void testGetOption3() {

        assertEquals("SQL", question.getOption3());

    }

    public void testGetOption4() {

        assertEquals("None of the Above", question.getOption4());

    }

    public void testGetAnswer() {

        assertEquals("XML", question.getAnswer());

    }

    public void testGetUserChoice() {

        assertEquals("", question.getUserChoice());

    }

}
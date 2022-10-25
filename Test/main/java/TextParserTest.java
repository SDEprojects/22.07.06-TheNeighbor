package main.java;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class TextParserTest {

    @Test
    public void getVerbKeywordPresent() {
        TextParser myTest = new TextParser("to the north go");
        assertEquals("go",myTest.getVerb());
    }

    @Test
    public void getVerbKeywordAbsent() {
        TextParser myTest = new TextParser("to the north ahead");
        assertEquals("invalid",myTest.getVerb());
    }

    @Test
    public void getNounKeywordPresent() {
        TextParser myTest = new TextParser("to the north ahead");
        assertEquals("north",myTest.getNoun());
    }

    @Test
    public void getNounKeywordAbsent() {
        TextParser myTest = new TextParser("to the nort ahead");
        assertEquals("invalid",myTest.getNoun());
    }

    @Test
    public void getHelpTrue() {
        TextParser myTest = new TextParser("please get help");
        assertEquals(true,myTest.getHelp());
    }

    @Test
    public void getHelpFalse() {
        TextParser myTest = new TextParser("please get hepl");
        assertEquals(false,myTest.getHelp());
    }

    @Test
    public void getValidTrue() {
        TextParser myTest = new TextParser("go to the west");
        assertEquals(true,myTest.getValid());
    }

    @Test
    public void getValidFalse() {
        TextParser myTest = new TextParser("get to the choppa");
        assertEquals(false,myTest.getValid());
    }
}
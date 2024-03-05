package org.youngpopeugene.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testLieInChair(){
        person.lieInChair();
        assertEquals(Level.LOW, person.getSatisfactionLevel());
        assertThrows(AlreadyInStateException.class, () -> person.lieInChair());
    }

    @Test
    public void testPutFeetOnPanel(){
        person.putFeetOnPanel();
        assertEquals(Level.LOW, person.getSatisfactionLevel());
        assertThrows(AlreadyInStateException.class, () -> person.putFeetOnPanel());
    }

    @Test
    public void testPickOnesTeeth(){
        person.pickOnesTeeth();
        assertEquals(Level.LOW, person.getSatisfactionLevel());
        assertThrows(AlreadyInStateException.class, () -> person.pickOnesTeeth());
    }


    @Test
    public void testThinkAboutDeath(){
        person.pickOnesTeeth();
        person.thinkAboutDeath();
        assertEquals(Level.ZERO, person.getSatisfactionLevel());
        assertThrows(BeyondLevelRangeException.class, () -> person.thinkAboutDeath());
    }

    @Test
    public void testSeeStrangeThing(){
       person.seeStrangeThing();
       assertEquals(1, person.getCountOfStrangeThings());
    }

    @Test
    public void testIsSmile(){
        person.lieInChair();
        person.putFeetOnPanel();
        person.pickOnesTeeth();
        assertTrue(person.isSmile());
        person.thinkAboutDeath();
        assertFalse(person.isSmile());
    }

    @Test
    public void testIsJawDropped(){
        for (int i = 0; i < 100; i++) {
            person.seeStrangeThing();
        }
        assertTrue(person.isJawDropped());
    }

    @Test
    public void testIsNervous(){
        for (int i = 0; i < 34; i++) {
            person.seeStrangeThing();
        }
        assertTrue(person.isNervous());
        person.lieInChair();
        assertFalse(person.isNervous());
    }
}

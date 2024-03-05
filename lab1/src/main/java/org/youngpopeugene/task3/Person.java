package org.youngpopeugene.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private boolean isNervous;
    private boolean isSmile;
    private boolean isJawDropped;

    private Level satisfactionLevel;
    private int countOfStrangeThings;

    private boolean lyingInChairState;
    private boolean puttingFeetOnPanelState;
    private boolean pickingOnesTeethState;

    public Person() {
        isNervous = false;
        isSmile = false;
        isJawDropped = false;

        satisfactionLevel = Level.ZERO;
        countOfStrangeThings = 0;

        lyingInChairState = false;
        puttingFeetOnPanelState = false;
        pickingOnesTeethState = false;
    }

    public void seeStrangeThing(){
        this.countOfStrangeThings++;
        updateEmotions();
    }

    public void thinkAboutDeath(){
        decreaseSatisfactionLevel();
        updateEmotions();
    }

    public void lieInChair() {
        if (!lyingInChairState) {
            lyingInChairState = true;
            increaseSatisfactionLevel();
            updateEmotions();
        } else throw new AlreadyInStateException();
    }

    public void putFeetOnPanel() {
        if (!puttingFeetOnPanelState) {
            puttingFeetOnPanelState = true;
            increaseSatisfactionLevel();
            updateEmotions();
        } else throw new AlreadyInStateException();
    }

    public void pickOnesTeeth() {
        if (!pickingOnesTeethState) {
            pickingOnesTeethState = true;
            increaseSatisfactionLevel();
            updateEmotions();
        } else throw new AlreadyInStateException();
    }

    private void updateEmotions() {
        isSmile = satisfactionLevel == Level.HIGH;
        isJawDropped = countOfStrangeThings > 99;
        isNervous = satisfactionLevel == Level.ZERO && countOfStrangeThings > 33;
    }

    private void decreaseSatisfactionLevel() {
        switch (this.satisfactionLevel) {
            case HIGH:
                this.satisfactionLevel = Level.MEDIUM;
                return;
            case MEDIUM:
                this.satisfactionLevel = Level.LOW;
                return;
            case LOW:
                this.satisfactionLevel = Level.ZERO;
                return;
            case ZERO:
                throw new BeyondLevelRangeException();
        }
    }

    private void increaseSatisfactionLevel() {
        switch (this.satisfactionLevel) {
            case HIGH:
                throw new BeyondLevelRangeException();
            case MEDIUM:
                this.satisfactionLevel = Level.HIGH;
                return;
            case LOW:
                this.satisfactionLevel = Level.MEDIUM;
                return;
            case ZERO:
                this.satisfactionLevel = Level.LOW;
        }
    }

}

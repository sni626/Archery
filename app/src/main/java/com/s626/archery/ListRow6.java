package com.s626.archery;

/**
 * Created by 626 on 31.05.2015.
 */
public class ListRow6 {
    String firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow, sixthArrow, allTotal, rowTotal;

    ListRow6(String firstArrow, String secondArrow, String thirdArrow,
             String fourthArrow, String fifthArrow, String sixthArrow,
             String allTotal) {
        this.firstArrow = firstArrow;
        this.secondArrow = secondArrow;
        this.thirdArrow = thirdArrow;
        this.fourthArrow = fourthArrow;
        this.fifthArrow = fifthArrow;
        this.sixthArrow = sixthArrow;
        this.rowTotal = String.valueOf(Integer.parseInt(firstArrow) + Integer.parseInt(secondArrow) + Integer.parseInt(thirdArrow) +
                Integer.parseInt(fourthArrow) + Integer.parseInt(fifthArrow) + Integer.parseInt(sixthArrow));
        this.allTotal = allTotal;
    }

    ListRow6(String[] arrows) {
        this.firstArrow = arrows[0];
        this.secondArrow = arrows[1];
        this.thirdArrow = arrows[2];
        this.fourthArrow = arrows[3];
        this.fifthArrow = arrows[4];
        this.sixthArrow = arrows[5];
        this.rowTotal = String.valueOf(Integer.parseInt(firstArrow) + Integer.parseInt(secondArrow) + Integer.parseInt(thirdArrow) +
                Integer.parseInt(fourthArrow) + Integer.parseInt(fifthArrow) + Integer.parseInt(sixthArrow));
        this.allTotal = arrows[6];
    }
}

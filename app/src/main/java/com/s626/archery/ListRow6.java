package com.s626.archery;

public class ListRow6 {
    String firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow, sixthArrow, allTotal, rowTotal;

   ListRow6(String[] arrows) {
        this.firstArrow = arrows[0];
        this.secondArrow = arrows[1];
        this.thirdArrow = arrows[2];
        this.fourthArrow = arrows[3];
        this.fifthArrow = arrows[4];
        this.sixthArrow = arrows[5];
        if (this.firstArrow != " ")
        this.rowTotal = String.valueOf(Integer.parseInt(firstArrow) + Integer.parseInt(secondArrow) + Integer.parseInt(thirdArrow) +
                Integer.parseInt(fourthArrow) + Integer.parseInt(fifthArrow) + Integer.parseInt(sixthArrow));
                else
        this.rowTotal="";
        this.allTotal = arrows[6];
    }

    public String[] getFullArray (){
       String[] arrowArray= {firstArrow, secondArrow, thirdArrow, fourthArrow, fifthArrow, sixthArrow, allTotal};
        return arrowArray;
    }


}

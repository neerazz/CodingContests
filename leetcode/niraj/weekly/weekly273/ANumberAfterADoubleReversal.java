package weekly.weekly273;

import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 25, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-273/problems/a-number-after-a-double-reversal/
 */

public class ANumberAfterADoubleReversal {

    public static void main(String[] args) {

    }

    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }

}

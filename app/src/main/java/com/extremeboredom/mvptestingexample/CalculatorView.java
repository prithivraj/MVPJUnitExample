/*
 * $Id$
 * 19/05/16
 */
package com.extremeboredom.mvptestingexample;

public interface CalculatorView {
    int getNumB();
    void showError(int resId);
    int getNumA();
    void showResult(float i);
}

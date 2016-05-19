/*
 * $Id$
 * 18/05/16
 */
package com.extremeboredom.mvptestingexample;

public class MathPresenter {
    private final CalculatorView calculatorView;
    private final MathService mathService;

    public MathPresenter(CalculatorView calculatorView, MathService mathService) {
        this.calculatorView = calculatorView;
        this.mathService = mathService;
    }

    public void onSubmitClicked() {
        int numA = calculatorView.getNumA();
        int numB = calculatorView.getNumB();
        if(numB == 0){
            calculatorView.showError(R.string.divide_by_zero);
        }
        float quotient = MathService.divide(numA, numB);
        calculatorView.showResult(quotient);
    }
}

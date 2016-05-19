package com.extremeboredom.mvptestingexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/*
 * $Id$
 * 19/05/16
 */
@RunWith(MockitoJUnitRunner.class)
public class MathPresenterTest {
    @Mock
    private CalculatorView view;
    @Mock
    private MathService service;
    private MathPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MathPresenter(view, service);
    }

    @Test
    public void testDivideByZero() throws Exception {
        Mockito.when(view.getNumB()).thenReturn(0);
        presenter.onSubmitClicked();
        Mockito.verify(view).showError(R.string.divide_by_zero);
    }

    @Test
    public void testDivide() throws Exception {
        Mockito.when(view.getNumB()).thenReturn(2);
        Mockito.when(view.getNumA()).thenReturn(10);
        //Mockito.when(service.divide(10, 2)).thenReturn(3f);
        presenter.onSubmitClicked();
        Mockito.verify(view).showResult(5);
    }
}
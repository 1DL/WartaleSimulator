/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author LuizV1
 */
public class FiltroTexto extends DocumentFilter {
    
    public static void limitarTexto(JTextField txt, int maxSize) {
        txt.validate();
        if (txt.getText().length() > maxSize) {
            txt.setText(txt.getText().substring(0,(maxSize)));
        }
    }
    
    @Override
    public void insertString(FilterBypass fb, int offset, String text, 
            AttributeSet attr) throws BadLocationException {
        super.insertString(fb, offset, revise(text), attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {
        super.replace(fb, offset, length, revise(text), attrs);
    }
    
    

    private String revise(String text) {
        StringBuilder builder = new StringBuilder(text);
        builder.setLength(4);
        int index = 0;
        while (index < builder.length()) {
            if (accept(builder.charAt(index))) {
                index++;
            } else {
                // Don't increment index here, or you'll skip the next character!
                builder.deleteCharAt(index);
            }
        }
        return builder.toString();
    }

    /**
     * Determine if the character should remain in the String. You may
     * override this to get any matching criteria you want. 
     * @param c The character in question
     * @return true if it's valid, false if it should be removed.
     */
    public boolean accept(final char c) {
        return Character.isDigit(c);
    }
}
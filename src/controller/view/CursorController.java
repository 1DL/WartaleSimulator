/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author Luiz
 */
public class CursorController {

    public Cursor getDefaultCursor() {
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage(this.getClass().getResource("/assets/cursor/default.png"));
        Point point = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(img, point, "Cursor");

        return cursor;
    }
}

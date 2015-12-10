/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Graphics;
import java.util.Stack;

/**
 *
 * @author Heba
 */
public class Stacks {

    public static Stack undo;
    public static Stack redo;

    public Stacks() {
    }

    public static void undo(Graphics g) {
        redo.add(undo.pop());
    }

    public static void redo(Graphics g) {
        undo.add(redo.pop());
    }

    public static void addToStacks(Graphics g) {
        undo.add(g);
        redo.add(g);
    }
    
}

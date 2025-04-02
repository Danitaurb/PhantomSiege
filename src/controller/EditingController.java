package controller;

import view.scenes.Editing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EditingController implements MouseListener, MouseMotionListener {
    private final Editing editing;

    public EditingController(Editing editing) {
        this.editing = editing;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (x >= 1024) {
            editing.getToolBar().mouseClicked(x, y);
        } else {
            editing.changeTile(x, y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (x >= 1024) {
            editing.getToolBar().mouseMoved(x, y);
            editing.setDrawSelect(false);
        } else {
            editing.setDrawSelect(true);
            editing.setMousePosition((x / 32) * 32, (y / 32) * 32);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handle mouse press events here
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Handle mouse release events here
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (x >= 1024) {
            // Handle dragging in the toolbar
        } else {
            editing.changeTile(x, y);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

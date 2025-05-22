package com.example;

import static org.lwjgl.opengl.GL11.*;

public class Block {
    private float x, y, width, height;

    public Block(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(float r, float g, float b) {
        glColor3f(r, g, b);
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + height);
        glEnd();
    }

    public boolean collidesWith(float px, float py, float pw, float ph) {
        return px + pw > x && px < x + width &&
               py + ph > y && py < y + height;
    }
}

package com.example;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Player {
    private float x, y, width, height, speed;
    private long window;

    public Player(float x, float y, float width, float height, float speed, long window) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.window = window;
    }

    public void update(Block block) {
        float nextX = x;
        float nextY = y;

        if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) nextY += speed;
        if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS) nextY -= speed;
        if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS) nextX -= speed;
        if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS) nextX += speed;

        if (!block.collidesWith(nextX, nextY, width, height)) {
            x = nextX;
            y = nextY;
        }
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
}

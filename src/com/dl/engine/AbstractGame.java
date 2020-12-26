/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine;

/**
 *
 * @author Luiz
 */
public abstract class AbstractGame {
    public abstract void init(GameEngine ge);
    public abstract void update(GameEngine ge, float dt);
    public abstract void render(GameEngine ge, Renderer r);
}

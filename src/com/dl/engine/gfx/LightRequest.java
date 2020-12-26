/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.gfx;

/**
 *
 * @author Luiz
 */
public class LightRequest
{
    public Light light;
    public int locX, locY;
    
    public LightRequest(Light light, int locX, int locY)
    {
        this.light = light;
        this.locX = locX;
        this.locY = locY;
    }
}

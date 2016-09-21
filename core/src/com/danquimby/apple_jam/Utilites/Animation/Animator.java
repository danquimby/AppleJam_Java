package com.danquimby.apple_jam.Utilites.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * Created by Quimby on 21.09.2016.
 */

public class Animator {

    Animation animation;
    Texture texture;
    ArrayList<TextureRegion> frames;
    //TextureRegion[] frames;
    ArrayList<FrameDimension> frameDimensions;
    int row,col;
    int frameCount;
    private TextureRegion currentFrame;

    public Animator(int frameCount) {
        this.frameCount= frameCount;
        frames = new ArrayList<TextureRegion>(row*col);
        frameDimensions = new ArrayList<FrameDimension>(row*col);
    }

    public Animator() {
        // TODO Auto-generated constructor stub
    }

    private Animation createAnimation(String pathToSpriteSheet,float frameTransition) {
        texture = new Texture(Gdx.files.internal(pathToSpriteSheet));
        int x1 = 0,y1 = 0,width1 = 0,height1 = 0;
        try {
            for(int i=0;i < frameCount;i++) {
                x1=frameDimensions.get(i).getX();
                y1=frameDimensions.get(i).getY();
                width1=frameDimensions.get(i).getWidth();
                height1=frameDimensions.get(i).getHeight();
                frames.add(i,new TextureRegion(texture,x1,y1,width1,height1));
            }
        }
        catch(NullPointerException e) {
            System.out.println("ERROR:trying to create Animation without filling up frameDimensions.");
            System.out.println("use addFrameDimension() or addCoOrdinates() to fill up frameDimensions");
        }
        System.out.println(x1+"-"+y1+"-"+width1+"-"+height1);
        animation = new Animation(frameTransition, (TextureRegion[]) frames.toArray());
        return animation;
    }
    public void addFrameDimesion(int frameIndex,int x,int y,int width,int height) {
        FrameDimension frameDimension = new FrameDimension(x,y,width,height);
        frameDimensions.add(frameIndex, frameDimension);
    }
    public void addFrameCoOrdinates(int frameIndex,int x,int y) {
        frameDimensions.get(frameIndex).setX(x);
        frameDimensions.get(frameIndex).setY(y);
    }
    public void setAllFramesDimension(int width,int height) {
        for(int i=0;i<row*col;i++) {
            frameDimensions.get(i).setWidth(width);
            frameDimensions.get(i).setHeight(height);
        }
    }
    public void render(SpriteBatch batch, int x, int y, float stateTime) {
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame =animation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame,x,y);
    }
}

package com.petlisky.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameScene extends SurfaceView {

	private GameThread mThread; // object of class GameThread

	private boolean running = false; // start drawing thread


	public class GameThread extends Thread {

		private GameScene view; // object of class GameView

		public GameThread(GameScene view) { // class constructor
	          this.view = view;
	    }

	    public void setRunning(boolean run) { // thread state
	          running = run;
	    }

	    public void run() { // actions performed in a thread

	    	while (running) {

	    		Canvas canvas = null;

	            try {

	                canvas = view.getHolder().lockCanvas();
	                synchronized (view.getHolder()) {
	                    onDraw(canvas); // drawing
	                }

	            }

	            catch (Exception e) { }

	            finally {

	            	if (canvas != null) {
	            		view.getHolder().unlockCanvasAndPost(canvas);
	            	}	

	            }

	    	}

	    }

	}

	public GameScene(Context context) {
		super(context);
		
		mThread = new GameThread(this);

        getHolder().addCallback(new SurfaceHolder.Callback() { //drawing all objects

        	public void surfaceDestroyed(SurfaceHolder holder) { // surface destroyed

        		boolean retry = true;

            	mThread.setRunning(false);

            	while (retry) {

            	    try {

            	        mThread.join(); // thread termination
            	        retry = false;

            	    }

            	    catch (InterruptedException e) { }

            	}

        	}

        	public void surfaceCreated(SurfaceHolder holder) { // surface created
        		mThread.setRunning(true);
            	mThread.start();
        	}

            	  

            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { // surface changed

            }

        });

	}

	protected void onDraw(Canvas canvas) { // drawing function
		canvas.drawColor(Color.WHITE); // white background
	}    	

}
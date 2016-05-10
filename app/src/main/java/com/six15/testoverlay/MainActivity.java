package com.six15.testoverlay;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView sv;
    private SurfaceView ov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv = (GLSurfaceView) findViewById(R.id.glSurfaceView);

        sv.setRenderer(new GLRenderer());

        ov = (SurfaceView)findViewById(R.id.ovSurface);
        ov.setZOrderMediaOverlay(true);
        SurfaceHolder sfhTrackHolder = ov.getHolder();
        sfhTrackHolder.setFormat(PixelFormat.TRANSPARENT);
    }

    public void drawCircle(View view) {
        SurfaceHolder holder = ov.getHolder();
        Canvas c = holder.lockCanvas();
        int x = c.getWidth();
        int y = c.getHeight();
        int radius;
        radius = 100;
        Paint paint = new Paint();
        paint.setColor(Color.TRANSPARENT);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        c.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.WHITE);
        c.drawCircle(x / 2, y / 2, radius, paint);
        holder.unlockCanvasAndPost(c);

    }
}

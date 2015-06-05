package com.s626.archery;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class TargetActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        // drawTarget();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_target, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        drawTarget();
    }


    public void drawTarget() {

        final RelativeLayout ll = (RelativeLayout) findViewById(R.id.rect);

        //We draw everything from inside this, because it`s impossible to get width\height of a View otherwise
        ll.post(new Runnable() {
            public void run() {
                int height = ll.getMeasuredHeight();
                int width = ll.getMeasuredWidth();

                //Check screen orientation
                float targetCenter;
                if (width < height) {
                    targetCenter = width / 2;
                } else {
                    targetCenter = height / 2;
                }

                Paint paint = new Paint();
                paint.setAntiAlias(true);

                Paint outlinePaint = new Paint();
                outlinePaint.setAntiAlias(true);
                outlinePaint.setStyle(Paint.Style.STROKE);
                outlinePaint.setStrokeWidth(2);
                outlinePaint.setColor(Color.BLACK);

                Bitmap bg = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bg);

                //Draw the 6 circle
                paint.setColor(Color.parseColor("#0193DC"));
                float radius = targetCenter - 20;
                canvas.drawCircle(targetCenter, targetCenter, radius, paint);
                canvas.drawCircle(targetCenter, targetCenter, radius, outlinePaint);

                //Draw the 7 circle
                paint.setColor(Color.parseColor("#D9271B"));
                radius = (float) (radius * 0.8);
                canvas.drawCircle(targetCenter, targetCenter, radius, paint);
                canvas.drawCircle(targetCenter, targetCenter, radius, outlinePaint);

                //Draw the 8 circle
                canvas.drawCircle(targetCenter, targetCenter, (float) (radius * 0.75), outlinePaint);

                //Draw the 9 circle
                paint.setColor(Color.parseColor("#FFF701"));
                radius = (float) (radius * 0.5);
                canvas.drawCircle(targetCenter, targetCenter, radius, paint);
                canvas.drawCircle(targetCenter, targetCenter, radius, outlinePaint);

                //Draw the 10 circle
                canvas.drawCircle(targetCenter, targetCenter, (float) (radius * 0.5), outlinePaint);

                outlinePaint.setStrokeWidth(1);
                //Draw the X circle
                canvas.drawCircle(targetCenter, targetCenter, (float) (radius * 0.25), outlinePaint);
                float crossStart = targetCenter - (int) (radius * 0.05);
                float crossFinish = targetCenter + (int) (radius * 0.07); //Must be some format error
                outlinePaint.setAntiAlias(false);
                canvas.drawLine(crossStart, targetCenter, crossFinish, targetCenter, outlinePaint);
                canvas.drawLine(targetCenter, crossStart, targetCenter, crossFinish, outlinePaint);

                ll.setBackgroundDrawable(new BitmapDrawable(bg));
            }
        });
    }
}

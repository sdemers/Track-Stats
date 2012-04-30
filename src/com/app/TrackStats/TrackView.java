package com.app.TrackStats;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class TrackView extends View
{
	public TrackView(Context context)
	{
		super(context);
	}
	
	@Override protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		
		canvas.drawColor(Color.WHITE);
		
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.BLUE);
		
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(2);
		
		Path path = new Path();
		path.moveTo(0, getHeight() / 2);
		
		path.lineTo(getWidth() / 2, getHeight() / 3);
		
		canvas.drawPath(path, paint);
	}
}
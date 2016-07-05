package com.tutorial.lancer521.bluetoothdataexchange.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tutorial.lancer521.bluetoothdataexchange.R;

/**
 * @author Lancer521 on 6/29/2016 at 3:12 PM.
 * See https://developer.android.com/training/custom-views/create-view.html
 *
 * Custom views should also support event listeners to communicate important events.
 * For instance, PieChart exposes a custom event called OnCurrentItemChanged to notify
 * listeners that the user has rotated the pie chart to focus on a new pie slice.
 */
public class MessageTextView extends TextView {

  private boolean mFontLarge;
  private Paint mFontPaint;

  public MessageTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    // Reading directly from the AttributeSet is not recommended; instead use obtainStyledAttributes
    // https://developer.android.com/training/custom-views/create-view.html#applyattr
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MessageTextView, 0, 0);

    try{
      mFontLarge = attributes.getBoolean(R.styleable.MessageTextView_font_large, false);
    } finally {
      // Note that TypedArray objects are a shared resource and must be recycled after use.
      attributes.recycle();
    }
  }

  public boolean isFontLarge(){
    return mFontLarge;
  }

  public void setFontLarge(boolean fontLarge){
    mFontLarge = fontLarge;
    invalidate();
    requestLayout();
  }

  private void init(){
    mFontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mFontPaint.setTextSize(mFontLarge ? 24 : 12);
    // Creating objects ahead of time is an important optimization. Views are redrawn very frequently,
    // and many drawing objects require expensive initialization. Creating drawing objects within your
    // onDraw() method significantly reduces performance and can make your UI appear sluggish.
  }

  @Override
  public void onDraw(Canvas canvas){
    //Do drawing here
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);

    // The layout manager assumes that the size includes all of the view's padding.
    // You must handle the padding values when you calculate your view's size.
  }
}

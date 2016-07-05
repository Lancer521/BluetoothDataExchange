package com.tutorial.lancer521.bluetoothdataexchange.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;
import com.tutorial.lancer521.bluetoothdataexchange.R;

/**
 * @author Lancer521 on 7/5/2016 at 1:14 PM.
 */
public class TertiaryButton extends Button {

  private int padding;
  private int paddingTop;
  private int paddingBottom;
  private int paddingLeft;
  private int paddingRight;
  private Paint paddingPaint;

  public TertiaryButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    // Reading directly from the AttributeSet is not recommended; instead use obtainStyledAttributes
    // https://developer.android.com/training/custom-views/create-view.html#applyattr
    TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TertiaryButton, 0, 0);

    try{
      padding = attributes.getDimensionPixelSize(R.styleable.TertiaryButton_padding, -1);
      if(padding == -1) {
        paddingTop = attributes.getDimensionPixelSize(R.styleable.TertiaryButton_paddingTop, 10);
        paddingBottom = attributes.getDimensionPixelSize(R.styleable.TertiaryButton_paddingBottom, 10);
        paddingLeft = attributes.getDimensionPixelSize(R.styleable.TertiaryButton_paddingLeft, 10);
        paddingRight = attributes.getDimensionPixelSize(R.styleable.TertiaryButton_paddingRight, 10);
      } else {
        paddingTop = padding;
        paddingBottom = padding;
        paddingLeft = padding;
        paddingRight = padding;
      }
    } finally {
      setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
      // Note that TypedArray objects are a shared resource and must be recycled after use.
      attributes.recycle();
    }
  }
}

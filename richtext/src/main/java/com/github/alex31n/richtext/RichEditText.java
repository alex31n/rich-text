package com.github.alex31n.richtext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;


public class RichEditText extends AppCompatEditText {

	int borderWidth = 0;
	@ColorInt
	int borderColor = 0x000000;
	float radius = 0;

	@ColorInt
	int backgroundColor = 0x000000;
	//int backgroundColor = Color.GREEN;


	private int textColor = 0;

	public RichEditText(Context context) {
		super(context);

		initializeView();
	}

	public RichEditText(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);

		processAttributes(context, attrs);
		initializeView();
	}

	public RichEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		processAttributes(context, attrs);
		initializeView();
	}

	private void processAttributes(final Context context, final AttributeSet attrs) {
		TypedArray attrsArray = context.obtainStyledAttributes(attrs, R.styleable.RichText, 0, 0);
		initAttributes(attrsArray);
		attrsArray.recycle();
	}

	private void initAttributes(TypedArray attrs) {

		radius = attrs.getDimension(R.styleable.RichEditText_rt_radius, radius);
		borderColor = attrs.getColor(R.styleable.RichEditText_rt_borderColor, borderColor);
		borderWidth = (int) attrs.getDimension(R.styleable.RichEditText_rt_borderWidth, borderWidth);
		backgroundColor = attrs.getColor(R.styleable.RichEditText_rt_backgroundColor, backgroundColor);
		//Log.e("TAG", "backgroundColor "+ backgroundColor);

	}


	private void initializeView() {
		//storeDefaultValue();
		int pLeft = getPaddingLeft();
		int pRight = getPaddingRight();
		int pTop = getPaddingTop();
		int pBottom = getPaddingBottom();

		setupBackground();

		setPadding(pLeft+10,pTop-5,pRight+10,pBottom-5);
		//invalidate();
	}

	private void storeDefaultValue() {
		textColor = getCurrentTextColor();
	}


	private void setupBackground() {

		DrawableHelper helper = new DrawableHelper.Builder()
			  .setBackgroundColor(backgroundColor)
			  .setDisabledColor(0)
			  .setBorderWidth(borderWidth)
			  .setBorderColor(borderColor)
			  .setDisabledBorderColor(0)
			  .setRadius((int) radius)
			  .setEnabled(true)
			  .build();
		helper.setBackground(this);

	}


	public void setBorderWidth(int borderWidth){
		this.borderWidth = borderWidth;
		setupBackground();
	}
	public int getBorderWidth() {
		return borderWidth;
	}


	public void setBorderColor(int color) {
		this.borderColor = color;
		setupBackground();
	}

	public int getBorderColor() {
		return this.borderColor;
	}


	public void setRadius(float size) {
		this.radius = size;
		setupBackground();
	}

	public float getRadius() {
		return radius;
	}

	public void setBackgroundColor(int color) {
		this.backgroundColor = color;
		setupBackground();
	}

	public int getBackgroundColor() {
		return this.backgroundColor;
	}




}

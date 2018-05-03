package com.ornach.richtext;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.view.View;


public class DrawableHelper {


	Builder mBuilder;

	public DrawableHelper(Builder mBuilder) {
		this.mBuilder = mBuilder;
	}

	public static class Builder {
		public int radius = 0;
		public int borderWidth = 0;
		@ColorInt
		public int borderColor = 0;
		public int disabledBorderColor = 0xFFDDDDDD;
		@ColorInt
		public int backgroundColor = 0;

		@ColorInt
		public int disabledColor = 0xFFE5E4E4;

		public boolean isEnabled = true;

		public int getRadius() {
			return radius;
		}

		public Builder setRadius(int radius) {
			this.radius = radius;
			return this;
		}

		public int getBorderWidth() {
			return borderWidth;
		}

		public Builder setBorderWidth(int borderWidth) {
			this.borderWidth = borderWidth;
			return this;
		}

		public int getBackgroundColor() {
			return backgroundColor;
		}

		public Builder setBackgroundColor(int backgroundColor) {
			this.backgroundColor = backgroundColor;
			return this;
		}

		public int getDisabledColor() {
			return disabledColor;
		}

		public Builder setDisabledColor(int disabledColor) {
			this.disabledColor = disabledColor;
			return this;
		}

		public int getBorderColor() {
			return borderColor;

		}

		public Builder setBorderColor(int borderColor) {
			this.borderColor = borderColor;
			return this;
		}

		public int getDisabledBorderColor() {
			return disabledBorderColor;
		}

		public Builder setDisabledBorderColor(int disabledBorderColor) {
			this.disabledBorderColor = disabledBorderColor;
			return this;
		}

		public boolean isEnabled() {
			return isEnabled;
		}

		public Builder setEnabled(boolean enabled) {
			isEnabled = enabled;
			return this;
		}

		public DrawableHelper build() {
			return new DrawableHelper(this);
		}

	}

	private Drawable setupBackground() {

		Drawable drawable = null;

		// Default Drawable
		GradientDrawable defaultDrawable = new GradientDrawable();
		defaultDrawable.setCornerRadius(mBuilder.radius);

		defaultDrawable.setColor(mBuilder.isEnabled() ? mBuilder.getBackgroundColor() : mBuilder.getDisabledColor());


		/*(mBuilder.borderColor != 0 || mBuilder.getDisabledBorderColor()!=0) &&*/
		if (mBuilder.borderWidth > 0) {
			//Log.e("TAG", mBuilder.isEnabled() +"");
			int bColor = mBuilder.isEnabled() ? mBuilder.getBorderColor() : mBuilder.getDisabledBorderColor();
			defaultDrawable.setStroke(mBuilder.borderWidth, bColor);
		}

		StateListDrawable states = new StateListDrawable();
		states.addState(new int[]{}, defaultDrawable);

		drawable = states;

		return drawable;

	}


	public void setBackground(View view) {
		Drawable drawable = setupBackground();

		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
			view.setBackgroundDrawable(drawable);
		} else {
			view.setBackground(drawable);
		}
	}



}

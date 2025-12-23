package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    public void setCardBackgroundColor(@ColorInt int i6) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(i6));
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.cardViewStyle);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (IMPL instanceof CardViewApi21Impl) {
            super.onMeasure(i6, i7);
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(i6)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i7 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(i7)), mode2);
        }
        super.onMeasure(i6, i7);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public void setCardElevation(float f6) {
        IMPL.setElevation(this.mCardViewDelegate, f6);
    }

    public void setContentPadding(@Px int i6, @Px int i7, @Px int i8, @Px int i9) {
        this.mContentPadding.set(i6, i7, i8, i9);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f6) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f6);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i6) {
        this.mUserSetMinHeight = i6;
        super.setMinimumHeight(i6);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i6) {
        this.mUserSetMinWidth = i6;
        super.setMinimumWidth(i6);
    }

    public void setPreventCornerOverlap(boolean z5) {
        if (z5 != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z5;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f6) {
        IMPL.setRadius(this.mCardViewDelegate, f6);
    }

    public void setUseCompatPadding(boolean z5) {
        if (this.mCompatPadding != z5) {
            this.mCompatPadding = z5;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }

    static {
        CardViewApi21Impl cardViewApi21Impl = new CardViewApi21Impl();
        IMPL = cardViewApi21Impl;
        cardViewApi21Impl.initStatic();
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        CardViewDelegate cardViewDelegate = new CardViewDelegate() { // from class: androidx.cardview.widget.CardView.1
            private Drawable mCardBackground;

            @Override // androidx.cardview.widget.CardViewDelegate
            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public View getCardView() {
                return CardView.this;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean getUseCompatPadding() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setMinWidthHeightInternal(int i7, int i8) {
                CardView cardView = CardView.this;
                if (i7 > cardView.mUserSetMinWidth) {
                    CardView.super.setMinimumWidth(i7);
                }
                CardView cardView2 = CardView.this;
                if (i8 > cardView2.mUserSetMinHeight) {
                    CardView.super.setMinimumHeight(i8);
                }
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setShadowPadding(int i7, int i8, int i9, int i10) {
                CardView.this.mShadowBounds.set(i7, i8, i9, i10);
                CardView cardView = CardView.this;
                Rect rect2 = cardView.mContentPadding;
                CardView.super.setPadding(i7 + rect2.left, i8 + rect2.top, i9 + rect2.right, i10 + rect2.bottom);
            }
        };
        this.mCardViewDelegate = cardViewDelegate;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, i6, androidx.cardview.R.style.CardView);
        int i7 = androidx.cardview.R.styleable.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i7)) {
            valueOf = obtainStyledAttributes.getColorStateList(i7);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(androidx.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(androidx.cardview.R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f6 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        IMPL.initialize(cardViewDelegate, context, colorStateList, dimension, dimension2, f6);
    }

    @Override // android.view.View
    public void setPadding(int i6, int i7, int i8, int i9) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i6, int i7, int i8, int i9) {
    }
}

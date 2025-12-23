package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(@NonNull Context context) {
        this(context, null);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mTabPaint = paint;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int i6 = this.mTextColor;
        this.mIndicatorColor = i6;
        paint.setColor(i6);
        float f6 = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * f6) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * f6) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * f6);
        this.mTabPadding = (int) ((16.0f * f6) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * f6) + 0.5f);
        this.mMinStripHeight = (int) ((f6 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.mPager.setCurrentItem(r2.getCurrentItem() - 1);
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.mPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    public void setDrawFullUnderline(boolean z5) {
        this.mDrawFullUnderline = z5;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i6, int i7, int i8, int i9) {
        int i10 = this.mMinPaddingBottom;
        if (i9 < i10) {
            i9 = i10;
        }
        super.setPadding(i6, i7, i8, i9);
    }

    public void setTabIndicatorColor(@ColorInt int i6) {
        this.mIndicatorColor = i6;
        this.mTabPaint.setColor(i6);
        invalidate();
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i6) {
        int i7 = this.mMinTextSpacing;
        if (i6 < i7) {
            i6 = i7;
        }
        super.setTextSpacing(i6);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void updateTextPositions(int i6, float f6, boolean z5) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        int i7 = height - this.mIndicatorHeight;
        rect.set(left, i7, right, height);
        super.updateTextPositions(i6, f6, z5);
        this.mTabAlpha = (int) (Math.abs(f6 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.mCurrText.getLeft() - this.mTabPadding, i7, this.mCurrText.getRight() + this.mTabPadding, height);
        invalidate(rect);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        int i6 = height - this.mIndicatorHeight;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & 16777215));
        float f6 = height;
        canvas.drawRect(left, i6, right, f6, this.mTabPaint);
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor((this.mIndicatorColor & 16777215) | ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect(getPaddingLeft(), height - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), f6, this.mTabPaint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.mIgnoreTap) {
            return false;
        }
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (Math.abs(x5 - this.mInitialMotionX) > this.mTouchSlop || Math.abs(y5 - this.mInitialMotionY) > this.mTouchSlop)) {
                    this.mIgnoreTap = true;
                }
            } else if (x5 < this.mCurrText.getLeft() - this.mTabPadding) {
                ViewPager viewPager = this.mPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            } else if (x5 > this.mCurrText.getRight() + this.mTabPadding) {
                ViewPager viewPager2 = this.mPager;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else {
            this.mInitialMotionX = x5;
            this.mInitialMotionY = y5;
            this.mIgnoreTap = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i6) {
        boolean z5;
        super.setBackgroundColor(i6);
        if (!this.mDrawFullUnderlineSet) {
            if ((i6 & ViewCompat.MEASURED_STATE_MASK) == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.mDrawFullUnderline = z5;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        boolean z5;
        super.setBackgroundDrawable(drawable);
        if (!this.mDrawFullUnderlineSet) {
            if (drawable == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.mDrawFullUnderline = z5;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i6) {
        boolean z5;
        super.setBackgroundResource(i6);
        if (!this.mDrawFullUnderlineSet) {
            if (i6 == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.mDrawFullUnderline = z5;
        }
    }

    public void setTabIndicatorColorResource(@ColorRes int i6) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i6));
    }
}

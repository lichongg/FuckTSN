package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.R;
import java.math.BigDecimal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RatingBar extends LinearLayout {
    private boolean mClickable;
    private OnRatingChangeListener onRatingChangeListener;
    private int starCount;
    private Drawable starEmptyDrawable;
    private Drawable starFillDrawable;
    private Drawable starHalfDrawable;
    private float starImageSize;
    private float starPadding;
    private float starStep;
    private StepSize stepSize;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnRatingChangeListener {
        void onRatingChange(float f6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum StepSize {
        Half(0),
        Full(1);

        int step;

        StepSize(int i6) {
            this.step = i6;
        }

        public static StepSize fromStep(int i6) {
            for (StepSize stepSize : values()) {
                if (stepSize.step == i6) {
                    return stepSize;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Math.round(this.starImageSize), Math.round(this.starImageSize));
        layoutParams.setMargins(0, 0, Math.round(this.starPadding), 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageDrawable(this.starEmptyDrawable);
        imageView.setMinimumWidth(10);
        imageView.setMaxHeight(10);
        return imageView;
    }

    @Override // android.view.View
    public void setClickable(boolean z5) {
        this.mClickable = z5;
    }

    public void setOnRatingChangeListener(OnRatingChangeListener onRatingChangeListener) {
        this.onRatingChangeListener = onRatingChangeListener;
    }

    public void setStar(float f6) {
        OnRatingChangeListener onRatingChangeListener = this.onRatingChangeListener;
        if (onRatingChangeListener != null) {
            onRatingChangeListener.onRatingChange(f6);
        }
        this.starStep = f6;
        int i6 = (int) f6;
        float floatValue = new BigDecimal(Float.toString(f6)).subtract(new BigDecimal(Integer.toString(i6))).floatValue();
        for (int i7 = 0; i7 < i6; i7++) {
            ((ImageView) getChildAt(i7)).setImageDrawable(this.starFillDrawable);
        }
        for (int i8 = i6; i8 < this.starCount; i8++) {
            ((ImageView) getChildAt(i8)).setImageDrawable(this.starEmptyDrawable);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i6)).setImageDrawable(this.starHalfDrawable);
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.starEmptyDrawable = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.starFillDrawable = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.starHalfDrawable = drawable;
    }

    public void setStarImageSize(float f6) {
        this.starImageSize = f6;
    }

    public void setStepSize(StepSize stepSize) {
        this.stepSize = stepSize;
    }

    public RatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatingBar);
        this.starImageSize = obtainStyledAttributes.getDimension(R.styleable.RatingBar_starImageSize, 20.0f);
        this.starPadding = obtainStyledAttributes.getDimension(R.styleable.RatingBar_starPadding, 10.0f);
        this.starStep = obtainStyledAttributes.getFloat(R.styleable.RatingBar_starStep, 1.0f);
        this.stepSize = StepSize.fromStep(obtainStyledAttributes.getInt(R.styleable.RatingBar_stepSize, 1));
        this.starCount = obtainStyledAttributes.getInteger(R.styleable.RatingBar_starCount, 5);
        this.starEmptyDrawable = obtainStyledAttributes.getDrawable(R.styleable.RatingBar_starEmpty);
        this.starFillDrawable = obtainStyledAttributes.getDrawable(R.styleable.RatingBar_starFill);
        this.starHalfDrawable = obtainStyledAttributes.getDrawable(R.styleable.RatingBar_starHalf);
        this.mClickable = obtainStyledAttributes.getBoolean(R.styleable.RatingBar_clickable, true);
        obtainStyledAttributes.recycle();
        for (int i6 = 0; i6 < this.starCount; i6++) {
            final ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(this.starEmptyDrawable);
            starImageView.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.RatingBar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RatingBar.this.mClickable) {
                        int i7 = (int) RatingBar.this.starStep;
                        if (new BigDecimal(Float.toString(RatingBar.this.starStep)).subtract(new BigDecimal(Integer.toString(i7))).floatValue() == 0.0f) {
                            i7--;
                        }
                        if (RatingBar.this.indexOfChild(view) > i7) {
                            RatingBar.this.setStar(r0.indexOfChild(view) + 1);
                            return;
                        }
                        if (RatingBar.this.indexOfChild(view) != i7) {
                            RatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        } else {
                            if (RatingBar.this.stepSize == StepSize.Full) {
                                return;
                            }
                            if (starImageView.getDrawable().getCurrent().getConstantState().equals(RatingBar.this.starHalfDrawable.getConstantState())) {
                                RatingBar.this.setStar(r0.indexOfChild(view) + 1);
                            } else {
                                RatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                            }
                        }
                    }
                }
            });
            addView(starImageView);
        }
        setStar(this.starStep);
    }
}

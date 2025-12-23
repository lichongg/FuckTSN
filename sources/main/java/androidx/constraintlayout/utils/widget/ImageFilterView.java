package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ImageFilterView extends AppCompatImageView {
    private float mCrossfade;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ImageMatrix {

        /* renamed from: m, reason: collision with root package name */
        float[] f815m = new float[20];
        ColorMatrix mColorMatrix = new ColorMatrix();
        ColorMatrix mTmpColorMatrix = new ColorMatrix();
        float mBrightness = 1.0f;
        float mSaturation = 1.0f;
        float mContrast = 1.0f;
        float mWarmth = 1.0f;

        private void warmth(float f6) {
            float log;
            float f7;
            if (f6 <= 0.0f) {
                f6 = 0.01f;
            }
            float f8 = (5000.0f / f6) / 100.0f;
            if (f8 > 66.0f) {
                double d6 = f8 - 60.0f;
                f7 = ((float) Math.pow(d6, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d6, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f8)) * 99.4708f) - 161.11957f;
                f7 = 255.0f;
            }
            float log2 = f8 < 66.0f ? f8 > 19.0f ? (((float) Math.log(f8 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f7, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log2, 0.0f));
            float log3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float log4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max(log3, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max(log4, 0.0f));
            float[] fArr = this.f815m;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void brightness(float f6) {
            float[] fArr = this.f815m;
            fArr[0] = f6;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f6;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void saturation(float f6) {
            float f7 = 1.0f - f6;
            float f8 = 0.2999f * f7;
            float f9 = 0.587f * f7;
            float f10 = f7 * 0.114f;
            float[] fArr = this.f815m;
            fArr[0] = f8 + f6;
            fArr[1] = f9;
            fArr[2] = f10;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f8;
            fArr[6] = f9 + f6;
            fArr[7] = f10;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f8;
            fArr[11] = f9;
            fArr[12] = f10 + f6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        void updateMatrix(ImageView imageView) {
            boolean z5;
            this.mColorMatrix.reset();
            float f6 = this.mSaturation;
            boolean z6 = true;
            if (f6 != 1.0f) {
                saturation(f6);
                this.mColorMatrix.set(this.f815m);
                z5 = true;
            } else {
                z5 = false;
            }
            float f7 = this.mContrast;
            if (f7 != 1.0f) {
                this.mTmpColorMatrix.setScale(f7, f7, f7, 1.0f);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z5 = true;
            }
            float f8 = this.mWarmth;
            if (f8 != 1.0f) {
                warmth(f8);
                this.mTmpColorMatrix.set(this.f815m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z5 = true;
            }
            float f9 = this.mBrightness;
            if (f9 != 1.0f) {
                brightness(f9);
                this.mTmpColorMatrix.set(this.f815m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            } else {
                z6 = z5;
            }
            if (z6) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            } else {
                imageView.clearColorFilter();
            }
        }

        ImageMatrix() {
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.mLayers = drawableArr;
                drawableArr[0] = getDrawable();
                this.mLayers[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
                this.mLayer = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
                super.setImageDrawable(this.mLayer);
            }
        }
    }

    private void setOverlay(boolean z5) {
        this.mOverlay = z5;
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public void setBrightness(float f6) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mBrightness = f6;
        imageMatrix.updateMatrix(this);
    }

    public void setContrast(float f6) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mContrast = f6;
        imageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float f6) {
        this.mCrossfade = f6;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f6) {
        boolean z5 = this.mRoundPercent != f6;
        this.mRoundPercent = f6;
        if (f6 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.mRoundPercent) / 2.0f);
                    }
                };
                this.mViewOutlineProvider = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f6) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mSaturation = f6;
        imageMatrix.updateMatrix(this);
    }

    public void setWarmth(float f6) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mWarmth = f6;
        imageMatrix.updateMatrix(this);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @RequiresApi(21)
    public void setRound(float f6) {
        boolean z5;
        if (Float.isNaN(f6)) {
            this.mRound = f6;
            float f7 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f7);
            return;
        }
        if (this.mRound != f6) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.mRound = f6;
        if (f6 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.mRound);
                    }
                };
                this.mViewOutlineProvider = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f8 = this.mRound;
            path.addRoundRect(rectF, f8, f8, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attributeSet);
    }
}

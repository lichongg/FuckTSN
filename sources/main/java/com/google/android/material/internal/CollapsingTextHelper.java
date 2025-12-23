package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private boolean boundsChanged;

    @NonNull
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    private Typeface collapsedTypefaceBold;
    private Typeface collapsedTypefaceDefault;

    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentLetterSpacing;
    private int currentOffsetY;
    private int currentShadowColor;
    private float currentShadowDx;
    private float currentShadowDy;
    private float currentShadowRadius;
    private float currentTextSize;
    private Typeface currentTypeface;

    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;

    @Nullable
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private Typeface expandedTypefaceBold;
    private Typeface expandedTypefaceDefault;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private boolean isRtl;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;

    @Nullable
    private StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer;

    @Nullable
    private CharSequence text;
    private StaticLayout textLayout;

    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;

    @Nullable
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;

    @NonNull
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;
    private static final boolean USE_SCALING_TEXTURE = false;

    @NonNull
    private static final Paint DEBUG_DRAW_PAINT = null;
    private int expandedTextGravity = 16;
    private int collapsedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    private float collapsedTextSize = 15.0f;
    private TextUtils.TruncateAt titleTextEllipsize = TextUtils.TruncateAt.END;
    private boolean isRtlTextDirectionHeuristicsEnabled = true;
    private int maxLines = 1;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private int hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;

    private void calculateUsingTextSize(float f6) {
        calculateUsingTextSize(f6, false);
    }

    private StaticLayout createStaticLayout(int i6, float f6, boolean z5) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) f6).setEllipsize(this.titleTextEllipsize).setIsRtl(z5).setAlignment(i6 == 1 ? Layout.Alignment.ALIGN_NORMAL : getMultilineTextLayoutAlignment()).setIncludePad(false).setMaxLines(i6).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).setStaticLayoutBuilderConfigurer(this.staticLayoutBuilderConfigurer).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e6) {
            e6.getCause().getMessage();
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private static boolean isClose(float f6, float f7) {
        return Math.abs(f6 - f7) < 1.0E-5f;
    }

    private float measureTextWidth(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedBounds(int i6, int i7, int i8, int i9) {
        if (rectEquals(this.collapsedBounds, i6, i7, i8, i9)) {
            return;
        }
        this.collapsedBounds.set(i6, i7, i8, i9);
        this.boundsChanged = true;
    }

    public void setExpandedBounds(int i6, int i7, int i8, int i9) {
        if (rectEquals(this.expandedBounds, i6, i7, i8, i9)) {
            return;
        }
        this.expandedBounds.set(i6, i7, i8, i9);
        this.boundsChanged = true;
    }

    public void setExpansionFraction(float f6) {
        float clamp = MathUtils.clamp(f6, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    @ColorInt
    private static int blendARGB(@ColorInt int i6, @ColorInt int i7, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        float f7 = 1.0f - f6;
        return Color.argb(Math.round((Color.alpha(i6) * f7) + (Color.alpha(i7) * f6)), Math.round((Color.red(i6) * f7) + (Color.red(i7) * f6)), Math.round((Color.green(i6) * f7) + (Color.green(i7) * f6)), Math.round((Color.blue(i6) * f7) + (Color.blue(i7) * f6)));
    }

    private void calculateBaseOffsets(boolean z5) {
        StaticLayout staticLayout;
        calculateUsingTextSize(1.0f, z5);
        CharSequence charSequence = this.textToDraw;
        if (charSequence != null && (staticLayout = this.textLayout) != null) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, staticLayout.getWidth(), this.titleTextEllipsize);
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        float f6 = 0.0f;
        if (charSequence2 != null) {
            this.collapsedTextWidth = measureTextWidth(this.textPaint, charSequence2);
        } else {
            this.collapsedTextWidth = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i6 = absoluteGravity & 112;
        if (i6 == 48) {
            this.collapsedDrawY = this.collapsedBounds.top;
        } else if (i6 != 80) {
            this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
        } else {
            this.collapsedDrawY = this.collapsedBounds.bottom + this.textPaint.ascent();
        }
        int i7 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i7 == 1) {
            this.collapsedDrawX = this.collapsedBounds.centerX() - (this.collapsedTextWidth / 2.0f);
        } else if (i7 != 5) {
            this.collapsedDrawX = this.collapsedBounds.left;
        } else {
            this.collapsedDrawX = this.collapsedBounds.right - this.collapsedTextWidth;
        }
        calculateUsingTextSize(0.0f, z5);
        float height = this.textLayout != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.textLayout;
        if (staticLayout2 == null || this.maxLines <= 1) {
            CharSequence charSequence3 = this.textToDraw;
            if (charSequence3 != null) {
                f6 = measureTextWidth(this.textPaint, charSequence3);
            }
        } else {
            f6 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.textLayout;
        this.expandedLineCount = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i8 = absoluteGravity2 & 112;
        if (i8 == 48) {
            this.expandedDrawY = this.expandedBounds.top;
        } else if (i8 != 80) {
            this.expandedDrawY = this.expandedBounds.centerY() - (height / 2.0f);
        } else {
            this.expandedDrawY = (this.expandedBounds.bottom - height) + this.textPaint.descent();
        }
        int i9 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i9 == 1) {
            this.expandedDrawX = this.expandedBounds.centerX() - (f6 / 2.0f);
        } else if (i9 != 5) {
            this.expandedDrawX = this.expandedBounds.left;
        } else {
            this.expandedDrawX = this.expandedBounds.right - f6;
        }
        clearTexture();
        setInterpolatedTextSize(this.expandedFraction);
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        float f7 = this.fadeModeThresholdFraction;
        return f6 <= f7 ? AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f7, f6) : AnimationUtils.lerp(0.0f, 1.0f, f7, 1.0f, f6);
    }

    private float calculateFadeModeThresholdFraction() {
        float f6 = this.fadeModeStartFraction;
        return f6 + ((1.0f - f6) * 0.5f);
    }

    private void calculateUsingTextSize(float f6, boolean z5) {
        float f7;
        float f8;
        Typeface typeface;
        if (this.text == null) {
            return;
        }
        float width = this.collapsedBounds.width();
        float width2 = this.expandedBounds.width();
        if (isClose(f6, 1.0f)) {
            f7 = this.collapsedTextSize;
            f8 = this.collapsedLetterSpacing;
            this.scale = 1.0f;
            typeface = this.collapsedTypeface;
        } else {
            float f9 = this.expandedTextSize;
            float f10 = this.expandedLetterSpacing;
            Typeface typeface2 = this.expandedTypeface;
            if (isClose(f6, 0.0f)) {
                this.scale = 1.0f;
            } else {
                this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, f6, this.textSizeInterpolator) / this.expandedTextSize;
            }
            float f11 = this.collapsedTextSize / this.expandedTextSize;
            width = (!z5 && width2 * f11 > width) ? Math.min(width / f11, width2) : width2;
            f7 = f9;
            f8 = f10;
            typeface = typeface2;
        }
        if (width > 0.0f) {
            boolean z6 = this.currentTextSize != f7;
            boolean z7 = this.currentLetterSpacing != f8;
            boolean z8 = this.currentTypeface != typeface;
            StaticLayout staticLayout = this.textLayout;
            boolean z9 = z6 || z7 || (staticLayout != null && (width > ((float) staticLayout.getWidth()) ? 1 : (width == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z8 || this.boundsChanged;
            this.currentTextSize = f7;
            this.currentLetterSpacing = f8;
            this.currentTypeface = typeface;
            this.boundsChanged = false;
            this.textPaint.setLinearText(this.scale != 1.0f);
            r5 = z9;
        }
        if (this.textToDraw == null || r5) {
            this.textPaint.setTextSize(this.currentTextSize);
            this.textPaint.setTypeface(this.currentTypeface);
            this.textPaint.setLetterSpacing(this.currentLetterSpacing);
            this.isRtl = calculateIsRtl(this.text);
            StaticLayout createStaticLayout = createStaticLayout(shouldDrawMultiline() ? this.maxLines : 1, width, this.isRtl);
            this.textLayout = createStaticLayout;
            this.textToDraw = createStaticLayout.getText();
        }
    }

    private void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    private void drawMultilineTransition(@NonNull Canvas canvas, float f6, float f7) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f6, f7);
        if (!this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (this.expandedTextBlend * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.textPaint;
                textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint.getAlpha()));
            }
            this.textLayout.draw(canvas);
        }
        if (!this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (this.collapsedTextBlend * alpha));
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 31) {
            TextPaint textPaint2 = this.textPaint;
            textPaint2.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint2.getAlpha()));
        }
        int lineBaseline = this.textLayout.getLineBaseline(0);
        CharSequence charSequence = this.textToDrawCollapsed;
        float f8 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f8, this.textPaint);
        if (i6 >= 31) {
            this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, this.currentShadowColor);
        }
        if (this.fadeModeEnabled) {
            return;
        }
        String trim = this.textToDrawCollapsed.toString().trim();
        if (trim.endsWith(ELLIPSIS_NORMAL)) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.textPaint.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f8, (Paint) this.textPaint);
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture != null || this.expandedBounds.isEmpty() || TextUtils.isEmpty(this.textToDraw)) {
            return;
        }
        calculateOffsets(0.0f);
        int width = this.textLayout.getWidth();
        int height = this.textLayout.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.expandedTitleTexture = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.textLayout.draw(new Canvas(this.expandedTitleTexture));
        if (this.texturePaint == null) {
            this.texturePaint = new Paint(3);
        }
    }

    private float getCollapsedTextLeftBound(int i6, int i7) {
        return (i7 == 17 || (i7 & 7) == 1) ? (i6 / 2.0f) - (this.collapsedTextWidth / 2.0f) : ((i7 & GravityCompat.END) == 8388613 || (i7 & 5) == 5) ? this.isRtl ? this.collapsedBounds.left : this.collapsedBounds.right - this.collapsedTextWidth : this.isRtl ? this.collapsedBounds.right - this.collapsedTextWidth : this.collapsedBounds.left;
    }

    private float getCollapsedTextRightBound(@NonNull RectF rectF, int i6, int i7) {
        return (i7 == 17 || (i7 & 7) == 1) ? (i6 / 2.0f) + (this.collapsedTextWidth / 2.0f) : ((i7 & GravityCompat.END) == 8388613 || (i7 & 5) == 5) ? this.isRtl ? rectF.left + this.collapsedTextWidth : this.collapsedBounds.right : this.isRtl ? this.collapsedBounds.right : rectF.left + this.collapsedTextWidth;
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private Layout.Alignment getMultilineTextLayoutAlignment() {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0) & 7;
        return absoluteGravity != 1 ? absoluteGravity != 5 ? this.isRtl ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.isRtl ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.collapsedTextSize);
        textPaint.setTypeface(this.collapsedTypeface);
        textPaint.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.expandedTextSize);
        textPaint.setTypeface(this.expandedTypeface);
        textPaint.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void interpolateBounds(float f6) {
        if (this.fadeModeEnabled) {
            this.currentBounds.set(f6 < this.fadeModeThresholdFraction ? this.expandedBounds : this.collapsedBounds);
            return;
        }
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, f6, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f6, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, f6, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, f6, this.positionInterpolator);
    }

    private boolean isDefaultIsRtl() {
        return ViewCompat.getLayoutDirection(this.view) == 1;
    }

    private boolean isTextDirectionHeuristicsIsRtl(@NonNull CharSequence charSequence, boolean z5) {
        return (z5 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private static float lerp(float f6, float f7, float f8, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f8 = timeInterpolator.getInterpolation(f8);
        }
        return AnimationUtils.lerp(f6, f7, f8);
    }

    private static boolean rectEquals(@NonNull Rect rect, int i6, int i7, int i8, int i9) {
        return rect.left == i6 && rect.top == i7 && rect.right == i8 && rect.bottom == i9;
    }

    private void setCollapsedTextBlend(float f6) {
        this.collapsedTextBlend = f6;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.collapsedTypefaceDefault == typeface) {
            return false;
        }
        this.collapsedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.collapsedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.collapsedTypefaceDefault;
        }
        this.collapsedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    private void setExpandedTextBlend(float f6) {
        this.expandedTextBlend = f6;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.expandedTypefaceDefault == typeface) {
            return false;
        }
        this.expandedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.expandedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.expandedTypefaceDefault;
        }
        this.expandedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    private boolean shouldDrawMultiline() {
        if (this.maxLines > 1) {
            return (!this.isRtl || this.fadeModeEnabled) && !this.useTexture;
        }
        return false;
    }

    public void getCollapsedTextActualBounds(@NonNull RectF rectF, int i6, int i7) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = Math.max(getCollapsedTextLeftBound(i6, i7), this.collapsedBounds.left);
        rectF.top = this.collapsedBounds.top;
        rectF.right = Math.min(getCollapsedTextRightBound(rectF, i6, i7), this.collapsedBounds.right);
        rectF.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.titleTextEllipsize;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.collapsedTextColor;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.expandedTextColor;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    public void maybeUpdateFontWeightAdjustment(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.collapsedTypefaceDefault;
            if (typeface != null) {
                this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface);
            }
            Typeface typeface2 = this.expandedTypefaceDefault;
            if (typeface2 != null) {
                this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface2);
            }
            Typeface typeface3 = this.collapsedTypefaceBold;
            if (typeface3 == null) {
                typeface3 = this.collapsedTypefaceDefault;
            }
            this.collapsedTypeface = typeface3;
            Typeface typeface4 = this.expandedTypefaceBold;
            if (typeface4 == null) {
                typeface4 = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = typeface4;
            recalculate(true);
        }
    }

    public void recalculate(boolean z5) {
        if ((this.view.getHeight() <= 0 || this.view.getWidth() <= 0) && !z5) {
            return;
        }
        calculateBaseOffsets(z5);
        calculateCurrentOffsets();
    }

    public void setCollapsedAndExpandedTextColor(@Nullable ColorStateList colorStateList) {
        if (this.collapsedTextColor == colorStateList && this.expandedTextColor == colorStateList) {
            return;
        }
        this.collapsedTextColor = colorStateList;
        this.expandedTextColor = colorStateList;
        recalculate();
    }

    public void setCollapsedTextAppearance(int i6) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i6);
        if (textAppearance.getTextColor() != null) {
            this.collapsedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.collapsedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.collapsedShadowColor = colorStateList;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        this.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i6) {
        if (this.collapsedTextGravity != i6) {
            this.collapsedTextGravity = i6;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f6) {
        if (this.collapsedTextSize != f6) {
            this.collapsedTextSize = f6;
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i6) {
        this.currentOffsetY = i6;
    }

    public void setExpandedLetterSpacing(float f6) {
        if (this.expandedLetterSpacing != f6) {
            this.expandedLetterSpacing = f6;
            recalculate();
        }
    }

    public void setExpandedTextAppearance(int i6) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i6);
        if (textAppearance.getTextColor() != null) {
            this.expandedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.expandedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.expandedShadowColor = colorStateList;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        this.expandedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i6) {
        if (this.expandedTextGravity != i6) {
            this.expandedTextGravity = i6;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f6) {
        if (this.expandedTextSize != f6) {
            this.expandedTextSize = f6;
            recalculate();
        }
    }

    public void setFadeModeEnabled(boolean z5) {
        this.fadeModeEnabled = z5;
    }

    public void setFadeModeStartFraction(float f6) {
        this.fadeModeStartFraction = f6;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int i6) {
        this.hyphenationFrequency = i6;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float f6) {
        this.lineSpacingAdd = f6;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f6) {
        this.lineSpacingMultiplier = f6;
    }

    public void setMaxLines(int i6) {
        if (i6 != this.maxLines) {
            this.maxLines = i6;
            clearTexture();
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z5) {
        this.isRtlTextDirectionHeuristicsEnabled = z5;
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    @RequiresApi(23)
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        if (this.staticLayoutBuilderConfigurer != staticLayoutBuilderConfigurer) {
            this.staticLayoutBuilderConfigurer = staticLayoutBuilderConfigurer;
            recalculate(true);
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setTitleTextEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.titleTextEllipsize = truncateAt;
        recalculate();
    }

    public CollapsingTextHelper(View view) {
        this.view = view;
        TextPaint textPaint = new TextPaint(129);
        this.textPaint = textPaint;
        this.tmpPaint = new TextPaint(textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
        maybeUpdateFontWeightAdjustment(view.getContext().getResources().getConfiguration());
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        boolean isDefaultIsRtl = isDefaultIsRtl();
        if (this.isRtlTextDirectionHeuristicsEnabled) {
            return isTextDirectionHeuristicsIsRtl(charSequence, isDefaultIsRtl);
        }
        return isDefaultIsRtl;
    }

    private void calculateOffsets(float f6) {
        float f7;
        interpolateBounds(f6);
        if (this.fadeModeEnabled) {
            if (f6 < this.fadeModeThresholdFraction) {
                this.currentDrawX = this.expandedDrawX;
                this.currentDrawY = this.expandedDrawY;
                setInterpolatedTextSize(0.0f);
                f7 = 0.0f;
            } else {
                this.currentDrawX = this.collapsedDrawX;
                this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
                setInterpolatedTextSize(1.0f);
                f7 = 1.0f;
            }
        } else {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f6, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f6, this.positionInterpolator);
            setInterpolatedTextSize(f6);
            f7 = f6;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f6, timeInterpolator));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f6, timeInterpolator));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendARGB(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f7));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        float f8 = this.collapsedLetterSpacing;
        float f9 = this.expandedLetterSpacing;
        if (f8 != f9) {
            this.textPaint.setLetterSpacing(lerp(f9, f8, f6, timeInterpolator));
        } else {
            this.textPaint.setLetterSpacing(f8);
        }
        this.currentShadowRadius = lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f6, null);
        this.currentShadowDx = lerp(this.expandedShadowDx, this.collapsedShadowDx, f6, null);
        this.currentShadowDy = lerp(this.expandedShadowDy, this.collapsedShadowDy, f6, null);
        int blendARGB = blendARGB(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f6);
        this.currentShadowColor = blendARGB;
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB);
        if (this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(f6) * this.textPaint.getAlpha()));
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private void setInterpolatedTextSize(float f6) {
        boolean z5;
        calculateUsingTextSize(f6);
        if (USE_SCALING_TEXTURE && this.scale != 1.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.useTexture = z5;
        if (z5) {
            ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public void draw(@NonNull Canvas canvas) {
        boolean z5;
        int save = canvas.save();
        if (this.textToDraw != null && this.currentBounds.width() > 0.0f && this.currentBounds.height() > 0.0f) {
            this.textPaint.setTextSize(this.currentTextSize);
            float f6 = this.currentDrawX;
            float f7 = this.currentDrawY;
            if (this.useTexture && this.expandedTitleTexture != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            float f8 = this.scale;
            if (f8 != 1.0f && !this.fadeModeEnabled) {
                canvas.scale(f8, f8, f6, f7);
            }
            if (z5) {
                canvas.drawBitmap(this.expandedTitleTexture, f6, f7, this.texturePaint);
                canvas.restoreToCount(save);
                return;
            }
            if (shouldDrawMultiline() && (!this.fadeModeEnabled || this.expandedFraction > this.fadeModeThresholdFraction)) {
                drawMultilineTransition(canvas, this.currentDrawX - this.textLayout.getLineStart(0), f7);
            } else {
                canvas.translate(f6, f7);
                this.textLayout.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (!collapsedTypefaceInternal && !expandedTypefaceInternal) {
            return;
        }
        recalculate();
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}

package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final int BADGE_CONTENT_NOT_TRUNCATED = -2;
    static final int BADGE_RADIUS_NOT_SPECIFIED = -1;

    @Deprecated
    public static final int BOTTOM_END = 8388693;

    @Deprecated
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    static final String DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX = "…";

    @StyleRes
    private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;

    @AttrRes
    private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    private static final float FONT_SCALE_THRESHOLD = 0.3f;
    static final int OFFSET_ALIGNMENT_MODE_EDGE = 0;
    static final int OFFSET_ALIGNMENT_MODE_LEGACY = 1;
    private static final String TAG = "Badge";
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;

    @Nullable
    private WeakReference<View> anchorViewRef;

    @NonNull
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;

    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;

    @Nullable
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;

    @NonNull
    private final MaterialShapeDrawable shapeDrawable;

    @NonNull
    private final BadgeState state;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public void setNumber(int i6) {
        int max = Math.max(0, i6);
        if (this.state.getNumber() != max) {
            this.state.setNumber(max);
            onNumberUpdated();
        }
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View view, @Nullable ViewGroup viewGroup) {
        if (!(viewGroup instanceof FrameLayout)) {
            throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
        }
        updateBadgeCoordinates(view, (FrameLayout) viewGroup);
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context context) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context context, @XmlRes int i6) {
        return new BadgeDrawable(context, i6, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    @NonNull
    static BadgeDrawable createFromSavedState(@NonNull Context context, @NonNull BadgeState.State state) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, state);
    }

    private CharSequence getEmptyContentDescription() {
        return this.state.getContentDescriptionNumberless();
    }

    private float getLeftCutOff(View view, float f6) {
        return (this.badgeCenterX - this.halfBadgeWidth) + view.getX() + f6;
    }

    @NonNull
    private String getNumberBadgeText() {
        if (this.maxBadgeNumber == -2 || getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance(this.state.getNumberLocale()).format(getNumber());
        }
        Context context = this.contextRef.get();
        return context == null ? "" : String.format(this.state.getNumberLocale(), context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.maxBadgeNumber), "+");
    }

    @Nullable
    private String getNumberContentDescription() {
        Context context;
        if (this.state.getContentDescriptionQuantityStrings() == 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        return (this.maxBadgeNumber == -2 || getNumber() <= this.maxBadgeNumber) ? context.getResources().getQuantityString(this.state.getContentDescriptionQuantityStrings(), getNumber(), Integer.valueOf(getNumber())) : context.getString(this.state.getContentDescriptionExceedsMaxBadgeNumberStringResource(), Integer.valueOf(this.maxBadgeNumber));
    }

    @Nullable
    private CharSequence getTextContentDescription() {
        CharSequence contentDescriptionForText = this.state.getContentDescriptionForText();
        return contentDescriptionForText != null ? contentDescriptionForText : getText();
    }

    private float getTopCutOff(View view, float f6) {
        return (this.badgeCenterY - this.halfBadgeHeight) + view.getY() + f6;
    }

    private int getTotalVerticalOffsetForState() {
        int verticalOffsetWithoutText = this.state.getVerticalOffsetWithoutText();
        if (hasBadgeContent()) {
            verticalOffsetWithoutText = this.state.getVerticalOffsetWithText();
            Context context = this.contextRef.get();
            if (context != null) {
                verticalOffsetWithoutText = AnimationUtils.lerp(verticalOffsetWithoutText, verticalOffsetWithoutText - this.state.getLargeFontVerticalOffsetAdjustment(), AnimationUtils.lerp(0.0f, 1.0f, FONT_SCALE_THRESHOLD, 1.0f, MaterialResources.getFontScale(context) - 1.0f));
            }
        }
        if (this.state.offsetAlignmentMode == 0) {
            verticalOffsetWithoutText -= Math.round(this.halfBadgeHeight);
        }
        return verticalOffsetWithoutText + this.state.getAdditionalVerticalOffset();
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList valueOf = ColorStateList.valueOf(this.state.getBackgroundColor());
        if (this.shapeDrawable.getFillColor() != valueOf) {
            this.shapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    private void onBadgeContentUpdated() {
        this.textDrawableHelper.setTextSizeDirty(true);
        onBadgeShapeAppearanceUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeGravityUpdated() {
        WeakReference<View> weakReference = this.anchorViewRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.anchorViewRef.get();
        WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
        updateBadgeCoordinates(view, weakReference2 != null ? weakReference2.get() : null);
    }

    private void onBadgeShapeAppearanceUpdated() {
        Context context = this.contextRef.get();
        if (context == null) {
            return;
        }
        this.shapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder(context, hasBadgeContent() ? this.state.getBadgeWithTextShapeAppearanceResId() : this.state.getBadgeShapeAppearanceResId(), hasBadgeContent() ? this.state.getBadgeWithTextShapeAppearanceOverlayResId() : this.state.getBadgeShapeAppearanceOverlayResId()).build());
        invalidateSelf();
    }

    private void onBadgeTextAppearanceUpdated() {
        TextAppearance textAppearance;
        Context context = this.contextRef.get();
        if (context == null || this.textDrawableHelper.getTextAppearance() == (textAppearance = new TextAppearance(context, this.state.getTextAppearanceResId()))) {
            return;
        }
        this.textDrawableHelper.setTextAppearance(textAppearance, context);
        onBadgeTextColorUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.getTextPaint().setColor(this.state.getBadgeTextColor());
        invalidateSelf();
    }

    private void onVisibilityUpdated() {
        boolean isVisible = this.state.isVisible();
        setVisible(isVisible, false);
        if (!BadgeUtils.USE_COMPAT_PARENT || getCustomBadgeParent() == null || isVisible) {
            return;
        }
        ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
    }

    private void updateCenterAndBounds() {
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.badgeBounds);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || BadgeUtils.USE_COMPAT_PARENT) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        calculateCenterAndBounds(rect2, view);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        float f6 = this.cornerRadius;
        if (f6 != -1.0f) {
            this.shapeDrawable.setCornerSize(f6);
        }
        if (rect.equals(this.badgeBounds)) {
            return;
        }
        this.shapeDrawable.setBounds(this.badgeBounds);
    }

    public void clearNumber() {
        if (this.state.hasNumber()) {
            this.state.clearNumber();
            onNumberUpdated();
        }
    }

    public void clearText() {
        if (this.state.hasText()) {
            this.state.clearText();
            onTextUpdated();
        }
    }

    int getAdditionalHorizontalOffset() {
        return this.state.getAdditionalHorizontalOffset();
    }

    @Px
    int getAdditionalVerticalOffset() {
        return this.state.getAdditionalVerticalOffset();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.state.getAlpha();
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.state.getBadgeGravity();
    }

    @NonNull
    public Locale getBadgeNumberLocale() {
        return this.state.getNumberLocale();
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    @Px
    public int getHorizontalOffsetWithText() {
        return this.state.getHorizontalOffsetWithText();
    }

    @Px
    public int getHorizontalOffsetWithoutText() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    @Px
    public int getHorizontalPadding() {
        return this.state.getBadgeHorizontalPadding();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Px
    public int getLargeFontVerticalOffsetAdjustment() {
        return this.state.getLargeFontVerticalOffsetAdjustment();
    }

    public int getMaxCharacterCount() {
        return this.state.getMaxCharacterCount();
    }

    public int getMaxNumber() {
        return this.state.getMaxNumber();
    }

    public int getNumber() {
        if (this.state.hasNumber()) {
            return this.state.getNumber();
        }
        return 0;
    }

    @NonNull
    BadgeState.State getSavedState() {
        return this.state.getOverridingState();
    }

    @Nullable
    public String getText() {
        return this.state.getText();
    }

    public int getVerticalOffset() {
        return this.state.getVerticalOffsetWithoutText();
    }

    @Px
    public int getVerticalOffsetWithText() {
        return this.state.getVerticalOffsetWithText();
    }

    @Px
    public int getVerticalOffsetWithoutText() {
        return this.state.getVerticalOffsetWithoutText();
    }

    @Px
    public int getVerticalPadding() {
        return this.state.getBadgeVerticalPadding();
    }

    public boolean hasNumber() {
        return !this.state.hasText() && this.state.hasNumber();
    }

    public boolean hasText() {
        return this.state.hasText();
    }

    void setAdditionalHorizontalOffset(int i6) {
        this.state.setAdditionalHorizontalOffset(i6);
        updateCenterAndBounds();
    }

    void setAdditionalVerticalOffset(@Px int i6) {
        this.state.setAdditionalVerticalOffset(i6);
        updateCenterAndBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.state.setAlpha(i6);
        onAlphaUpdated();
    }

    public void setAutoAdjustToWithinGrandparentBounds(boolean z5) {
        if (this.state.isAutoAdjustedToGrandparentBounds() == z5) {
            return;
        }
        this.state.setAutoAdjustToGrandparentBounds(z5);
        WeakReference<View> weakReference = this.anchorViewRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        autoAdjustWithinGrandparentBounds(this.anchorViewRef.get());
    }

    public void setBackgroundColor(@ColorInt int i6) {
        this.state.setBackgroundColor(i6);
        onBackgroundColorUpdated();
    }

    public void setBadgeNumberLocale(@NonNull Locale locale) {
        if (locale.equals(this.state.getNumberLocale())) {
            return;
        }
        this.state.setNumberLocale(locale);
        invalidateSelf();
    }

    public void setBadgeTextColor(@ColorInt int i6) {
        if (this.textDrawableHelper.getTextPaint().getColor() != i6) {
            this.state.setBadgeTextColor(i6);
            onBadgeTextColorUpdated();
        }
    }

    public void setBadgeWithTextShapeAppearance(@StyleRes int i6) {
        this.state.setBadgeWithTextShapeAppearanceResId(i6);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithTextShapeAppearanceOverlay(@StyleRes int i6) {
        this.state.setBadgeWithTextShapeAppearanceOverlayResId(i6);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearance(@StyleRes int i6) {
        this.state.setBadgeShapeAppearanceResId(i6);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearanceOverlay(@StyleRes int i6) {
        this.state.setBadgeShapeAppearanceOverlayResId(i6);
        onBadgeShapeAppearanceUpdated();
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i6) {
        this.state.setContentDescriptionExceedsMaxBadgeNumberStringResource(i6);
    }

    public void setContentDescriptionForText(@Nullable CharSequence charSequence) {
        this.state.setContentDescriptionForText(charSequence);
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        this.state.setContentDescriptionNumberless(charSequence);
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int i6) {
        this.state.setContentDescriptionQuantityStringsResource(i6);
    }

    public void setHorizontalOffsetWithText(@Px int i6) {
        this.state.setHorizontalOffsetWithText(i6);
        updateCenterAndBounds();
    }

    public void setHorizontalOffsetWithoutText(@Px int i6) {
        this.state.setHorizontalOffsetWithoutText(i6);
        updateCenterAndBounds();
    }

    public void setHorizontalPadding(@Px int i6) {
        if (i6 != this.state.getBadgeHorizontalPadding()) {
            this.state.setBadgeHorizontalPadding(i6);
            updateCenterAndBounds();
        }
    }

    public void setLargeFontVerticalOffsetAdjustment(@Px int i6) {
        this.state.setLargeFontVerticalOffsetAdjustment(i6);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int i6) {
        if (this.state.getMaxCharacterCount() != i6) {
            this.state.setMaxCharacterCount(i6);
            onMaxBadgeLengthUpdated();
        }
    }

    public void setMaxNumber(int i6) {
        if (this.state.getMaxNumber() != i6) {
            this.state.setMaxNumber(i6);
            onMaxBadgeLengthUpdated();
        }
    }

    public void setText(@Nullable String str) {
        if (TextUtils.equals(this.state.getText(), str)) {
            return;
        }
        this.state.setText(str);
        onTextUpdated();
    }

    public void setTextAppearance(@StyleRes int i6) {
        this.state.setTextAppearanceResId(i6);
        onBadgeTextAppearanceUpdated();
    }

    public void setVerticalOffsetWithText(@Px int i6) {
        this.state.setVerticalOffsetWithText(i6);
        updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(@Px int i6) {
        this.state.setVerticalOffsetWithoutText(i6);
        updateCenterAndBounds();
    }

    public void setVerticalPadding(@Px int i6) {
        if (i6 != this.state.getBadgeVerticalPadding()) {
            this.state.setBadgeVerticalPadding(i6);
            updateCenterAndBounds();
        }
    }

    public void setVisible(boolean z5) {
        this.state.setVisible(z5);
        onVisibilityUpdated();
    }

    private BadgeDrawable(@NonNull Context context, @XmlRes int i6, @AttrRes int i7, @StyleRes int i8, @Nullable BadgeState.State state) {
        int badgeShapeAppearanceResId;
        int badgeShapeAppearanceOverlayResId;
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        this.badgeBounds = new Rect();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i6, i7, i8, state);
        this.state = badgeState;
        if (hasBadgeContent()) {
            badgeShapeAppearanceResId = badgeState.getBadgeWithTextShapeAppearanceResId();
        } else {
            badgeShapeAppearanceResId = badgeState.getBadgeShapeAppearanceResId();
        }
        if (hasBadgeContent()) {
            badgeShapeAppearanceOverlayResId = badgeState.getBadgeWithTextShapeAppearanceOverlayResId();
        } else {
            badgeShapeAppearanceOverlayResId = badgeState.getBadgeShapeAppearanceOverlayResId();
        }
        this.shapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context, badgeShapeAppearanceResId, badgeShapeAppearanceOverlayResId).build());
        restoreState();
    }

    private void autoAdjustWithinGrandparentBounds(@NonNull View view) {
        float f6;
        float f7;
        View customBadgeParent = getCustomBadgeParent();
        if (customBadgeParent == null) {
            if (view.getParent() instanceof View) {
                float y5 = view.getY();
                f7 = view.getX();
                customBadgeParent = (View) view.getParent();
                f6 = y5;
            } else {
                return;
            }
        } else if (isAnchorViewWrappedInCompatParent()) {
            if (customBadgeParent.getParent() instanceof View) {
                f6 = customBadgeParent.getY();
                f7 = customBadgeParent.getX();
                customBadgeParent = (View) customBadgeParent.getParent();
            } else {
                return;
            }
        } else {
            f6 = 0.0f;
            f7 = 0.0f;
        }
        float topCutOff = getTopCutOff(customBadgeParent, f6);
        float leftCutOff = getLeftCutOff(customBadgeParent, f7);
        float bottomCutOff = getBottomCutOff(customBadgeParent, f6);
        float rightCutoff = getRightCutoff(customBadgeParent, f7);
        if (topCutOff < 0.0f) {
            this.badgeCenterY += Math.abs(topCutOff);
        }
        if (leftCutOff < 0.0f) {
            this.badgeCenterX += Math.abs(leftCutOff);
        }
        if (bottomCutOff > 0.0f) {
            this.badgeCenterY -= Math.abs(bottomCutOff);
        }
        if (rightCutoff > 0.0f) {
            this.badgeCenterX -= Math.abs(rightCutoff);
        }
    }

    private void calculateCenterAndBounds(@NonNull Rect rect, @NonNull View view) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        if (hasBadgeContent()) {
            f6 = this.state.badgeWithTextRadius;
        } else {
            f6 = this.state.badgeRadius;
        }
        this.cornerRadius = f6;
        if (f6 != -1.0f) {
            this.halfBadgeWidth = f6;
            this.halfBadgeHeight = f6;
        } else {
            if (hasBadgeContent()) {
                f7 = this.state.badgeWithTextWidth;
            } else {
                f7 = this.state.badgeWidth;
            }
            this.halfBadgeWidth = Math.round(f7 / 2.0f);
            if (hasBadgeContent()) {
                f8 = this.state.badgeWithTextHeight;
            } else {
                f8 = this.state.badgeHeight;
            }
            this.halfBadgeHeight = Math.round(f8 / 2.0f);
        }
        if (hasBadgeContent()) {
            String badgeContent = getBadgeContent();
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, (this.textDrawableHelper.getTextWidth(badgeContent) / 2.0f) + this.state.getBadgeHorizontalPadding());
            float max = Math.max(this.halfBadgeHeight, (this.textDrawableHelper.getTextHeight(badgeContent) / 2.0f) + this.state.getBadgeVerticalPadding());
            this.halfBadgeHeight = max;
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, max);
        }
        int totalVerticalOffsetForState = getTotalVerticalOffsetForState();
        int badgeGravity = this.state.getBadgeGravity();
        if (badgeGravity != 8388691 && badgeGravity != 8388693) {
            this.badgeCenterY = rect.top + totalVerticalOffsetForState;
        } else {
            this.badgeCenterY = rect.bottom - totalVerticalOffsetForState;
        }
        int totalHorizontalOffsetForState = getTotalHorizontalOffsetForState();
        int badgeGravity2 = this.state.getBadgeGravity();
        if (badgeGravity2 != 8388659 && badgeGravity2 != 8388691) {
            if (ViewCompat.getLayoutDirection(view) == 0) {
                f10 = (rect.right + this.halfBadgeWidth) - totalHorizontalOffsetForState;
            } else {
                f10 = (rect.left - this.halfBadgeWidth) + totalHorizontalOffsetForState;
            }
            this.badgeCenterX = f10;
        } else {
            if (ViewCompat.getLayoutDirection(view) == 0) {
                f9 = (rect.left - this.halfBadgeWidth) + totalHorizontalOffsetForState;
            } else {
                f9 = (rect.right + this.halfBadgeWidth) - totalHorizontalOffsetForState;
            }
            this.badgeCenterX = f9;
        }
        if (this.state.isAutoAdjustedToGrandparentBounds()) {
            autoAdjustWithinGrandparentBounds(view);
        }
    }

    private void drawBadgeContent(Canvas canvas) {
        int round;
        String badgeContent = getBadgeContent();
        if (badgeContent != null) {
            Rect rect = new Rect();
            this.textDrawableHelper.getTextPaint().getTextBounds(badgeContent, 0, badgeContent.length(), rect);
            float exactCenterY = this.badgeCenterY - rect.exactCenterY();
            float f6 = this.badgeCenterX;
            if (rect.bottom <= 0) {
                round = (int) exactCenterY;
            } else {
                round = Math.round(exactCenterY);
            }
            canvas.drawText(badgeContent, f6, round, this.textDrawableHelper.getTextPaint());
        }
    }

    @Nullable
    private String getBadgeContent() {
        if (hasText()) {
            return getTextBadgeText();
        }
        if (hasNumber()) {
            return getNumberBadgeText();
        }
        return null;
    }

    private float getBottomCutOff(View view, float f6) {
        if (view.getParent() instanceof View) {
            return ((this.badgeCenterY + this.halfBadgeHeight) - (((View) view.getParent()).getHeight() - view.getY())) + f6;
        }
        return 0.0f;
    }

    private float getRightCutoff(View view, float f6) {
        if (view.getParent() instanceof View) {
            return ((this.badgeCenterX + this.halfBadgeWidth) - (((View) view.getParent()).getWidth() - view.getX())) + f6;
        }
        return 0.0f;
    }

    @Nullable
    private String getTextBadgeText() {
        String text = getText();
        int maxCharacterCount = getMaxCharacterCount();
        if (maxCharacterCount != -2 && text != null && text.length() > maxCharacterCount) {
            Context context = this.contextRef.get();
            if (context == null) {
                return "";
            }
            return String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), text.substring(0, maxCharacterCount - 1), DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX);
        }
        return text;
    }

    private int getTotalHorizontalOffsetForState() {
        int horizontalOffsetWithoutText;
        int i6;
        if (hasBadgeContent()) {
            horizontalOffsetWithoutText = this.state.getHorizontalOffsetWithText();
        } else {
            horizontalOffsetWithoutText = this.state.getHorizontalOffsetWithoutText();
        }
        if (this.state.offsetAlignmentMode == 1) {
            if (hasBadgeContent()) {
                i6 = this.state.horizontalInsetWithText;
            } else {
                i6 = this.state.horizontalInset;
            }
            horizontalOffsetWithoutText += i6;
        }
        return horizontalOffsetWithoutText + this.state.getAdditionalHorizontalOffset();
    }

    private boolean hasBadgeContent() {
        if (!hasText() && !hasNumber()) {
            return false;
        }
        return true;
    }

    private boolean isAnchorViewWrappedInCompatParent() {
        FrameLayout customBadgeParent = getCustomBadgeParent();
        if (customBadgeParent != null && customBadgeParent.getId() == R.id.mtrl_anchor_parent) {
            return true;
        }
        return false;
    }

    private void onMaxBadgeLengthUpdated() {
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextSizeDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onNumberUpdated() {
        if (!hasText()) {
            onBadgeContentUpdated();
        }
    }

    private void onTextUpdated() {
        onBadgeContentUpdated();
    }

    private void restoreState() {
        onBadgeShapeAppearanceUpdated();
        onBadgeTextAppearanceUpdated();
        onMaxBadgeLengthUpdated();
        onBadgeContentUpdated();
        onAlphaUpdated();
        onBackgroundColorUpdated();
        onBadgeTextColorUpdated();
        onBadgeGravityUpdated();
        updateCenterAndBounds();
        onVisibilityUpdated();
    }

    private void tryWrapAnchorInCompatParent(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
            if (weakReference != null && weakReference.get() == viewGroup) {
                return;
            }
            updateAnchorParentToNotClip(view);
            final FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(R.id.mtrl_anchor_parent);
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            frameLayout.setLayoutParams(view.getLayoutParams());
            frameLayout.setMinimumWidth(view.getWidth());
            frameLayout.setMinimumHeight(view.getHeight());
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeViewAt(indexOfChild);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(view);
            viewGroup.addView(frameLayout, indexOfChild);
            this.customBadgeParentRef = new WeakReference<>(frameLayout);
            frameLayout.post(new Runnable() { // from class: com.google.android.material.badge.BadgeDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    BadgeDrawable.this.updateBadgeCoordinates(view, frameLayout);
                }
            });
        }
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void updateMaxBadgeNumber() {
        if (getMaxCharacterCount() != -2) {
            this.maxBadgeNumber = ((int) Math.pow(10.0d, getMaxCharacterCount() - 1.0d)) - 1;
        } else {
            this.maxBadgeNumber = getMaxNumber();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasBadgeContent()) {
                drawBadgeContent(canvas);
            }
        }
    }

    @Nullable
    public CharSequence getContentDescription() {
        if (!isVisible()) {
            return null;
        }
        if (hasText()) {
            return getTextContentDescription();
        }
        if (hasNumber()) {
            return getNumberContentDescription();
        }
        return getEmptyContentDescription();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setBadgeGravity(int i6) {
        if (i6 != 8388691) {
        }
        if (this.state.getBadgeGravity() != i6) {
            this.state.setBadgeGravity(i6);
            onBadgeGravityUpdated();
        }
    }

    public void setHorizontalOffset(int i6) {
        setHorizontalOffsetWithoutText(i6);
        setHorizontalOffsetWithText(i6);
    }

    public void setVerticalOffset(int i6) {
        setVerticalOffsetWithoutText(i6);
        setVerticalOffsetWithText(i6);
    }

    public void updateBadgeCoordinates(@NonNull View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        boolean z5 = BadgeUtils.USE_COMPAT_PARENT;
        if (z5 && frameLayout == null) {
            tryWrapAnchorInCompatParent(view);
        } else {
            this.customBadgeParentRef = new WeakReference<>(frameLayout);
        }
        if (!z5) {
            updateAnchorParentToNotClip(view);
        }
        updateCenterAndBounds();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}

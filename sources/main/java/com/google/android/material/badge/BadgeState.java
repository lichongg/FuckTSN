package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class BadgeState {
    private static final String BADGE_RESOURCE_TAG = "badge";
    final float badgeHeight;
    final float badgeRadius;
    final float badgeWidth;
    final float badgeWithTextHeight;
    final float badgeWithTextRadius;
    final float badgeWithTextWidth;
    private final State currentState;
    final int horizontalInset;
    final int horizontalInsetWithText;
    int offsetAlignmentMode;
    private final State overridingState;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() { // from class: com.google.android.material.badge.BadgeState.State.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public State createFromParcel(@NonNull Parcel parcel) {
                return new State(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public State[] newArray(int i6) {
                return new State[i6];
            }
        };
        private static final int NOT_SET = -2;

        @Dimension(unit = 1)
        private Integer additionalHorizontalOffset;

        @Dimension(unit = 1)
        private Integer additionalVerticalOffset;
        private int alpha;
        private Boolean autoAdjustToWithinGrandparentBounds;

        @ColorInt
        private Integer backgroundColor;
        private Integer badgeGravity;

        @Px
        private Integer badgeHorizontalPadding;

        @XmlRes
        private int badgeResId;

        @StyleRes
        private Integer badgeShapeAppearanceOverlayResId;

        @StyleRes
        private Integer badgeShapeAppearanceResId;

        @StyleRes
        private Integer badgeTextAppearanceResId;

        @ColorInt
        private Integer badgeTextColor;

        @Px
        private Integer badgeVerticalPadding;

        @StyleRes
        private Integer badgeWithTextShapeAppearanceOverlayResId;

        @StyleRes
        private Integer badgeWithTextShapeAppearanceResId;

        @StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;

        @Nullable
        private CharSequence contentDescriptionForText;

        @Nullable
        private CharSequence contentDescriptionNumberless;

        @PluralsRes
        private int contentDescriptionQuantityStrings;

        @Dimension(unit = 1)
        private Integer horizontalOffsetWithText;

        @Dimension(unit = 1)
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;

        @Dimension(unit = 1)
        private Integer largeFontVerticalOffsetAdjustment;
        private int maxCharacterCount;
        private int maxNumber;
        private int number;
        private Locale numberLocale;

        @Nullable
        private String text;

        @Dimension(unit = 1)
        private Integer verticalOffsetWithText;

        @Dimension(unit = 1)
        private Integer verticalOffsetWithoutText;

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i6) {
            parcel.writeInt(this.badgeResId);
            parcel.writeSerializable(this.backgroundColor);
            parcel.writeSerializable(this.badgeTextColor);
            parcel.writeSerializable(this.badgeTextAppearanceResId);
            parcel.writeSerializable(this.badgeShapeAppearanceResId);
            parcel.writeSerializable(this.badgeShapeAppearanceOverlayResId);
            parcel.writeSerializable(this.badgeWithTextShapeAppearanceResId);
            parcel.writeSerializable(this.badgeWithTextShapeAppearanceOverlayResId);
            parcel.writeInt(this.alpha);
            parcel.writeString(this.text);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeInt(this.maxNumber);
            CharSequence charSequence = this.contentDescriptionForText;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.contentDescriptionNumberless;
            parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeSerializable(this.badgeGravity);
            parcel.writeSerializable(this.badgeHorizontalPadding);
            parcel.writeSerializable(this.badgeVerticalPadding);
            parcel.writeSerializable(this.horizontalOffsetWithoutText);
            parcel.writeSerializable(this.verticalOffsetWithoutText);
            parcel.writeSerializable(this.horizontalOffsetWithText);
            parcel.writeSerializable(this.verticalOffsetWithText);
            parcel.writeSerializable(this.largeFontVerticalOffsetAdjustment);
            parcel.writeSerializable(this.additionalHorizontalOffset);
            parcel.writeSerializable(this.additionalVerticalOffset);
            parcel.writeSerializable(this.isVisible);
            parcel.writeSerializable(this.numberLocale);
            parcel.writeSerializable(this.autoAdjustToWithinGrandparentBounds);
        }

        State(@NonNull Parcel parcel) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.maxNumber = -2;
            this.isVisible = Boolean.TRUE;
            this.badgeResId = parcel.readInt();
            this.backgroundColor = (Integer) parcel.readSerializable();
            this.badgeTextColor = (Integer) parcel.readSerializable();
            this.badgeTextAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeShapeAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
            this.badgeWithTextShapeAppearanceResId = (Integer) parcel.readSerializable();
            this.badgeWithTextShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
            this.alpha = parcel.readInt();
            this.text = parcel.readString();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.maxNumber = parcel.readInt();
            this.contentDescriptionForText = parcel.readString();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = (Integer) parcel.readSerializable();
            this.badgeHorizontalPadding = (Integer) parcel.readSerializable();
            this.badgeVerticalPadding = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithoutText = (Integer) parcel.readSerializable();
            this.horizontalOffsetWithText = (Integer) parcel.readSerializable();
            this.verticalOffsetWithText = (Integer) parcel.readSerializable();
            this.largeFontVerticalOffsetAdjustment = (Integer) parcel.readSerializable();
            this.additionalHorizontalOffset = (Integer) parcel.readSerializable();
            this.additionalVerticalOffset = (Integer) parcel.readSerializable();
            this.isVisible = (Boolean) parcel.readSerializable();
            this.numberLocale = (Locale) parcel.readSerializable();
            this.autoAdjustToWithinGrandparentBounds = (Boolean) parcel.readSerializable();
        }
    }

    BadgeState(Context context, @XmlRes int i6, @AttrRes int i7, @StyleRes int i8, @Nullable State state) {
        Locale locale;
        Locale.Category category;
        State state2 = new State();
        this.currentState = state2;
        state = state == null ? new State() : state;
        if (i6 != 0) {
            state.badgeResId = i6;
        }
        TypedArray generateTypedArray = generateTypedArray(context, state.badgeResId, i7, i8);
        Resources resources = context.getResources();
        this.badgeRadius = generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeRadius, -1);
        this.horizontalInset = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.horizontalInsetWithText = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.badgeWithTextRadius = generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, -1);
        int i9 = R.styleable.Badge_badgeWidth;
        int i10 = R.dimen.m3_badge_size;
        this.badgeWidth = generateTypedArray.getDimension(i9, resources.getDimension(i10));
        int i11 = R.styleable.Badge_badgeWithTextWidth;
        int i12 = R.dimen.m3_badge_with_text_size;
        this.badgeWithTextWidth = generateTypedArray.getDimension(i11, resources.getDimension(i12));
        this.badgeHeight = generateTypedArray.getDimension(R.styleable.Badge_badgeHeight, resources.getDimension(i10));
        this.badgeWithTextHeight = generateTypedArray.getDimension(R.styleable.Badge_badgeWithTextHeight, resources.getDimension(i12));
        boolean z5 = true;
        this.offsetAlignmentMode = generateTypedArray.getInt(R.styleable.Badge_offsetAlignmentMode, 1);
        state2.alpha = state.alpha == -2 ? 255 : state.alpha;
        if (state.number != -2) {
            state2.number = state.number;
        } else {
            int i13 = R.styleable.Badge_number;
            if (generateTypedArray.hasValue(i13)) {
                state2.number = generateTypedArray.getInt(i13, 0);
            } else {
                state2.number = -1;
            }
        }
        if (state.text != null) {
            state2.text = state.text;
        } else {
            int i14 = R.styleable.Badge_badgeText;
            if (generateTypedArray.hasValue(i14)) {
                state2.text = generateTypedArray.getString(i14);
            }
        }
        state2.contentDescriptionForText = state.contentDescriptionForText;
        state2.contentDescriptionNumberless = state.contentDescriptionNumberless == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : state.contentDescriptionNumberless;
        state2.contentDescriptionQuantityStrings = state.contentDescriptionQuantityStrings == 0 ? R.plurals.mtrl_badge_content_description : state.contentDescriptionQuantityStrings;
        state2.contentDescriptionExceedsMaxBadgeNumberRes = state.contentDescriptionExceedsMaxBadgeNumberRes == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : state.contentDescriptionExceedsMaxBadgeNumberRes;
        if (state.isVisible != null && !state.isVisible.booleanValue()) {
            z5 = false;
        }
        state2.isVisible = Boolean.valueOf(z5);
        state2.maxCharacterCount = state.maxCharacterCount == -2 ? generateTypedArray.getInt(R.styleable.Badge_maxCharacterCount, -2) : state.maxCharacterCount;
        state2.maxNumber = state.maxNumber == -2 ? generateTypedArray.getInt(R.styleable.Badge_maxNumber, -2) : state.maxNumber;
        state2.badgeShapeAppearanceResId = Integer.valueOf(state.badgeShapeAppearanceResId == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : state.badgeShapeAppearanceResId.intValue());
        state2.badgeShapeAppearanceOverlayResId = Integer.valueOf(state.badgeShapeAppearanceOverlayResId == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeShapeAppearanceOverlay, 0) : state.badgeShapeAppearanceOverlayResId.intValue());
        state2.badgeWithTextShapeAppearanceResId = Integer.valueOf(state.badgeWithTextShapeAppearanceResId == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : state.badgeWithTextShapeAppearanceResId.intValue());
        state2.badgeWithTextShapeAppearanceOverlayResId = Integer.valueOf(state.badgeWithTextShapeAppearanceOverlayResId == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0) : state.badgeWithTextShapeAppearanceOverlayResId.intValue());
        state2.backgroundColor = Integer.valueOf(state.backgroundColor == null ? readColorFromAttributes(context, generateTypedArray, R.styleable.Badge_backgroundColor) : state.backgroundColor.intValue());
        state2.badgeTextAppearanceResId = Integer.valueOf(state.badgeTextAppearanceResId == null ? generateTypedArray.getResourceId(R.styleable.Badge_badgeTextAppearance, R.style.TextAppearance_MaterialComponents_Badge) : state.badgeTextAppearanceResId.intValue());
        if (state.badgeTextColor != null) {
            state2.badgeTextColor = state.badgeTextColor;
        } else {
            int i15 = R.styleable.Badge_badgeTextColor;
            if (generateTypedArray.hasValue(i15)) {
                state2.badgeTextColor = Integer.valueOf(readColorFromAttributes(context, generateTypedArray, i15));
            } else {
                state2.badgeTextColor = Integer.valueOf(new TextAppearance(context, state2.badgeTextAppearanceResId.intValue()).getTextColor().getDefaultColor());
            }
        }
        state2.badgeGravity = Integer.valueOf(state.badgeGravity == null ? generateTypedArray.getInt(R.styleable.Badge_badgeGravity, 8388661) : state.badgeGravity.intValue());
        state2.badgeHorizontalPadding = Integer.valueOf(state.badgeHorizontalPadding == null ? generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : state.badgeHorizontalPadding.intValue());
        state2.badgeVerticalPadding = Integer.valueOf(state.badgeVerticalPadding == null ? generateTypedArray.getDimensionPixelSize(R.styleable.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : state.badgeVerticalPadding.intValue());
        state2.horizontalOffsetWithoutText = Integer.valueOf(state.horizontalOffsetWithoutText == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0) : state.horizontalOffsetWithoutText.intValue());
        state2.verticalOffsetWithoutText = Integer.valueOf(state.verticalOffsetWithoutText == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0) : state.verticalOffsetWithoutText.intValue());
        state2.horizontalOffsetWithText = Integer.valueOf(state.horizontalOffsetWithText == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, state2.horizontalOffsetWithoutText.intValue()) : state.horizontalOffsetWithText.intValue());
        state2.verticalOffsetWithText = Integer.valueOf(state.verticalOffsetWithText == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, state2.verticalOffsetWithoutText.intValue()) : state.verticalOffsetWithText.intValue());
        state2.largeFontVerticalOffsetAdjustment = Integer.valueOf(state.largeFontVerticalOffsetAdjustment == null ? generateTypedArray.getDimensionPixelOffset(R.styleable.Badge_largeFontVerticalOffsetAdjustment, 0) : state.largeFontVerticalOffsetAdjustment.intValue());
        state2.additionalHorizontalOffset = Integer.valueOf(state.additionalHorizontalOffset == null ? 0 : state.additionalHorizontalOffset.intValue());
        state2.additionalVerticalOffset = Integer.valueOf(state.additionalVerticalOffset == null ? 0 : state.additionalVerticalOffset.intValue());
        state2.autoAdjustToWithinGrandparentBounds = Boolean.valueOf(state.autoAdjustToWithinGrandparentBounds == null ? generateTypedArray.getBoolean(R.styleable.Badge_autoAdjustToWithinGrandparentBounds, false) : state.autoAdjustToWithinGrandparentBounds.booleanValue());
        generateTypedArray.recycle();
        if (state.numberLocale == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                category = Locale.Category.FORMAT;
                locale = Locale.getDefault(category);
            } else {
                locale = Locale.getDefault();
            }
            state2.numberLocale = locale;
        } else {
            state2.numberLocale = state.numberLocale;
        }
        this.overridingState = state;
    }

    private TypedArray generateTypedArray(Context context, @XmlRes int i6, @AttrRes int i7, @StyleRes int i8) {
        AttributeSet attributeSet;
        int i9;
        if (i6 != 0) {
            attributeSet = DrawableUtils.parseDrawableXml(context, i6, BADGE_RESOURCE_TAG);
            i9 = attributeSet.getStyleAttribute();
        } else {
            attributeSet = null;
            i9 = 0;
        }
        return ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Badge, i7, i9 == 0 ? i8 : i9, new int[0]);
    }

    void clearNumber() {
        setNumber(-1);
    }

    void clearText() {
        setText(null);
    }

    @Dimension(unit = 1)
    int getAdditionalHorizontalOffset() {
        return this.currentState.additionalHorizontalOffset.intValue();
    }

    @Dimension(unit = 1)
    int getAdditionalVerticalOffset() {
        return this.currentState.additionalVerticalOffset.intValue();
    }

    int getAlpha() {
        return this.currentState.alpha;
    }

    @ColorInt
    int getBackgroundColor() {
        return this.currentState.backgroundColor.intValue();
    }

    int getBadgeGravity() {
        return this.currentState.badgeGravity.intValue();
    }

    @Px
    int getBadgeHorizontalPadding() {
        return this.currentState.badgeHorizontalPadding.intValue();
    }

    int getBadgeShapeAppearanceOverlayResId() {
        return this.currentState.badgeShapeAppearanceOverlayResId.intValue();
    }

    int getBadgeShapeAppearanceResId() {
        return this.currentState.badgeShapeAppearanceResId.intValue();
    }

    @ColorInt
    int getBadgeTextColor() {
        return this.currentState.badgeTextColor.intValue();
    }

    @Px
    int getBadgeVerticalPadding() {
        return this.currentState.badgeVerticalPadding.intValue();
    }

    int getBadgeWithTextShapeAppearanceOverlayResId() {
        return this.currentState.badgeWithTextShapeAppearanceOverlayResId.intValue();
    }

    int getBadgeWithTextShapeAppearanceResId() {
        return this.currentState.badgeWithTextShapeAppearanceResId.intValue();
    }

    @StringRes
    int getContentDescriptionExceedsMaxBadgeNumberStringResource() {
        return this.currentState.contentDescriptionExceedsMaxBadgeNumberRes;
    }

    CharSequence getContentDescriptionForText() {
        return this.currentState.contentDescriptionForText;
    }

    CharSequence getContentDescriptionNumberless() {
        return this.currentState.contentDescriptionNumberless;
    }

    @PluralsRes
    int getContentDescriptionQuantityStrings() {
        return this.currentState.contentDescriptionQuantityStrings;
    }

    @Dimension(unit = 1)
    int getHorizontalOffsetWithText() {
        return this.currentState.horizontalOffsetWithText.intValue();
    }

    @Dimension(unit = 1)
    int getHorizontalOffsetWithoutText() {
        return this.currentState.horizontalOffsetWithoutText.intValue();
    }

    @Dimension(unit = 1)
    int getLargeFontVerticalOffsetAdjustment() {
        return this.currentState.largeFontVerticalOffsetAdjustment.intValue();
    }

    int getMaxCharacterCount() {
        return this.currentState.maxCharacterCount;
    }

    int getMaxNumber() {
        return this.currentState.maxNumber;
    }

    int getNumber() {
        return this.currentState.number;
    }

    Locale getNumberLocale() {
        return this.currentState.numberLocale;
    }

    State getOverridingState() {
        return this.overridingState;
    }

    String getText() {
        return this.currentState.text;
    }

    @StyleRes
    int getTextAppearanceResId() {
        return this.currentState.badgeTextAppearanceResId.intValue();
    }

    @Dimension(unit = 1)
    int getVerticalOffsetWithText() {
        return this.currentState.verticalOffsetWithText.intValue();
    }

    @Dimension(unit = 1)
    int getVerticalOffsetWithoutText() {
        return this.currentState.verticalOffsetWithoutText.intValue();
    }

    boolean hasNumber() {
        return this.currentState.number != -1;
    }

    boolean hasText() {
        return this.currentState.text != null;
    }

    boolean isAutoAdjustedToGrandparentBounds() {
        return this.currentState.autoAdjustToWithinGrandparentBounds.booleanValue();
    }

    boolean isVisible() {
        return this.currentState.isVisible.booleanValue();
    }

    void setAdditionalHorizontalOffset(@Dimension(unit = 1) int i6) {
        this.overridingState.additionalHorizontalOffset = Integer.valueOf(i6);
        this.currentState.additionalHorizontalOffset = Integer.valueOf(i6);
    }

    void setAdditionalVerticalOffset(@Dimension(unit = 1) int i6) {
        this.overridingState.additionalVerticalOffset = Integer.valueOf(i6);
        this.currentState.additionalVerticalOffset = Integer.valueOf(i6);
    }

    void setAlpha(int i6) {
        this.overridingState.alpha = i6;
        this.currentState.alpha = i6;
    }

    void setAutoAdjustToGrandparentBounds(boolean z5) {
        this.overridingState.autoAdjustToWithinGrandparentBounds = Boolean.valueOf(z5);
        this.currentState.autoAdjustToWithinGrandparentBounds = Boolean.valueOf(z5);
    }

    void setBackgroundColor(@ColorInt int i6) {
        this.overridingState.backgroundColor = Integer.valueOf(i6);
        this.currentState.backgroundColor = Integer.valueOf(i6);
    }

    void setBadgeGravity(int i6) {
        this.overridingState.badgeGravity = Integer.valueOf(i6);
        this.currentState.badgeGravity = Integer.valueOf(i6);
    }

    void setBadgeHorizontalPadding(@Px int i6) {
        this.overridingState.badgeHorizontalPadding = Integer.valueOf(i6);
        this.currentState.badgeHorizontalPadding = Integer.valueOf(i6);
    }

    void setBadgeShapeAppearanceOverlayResId(int i6) {
        this.overridingState.badgeShapeAppearanceOverlayResId = Integer.valueOf(i6);
        this.currentState.badgeShapeAppearanceOverlayResId = Integer.valueOf(i6);
    }

    void setBadgeShapeAppearanceResId(int i6) {
        this.overridingState.badgeShapeAppearanceResId = Integer.valueOf(i6);
        this.currentState.badgeShapeAppearanceResId = Integer.valueOf(i6);
    }

    void setBadgeTextColor(@ColorInt int i6) {
        this.overridingState.badgeTextColor = Integer.valueOf(i6);
        this.currentState.badgeTextColor = Integer.valueOf(i6);
    }

    void setBadgeVerticalPadding(@Px int i6) {
        this.overridingState.badgeVerticalPadding = Integer.valueOf(i6);
        this.currentState.badgeVerticalPadding = Integer.valueOf(i6);
    }

    void setBadgeWithTextShapeAppearanceOverlayResId(int i6) {
        this.overridingState.badgeWithTextShapeAppearanceOverlayResId = Integer.valueOf(i6);
        this.currentState.badgeWithTextShapeAppearanceOverlayResId = Integer.valueOf(i6);
    }

    void setBadgeWithTextShapeAppearanceResId(int i6) {
        this.overridingState.badgeWithTextShapeAppearanceResId = Integer.valueOf(i6);
        this.currentState.badgeWithTextShapeAppearanceResId = Integer.valueOf(i6);
    }

    void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i6) {
        this.overridingState.contentDescriptionExceedsMaxBadgeNumberRes = i6;
        this.currentState.contentDescriptionExceedsMaxBadgeNumberRes = i6;
    }

    void setContentDescriptionForText(CharSequence charSequence) {
        this.overridingState.contentDescriptionForText = charSequence;
        this.currentState.contentDescriptionForText = charSequence;
    }

    void setContentDescriptionNumberless(CharSequence charSequence) {
        this.overridingState.contentDescriptionNumberless = charSequence;
        this.currentState.contentDescriptionNumberless = charSequence;
    }

    void setContentDescriptionQuantityStringsResource(@PluralsRes int i6) {
        this.overridingState.contentDescriptionQuantityStrings = i6;
        this.currentState.contentDescriptionQuantityStrings = i6;
    }

    void setHorizontalOffsetWithText(@Dimension(unit = 1) int i6) {
        this.overridingState.horizontalOffsetWithText = Integer.valueOf(i6);
        this.currentState.horizontalOffsetWithText = Integer.valueOf(i6);
    }

    void setHorizontalOffsetWithoutText(@Dimension(unit = 1) int i6) {
        this.overridingState.horizontalOffsetWithoutText = Integer.valueOf(i6);
        this.currentState.horizontalOffsetWithoutText = Integer.valueOf(i6);
    }

    void setLargeFontVerticalOffsetAdjustment(@Dimension(unit = 1) int i6) {
        this.overridingState.largeFontVerticalOffsetAdjustment = Integer.valueOf(i6);
        this.currentState.largeFontVerticalOffsetAdjustment = Integer.valueOf(i6);
    }

    void setMaxCharacterCount(int i6) {
        this.overridingState.maxCharacterCount = i6;
        this.currentState.maxCharacterCount = i6;
    }

    void setMaxNumber(int i6) {
        this.overridingState.maxNumber = i6;
        this.currentState.maxNumber = i6;
    }

    void setNumber(int i6) {
        this.overridingState.number = i6;
        this.currentState.number = i6;
    }

    void setNumberLocale(Locale locale) {
        this.overridingState.numberLocale = locale;
        this.currentState.numberLocale = locale;
    }

    void setText(String str) {
        this.overridingState.text = str;
        this.currentState.text = str;
    }

    void setTextAppearanceResId(@StyleRes int i6) {
        this.overridingState.badgeTextAppearanceResId = Integer.valueOf(i6);
        this.currentState.badgeTextAppearanceResId = Integer.valueOf(i6);
    }

    void setVerticalOffsetWithText(@Dimension(unit = 1) int i6) {
        this.overridingState.verticalOffsetWithText = Integer.valueOf(i6);
        this.currentState.verticalOffsetWithText = Integer.valueOf(i6);
    }

    void setVerticalOffsetWithoutText(@Dimension(unit = 1) int i6) {
        this.overridingState.verticalOffsetWithoutText = Integer.valueOf(i6);
        this.currentState.verticalOffsetWithoutText = Integer.valueOf(i6);
    }

    void setVisible(boolean z5) {
        this.overridingState.isVisible = Boolean.valueOf(z5);
        this.currentState.isVisible = Boolean.valueOf(z5);
    }

    private static int readColorFromAttributes(Context context, @NonNull TypedArray typedArray, @StyleableRes int i6) {
        return MaterialResources.getColorStateList(context, typedArray, i6).getDefaultColor();
    }
}

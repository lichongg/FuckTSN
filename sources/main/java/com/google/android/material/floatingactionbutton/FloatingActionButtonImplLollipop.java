package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes5.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    @Nullable
    private StateListAnimator stateListAnimator;

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean requirePreDrawListener() {
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }
    }

    @NonNull
    private StateListAnimator createDefaultStateListAnimator(float f6, float f7, float f8) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(f6, f8));
        stateListAnimator.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f6, f7));
        stateListAnimator.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f6, f7));
        stateListAnimator.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(f6, f7));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.view, "elevation", f6).setDuration(0L));
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 22 && i6 <= 24) {
            FloatingActionButton floatingActionButton = this.view;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        stateListAnimator.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, animatorSet);
        stateListAnimator.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        return stateListAnimator;
    }

    @NonNull
    private Animator createElevationAnimator(float f6, float f7) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.view, "elevation", f6).setDuration(0L)).with(ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f7).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    @NonNull
    BorderDrawable createBorderDrawable(int i6, ColorStateList colorStateList) {
        Context context = this.view.getContext();
        BorderDrawable borderDrawable = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
        borderDrawable.setGradientColors(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        borderDrawable.setBorderWidth(i6);
        borderDrawable.setBorderTint(colorStateList);
        return borderDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    @NonNull
    MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void getPadding(@NonNull Rect rect) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled()) {
            super.getPadding(rect);
        } else if (shouldExpandBoundsForA11y()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onDrawableStateChanged(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.view.isEnabled()) {
                this.view.setElevation(0.0f);
                this.view.setTranslationZ(0.0f);
                return;
            }
            this.view.setElevation(this.elevation);
            if (this.view.isPressed()) {
                this.view.setTranslationZ(this.pressedTranslationZ);
            } else if (this.view.isFocused() || this.view.isHovered()) {
                this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
            } else {
                this.view.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onElevationsChanged(float f6, float f7, float f8) {
        if (Build.VERSION.SDK_INT == 21) {
            this.view.refreshDrawableState();
        } else if (this.view.getStateListAnimator() == this.stateListAnimator) {
            StateListAnimator createDefaultStateListAnimator = createDefaultStateListAnimator(f6, f7, f8);
            this.stateListAnimator = createDefaultStateListAnimator;
            this.view.setStateListAnimator(createDefaultStateListAnimator);
        }
        if (shouldAddPadding()) {
            updatePadding();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void setRippleColor(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else {
            super.setRippleColor(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean shouldAddPadding() {
        return this.shadowViewDelegate.isCompatPaddingEnabled() || !shouldExpandBoundsForA11y();
    }

    FloatingActionButtonImplLollipop(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void initializeBackgroundDrawable(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i6) {
        Drawable drawable;
        MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
        this.shapeDrawable = createShapeDrawable;
        createShapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (i6 > 0) {
            this.borderDrawable = createBorderDrawable(i6, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.borderDrawable), (Drawable) Preconditions.checkNotNull(this.shapeDrawable)});
        } else {
            this.borderDrawable = null;
            drawable = this.shapeDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, null);
        this.rippleDrawable = rippleDrawable;
        this.contentBackground = rippleDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void updateFromViewRotation() {
    }
}

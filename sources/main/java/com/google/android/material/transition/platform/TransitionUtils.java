package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.PathParser;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes5.dex */
class TransitionUtils {

    @AttrRes
    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final RectF transformAlphaRectF = new RectF();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2);
    }

    static RectF getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    static float lerp(float f6, float f7, float f8) {
        return f6 + (f8 * (f7 - f6));
    }

    static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.platform.a
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public final CornerSize apply(CornerSize cornerSize) {
                CornerSize createFromCornerSize;
                createFromCornerSize = RelativeCornerSize.createFromCornerSize(rectF, cornerSize);
                return createFromCornerSize;
            }
        });
    }

    static Shader createColorShader(@ColorInt int i6) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i6, i6, Shader.TileMode.CLAMP);
    }

    @NonNull
    static <T> T defaultIfNull(@Nullable T t5, @NonNull T t6) {
        return t5 != null ? t5 : t6;
    }

    static RectF getRelativeBounds(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static Rect getRelativeBoundsRect(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static float lerp(float f6, float f7, @FloatRange(from = 0.0d, to = 1.0d) float f8, @FloatRange(from = 0.0d, to = 1.0d) float f9, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return lerp(f6, f7, f8, f9, f10, false);
    }

    static void maybeAddTransition(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static boolean maybeApplyThemeDuration(Transition transition, Context context, @AttrRes int i6) {
        int resolveThemeDuration;
        if (i6 == 0 || transition.getDuration() != -1 || (resolveThemeDuration = MotionUtils.resolveThemeDuration(context, i6, -1)) == -1) {
            return false;
        }
        transition.setDuration(resolveThemeDuration);
        return true;
    }

    static boolean maybeApplyThemeInterpolator(Transition transition, Context context, @AttrRes int i6, TimeInterpolator timeInterpolator) {
        if (i6 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(MotionUtils.resolveThemeInterpolator(context, i6, timeInterpolator));
        return true;
    }

    static boolean maybeApplyThemePath(Transition transition, Context context, @AttrRes int i6) {
        PathMotion resolveThemePath;
        if (i6 == 0 || (resolveThemePath = resolveThemePath(context, i6)) == null) {
            return false;
        }
        transition.setPathMotion(resolveThemePath);
        return true;
    }

    static void maybeRemoveTransition(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    @Nullable
    static PathMotion resolveThemePath(Context context, @AttrRes int i6) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i6, typedValue, true)) {
            return null;
        }
        int i7 = typedValue.type;
        if (i7 != 16) {
            if (i7 == 3) {
                return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(typedValue.string)));
            }
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
        int i8 = typedValue.data;
        if (i8 == 0) {
            return null;
        }
        if (i8 == 1) {
            return new MaterialArcMotion();
        }
        throw new IllegalArgumentException("Invalid motion path type: " + i8);
    }

    private static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int i6) {
        RectF rectF = transformAlphaRectF;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i6);
    }

    static void transform(Canvas canvas, Rect rect, float f6, float f7, float f8, int i6, CanvasCompat.CanvasOperation canvasOperation) {
        if (i6 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f6, f7);
        canvas.scale(f8, f8);
        if (i6 < 255) {
            saveLayerAlphaCompat(canvas, rect, i6);
        }
        canvasOperation.run(canvas);
        canvas.restoreToCount(save);
    }

    private TransitionUtils() {
    }

    static float calculateArea(@NonNull RectF rectF) {
        return rectF.width() * rectF.height();
    }

    static View findAncestorById(View view, @IdRes int i6) {
        String resourceName = view.getResources().getResourceName(i6);
        while (view != null) {
            if (view.getId() == i6) {
                return view;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static View findDescendantOrAncestorById(View view, @IdRes int i6) {
        View findViewById = view.findViewById(i6);
        if (findViewById != null) {
            return findViewById;
        }
        return findAncestorById(view, i6);
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) {
            return false;
        }
        return true;
    }

    static float lerp(float f6, float f7, @FloatRange(from = 0.0d, to = 1.0d) float f8, @FloatRange(from = 0.0d, to = 1.0d) float f9, @FloatRange(from = 0.0d) float f10, boolean z5) {
        if (!z5 || (f10 >= 0.0f && f10 <= 1.0f)) {
            return f10 < f8 ? f6 : f10 > f9 ? f7 : lerp(f6, f7, (f10 - f8) / (f9 - f8));
        }
        return lerp(f6, f7, f10);
    }

    static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        ShapeAppearanceModel shapeAppearanceModel3;
        if (isShapeAppearanceSignificant(shapeAppearanceModel, rectF)) {
            shapeAppearanceModel3 = shapeAppearanceModel;
        } else {
            shapeAppearanceModel3 = shapeAppearanceModel2;
        }
        return shapeAppearanceModel3.toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    static int lerp(int i6, int i7, @FloatRange(from = 0.0d, to = 1.0d) float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, @FloatRange(from = 0.0d, to = 1.0d) float f8) {
        return f8 < f6 ? i6 : f8 > f7 ? i7 : (int) lerp(i6, i7, (f8 - f6) / (f7 - f6));
    }

    static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, final RectF rectF, final RectF rectF2, @FloatRange(from = 0.0d, to = 1.0d) final float f6, @FloatRange(from = 0.0d, to = 1.0d) final float f7, @FloatRange(from = 0.0d, to = 1.0d) final float f8) {
        return f8 < f6 ? shapeAppearanceModel : f8 > f7 ? shapeAppearanceModel2 : transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils.1
            @Override // com.google.android.material.transition.platform.TransitionUtils.CornerSizeBinaryOperator
            @NonNull
            public CornerSize apply(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF), cornerSize2.getCornerSize(rectF2), f6, f7, f8));
            }
        });
    }
}

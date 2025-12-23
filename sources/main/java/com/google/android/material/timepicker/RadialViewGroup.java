package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class RadialViewGroup extends ConstraintLayout {
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final float LEVEL_RADIUS_RATIO = 0.66f;
    private static final String SKIP_TAG = "skip";
    private MaterialShapeDrawable background;
    private int radius;
    private final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(@NonNull Context context) {
        this(context, null);
    }

    @Dimension
    int getLeveledRadius(int i6) {
        return i6 == 2 ? Math.round(this.radius * LEVEL_RADIUS_RATIO) : this.radius;
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Drawable createBackground() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.background = materialShapeDrawable;
        materialShapeDrawable.setCornerSize(new RelativeCornerSize(0.5f));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        return this.background;
    }

    private static boolean shouldSkipView(View view) {
        return SKIP_TAG.equals(view.getTag());
    }

    @Dimension
    public int getRadius() {
        return this.radius;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i6) {
        this.background.setFillColor(ColorStateList.valueOf(i6));
    }

    public void setRadius(@Dimension int i6) {
        this.radius = i6;
        updateLayoutParams();
    }

    protected void updateLayoutParams() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getId() != R.id.circle_center && !shouldSkipView(childAt)) {
                int i7 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i7 == null) {
                    i7 = 1;
                }
                if (!hashMap.containsKey(i7)) {
                    hashMap.put(i7, new ArrayList());
                }
                ((List) hashMap.get(i7)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            addConstraints((List) entry.getValue(), constraintSet, getLeveledRadius(((Integer) entry.getKey()).intValue()));
        }
        constraintSet.applyTo(this);
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, createBackground());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i6, 0);
        this.radius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.updateLayoutParametersRunnable = new Runnable() { // from class: com.google.android.material.timepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                RadialViewGroup.this.updateLayoutParams();
            }
        };
        obtainStyledAttributes.recycle();
    }

    private void addConstraints(List<View> list, ConstraintSet constraintSet, int i6) {
        Iterator<View> it = list.iterator();
        float f6 = 0.0f;
        while (it.hasNext()) {
            constraintSet.constrainCircle(it.next().getId(), R.id.circle_center, i6, f6);
            f6 += 360.0f / list.size();
        }
    }

    private void updateLayoutParamsAsync() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.updateLayoutParametersRunnable);
            handler.post(this.updateLayoutParametersRunnable);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i6, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        updateLayoutParamsAsync();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        updateLayoutParamsAsync();
    }
}

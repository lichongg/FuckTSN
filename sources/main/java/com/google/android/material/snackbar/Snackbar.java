package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onDismissed(Snackbar snackbar, int i6) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onShown(Snackbar snackbar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i6, int i7) {
            super.onMeasure(i6, i7);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    @Nullable
    private static ViewGroup findSuitableParent(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @NonNull CharSequence charSequence, int i6) {
        return makeInternal(null, view, charSequence, i6);
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setAction(@StringRes int i6, View.OnClickListener onClickListener) {
        return setAction(getContext().getText(i6), onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        getActionView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setText(@NonNull CharSequence charSequence) {
        getMessageView().setText(charSequence);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setTextColor(ColorStateList colorStateList) {
        getMessageView().setTextColor(colorStateList);
        return this;
    }

    static {
        int i6 = R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{i6};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{i6, R.attr.snackbarTextViewStyle};
    }

    private SnackbarContentLayout getContentLayout() {
        return (SnackbarContentLayout) this.view.getChildAt(0);
    }

    @Deprecated
    protected static boolean hasSnackbarButtonStyleAttr(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    private static boolean hasSnackbarContentStyleAttrs(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    @NonNull
    public static Snackbar make(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i6) {
        return makeInternal(context, view, charSequence, i6);
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setAction(@Nullable CharSequence charSequence, @Nullable final View.OnClickListener onClickListener) {
        Button actionView = getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.hasAction = false;
            return this;
        }
        this.hasAction = true;
        actionView.setVisibility(0);
        actionView.setText(charSequence);
        actionView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Snackbar.a(Snackbar.this, onClickListener, view);
            }
        });
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setActionTextColor(@ColorInt int i6) {
        getActionView().setTextColor(i6);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.view.setBackgroundTintList(colorStateList);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.view.setBackgroundTintMode(mode);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    @Deprecated
    public Snackbar setCallback(@Nullable Callback callback) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            removeCallback(baseCallback);
        }
        if (callback != null) {
            addCallback(callback);
        }
        this.callback = callback;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setText(@StringRes int i6) {
        return setText(getContext().getText(i6));
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setTextColor(@ColorInt int i6) {
        getMessageView().setTextColor(i6);
        return this;
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static /* synthetic */ void a(Snackbar snackbar, View.OnClickListener onClickListener, View view) {
        snackbar.getClass();
        onClickListener.onClick(view);
        snackbar.dispatchDismiss(1);
    }

    private Button getActionView() {
        return getContentLayout().getActionView();
    }

    private TextView getMessageView() {
        return getContentLayout().getMessageView();
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @StringRes int i6, int i7) {
        return make(view, view.getResources().getText(i6), i7);
    }

    @NonNull
    private static Snackbar makeInternal(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i6) {
        int i7;
        ViewGroup findSuitableParent = findSuitableParent(view);
        if (findSuitableParent != null) {
            if (context == null) {
                context = findSuitableParent.getContext();
            }
            LayoutInflater from = LayoutInflater.from(context);
            if (hasSnackbarContentStyleAttrs(context)) {
                i7 = R.layout.mtrl_layout_snackbar_include;
            } else {
                i7 = R.layout.design_layout_snackbar_include;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(i7, findSuitableParent, false);
            Snackbar snackbar = new Snackbar(context, findSuitableParent, snackbarContentLayout, snackbarContentLayout);
            snackbar.setText(charSequence);
            snackbar.setDuration(i6);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int i6;
        int recommendedTimeoutMillis;
        int duration = super.getDuration();
        if (duration == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.hasAction) {
                i6 = 4;
            } else {
                i6 = 0;
            }
            recommendedTimeoutMillis = this.accessibilityManager.getRecommendedTimeoutMillis(duration, i6 | 3);
            return recommendedTimeoutMillis;
        }
        if (this.hasAction && this.accessibilityManager.isTouchExplorationEnabled()) {
            return -2;
        }
        return duration;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setBackgroundTint(@ColorInt int i6) {
        return setBackgroundTintList(ColorStateList.valueOf(i6));
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setMaxInlineActionWidth(@Dimension int i6) {
        getContentLayout().setMaxInlineActionWidth(i6);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setTextMaxLines(int i6) {
        getMessageView().setMaxLines(i6);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }
}

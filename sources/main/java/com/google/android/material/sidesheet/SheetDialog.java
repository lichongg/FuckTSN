package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.sidesheet.SheetCallback;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class SheetDialog<C extends SheetCallback> extends AppCompatDialog {
    private static final int COORDINATOR_LAYOUT_ID = R.id.coordinator;
    private static final int TOUCH_OUTSIDE_ID = R.id.touch_outside;

    @Nullable
    private MaterialBackOrchestrator backOrchestrator;

    @Nullable
    private Sheet<C> behavior;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;

    @Nullable
    private FrameLayout container;
    boolean dismissWithAnimation;

    @Nullable
    private FrameLayout sheet;

    abstract void addSheetCancelOnHideCallback(Sheet<C> sheet);

    @NonNull
    abstract Sheet<C> getBehaviorFromSheet(@NonNull FrameLayout frameLayout);

    @IdRes
    abstract int getDialogId();

    @LayoutRes
    abstract int getLayoutResId();

    abstract int getStateOnStart();

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i6) {
        super.setContentView(wrapInSheet(i6, null, null));
    }

    public static /* synthetic */ void b(SheetDialog sheetDialog, View view) {
        if (sheetDialog.cancelable && sheetDialog.isShowing() && sheetDialog.shouldWindowCloseOnTouchOutside()) {
            sheetDialog.cancel();
        }
    }

    private void ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), getLayoutResId(), null);
            this.container = frameLayout;
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(getDialogId());
            this.sheet = frameLayout2;
            Sheet<C> behaviorFromSheet = getBehaviorFromSheet(frameLayout2);
            this.behavior = behaviorFromSheet;
            addSheetCancelOnHideCallback(behaviorFromSheet);
            this.backOrchestrator = new MaterialBackOrchestrator(this.behavior, this.sheet);
        }
    }

    @NonNull
    private FrameLayout getContainer() {
        if (this.container == null) {
            ensureContainerAndBehavior();
        }
        return this.container;
    }

    @NonNull
    private FrameLayout getSheet() {
        if (this.sheet == null) {
            ensureContainerAndBehavior();
        }
        return this.sheet;
    }

    private static int getThemeResId(@NonNull Context context, @StyleRes int i6, @AttrRes int i7, @StyleRes int i8) {
        if (i6 != 0) {
            return i6;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i7, typedValue, true) ? typedValue.resourceId : i8;
    }

    private boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    private void updateListeningForBackCallbacks() {
        MaterialBackOrchestrator materialBackOrchestrator = this.backOrchestrator;
        if (materialBackOrchestrator == null) {
            return;
        }
        if (this.cancelable) {
            materialBackOrchestrator.startListeningForBackCallbacks();
        } else {
            materialBackOrchestrator.stopListeningForBackCallbacks();
        }
    }

    @NonNull
    Sheet<C> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean isDismissWithSheetAnimationEnabled() {
        return this.dismissWithAnimation;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@Nullable View view) {
        super.setContentView(wrapInSheet(0, view, null));
    }

    public void setDismissWithSheetAnimationEnabled(boolean z5) {
        this.dismissWithAnimation = z5;
    }

    public void setSheetEdge(@GravityInt int i6) {
        FrameLayout frameLayout = this.sheet;
        if (frameLayout == null) {
            throw new IllegalStateException("Sheet view reference is null; sheet edge cannot be changed if the sheet view is null.");
        }
        if (ViewCompat.isLaidOut(frameLayout)) {
            throw new IllegalStateException("Sheet view has been laid out; sheet edge cannot be changed once the sheet has been laid out.");
        }
        ViewGroup.LayoutParams layoutParams = this.sheet.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) layoutParams).gravity = i6;
            maybeUpdateWindowAnimationsBasedOnLayoutDirection();
        }
    }

    SheetDialog(@NonNull Context context, @StyleRes int i6, @AttrRes int i7, @StyleRes int i8) {
        super(context, getThemeResId(context, i6, i7, i8));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        supportRequestWindowFeature(1);
    }

    private void maybeUpdateWindowAnimationsBasedOnLayoutDirection() {
        FrameLayout frameLayout;
        int i6;
        Window window = getWindow();
        if (window != null && (frameLayout = this.sheet) != null && (frameLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            if (GravityCompat.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) this.sheet.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this.sheet)) == 3) {
                i6 = R.style.Animation_Material3_SideSheetDialog_Left;
            } else {
                i6 = R.style.Animation_Material3_SideSheetDialog_Right;
            }
            window.setWindowAnimations(i6);
        }
    }

    private View wrapInSheet(int i6, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getContainer().findViewById(COORDINATOR_LAYOUT_ID);
        if (i6 != 0 && view == null) {
            view = getLayoutInflater().inflate(i6, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout sheet = getSheet();
        sheet.removeAllViews();
        if (layoutParams == null) {
            sheet.addView(view);
        } else {
            sheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(TOUCH_OUTSIDE_ID).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.sidesheet.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SheetDialog.b(SheetDialog.this, view2);
            }
        });
        ViewCompat.setAccessibilityDelegate(getSheet(), new AccessibilityDelegateCompat() { // from class: com.google.android.material.sidesheet.SheetDialog.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view2, int i7, Bundle bundle) {
                if (i7 == 1048576) {
                    SheetDialog sheetDialog = SheetDialog.this;
                    if (sheetDialog.cancelable) {
                        sheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view2, i7, bundle);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                if (SheetDialog.this.cancelable) {
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                } else {
                    accessibilityNodeInfoCompat.setDismissable(false);
                }
            }
        });
        return this.container;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Sheet<C> behavior = getBehavior();
        if (this.dismissWithAnimation && behavior.getState() != 5) {
            behavior.setState(5);
        } else {
            super.cancel();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeUpdateWindowAnimationsBasedOnLayoutDirection();
        updateListeningForBackCallbacks();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i6 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i6 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaterialBackOrchestrator materialBackOrchestrator = this.backOrchestrator;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.stopListeningForBackCallbacks();
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        Sheet<C> sheet = this.behavior;
        if (sheet != null && sheet.getState() == 5) {
            this.behavior.setState(getStateOnStart());
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z5) {
        super.setCancelable(z5);
        if (this.cancelable != z5) {
            this.cancelable = z5;
        }
        if (getWindow() != null) {
            updateListeningForBackCallbacks();
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z5) {
        super.setCanceledOnTouchOutside(z5);
        if (z5 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z5;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInSheet(0, view, layoutParams));
    }
}

package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FragmentContainerView extends FrameLayout {
    private View.OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private ArrayList<View> mDisappearingFragmentChildren;
    private boolean mDrawDisappearingViewsFirst;
    private ArrayList<View> mTransitioningFragmentViews;

    public FragmentContainerView(@NonNull Context context) {
        super(context);
        this.mDrawDisappearingViewsFirst = true;
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            addDisappearingFragmentView(getChildAt(i8));
        }
        super.removeViews(i6, i7);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            addDisappearingFragmentView(getChildAt(i8));
        }
        super.removeViewsInLayout(i6, i7);
    }

    private void addDisappearingFragmentView(@NonNull View view) {
        ArrayList<View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.mDisappearingFragmentChildren == null) {
            this.mDisappearingFragmentChildren = new ArrayList<>();
        }
        this.mDisappearingFragmentChildren.add(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        if (this.mDrawDisappearingViewsFirst && this.mDisappearingFragmentChildren != null) {
            for (int i6 = 0; i6 < this.mDisappearingFragmentChildren.size(); i6++) {
                super.drawChild(canvas, this.mDisappearingFragmentChildren.get(i6), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@NonNull Canvas canvas, @NonNull View view, long j6) {
        ArrayList<View> arrayList;
        if (!this.mDrawDisappearingViewsFirst || (arrayList = this.mDisappearingFragmentChildren) == null || arrayList.size() <= 0 || !this.mDisappearingFragmentChildren.contains(view)) {
            return super.drawChild(canvas, view, j6);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@NonNull View view) {
        ArrayList<View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.mDisappearingFragmentChildren;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.mDrawDisappearingViewsFirst = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(@NonNull View view, boolean z5) {
        if (z5) {
            addDisappearingFragmentView(view);
        }
        super.removeDetachedView(view, z5);
    }

    void setDrawDisappearingViewsLast(boolean z5) {
        this.mDrawDisappearingViewsFirst = z5;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@Nullable LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@NonNull View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.mApplyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    public FragmentContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i6, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (FragmentManager.getViewFragment(view) != null) {
            super.addView(view, i6, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(@NonNull View view, int i6, @Nullable ViewGroup.LayoutParams layoutParams, boolean z5) {
        if (FragmentManager.getViewFragment(view) != null) {
            return super.addViewInLayout(view, i6, layoutParams, z5);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    @RequiresApi(20)
    public WindowInsets dispatchApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        WindowInsetsCompat onApplyWindowInsets;
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.mApplyWindowInsetsListener;
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsets = WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            onApplyWindowInsets = ViewCompat.onApplyWindowInsets(this, windowInsetsCompat);
        }
        if (!onApplyWindowInsets.isConsumed()) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewCompat.dispatchApplyWindowInsets(getChildAt(i6), onApplyWindowInsets);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            addDisappearingFragmentView(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@NonNull View view) {
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i6) {
        addDisappearingFragmentView(getChildAt(i6));
        super.removeViewAt(i6);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(@NonNull View view) {
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@NonNull View view) {
        if (view.getParent() == this) {
            if (this.mTransitioningFragmentViews == null) {
                this.mTransitioningFragmentViews = new ArrayList<>();
            }
            this.mTransitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        String str;
        this.mDrawDisappearingViewsFirst = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    FragmentContainerView(@NonNull Context context, @NonNull AttributeSet attributeSet, @NonNull FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        this.mDrawDisappearingViewsFirst = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment findFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute != null && findFragmentById == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment instantiate = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), classAttribute);
            instantiate.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.beginTransaction().setReorderingAllowed(true).add(this, instantiate, string).commitNowAllowingStateLoss();
        }
        fragmentManager.onContainerAvailable(this);
    }

    @Override // android.view.View
    @NonNull
    @RequiresApi(20)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        return windowInsets;
    }
}

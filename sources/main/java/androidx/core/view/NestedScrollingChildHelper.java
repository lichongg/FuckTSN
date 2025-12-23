package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public boolean dispatchNestedPreScroll(int i6, int i7, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i6, i7, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, @Nullable int[] iArr) {
        return dispatchNestedScrollInternal(i6, i7, i8, i9, iArr, 0, null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean startNestedScroll(int i6) {
        return startNestedScroll(i6, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    private boolean dispatchNestedScrollInternal(int i6, int i7, int i8, int i9, @Nullable int[] iArr, int i10, @Nullable int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i11;
        int i12;
        int[] iArr3;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i10)) == null) {
            return false;
        }
        if (i6 == 0 && i7 == 0 && i8 == 0 && i9 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            i11 = iArr[0];
            i12 = iArr[1];
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (iArr2 == null) {
            int[] tempNestedScrollConsumed = getTempNestedScrollConsumed();
            tempNestedScrollConsumed[0] = 0;
            tempNestedScrollConsumed[1] = 0;
            iArr3 = tempNestedScrollConsumed;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, i6, i7, i8, i9, i10, iArr3);
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i11;
            iArr[1] = iArr[1] - i12;
        }
        return true;
    }

    private ViewParent getNestedScrollingParentForType(int i6) {
        if (i6 == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i6 != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int i6, ViewParent viewParent) {
        if (i6 == 0) {
            this.mNestedScrollingParentTouch = viewParent;
        } else {
            if (i6 != 1) {
                return;
            }
            this.mNestedScrollingParentNonTouch = viewParent;
        }
    }

    public boolean dispatchNestedPreScroll(int i6, int i7, @Nullable int[] iArr, @Nullable int[] iArr2, int i8) {
        ViewParent nestedScrollingParentForType;
        int i9;
        int i10;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i8)) == null) {
            return false;
        }
        if (i6 == 0 && i7 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            i9 = iArr2[0];
            i10 = iArr2[1];
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (iArr == null) {
            iArr = getTempNestedScrollConsumed();
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i6, i7, iArr3, i8);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i9;
            iArr2[1] = iArr2[1] - i10;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, @Nullable int[] iArr, int i10) {
        return dispatchNestedScrollInternal(i6, i7, i8, i9, iArr, i10, null);
    }

    public boolean hasNestedScrollingParent(int i6) {
        return getNestedScrollingParentForType(i6) != null;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z5) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z5;
    }

    public boolean startNestedScroll(int i6, int i7) {
        if (hasNestedScrollingParent(i7)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.mView;
        for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i6, i7)) {
                setNestedScrollingParentForType(i7, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i6, i7);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i6) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i6);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i6);
            setNestedScrollingParentForType(i6, null);
        }
    }

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f6, f7, z5);
    }

    public boolean dispatchNestedPreFling(float f6, float f7) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f6, f7);
    }

    public void dispatchNestedScroll(int i6, int i7, int i8, int i9, @Nullable int[] iArr, int i10, @Nullable int[] iArr2) {
        dispatchNestedScrollInternal(i6, i7, i8, i9, iArr, i10, iArr2);
    }
}

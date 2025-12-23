package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f6, float f7, boolean z5);

    boolean dispatchNestedPreFling(float f6, float f7);

    boolean dispatchNestedPreScroll(int i6, int i7, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z5);

    boolean startNestedScroll(int i6);

    void stopNestedScroll();
}

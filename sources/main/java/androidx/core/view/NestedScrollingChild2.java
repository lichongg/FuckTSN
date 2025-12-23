package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i6, int i7, @Nullable int[] iArr, @Nullable int[] iArr2, int i8);

    boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, @Nullable int[] iArr, int i10);

    boolean hasNestedScrollingParent(int i6);

    boolean startNestedScroll(int i6, int i7);

    void stopNestedScroll(int i6);
}

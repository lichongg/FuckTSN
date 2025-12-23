package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i6, int i7, @NonNull int[] iArr, int i8);

    void onNestedScroll(@NonNull View view, int i6, int i7, int i8, int i9, int i10);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i6, int i7);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i6, int i7);

    void onStopNestedScroll(@NonNull View view, int i6);
}

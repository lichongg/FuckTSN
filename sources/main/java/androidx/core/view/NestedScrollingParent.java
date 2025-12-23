package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f6, float f7, boolean z5);

    boolean onNestedPreFling(@NonNull View view, float f6, float f7);

    void onNestedPreScroll(@NonNull View view, int i6, int i7, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i6, int i7, int i8, int i9);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i6);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i6);

    void onStopNestedScroll(@NonNull View view);
}

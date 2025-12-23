package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i6) {
        onNestedScrollAccepted(view, view2, i6, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxesTouch | this.mNestedScrollAxesNonTouch;
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i6, int i7) {
        if (i7 == 1) {
            this.mNestedScrollAxesNonTouch = i6;
        } else {
            this.mNestedScrollAxesTouch = i6;
        }
    }

    public void onStopNestedScroll(@NonNull View view, int i6) {
        if (i6 == 1) {
            this.mNestedScrollAxesNonTouch = 0;
        } else {
            this.mNestedScrollAxesTouch = 0;
        }
    }

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
    }
}

package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ViewBindings {
    @Nullable
    public static <T extends View> T findChildViewById(View view, @IdRes int i6) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            T t5 = (T) viewGroup.getChildAt(i7).findViewById(i6);
            if (t5 != null) {
                return t5;
            }
        }
        return null;
    }

    private ViewBindings() {
    }
}

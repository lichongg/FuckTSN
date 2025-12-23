package androidx.databinding.adapters;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ListenerUtil {
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> sListeners = new SparseArray<>();

    public static <T> T getListener(View view, int i6) {
        return (T) view.getTag(i6);
    }

    public static <T> T trackListener(View view, T t5, int i6) {
        T t6 = (T) view.getTag(i6);
        view.setTag(i6, t5);
        return t6;
    }
}

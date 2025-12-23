package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i6, int i7, @Nullable Object obj);

    void onInserted(int i6, int i7);

    void onMoved(int i6, int i7);

    void onRemoved(int i6, int i7);
}

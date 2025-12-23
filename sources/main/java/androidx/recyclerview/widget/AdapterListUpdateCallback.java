package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    @NonNull
    private final RecyclerView.Adapter mAdapter;

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i6, int i7, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i6, i7, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i6, int i7) {
        this.mAdapter.notifyItemRangeInserted(i6, i7);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i6, int i7) {
        this.mAdapter.notifyItemMoved(i6, i7);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i6, int i7) {
        this.mAdapter.notifyItemRangeRemoved(i6, i7);
    }

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }
}

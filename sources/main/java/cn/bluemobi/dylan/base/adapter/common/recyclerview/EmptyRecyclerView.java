package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EmptyRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    View f1155f;

    /* renamed from: g, reason: collision with root package name */
    final RecyclerView.AdapterDataObserver f1156g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            EmptyRecyclerView.this.a();
        }
    }

    public EmptyRecyclerView(Context context) {
        super(context);
        this.f1156g = new a();
    }

    void a() {
        View view = this.f1155f;
        if (view != null) {
            view.setVisibility(getAdapter().getItemCount() > 0 ? 8 : 0);
        }
    }

    public void setEmptyView(View view) {
        this.f1155f = view;
        a();
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1156g = new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f1156g);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f1156g);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z5) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f1156g);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f1156g);
        }
        super.swapAdapter(adapter, z5);
        a();
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1156g = new a();
    }
}

package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class d extends RecyclerView.Adapter<c> {
    private List<Presenter> Va = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i6) {
        cVar.mPresenter.n(cVar.Th);
    }

    protected abstract c c(ViewGroup viewGroup, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.mPresenter.ny();
    }

    public final void rG() {
        Iterator<Presenter> it = this.Va.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i6) {
        c c6 = c(viewGroup, i6);
        this.Va.add(c6.mPresenter);
        return c6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        rG();
    }
}

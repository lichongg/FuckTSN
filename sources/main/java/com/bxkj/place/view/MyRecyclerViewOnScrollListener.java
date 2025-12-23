package com.bxkj.place.view;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyRecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {

    /* renamed from: t, reason: collision with root package name */
    private RecyclerView f17572t;

    public MyRecyclerViewOnScrollListener(RecyclerView other) {
        this.f17572t = other;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            recyclerView.removeOnScrollListener(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        this.f17572t.scrollBy(dx, dy);
    }
}

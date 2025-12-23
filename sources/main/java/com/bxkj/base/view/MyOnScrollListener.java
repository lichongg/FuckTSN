package com.bxkj.base.view;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyOnScrollListener extends RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i6) {
        super.onScrollStateChanged(recyclerView, i6);
        if (i6 == 0) {
            recyclerView.removeOnScrollListener(this);
        }
    }
}

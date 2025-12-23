package com.bxkj.student.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyEmptyRecyclerView extends RecyclerView {
    private View mEmptyView;
    private RecyclerView.AdapterDataObserver mObserver;

    public void setEmptyView(View view) {
        this.mEmptyView = view;
    }

    public MyEmptyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mObserver = new RecyclerView.AdapterDataObserver() { // from class: com.bxkj.student.common.view.MyEmptyRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int positionStart, int itemCount) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                if (MyEmptyRecyclerView.this.getAdapter().getItemCount() == 0) {
                    MyEmptyRecyclerView.this.mEmptyView.setVisibility(0);
                    MyEmptyRecyclerView.this.setVisibility(8);
                } else {
                    MyEmptyRecyclerView.this.mEmptyView.setVisibility(8);
                    MyEmptyRecyclerView.this.setVisibility(0);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                onChanged();
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        adapter.registerAdapterDataObserver(this.mObserver);
        this.mObserver.onChanged();
    }
}

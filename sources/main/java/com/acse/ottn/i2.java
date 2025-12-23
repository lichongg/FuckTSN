package com.acse.ottn;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i2 extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public int f4637a;

    public i2(@Px int i6) {
        this.f4637a = i6;
    }

    public final LinearLayoutManager a(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (a(recyclerView).getOrientation() == 1) {
            int i6 = this.f4637a;
            rect.top = i6;
            rect.bottom = i6;
        } else {
            int i7 = this.f4637a;
            rect.left = i7;
            rect.right = i7;
        }
    }
}

package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g extends RecyclerView {
    private boolean Vd;

    public g(Context context) {
        super(context);
    }

    public g(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z5) {
        if (this.Vd) {
            super.removeDetachedView(view, z5);
        } else {
            super.removeDetachedView(view, z5);
        }
    }

    public void setIngoreTmpDetachedFlag(boolean z5) {
        this.Vd = z5;
    }

    public g(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }
}

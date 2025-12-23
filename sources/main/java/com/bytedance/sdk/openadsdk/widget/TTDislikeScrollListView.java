package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.core.dislike.j.xt;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTDislikeScrollListView extends ListView {
    private AdapterView.OnItemClickListener cw;

    /* renamed from: j, reason: collision with root package name */
    private xt f31969j;
    private AdapterView.OnItemClickListener xt;

    private void j() {
        super.setOnItemClickListener(this.cw);
    }

    public void setDislikeController(xt xtVar) {
        this.f31969j = xtVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.xt = onItemClickListener;
    }

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.cw = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j6) {
                if (TTDislikeScrollListView.this.getAdapter() == null || TTDislikeScrollListView.this.getAdapter().getItem(i6) == null || !(TTDislikeScrollListView.this.getAdapter().getItem(i6) instanceof m)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                m mVar = (m) TTDislikeScrollListView.this.getAdapter().getItem(i6);
                if (mVar.m()) {
                    return;
                }
                if (TTDislikeScrollListView.this.xt != null) {
                    TTDislikeScrollListView.this.xt.onItemClick(adapterView, view, i6, j6);
                }
                if (TTDislikeScrollListView.this.f31969j != null) {
                    TTDislikeScrollListView.this.f31969j.j(mVar);
                }
            }
        };
        j();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}

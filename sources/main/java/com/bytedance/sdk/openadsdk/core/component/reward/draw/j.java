package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends RecyclerView.j<up> {
    private final float cw;

    /* renamed from: j, reason: collision with root package name */
    private final Context f28201j;

    /* renamed from: r, reason: collision with root package name */
    private final float f28202r;
    private final List<xt> xt = new ArrayList();
    private final List<up> up = new ArrayList();

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public int j() {
        return Integer.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public long xt(int i6) {
        return i6;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    /* renamed from: cw, reason: merged with bridge method [inline-methods] */
    public up j(ViewGroup viewGroup, int i6) {
        up upVar = new up(com.bytedance.sdk.openadsdk.res.up.qv(this.f28201j));
        this.up.add(upVar);
        return upVar;
    }

    public void r() {
        Iterator<up> it = this.up.iterator();
        while (it.hasNext()) {
            it.next().wq();
        }
        this.up.clear();
    }

    public j(Context context, float f6, float f7) {
        this.f28201j = context;
        this.cw = f6;
        this.f28202r = f7;
    }

    public void j(List<xt> list) {
        this.xt.clear();
        this.xt.addAll(list);
        cw();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public void j(up upVar) {
        super.j((j) upVar);
        upVar.wq();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public void j(up upVar, int i6) {
        List<xt> list = this.xt;
        upVar.j(list.get(i6 % list.size()), this.cw, this.f28202r);
    }
}

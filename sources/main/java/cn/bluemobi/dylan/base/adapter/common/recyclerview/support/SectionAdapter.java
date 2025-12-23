package cn.bluemobi.dylan.base.adapter.common.recyclerview.support;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class SectionAdapter<T> extends MultiItemCommonAdapter<T> {

    /* renamed from: p, reason: collision with root package name */
    private static final int f1159p = 0;

    /* renamed from: l, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.support.a f1160l;

    /* renamed from: m, reason: collision with root package name */
    private LinkedHashMap<String, Integer> f1161m;

    /* renamed from: n, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.a<T> f1162n;

    /* renamed from: o, reason: collision with root package name */
    final RecyclerView.AdapterDataObserver f1163o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            SectionAdapter.this.p();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<T> {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int a(int i6, T t5) {
            SectionAdapter.this.q(i6);
            return !SectionAdapter.this.f1161m.values().contains(Integer.valueOf(i6)) ? 1 : 0;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int i6) {
            return i6 == 0 ? SectionAdapter.this.f1160l.c() : ((CommonAdapter) SectionAdapter.this).f1139f;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cn.bluemobi.dylan.base.adapter.common.recyclerview.a f1166a;

        c(cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar) {
            this.f1166a = aVar;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int a(int i6, T t5) {
            int q5 = SectionAdapter.this.q(i6);
            if (SectionAdapter.this.f1161m.values().contains(Integer.valueOf(i6))) {
                return 0;
            }
            return this.f1166a.a(q5, t5);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int i6) {
            return i6 == 0 ? SectionAdapter.this.f1160l.c() : this.f1166a.b(i6);
        }
    }

    public SectionAdapter(Context context, int i6, List<T> list, cn.bluemobi.dylan.base.adapter.common.recyclerview.support.a aVar) {
        this(context, i6, null, list, aVar);
    }

    private void r(int i6, cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar) {
        if (i6 != -1) {
            this.f1162n = new b();
        } else {
            if (aVar == null) {
                throw new RuntimeException("layoutId or MultiItemTypeSupport must set one.");
            }
            this.f1162n = new c(aVar);
        }
    }

    public SectionAdapter(Context context, cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar, List<T> list, cn.bluemobi.dylan.base.adapter.common.recyclerview.support.a aVar2) {
        this(context, -1, aVar, list, aVar2);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    protected boolean f(int i6) {
        if (i6 == 0) {
            return false;
        }
        return super.f(i6);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i6) {
        return this.f1158k.a(i6, null);
    }

    public void p() {
        int size = this.f1140g.size();
        this.f1161m.clear();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            String a6 = this.f1160l.a(this.f1140g.get(i7));
            if (!this.f1161m.containsKey(a6)) {
                this.f1161m.put(a6, Integer.valueOf(i7 + i6));
                i6++;
            }
        }
    }

    public int q(int i6) {
        Iterator<Map.Entry<String, Integer>> it = this.f1161m.entrySet().iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (it.next().getValue().intValue() < i6) {
                i7++;
            }
        }
        return i6 - i7;
    }

    public SectionAdapter(Context context, int i6, cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar, List<T> list, cn.bluemobi.dylan.base.adapter.common.recyclerview.support.a aVar2) {
        super(context, list, null);
        a aVar3 = new a();
        this.f1163o = aVar3;
        this.f1139f = i6;
        r(i6, aVar);
        this.f1158k = this.f1162n;
        this.f1160l = aVar2;
        this.f1161m = new LinkedHashMap<>();
        p();
        registerAdapterDataObserver(aVar3);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    protected int e(RecyclerView.ViewHolder viewHolder) {
        return q(viewHolder.getAdapterPosition());
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return super.getItemCount() + this.f1161m.size();
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(ViewHolder viewHolder, int i6) {
        int q5 = q(i6);
        if (viewHolder.getItemViewType() == 0) {
            viewHolder.J(this.f1160l.b(), this.f1160l.a(this.f1140g.get(q5)));
        } else {
            super.onBindViewHolder(viewHolder, q5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        unregisterAdapterDataObserver(this.f1163o);
    }
}

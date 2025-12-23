package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: e, reason: collision with root package name */
    protected Context f1138e;

    /* renamed from: f, reason: collision with root package name */
    protected int f1139f;

    /* renamed from: g, reason: collision with root package name */
    protected List<T> f1140g;

    /* renamed from: h, reason: collision with root package name */
    protected LayoutInflater f1141h;

    /* renamed from: i, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.b f1142i;

    /* renamed from: j, reason: collision with root package name */
    private c f1143j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewHolder f1144a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1145b;

        a(ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f1144a = viewHolder;
            this.f1145b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int e6;
            List<T> list;
            if (CommonAdapter.this.f1142i == null || (e6 = CommonAdapter.this.e(this.f1144a)) == -1 || (list = CommonAdapter.this.f1140g) == null || e6 >= list.size()) {
                return;
            }
            CommonAdapter.this.f1142i.a(this.f1145b, view, CommonAdapter.this.f1140g.get(e6), e6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewHolder f1147a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1148b;

        b(ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f1147a = viewHolder;
            this.f1148b = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int e6;
            List<T> list;
            if (CommonAdapter.this.f1143j == null || (e6 = CommonAdapter.this.e(this.f1147a)) == -1 || (list = CommonAdapter.this.f1140g) == null || e6 >= list.size()) {
                return false;
            }
            return CommonAdapter.this.f1143j.a(this.f1148b, view, CommonAdapter.this.f1140g.get(e6), e6);
        }
    }

    public abstract void c(ViewHolder viewHolder, T t5);

    protected boolean f(int i6) {
        return true;
    }

    public List<T> d() {
        return this.f1140g;
    }

    public void g(List<T> list) {
        this.f1140g = list;
        notifyDataSetChanged();
    }

    public T getItem(int i6) {
        return this.f1140g.get(i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.f1140g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
        ViewHolder a6 = ViewHolder.a(this.f1138e, null, viewGroup, this.f1139f);
        j(viewGroup, a6, i6);
        return a6;
    }

    public void k(cn.bluemobi.dylan.base.adapter.common.recyclerview.b bVar) {
        this.f1142i = bVar;
    }

    public void l(c cVar) {
        this.f1143j = cVar;
    }

    public CommonAdapter(Context context, int i6, List<T> list) {
        this.f1138e = context;
        this.f1141h = LayoutInflater.from(context);
        this.f1139f = i6;
        this.f1140g = list;
    }

    protected int e(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i6) {
        viewHolder.v(i6);
        c(viewHolder, this.f1140g.get(i6));
    }

    protected void j(ViewGroup viewGroup, ViewHolder viewHolder, int i6) {
        if (!f(i6)) {
            return;
        }
        viewHolder.b().setOnClickListener(new a(viewHolder, viewGroup));
        viewHolder.b().setOnLongClickListener(new b(viewHolder, viewGroup));
    }
}

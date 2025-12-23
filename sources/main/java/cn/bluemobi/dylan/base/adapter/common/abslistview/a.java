package cn.bluemobi.dylan.base.adapter.common.abslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a<T> extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    protected Context f1133a;

    /* renamed from: b, reason: collision with root package name */
    protected List<T> f1134b;

    /* renamed from: c, reason: collision with root package name */
    protected LayoutInflater f1135c;

    /* renamed from: d, reason: collision with root package name */
    private int f1136d;

    public abstract void a(ViewHolder viewHolder, T t5);

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return i6;
    }

    public List<T> b() {
        return this.f1134b;
    }

    public void c(List<T> list) {
        this.f1134b = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.f1134b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i6) {
        return this.f1134b.get(i6);
    }

    @Override // android.widget.Adapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        ViewHolder a6 = ViewHolder.a(this.f1133a, view, viewGroup, this.f1136d);
        a6.v(i6);
        a(a6, getItem(i6));
        return a6.b();
    }

    public a(Context context, int i6, List<T> list) {
        this.f1133a = context;
        this.f1135c = LayoutInflater.from(context);
        this.f1134b = list;
        this.f1136d = i6;
    }
}

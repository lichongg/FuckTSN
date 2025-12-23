package cn.bluemobi.dylan.base.adapter.common.abslistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class b<T> extends a<T> {

    /* renamed from: e, reason: collision with root package name */
    protected c<T> f1137e;

    public b(Context context, List<T> list, c<T> cVar) {
        super(context, -1, list);
        this.f1137e = cVar;
        if (cVar == null) {
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i6) {
        c<T> cVar = this.f1137e;
        return cVar != null ? cVar.a(i6, this.f1134b.get(i6)) : super.getItemViewType(i6);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a, android.widget.Adapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        c<T> cVar = this.f1137e;
        if (cVar == null) {
            return super.getView(i6, view, viewGroup);
        }
        ViewHolder a6 = ViewHolder.a(this.f1133a, view, viewGroup, cVar.b(i6, getItem(i6)));
        a6.v(i6);
        a(a6, getItem(i6));
        return a6.b();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        c<T> cVar = this.f1137e;
        return cVar != null ? cVar.getViewTypeCount() : super.getViewTypeCount();
    }
}

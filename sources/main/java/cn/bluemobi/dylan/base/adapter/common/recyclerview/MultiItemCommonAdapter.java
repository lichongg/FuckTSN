package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.view.ViewGroup;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    /* renamed from: k, reason: collision with root package name */
    protected a<T> f1158k;

    public MultiItemCommonAdapter(Context context, List<T> list, a<T> aVar) {
        super(context, -1, list);
        this.f1158k = aVar;
        if (aVar == null) {
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i6) {
        a<T> aVar = this.f1158k;
        return aVar != null ? aVar.a(i6, this.f1140g.get(i6)) : super.getItemViewType(i6);
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
        a<T> aVar = this.f1158k;
        if (aVar == null) {
            return super.onCreateViewHolder(viewGroup, i6);
        }
        ViewHolder a6 = ViewHolder.a(this.f1138e, null, viewGroup, aVar.b(i6));
        j(viewGroup, a6, i6);
        return a6;
    }
}

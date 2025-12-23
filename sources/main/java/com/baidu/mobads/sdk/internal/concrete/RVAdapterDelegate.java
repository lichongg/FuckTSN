package com.baidu.mobads.sdk.internal.concrete;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RVAdapterDelegate extends RecyclerView.Adapter<RVViewHolderDelegate> implements a {

    /* renamed from: a, reason: collision with root package name */
    private final c f10940a;

    /* renamed from: b, reason: collision with root package name */
    private final b f10941b;

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f10940a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f10940a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f10940a.getDelegator();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Object a6 = this.f10940a.a("getItemCount", new Object[0]);
        if (a6 instanceof Integer) {
            return ((Integer) a6).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i6) {
        return this.f10940a.a("getItemId", Integer.valueOf(i6)) instanceof Integer ? ((Integer) r0).intValue() : super.getItemId(i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i6) {
        Object a6 = this.f10940a.a("getItemType", Integer.valueOf(i6));
        return a6 instanceof Integer ? ((Integer) a6).intValue() : super.getItemViewType(i6);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f10940a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f10940a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f10940a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("notifyItemChanged".equals(str2)) {
            notifyItemChanged(this.f10941b.a(objArr, 0, 0), this.f10941b.a(objArr, 1, (Object) null));
        } else if ("notifyRangeInserted".equals(str2)) {
            notifyItemRangeInserted(this.f10941b.a(objArr, 0, 0), this.f10941b.a(objArr, 1, 0));
        } else if ("notifyRangeRemoved".equals(str2)) {
            notifyItemRangeRemoved(this.f10941b.a(objArr, 0, 0), this.f10941b.a(objArr, 1, 0));
        } else if ("notifyItemRangeChanged".equals(str2)) {
            notifyItemRangeChanged(this.f10941b.a(objArr, 0, 0), this.f10941b.a(objArr, 1, 0));
        } else if ("notifyDataSetChanged".equals(str2)) {
            notifyDataSetChanged();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RVViewHolderDelegate rVViewHolderDelegate, int i6) {
        this.f10940a.a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), Integer.valueOf(i6));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RVViewHolderDelegate onCreateViewHolder(@NonNull ViewGroup viewGroup, int i6) {
        Object a6 = this.f10940a.a("onCreateViewHolder", viewGroup, Integer.valueOf(i6));
        return a6 instanceof RVViewHolderDelegate ? (RVViewHolderDelegate) a6 : new RVViewHolderDelegate(this.f10940a.getDelegator(), viewGroup) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.2
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        Object a6 = this.f10940a.a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
        return a6 instanceof Boolean ? ((Boolean) a6).booleanValue() : super.onFailedToRecycleView((RVAdapterDelegate) rVViewHolderDelegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewAttachedToWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.f10940a.a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewDetachedFromWindow((RVAdapterDelegate) rVViewHolderDelegate);
        this.f10940a.a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewRecycled((RVAdapterDelegate) rVViewHolderDelegate);
        this.f10940a.a("onViewRecycled", rVViewHolderDelegate.getDelegator());
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f10940a.setTarget(obj);
    }

    public RVAdapterDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f10940a = c.a(iAdInterListener, this);
        registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                RVAdapterDelegate.this.f10940a.a("onChanged");
            }
        });
        this.f10941b = new b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f10940a.a("onAttachedToRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f10940a.a("onDetachedFromRecyclerView", recyclerView);
    }
}

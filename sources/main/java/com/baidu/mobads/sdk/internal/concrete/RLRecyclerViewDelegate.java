package com.baidu.mobads.sdk.internal.concrete;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.RLRecyclerView;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RLRecyclerViewDelegate extends RLRecyclerView implements a {

    /* renamed from: a, reason: collision with root package name */
    private final c f10935a;

    /* renamed from: b, reason: collision with root package name */
    private final b f10936b;

    public RLRecyclerViewDelegate(IAdInterListener iAdInterListener, Object[] objArr) {
        super((Context) objArr[0]);
        b bVar = new b();
        this.f10936b = bVar;
        setLayoutManager(bVar.a(objArr, 1, 1), bVar.a(objArr, 2, 1), bVar.a(objArr, 3, 0));
        this.f10935a = c.a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f10935a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f10935a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f10935a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f10935a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f10935a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f10935a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("setAdapter".equals(str2)) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if ("setRefreshing".equals(str2)) {
            setRefreshing(((Boolean) objArr[0]).booleanValue());
            return null;
        }
        if ("setItemDecoration".equals(str2)) {
            setItemDecoration(this.f10936b.a(objArr, 0, 4), this.f10936b.a(objArr, 1, 10), this.f10936b.a(objArr, 2, 4), this.f10936b.a(objArr, 3, 10));
            return null;
        }
        if ("setRvPadding".equals(str2)) {
            setRecyclerViewPadding(this.f10936b.a(objArr, 0, 6), this.f10936b.a(objArr, 1, 0), this.f10936b.a(objArr, 2, 6), this.f10936b.a(objArr, 3, 0));
            return null;
        }
        if ("setRefreshEnable".equals(str2)) {
            setEnabled(((Boolean) objArr[0]).booleanValue());
            return null;
        }
        if ("scrollToPosition".equals(str2)) {
            scrollToPosition(this.f10936b.a(objArr, 0, 0));
            return null;
        }
        if ("addOnScrollListener".equals(str2)) {
            final Object obj = objArr[0];
            addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i6) {
                    super.onScrollStateChanged(recyclerView, i6);
                    RLRecyclerViewDelegate.this.f10935a.a("onScrollStateChanged", obj, Integer.valueOf(i6));
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i6, int i7) {
                    super.onScrolled(recyclerView, i6, i7);
                    RLRecyclerViewDelegate.this.f10935a.a("onScrolled", obj, Integer.valueOf(i6), Integer.valueOf(i7));
                }
            });
            return null;
        }
        if ("setOnRefreshListener".equals(str2)) {
            setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.2
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public void onRefresh() {
                    RLRecyclerViewDelegate.this.f10935a.a("onRefresh");
                }
            });
            return null;
        }
        if ("findVisibleItemPositions".equals(str2)) {
            return findVisibleItemPositions();
        }
        if ("getLayoutManagerCounts".equals(str2)) {
            return getLayoutManagerCounts();
        }
        if ("getRvChildAt".equals(str2)) {
            return getRvChildAt(this.f10936b.a(objArr, 0, -1));
        }
        if ("getRvChildCount".equals(str2)) {
            return Integer.valueOf(getRvChildCount());
        }
        if ("indexOfRvChild".equals(str2)) {
            return Integer.valueOf(indexOfRvChild((View) objArr[0]));
        }
        if ("getChildAdapterPosition".equals(str2)) {
            return Integer.valueOf(getChildAdapterPosition((View) objArr[0]));
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f10935a.setTarget(obj);
    }
}

package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nEmptyRecyclerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmptyRecyclerView.kt\ncom/bxkj/base/v2/common/view/EmptyRecyclerView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,113:1\n1#2:114\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class EmptyRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private View f16992f;

    /* renamed from: g, reason: collision with root package name */
    private int f16993g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final RecyclerView.AdapterDataObserver f16994h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyRecyclerView(@Nullable Context context) {
        super(context);
        g0.m(context);
        this.f16993g = -1;
        this.f16994h = new RecyclerView.AdapterDataObserver() { // from class: com.bxkj.base.v2.common.view.EmptyRecyclerView$observer$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i6, int i7) {
                super.onItemRangeChanged(i6, i7);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i6, int i7) {
                super.onItemRangeInserted(i6, i7);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i6, int i7, int i8) {
                super.onItemRangeMoved(i6, i7, i8);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i6, int i7) {
                super.onItemRangeRemoved(i6, i7);
                EmptyRecyclerView.this.a();
            }
        };
    }

    private final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmptyRecyclerView);
        g0.o(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f16993g = obtainStyledAttributes.getResourceId(R.styleable.EmptyRecyclerView_emptyId, -1);
    }

    public final void a() {
        RecyclerView.Adapter adapter;
        View view = this.f16992f;
        if (view == null || (adapter = getAdapter()) == null) {
            return;
        }
        view.setVisibility(adapter.getItemCount() > 0 ? 8 : 0);
    }

    public final void setEmptyView(@Nullable View view) {
        this.f16992f = view;
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View findViewById;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent != null) {
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup instanceof SmartRefreshLayout) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) viewGroup;
                    if (smartRefreshLayout.getParent() instanceof ViewGroup) {
                        ViewParent parent2 = smartRefreshLayout.getParent();
                        g0.n(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                        viewGroup = (ViewGroup) parent2;
                    }
                }
                int i6 = this.f16993g;
                if (i6 == -1) {
                    findViewById = LayoutInflater.from(getContext()).inflate(R.layout.v2_pub_empty, viewGroup, false);
                    viewGroup.addView(findViewById);
                } else {
                    findViewById = viewGroup.findViewById(i6);
                }
                this.f16992f = findViewById;
            }
        }
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f16994h);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f16994h);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(@Nullable RecyclerView.Adapter<?> adapter, boolean z5) {
        RecyclerView.Adapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f16994h);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f16994h);
        }
        super.swapAdapter(adapter, z5);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g0.m(context);
        this.f16993g = -1;
        this.f16994h = new RecyclerView.AdapterDataObserver() { // from class: com.bxkj.base.v2.common.view.EmptyRecyclerView$observer$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i6, int i7) {
                super.onItemRangeChanged(i6, i7);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i6, int i7) {
                super.onItemRangeInserted(i6, i7);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i6, int i7, int i8) {
                super.onItemRangeMoved(i6, i7, i8);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i6, int i7) {
                super.onItemRangeRemoved(i6, i7);
                EmptyRecyclerView.this.a();
            }
        };
        b(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        g0.m(context);
        this.f16993g = -1;
        this.f16994h = new RecyclerView.AdapterDataObserver() { // from class: com.bxkj.base.v2.common.view.EmptyRecyclerView$observer$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i62, int i7) {
                super.onItemRangeChanged(i62, i7);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i62, int i7) {
                super.onItemRangeInserted(i62, i7);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i62, int i7, int i8) {
                super.onItemRangeMoved(i62, i7, i8);
                EmptyRecyclerView.this.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i62, int i7) {
                super.onItemRangeRemoved(i62, i7);
                EmptyRecyclerView.this.a();
            }
        };
        b(context, attributeSet);
    }
}

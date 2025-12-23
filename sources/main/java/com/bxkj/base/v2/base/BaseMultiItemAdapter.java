package com.bxkj.base.v2.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBaseMultiItemAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMultiItemAdapter.kt\ncom/bxkj/base/v2/base/BaseMultiItemAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,184:1\n4225#2,11:185\n*S KotlinDebug\n*F\n+ 1 BaseMultiItemAdapter.kt\ncom/bxkj/base/v2/base/BaseMultiItemAdapter\n*L\n77#1:185,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class BaseMultiItemAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private List<? extends T> f16688e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private View f16689f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class BaseViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private ViewDataBinding f16691d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull ViewDataBinding binding) {
            super(binding.getRoot());
            g0.p(binding, "binding");
            this.f16691d = binding;
        }

        @NotNull
        public final ViewDataBinding a() {
            return this.f16691d;
        }

        public final void b(@NotNull ViewDataBinding viewDataBinding) {
            g0.p(viewDataBinding, "<set-?>");
            this.f16691d = viewDataBinding;
        }
    }

    public BaseMultiItemAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract void g(@NotNull ViewDataBinding viewDataBinding, T t5, int i6);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract int getItemViewType(int i6);

    public abstract int j(int i6);

    public /* synthetic */ BaseMultiItemAdapter(List list, int i6, v vVar) {
        this((i6 & 1) != 0 ? new ArrayList() : list);
    }

    public static /* synthetic */ void c(BaseMultiItemAdapter baseMultiItemAdapter, List list, Integer num, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addData");
        }
        if ((i6 & 2) != 0) {
            num = null;
        }
        baseMultiItemAdapter.b(list, num);
    }

    static /* synthetic */ ViewBinding l(BaseMultiItemAdapter baseMultiItemAdapter, Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i6, int i7, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewBinding");
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return baseMultiItemAdapter.k(obj, layoutInflater, viewGroup, i6);
    }

    public final void b(@Nullable List<? extends T> list, @Nullable Integer num) {
        List<? extends T> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.f16688e);
        if (num != null) {
            int intValue = num.intValue();
            if (intValue < 0) {
                intValue = 0;
            } else if (intValue >= linkedList.size()) {
                intValue = linkedList.size();
            }
            linkedList.addAll(intValue, list2);
        } else {
            linkedList.addAll(list2);
        }
        o(linkedList);
    }

    public void f() {
        View view = this.f16689f;
        if (view != null) {
            view.setVisibility(getItemCount() > 0 ? 8 : 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.f16688e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Nullable
    public final List<T> h() {
        return this.f16688e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull BaseViewHolder holder, int i6) {
        g0.p(holder, "holder");
        ViewDataBinding a6 = holder.a();
        List<? extends T> list = this.f16688e;
        g0.m(list);
        g(a6, list.get(i6), i6);
        holder.a().executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i6) {
        g0.p(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), j(i6), parent, false);
        if (inflate != null) {
            return new BaseViewHolder(inflate);
        }
        RecyclerView.ViewHolder createViewHolder = super.createViewHolder(parent, i6);
        g0.m(createViewHolder);
        return (BaseViewHolder) createViewHolder;
    }

    public final void o(@Nullable final List<? extends T> list) {
        if (list == null) {
            this.f16688e = new ArrayList();
            notifyItemRangeChanged(0, getItemCount());
        } else {
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: com.bxkj.base.v2.base.BaseMultiItemAdapter$setData$1$result$1

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ BaseMultiItemAdapter<T> f16692a;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f16692a = this;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i6, int i7) {
                    List list2;
                    list2 = ((BaseMultiItemAdapter) this.f16692a).f16688e;
                    g0.m(list2);
                    return this.f16692a.d(list2.get(i6), list.get(i7), i6, i7);
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i6, int i7) {
                    List list2;
                    list2 = ((BaseMultiItemAdapter) this.f16692a).f16688e;
                    g0.m(list2);
                    return this.f16692a.e(list2.get(i6), list.get(i7));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.f16692a.getItemCount();
                }
            });
            g0.o(calculateDiff, "calculateDiff(...)");
            this.f16688e = list;
            calculateDiff.dispatchUpdatesTo(this);
        }
    }

    public void p(@NotNull View emptyView) {
        g0.p(emptyView, "emptyView");
        this.f16689f = emptyView;
        f();
    }

    public BaseMultiItemAdapter(@Nullable List<? extends T> list) {
        this.f16688e = list;
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: com.bxkj.base.v2.base.BaseMultiItemAdapter.1

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ BaseMultiItemAdapter<T> f16690b;

            {
                this.f16690b = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                this.f16690b.f();
            }
        });
    }

    private final <VB extends ViewBinding> VB k(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i6) {
        String str;
        Method declaredMethod;
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        g0.n(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        g0.o(actualTypeArguments, "getActualTypeArguments(...)");
        ArrayList arrayList = new ArrayList();
        for (Type type : actualTypeArguments) {
            if (type instanceof Class) {
                arrayList.add(type);
            }
        }
        Class<? super T> superclass = ((Class) arrayList.get(0)).getSuperclass();
        if (superclass != null) {
            str = superclass.getSimpleName();
        } else {
            str = null;
        }
        boolean g6 = g0.g(str, o0.d(ViewDataBinding.class).D());
        Class<?> cls = Boolean.TYPE;
        if (g6) {
            declaredMethod = ((Class) arrayList.get(i6)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, cls);
            g0.m(declaredMethod);
        } else {
            declaredMethod = ((Class) arrayList.get(1)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, cls);
            g0.m(declaredMethod);
        }
        Object invoke = declaredMethod.invoke(null, layoutInflater, viewGroup, Boolean.FALSE);
        g0.n(invoke, "null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseMultiItemAdapter.getViewBinding");
        return (VB) invoke;
    }

    protected boolean d(T t5, T t6, int i6, int i7) {
        return g0.g(t5, t6);
    }

    protected boolean e(T t5, T t6) {
        return g0.g(t5, t6);
    }

    @Nullable
    public final T i(int i6) {
        List<T> h6 = h();
        if (h6 != null) {
            if (i6 == -1) {
                i6 = 0;
            }
            return h6.get(i6);
        }
        return null;
    }
}

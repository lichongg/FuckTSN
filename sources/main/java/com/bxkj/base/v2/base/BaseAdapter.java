package com.bxkj.base.v2.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;
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
@SourceDebugExtension({"SMAP\nBaseAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseAdapter.kt\ncom/bxkj/base/v2/base/BaseAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,145:1\n4225#2,11:146\n*S KotlinDebug\n*F\n+ 1 BaseAdapter.kt\ncom/bxkj/base/v2/base/BaseAdapter\n*L\n42#1:146,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class BaseAdapter<T, VB extends ViewDataBinding> extends RecyclerView.Adapter<BaseViewHolder<VB>> {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private List<? extends T> f16667e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class BaseViewHolder<VB extends ViewDataBinding> extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private VB f16668d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull VB binding) {
            super(binding.getRoot());
            g0.p(binding, "binding");
            this.f16668d = binding;
        }

        @NotNull
        public final VB a() {
            return this.f16668d;
        }

        public final void b(@NotNull VB vb) {
            g0.p(vb, "<set-?>");
            this.f16668d = vb;
        }
    }

    public BaseAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract void f(@NotNull VB vb, T t5, int i6);

    public /* synthetic */ BaseAdapter(List list, int i6, v vVar) {
        this((i6 & 1) != 0 ? new ArrayList() : list);
    }

    public static /* synthetic */ void c(BaseAdapter baseAdapter, List list, Integer num, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addData");
        }
        if ((i6 & 2) != 0) {
            num = null;
        }
        baseAdapter.b(list, num);
    }

    static /* synthetic */ ViewBinding i(BaseAdapter baseAdapter, Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i6, int i7, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewBinding");
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return baseAdapter.h(obj, layoutInflater, viewGroup, i6);
    }

    public final void b(@Nullable List<? extends T> list, @Nullable Integer num) {
        List<? extends T> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.f16667e);
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
        l(linkedList);
    }

    @Nullable
    public final List<T> g() {
        return this.f16667e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.f16667e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull BaseViewHolder<VB> holder, int i6) {
        g0.p(holder, "holder");
        VB a6 = holder.a();
        List<? extends T> list = this.f16667e;
        g0.m(list);
        f(a6, list.get(i6), i6);
        holder.a().executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder<VB> onCreateViewHolder(@NotNull ViewGroup parent, int i6) {
        g0.p(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        g0.o(from, "from(...)");
        return new BaseViewHolder<>(h(this, from, parent, 0));
    }

    public final void l(@Nullable final List<? extends T> list) {
        if (list == null) {
            this.f16667e = new ArrayList();
            notifyItemRangeChanged(0, getItemCount());
        } else {
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: com.bxkj.base.v2.base.BaseAdapter$setData$1$result$1

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ BaseAdapter<T, VB> f16669a;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f16669a = this;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i6, int i7) {
                    List list2;
                    list2 = ((BaseAdapter) this.f16669a).f16667e;
                    g0.m(list2);
                    return this.f16669a.d(list2.get(i6), list.get(i7), i6, i7);
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i6, int i7) {
                    List list2;
                    list2 = ((BaseAdapter) this.f16669a).f16667e;
                    g0.m(list2);
                    return this.f16669a.e(list2.get(i6), list.get(i7));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.f16669a.getItemCount();
                }
            });
            g0.o(calculateDiff, "calculateDiff(...)");
            this.f16667e = list;
            calculateDiff.dispatchUpdatesTo(this);
        }
    }

    public BaseAdapter(@Nullable List<? extends T> list) {
        this.f16667e = list;
    }

    private final <VB extends ViewBinding> VB h(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i6) {
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
        g0.n(invoke, "null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseAdapter.getViewBinding");
        return (VB) ((ViewBinding) invoke);
    }

    protected boolean d(T t5, T t6, int i6, int i7) {
        return g0.g(t5, t6);
    }

    protected boolean e(T t5, T t6) {
        return g0.g(t5, t6);
    }
}

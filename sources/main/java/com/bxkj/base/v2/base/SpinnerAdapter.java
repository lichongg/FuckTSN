package com.bxkj.base.v2.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSpinnerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpinnerAdapter.kt\ncom/bxkj/base/v2/base/SpinnerAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,61:1\n4225#2,11:62\n*S KotlinDebug\n*F\n+ 1 SpinnerAdapter.kt\ncom/bxkj/base/v2/base/SpinnerAdapter\n*L\n34#1:62,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class SpinnerAdapter<T, VB extends ViewDataBinding> extends android.widget.BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private List<? extends T> f16727a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class BaseViewHolder<VB extends ViewDataBinding> extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private VB f16728d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull VB binding) {
            super(binding.getRoot());
            g0.p(binding, "binding");
            this.f16728d = binding;
        }

        @NotNull
        public final VB a() {
            return this.f16728d;
        }

        public final void b(@NotNull VB vb) {
            g0.p(vb, "<set-?>");
            this.f16728d = vb;
        }
    }

    public SpinnerAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract void a(@NotNull VB vb, T t5, int i6);

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return i6;
    }

    public /* synthetic */ SpinnerAdapter(List list, int i6, v vVar) {
        this((i6 & 1) != 0 ? new ArrayList() : list);
    }

    static /* synthetic */ ViewBinding c(SpinnerAdapter spinnerAdapter, Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i6, int i7, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewBinding");
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return spinnerAdapter.b(obj, layoutInflater, viewGroup, i6);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends T> list = this.f16727a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    @Nullable
    public T getItem(int i6) {
        List<? extends T> list = this.f16727a;
        if (list != null) {
            return list.get(i6);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    @NotNull
    public View getView(int i6, @Nullable View view, @Nullable ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null);
        g0.o(from, "from(...)");
        BaseViewHolder baseViewHolder = new BaseViewHolder((ViewDataBinding) b(this, from, viewGroup, 0));
        List<? extends T> list = this.f16727a;
        g0.m(list);
        a(baseViewHolder.a(), list.get(i6), i6);
        View itemView = baseViewHolder.itemView;
        g0.o(itemView, "itemView");
        return itemView;
    }

    private final <VB extends ViewBinding> VB b(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i6) {
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
        Object invoke = ((Class) arrayList.get(i6)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, layoutInflater, viewGroup, Boolean.FALSE);
        g0.n(invoke, "null cannot be cast to non-null type VB of com.bxkj.base.v2.base.SpinnerAdapter.getViewBinding");
        return (VB) ((ViewBinding) invoke);
    }

    public SpinnerAdapter(@Nullable List<? extends T> list) {
        this.f16727a = list;
    }
}

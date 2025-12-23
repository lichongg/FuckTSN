package com.acse.ottn;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class t<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements o1<T, VH> {

    /* renamed from: b, reason: collision with root package name */
    public x2 f5303b;

    /* renamed from: c, reason: collision with root package name */
    public VH f5304c;

    /* renamed from: a, reason: collision with root package name */
    public List<T> f5302a = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public int f5305d = 2;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5306a;

        public a(int i6) {
            this.f5306a = i6;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.this.f5303b.a(t.this.f5302a.get(this.f5306a), this.f5306a);
        }
    }

    public int b(int i6) {
        return y.a(this.f5305d == 2, i6, a());
    }

    public void a(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f5302a = list;
    }

    public VH b() {
        return this.f5304c;
    }

    public void c(int i6) {
        this.f5305d = i6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh, int i6) {
        this.f5304c = vh;
        int b6 = b(i6);
        a(vh, this.f5302a.get(b6), b6, a());
        if (this.f5303b != null) {
            vh.itemView.setOnClickListener(new a(b6));
        }
    }

    public t(List<T> list) {
        a(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (a() > 1) {
            return a() + this.f5305d;
        }
        return a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i6) {
        return (VH) a(viewGroup, i6);
    }

    public T a(int i6) {
        return this.f5302a.get(i6);
    }

    public int a() {
        List<T> list = this.f5302a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(x2 x2Var) {
        this.f5303b = x2Var;
    }
}

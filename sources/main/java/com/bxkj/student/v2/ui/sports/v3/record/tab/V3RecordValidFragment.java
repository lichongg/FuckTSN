package com.bxkj.student.v2.ui.sports.v3.record.tab;

import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.student.databinding.V3FmValidRecordListBinding;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.bxkj.student.v2.vm.sports.record.RecordVM;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RecordValidFragment extends BaseFragment<V3FmValidRecordListBinding, RecordVM> {

    /* renamed from: l, reason: collision with root package name */
    private int f21861l = 1;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private List<Map<String, Object>> f21862m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> f21863n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements n2.e {
        a() {
        }

        @Override // n2.d
        public void a(m2.h hVar) {
            V3RecordValidFragment.this.f21861l = 1;
            V3RecordValidFragment.this.j();
        }

        @Override // n2.b
        public void f(m2.h hVar) {
            V3RecordValidFragment.this.f21861l++;
            V3RecordValidFragment.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 k(V3RecordValidFragment v3RecordValidFragment, List it) {
        g0.p(it, "it");
        if (v3RecordValidFragment.f21861l == 1) {
            v3RecordValidFragment.f21862m.clear();
        }
        v3RecordValidFragment.f21862m.addAll(it);
        BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> baseAdapter = v3RecordValidFragment.f21863n;
        if (baseAdapter != null) {
            baseAdapter.l(v3RecordValidFragment.f21862m);
        }
        BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> baseAdapter2 = v3RecordValidFragment.f21863n;
        if (baseAdapter2 != null) {
            baseAdapter2.notifyDataSetChanged();
        }
        return n1.f44123a;
    }

    private final void m() {
        this.f21863n = new V3RecordValidFragment$initAdapter$1(this, this.f21862m);
        L().recyclerView.setAdapter(this.f21863n);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        D().H("1", this.f21861l, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 k6;
                k6 = V3RecordValidFragment.k(V3RecordValidFragment.this, (List) obj);
                return k6;
            }
        }, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 l6;
                l6 = V3RecordValidFragment.l(V3RecordValidFragment.this);
                return l6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(V3RecordValidFragment v3RecordValidFragment) {
        v3RecordValidFragment.L().refresh.Y();
        v3RecordValidFragment.L().refresh.Q();
        return n1.f44123a;
    }

    private final void n() {
        L().refresh.D(new a());
    }

    public final void M() {
        L().refresh.F();
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        n();
        m();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}

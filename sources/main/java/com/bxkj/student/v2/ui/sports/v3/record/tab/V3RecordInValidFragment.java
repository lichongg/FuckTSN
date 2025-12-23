package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.databinding.V3FmInvalidRecordListBinding;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.appeal.V3AppealActivity;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.vm.sports.record.RecordVM;
import com.google.android.material.tabs.TabLayout;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
public final class V3RecordInValidFragment extends BaseFragment<V3FmInvalidRecordListBinding, RecordVM> {

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> f21855o;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private String f21852l = "0";

    /* renamed from: m, reason: collision with root package name */
    private int f21853m = 1;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private List<Map<String, Object>> f21854n = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private Map<String, ? extends Object> f21856p = new LinkedHashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements n2.e {
        a() {
        }

        @Override // n2.d
        public void a(m2.h hVar) {
            V3RecordInValidFragment.this.f21853m = 1;
            V3RecordInValidFragment.this.S();
        }

        @Override // n2.b
        public void f(m2.h hVar) {
            V3RecordInValidFragment.this.f21853m++;
            V3RecordInValidFragment.this.S();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements TabLayout.OnTabSelectedListener {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null) {
                int position = tab.getPosition();
                if (position == 0) {
                    V3RecordInValidFragment.this.f21852l = "0";
                } else if (position == 1) {
                    V3RecordInValidFragment.this.f21852l = "2";
                } else if (position == 2) {
                    V3RecordInValidFragment.this.f21852l = "-1";
                }
                V3RecordInValidFragment.this.L().refresh.F();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    private final void N(int i6, final String str, String str2) {
        String str3;
        if (i6 > 0) {
            str3 = "还剩" + i6 + "次申诉机会,确定是否申诉？";
        } else {
            str3 = "还剩0次申诉机会,无法进行申诉！";
        }
        String str4 = str3;
        if (i6 <= 0) {
            ContextExtKt.m(H(), str4);
        } else {
            ContextExtKt.h(H(), null, str4, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 O;
                    O = V3RecordInValidFragment.O(V3RecordInValidFragment.this, str, (iOSTwoButtonDialog) obj);
                    return O;
                }
            }, null, null, null, 57, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 O(V3RecordInValidFragment v3RecordInValidFragment, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        v3RecordInValidFragment.startActivity(new Intent(v3RecordInValidFragment.H(), (Class<?>) V3AppealActivity.class).putExtra("exerciseRecordId", str));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T(V3RecordInValidFragment v3RecordInValidFragment, List it) {
        g0.p(it, "it");
        if (v3RecordInValidFragment.f21853m == 1) {
            v3RecordInValidFragment.f21854n.clear();
        }
        v3RecordInValidFragment.f21854n.addAll(it);
        BaseAdapter<Map<String, Object>, V3ItemForValidRecordListBinding> baseAdapter = v3RecordInValidFragment.f21855o;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
        return n1.f44123a;
    }

    private final void W() {
        this.f21855o = new V3RecordInValidFragment$initAdapter$1(this, this.f21854n);
        L().recyclerView.setAdapter(this.f21855o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 a0(V3RecordInValidFragment v3RecordInValidFragment, Map it) {
        g0.p(it, "it");
        v3RecordInValidFragment.f21856p = it;
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(Button button, final Map<String, ? extends Object> map) {
        c0 c0Var = c0.f16887a;
        int k6 = c0Var.k(map, "sportType") == 1 ? c0Var.k(this.f21856p, "validitySunRun") : c0Var.k(map, "sportType") == 2 ? c0Var.k(this.f21856p, "validityMorningRun") : -1;
        final int k7 = c0Var.k(map, "sportType") == 1 ? c0Var.k(this.f21856p, "balanceSunRun") : c0Var.k(map, "sportType") == 2 ? c0Var.k(this.f21856p, "balanceMorningRun") : 0;
        double doubleValue = new BigDecimal(System.currentTimeMillis()).subtract(new BigDecimal(c0Var.o(map, AnalyticsConfig.RTD_START_TIME))).divide(new BigDecimal(86400000), 10, 4).doubleValue();
        if (k6 == -1) {
            button.setVisibility(8);
        } else if (doubleValue <= k6) {
            button.setVisibility(0);
            button.setEnabled(c0Var.d(map, "enable"));
            button.setText(c0Var.t(map, "va"));
        } else if (g0.g(c0Var.t(map, NotificationCompat.CATEGORY_STATUS), "1")) {
            button.setVisibility(8);
        } else if (c0Var.d(map, "enable")) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setEnabled(false);
            button.setText(c0Var.t(map, "va"));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3RecordInValidFragment.c0(V3RecordInValidFragment.this, k7, map, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(V3RecordInValidFragment v3RecordInValidFragment, int i6, Map map, View view) {
        c0 c0Var = c0.f16887a;
        v3RecordInValidFragment.N(i6, c0Var.t(map, "id"), c0Var.t(map, "identify"));
    }

    public final void P(@NotNull Map<String, ? extends Object> map) {
        g0.p(map, "map");
        D().R(c0.f16887a.t(map, "identify"), new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 Q;
                Q = V3RecordInValidFragment.Q(V3RecordInValidFragment.this, (String) obj);
                return Q;
            }
        });
    }

    public final void R(@NotNull Map<String, ? extends Object> map) {
        g0.p(map, "map");
        c0 c0Var = c0.f16887a;
        if (TextUtils.isEmpty(c0Var.t(map, "faceUrl"))) {
            return;
        }
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, "核对人脸信息");
        linkedHashMap.put("linkUrl", c0Var.t(map, "faceUrl"));
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
    }

    public final void V(@NotNull Map<String, ? extends Object> map) {
        g0.p(map, "map");
        c0 c0Var = c0.f16887a;
        if (c0Var.d(map, "isLocal")) {
            startActivity(new Intent(H(), (Class<?>) V3RecordDetailActivity.class).putExtra("identify", c0Var.t(map, "identify")));
        } else {
            startActivity(new Intent(H(), (Class<?>) V3RecordDetailActivity.class).putExtra("exerciseRecordId", c0Var.t(map, "id")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Q(V3RecordInValidFragment v3RecordInValidFragment, String str) {
        Context H = v3RecordInValidFragment.H();
        if (str == null) {
            str = "上传成功";
        }
        ContextExtKt.s(H, str, 0, 2, null);
        com.bxkj.student.v2.common.data.i.f20657a.l0(false);
        V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3SportsHomeActivity.class);
        if (v3SportsHomeActivity != null) {
            v3SportsHomeActivity.y1();
        }
        v3RecordInValidFragment.Z();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        D().H(this.f21852l, this.f21853m, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 T;
                T = V3RecordInValidFragment.T(V3RecordInValidFragment.this, (List) obj);
                return T;
            }
        }, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 U;
                U = V3RecordInValidFragment.U(V3RecordInValidFragment.this);
                return U;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 U(V3RecordInValidFragment v3RecordInValidFragment) {
        v3RecordInValidFragment.L().refresh.Y();
        v3RecordInValidFragment.L().refresh.Q();
        return n1.f44123a;
    }

    private final void X() {
        L().refresh.D(new a());
    }

    private final void Y() {
        L().tb.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
    }

    public final void Z() {
        L().refresh.F();
        D().K(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 a02;
                a02 = V3RecordInValidFragment.a0(V3RecordInValidFragment.this, (Map) obj);
                return a02;
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        Y();
        X();
        W();
        Z();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}

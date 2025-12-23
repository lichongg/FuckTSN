package com.bxkj.student.v2.ui.sports.v3;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.student.databinding.ItemForV3PassPointDialogBinding;
import com.bxkj.student.databinding.V3PassPointDialogBinding;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3PassPointDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3PassPointDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/V3PassPointDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1563#2:92\n1634#2,3:93\n774#2:96\n865#2,2:97\n1056#2:99\n1869#2,2:100\n*S KotlinDebug\n*F\n+ 1 V3PassPointDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/V3PassPointDialog\n*L\n79#1:92\n79#1:93,3\n80#1:96\n80#1:97,2\n82#1:99\n83#1:100,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3PassPointDialog extends BaseDialog<V3PassPointDialogBinding, SportsVM> {

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> f21539l;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final List<Map<String, Object>> f21538k = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private int f21540m = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 V3PassPointDialog.kt\ncom/bxkj/student/v2/ui/sports/v3/V3PassPointDialog\n*L\n1#1,328:1\n82#2:329\n*E\n"})
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
            return kotlin.comparisons.a.l(Integer.valueOf(c0Var.k((Map) t5, "sort")), Integer.valueOf(c0Var.k((Map) t6, "sort")));
        }
    }

    private final void M() {
        List<Map<String, Object>> n6 = com.bxkj.base.v2.common.utils.c0.f16887a.n(D().M(), "list");
        List<Map<String, Object>> x5 = com.bxkj.student.v2.common.data.i.f20657a.x();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(x5, 10));
        Iterator<T> it = x5.iterator();
        while (it.hasNext()) {
            arrayList.add(com.bxkj.base.v2.common.utils.c0.f16887a.t((Map) it.next(), "id"));
        }
        Set f6 = kotlin.collections.f0.f6(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : n6) {
            if (!f6.contains(com.bxkj.base.v2.common.utils.c0.f16887a.t((Map) obj, "id"))) {
                arrayList2.add(obj);
            }
        }
        for (Map<String, ? extends Object> map : kotlin.collections.f0.z5(arrayList2, new a())) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
            linkedHashMap.put("sort", c0Var.t(map, "sort"));
            linkedHashMap.put(CommonNetImpl.NAME, c0Var.t(map, "content"));
            this.f21538k.add(linkedHashMap);
        }
        BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter = this.f21539l;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    private final void P() {
        final List<Map<String, Object>> list = this.f21538k;
        this.f21539l = new BaseAdapter<Map<String, ? extends Object>, ItemForV3PassPointDialogBinding>(list) { // from class: com.bxkj.student.v2.ui.sports.v3.V3PassPointDialog$initAdapter$1
            @Override // com.bxkj.base.v2.base.BaseAdapter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public void f(ItemForV3PassPointDialogBinding itemBinding, Map<String, ? extends Object> bean, int i6) {
                int i7;
                String t5;
                kotlin.jvm.internal.g0.p(itemBinding, "itemBinding");
                kotlin.jvm.internal.g0.p(bean, "bean");
                com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
                if (c0Var.k(V3PassPointDialog.this.D().M(), "isSequencePoint") == 1) {
                    itemBinding.ivPoint.setImageBitmap(com.bxkj.student.v2.common.utils.c.f20881a.b(c0Var.t(bean, "sort")));
                } else {
                    itemBinding.ivPoint.setImageBitmap(com.bxkj.student.v2.common.utils.c.f20881a.b("经"));
                }
                TextView textView = itemBinding.tvPoint;
                i7 = V3PassPointDialog.this.f21540m;
                if (i7 == 2) {
                    t5 = "第" + c0Var.t(bean, "sort") + "个必经点";
                } else {
                    t5 = c0Var.t(bean, CommonNetImpl.NAME);
                }
                textView.setText(t5);
            }
        };
        L().rv.setAdapter(this.f21539l);
    }

    @Nullable
    public final BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> N() {
        return this.f21539l;
    }

    @NotNull
    public final List<Map<String, Object>> O() {
        return this.f21538k;
    }

    public final void Q(@Nullable BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter) {
        this.f21539l = baseAdapter;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2132017957);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawableResource(2131100584);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        D().S(com.bxkj.student.v2.common.data.i.f20657a.B());
        this.f21540m = com.bxkj.base.v2.common.utils.c0.f16887a.l(D().M(), "pointShowMode", 1);
        L().setDialog(this);
        M();
        P();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}

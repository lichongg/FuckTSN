package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.databinding.V3ItemForInvalidRecordListBinding;
import com.bxkj.student.v2.common.utils.s;
import com.bxkj.student.v2.ui.dialog.TipsDialog;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3RecordInValidFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3RecordInValidFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/record/tab/V3RecordInValidFragment$initAdapter$1$convert$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,353:1\n1#2:354\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RecordInValidFragment$initAdapter$1$convert$1 extends BaseAdapter<Map<String, ? extends Object>, V3ItemForInvalidRecordListBinding> {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ V3RecordInValidFragment f21860f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    V3RecordInValidFragment$initAdapter$1$convert$1(List<? extends Map<String, ? extends Object>> list, V3RecordInValidFragment v3RecordInValidFragment) {
        super(list);
        this.f21860f = v3RecordInValidFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Map map, V3RecordInValidFragment v3RecordInValidFragment, View view) {
        TipsDialog tipsDialog = new TipsDialog();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("contentText", c0.f16887a.t(map, "remarkExp"));
        tipsDialog.setArguments(bundle);
        FragmentManager childFragmentManager = v3RecordInValidFragment.getChildFragmentManager();
        g0.o(childFragmentManager, "getChildFragmentManager(...)");
        tipsDialog.i(childFragmentManager, "TipsDialog", true);
    }

    @Override // com.bxkj.base.v2.base.BaseAdapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void f(V3ItemForInvalidRecordListBinding itemBinding, final Map<String, ? extends Object> bean, int i6) {
        g0.p(itemBinding, "itemBinding");
        g0.p(bean, "bean");
        itemBinding.setMActivity(this.f21860f);
        itemBinding.setMap(bean);
        Map<String, ? extends Object> map = itemBinding.getMap();
        if (map != null) {
            c0 c0Var = c0.f16887a;
            if (c0Var.t(map, "sportTypeName").length() != 0) {
                map = null;
            }
            if (map != null) {
                map.put("sportTypeName", s.f20923a.d(c0Var.k(map, "sportType")));
            }
        }
        Button button = itemBinding.btFace;
        c0 c0Var2 = c0.f16887a;
        button.setVisibility(TextUtils.isEmpty(c0Var2.t(bean, "faceUrl")) ? 8 : 0);
        if (c0Var2.d(bean, "isLocal")) {
            itemBinding.card.setCardBackgroundColor(ContextCompat.getColor(this.f21860f.H(), 2131100550));
            itemBinding.btAppeal.setVisibility(0);
            itemBinding.btAppeal.setText("立即上传");
            Button button2 = itemBinding.btAppeal;
            final V3RecordInValidFragment v3RecordInValidFragment = this.f21860f;
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    V3RecordInValidFragment$initAdapter$1$convert$1.p(V3RecordInValidFragment.this, bean, view);
                }
            });
        } else {
            itemBinding.card.setCardBackgroundColor(ContextCompat.getColor(this.f21860f.H(), 2131099737));
            itemBinding.btAppeal.setVisibility(0);
            itemBinding.btAppeal.setText("我要申诉");
            V3RecordInValidFragment v3RecordInValidFragment2 = this.f21860f;
            Button btAppeal = itemBinding.btAppeal;
            g0.o(btAppeal, "btAppeal");
            v3RecordInValidFragment2.b0(btAppeal, bean);
        }
        LinearLayout linearLayout = itemBinding.llQuestion;
        final V3RecordInValidFragment v3RecordInValidFragment3 = this.f21860f;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3RecordInValidFragment$initAdapter$1$convert$1.q(bean, v3RecordInValidFragment3, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(V3RecordInValidFragment v3RecordInValidFragment, Map map, View view) {
        v3RecordInValidFragment.P(map);
    }
}

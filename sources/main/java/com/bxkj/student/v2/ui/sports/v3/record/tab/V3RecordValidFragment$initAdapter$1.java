package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.view.View;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.databinding.V3ItemForValidRecordListBinding;
import com.google.android.material.card.MaterialCardView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RecordValidFragment$initAdapter$1 extends BaseAdapter<Map<String, ? extends Object>, V3ItemForValidRecordListBinding> {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ V3RecordValidFragment f21865f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    V3RecordValidFragment$initAdapter$1(V3RecordValidFragment v3RecordValidFragment, List<Map<String, Object>> list) {
        super(list);
        this.f21865f = v3RecordValidFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Ref.BooleanRef booleanRef, V3RecordValidFragment v3RecordValidFragment, String str, List list, V3RecordValidFragment$initAdapter$1 v3RecordValidFragment$initAdapter$1, V3ItemForValidRecordListBinding v3ItemForValidRecordListBinding, View view) {
        booleanRef.element = !booleanRef.element;
        v3RecordValidFragment.D().E().put(str, Boolean.valueOf(booleanRef.element));
        v3RecordValidFragment.D().N(str);
        if (list.isEmpty()) {
            v3RecordValidFragment.j();
        } else {
            v3RecordValidFragment$initAdapter$1.p(v3ItemForValidRecordListBinding, booleanRef.element);
        }
    }

    private final void p(V3ItemForValidRecordListBinding v3ItemForValidRecordListBinding, boolean z5) {
        v3ItemForValidRecordListBinding.rvTrace.setVisibility(z5 ? 0 : 8);
        v3ItemForValidRecordListBinding.ivArrow.setRotation(z5 ? 180.0f : 0.0f);
    }

    static /* synthetic */ void q(V3RecordValidFragment$initAdapter$1 v3RecordValidFragment$initAdapter$1, V3ItemForValidRecordListBinding v3ItemForValidRecordListBinding, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        v3RecordValidFragment$initAdapter$1.p(v3ItemForValidRecordListBinding, z5);
    }

    @Override // com.bxkj.base.v2.base.BaseAdapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void f(final V3ItemForValidRecordListBinding itemBinding, Map<String, ? extends Object> bean, int i6) {
        g0.p(itemBinding, "itemBinding");
        g0.p(bean, "bean");
        c0 c0Var = c0.f16887a;
        final String t5 = c0Var.t(bean, "date");
        itemBinding.tvDate.setText(new SimpleDateFormat("yyyy年MM月").format(new SimpleDateFormat("yyyy-MM").parse(t5)));
        itemBinding.tvCountDistance.setText(com.bxkj.base.v2.common.utils.h.f16899a.a(c0Var.f(bean, "totalRange")) + "公里");
        itemBinding.tvCountTime.setText(com.bxkj.student.run.app.utils.i.g((long) c0Var.f(bean, "totalTime")));
        itemBinding.tvCountNumber.setText(c0Var.t(bean, "count") + "次");
        final List<Map<String, Object>> n6 = c0Var.n(this.f21865f.D().I(), t5);
        itemBinding.rvTrace.setAdapter(new V3RecordValidFragment$initAdapter$1$convert$1(n6, this.f21865f));
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean e6 = c0Var.e(this.f21865f.D().E(), t5, false);
        booleanRef.element = e6;
        p(itemBinding, e6);
        MaterialCardView materialCardView = itemBinding.card1;
        final V3RecordValidFragment v3RecordValidFragment = this.f21865f;
        materialCardView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3RecordValidFragment$initAdapter$1.o(Ref.BooleanRef.this, v3RecordValidFragment, t5, n6, this, itemBinding, view);
            }
        });
    }
}

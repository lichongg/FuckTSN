package com.bxkj.student.v2.ui.sports.v3.record.tab;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.databinding.V3ItemForValidRecordListTraceBinding;
import com.bxkj.student.v2.common.utils.s;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.umeng.analytics.AnalyticsConfig;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RecordValidFragment$initAdapter$1$convert$1 extends BaseAdapter<Map<String, ? extends Object>, V3ItemForValidRecordListTraceBinding> {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ V3RecordValidFragment f21866f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    V3RecordValidFragment$initAdapter$1$convert$1(List<? extends Map<String, ? extends Object>> list, V3RecordValidFragment v3RecordValidFragment) {
        super(list);
        this.f21866f = v3RecordValidFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(V3RecordValidFragment v3RecordValidFragment, Map map, View view) {
        v3RecordValidFragment.startActivity(new Intent(v3RecordValidFragment.H(), (Class<?>) V3RecordDetailActivity.class).putExtra("exerciseRecordId", c0.f16887a.t(map, "id")));
    }

    @Override // com.bxkj.base.v2.base.BaseAdapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void f(V3ItemForValidRecordListTraceBinding itemBinding, final Map<String, ? extends Object> bean, int i6) {
        g0.p(itemBinding, "itemBinding");
        g0.p(bean, "bean");
        c0 c0Var = c0.f16887a;
        int k6 = c0Var.k(bean, "sportType");
        itemBinding.setSportType(k6);
        ImageView imageView = itemBinding.ivSportsType;
        s.a aVar = s.f20923a;
        imageView.setImageResource(aVar.b(k6));
        itemBinding.tvSportsTypeName.setText(aVar.d(k6));
        itemBinding.tvDistance.setText(com.bxkj.base.v2.common.utils.h.f16899a.a(c0Var.f(bean, "sportRange")));
        itemBinding.tvDuration.setText(com.bxkj.student.run.app.utils.i.g(c0Var.o(bean, "sportTime")));
        itemBinding.tvStep.setText(String.valueOf(com.bxkj.student.run.app.utils.i.t(c0Var.t(bean, "stepNumbers"))));
        itemBinding.tvTime.setText(com.bxkj.base.v2.common.utils.g.a(c0Var.t(bean, AnalyticsConfig.RTD_START_TIME)));
        View root = itemBinding.getRoot();
        final V3RecordValidFragment v3RecordValidFragment = this.f21866f;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.record.tab.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3RecordValidFragment$initAdapter$1$convert$1.o(V3RecordValidFragment.this, bean, view);
            }
        });
    }
}

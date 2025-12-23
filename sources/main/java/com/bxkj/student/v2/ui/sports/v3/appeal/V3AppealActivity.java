package com.bxkj.student.v2.ui.sports.v3.appeal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import cn.bluemobi.dylan.base.adapter.c;
import cn.bluemobi.dylan.base.utils.a;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.databinding.AcV3SportsAppealBinding;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.appeal.V3AppealActivity;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordValidFragment;
import com.bxkj.student.v2.vm.sports.appeal.AppealVM;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3AppealActivity extends BaseActivity<AcV3SportsAppealBinding, AppealVM> {

    @NotNull
    private final List<String> U = new ArrayList();

    @Nullable
    private c V;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final V3AppealActivity v3AppealActivity, AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(v3AppealActivity.r(), new Function1() { // from class: q0.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 j7;
                j7 = V3AppealActivity.j(V3AppealActivity.this, (File) obj);
                return j7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 j(V3AppealActivity v3AppealActivity, File it) {
        g0.p(it, "it");
        List<String> list = v3AppealActivity.U;
        String path = it.getPath();
        g0.o(path, "getPath(...)");
        list.add(path);
        c cVar = v3AppealActivity.V;
        g0.m(cVar);
        cVar.c(v3AppealActivity.U);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(V3AppealActivity v3AppealActivity, String str) {
        if (str == null) {
            str = "申诉提交成功，请耐心等待审核";
        }
        ContextExtKt.s(v3AppealActivity, str, 0, 2, null);
        H5AppActivity h5AppActivity = (H5AppActivity) a.n().getActivity(H5AppActivity.class);
        if (h5AppActivity != null) {
            h5AppActivity.M();
        }
        V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) a.n().getActivity(V3SportsHomeActivity.class);
        if (v3SportsHomeActivity != null) {
            v3SportsHomeActivity.y1();
        }
        V3RecordDetailActivity v3RecordDetailActivity = (V3RecordDetailActivity) a.n().getActivity(V3RecordDetailActivity.class);
        if (v3RecordDetailActivity != null) {
            v3RecordDetailActivity.M();
        }
        V3RecordValidFragment v3RecordValidFragment = (V3RecordValidFragment) a.n().o(V3RecordValidFragment.class);
        if (v3RecordValidFragment != null) {
            v3RecordValidFragment.M();
        }
        V3RecordInValidFragment v3RecordInValidFragment = (V3RecordInValidFragment) a.n().o(V3RecordInValidFragment.class);
        if (v3RecordInValidFragment != null) {
            v3RecordInValidFragment.Z();
        }
        v3AppealActivity.finish();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final V3AppealActivity v3AppealActivity, View view) {
        v3AppealActivity.D().t(u.Z5(v3AppealActivity.L().etReason.getText().toString()).toString(), v3AppealActivity.U, new Function1() { // from class: q0.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l6;
                l6 = V3AppealActivity.l(V3AppealActivity.this, (String) obj);
                return l6;
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setBackEvent(this);
        c cVar = new c(this.U, H(), 4, cn.bluemobi.dylan.base.utils.u.a(10.0f, H()));
        cVar.e(3);
        this.V = cVar;
        L().gvImages.setAdapter((ListAdapter) this.V);
        L().gvImages.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: q0.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                V3AppealActivity.i(V3AppealActivity.this, adapterView, view, i6, j6);
            }
        });
        if (getIntent().hasExtra("exerciseRecordId")) {
            D().v(getIntent().getStringExtra("exerciseRecordId"));
        }
        L().btCommit.setOnClickListener(new View.OnClickListener() { // from class: q0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3AppealActivity.k(V3AppealActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}

package com.bxkj.student.v2.ui.my;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.databinding.AcV3BugReportBinding;
import com.bxkj.student.v2.vm.my.BugReportVM;
import com.stub.StubApp;
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
public final class BugReportActivity extends BaseActivity<AcV3BugReportBinding, BugReportVM> {

    @NotNull
    private final List<String> U = new ArrayList();

    @Nullable
    private cn.bluemobi.dylan.base.adapter.c V;

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(BugReportActivity bugReportActivity, String str) {
        if (str == null) {
            str = "上报开发者成功！";
        }
        ContextExtKt.s(bugReportActivity, str, 0, 2, null);
        bugReportActivity.finish();
        return n1.f44123a;
    }

    private final File P() {
        return new File(new File(StubApp.getOrigApplicationContext(getApplicationContext()).getFilesDir().getParent(), "shared_prefs"), "share_date.xml");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final BugReportActivity bugReportActivity, AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(bugReportActivity.r(), new Function1() { // from class: com.bxkj.student.v2.ui.my.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 R;
                R = BugReportActivity.R(BugReportActivity.this, (File) obj);
                return R;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 R(BugReportActivity bugReportActivity, File it) {
        g0.p(it, "it");
        bugReportActivity.U.clear();
        List<String> list = bugReportActivity.U;
        String path = it.getPath();
        g0.o(path, "getPath(...)");
        list.add(path);
        cn.bluemobi.dylan.base.adapter.c cVar = bugReportActivity.V;
        g0.m(cVar);
        cVar.c(bugReportActivity.U);
        return n1.f44123a;
    }

    private final void M() {
        D().x(u.Z5(L().etPhone.getText().toString()).toString(), u.Z5(L().etReason.getText().toString()).toString(), this.U, new Function1() { // from class: com.bxkj.student.v2.ui.my.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 N;
                N = BugReportActivity.N(BugReportActivity.this, (String) obj);
                return N;
            }
        });
    }

    private final File O() {
        File databasePath = StubApp.getOrigApplicationContext(getApplicationContext()).getDatabasePath("TSNStudent.db");
        g0.o(databasePath, "getDatabasePath(...)");
        return databasePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(BugReportActivity bugReportActivity, View view) {
        bugReportActivity.M();
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setBackEvent(this);
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(this.U, H(), 4, cn.bluemobi.dylan.base.utils.u.a(10.0f, H()));
        cVar.e(1);
        this.V = cVar;
        L().gvImages.setAdapter((ListAdapter) this.V);
        L().gvImages.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.v2.ui.my.j
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                BugReportActivity.Q(BugReportActivity.this, adapterView, view, i6, j6);
            }
        });
        L().btCommit.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.my.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BugReportActivity.S(BugReportActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}

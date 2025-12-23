package com.bxkj.student.v2.ui.sports.set;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.b0;
import com.bxkj.base.util.v;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.h5.m;
import com.bxkj.student.databinding.AcV2PermissionSetBinding;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.common.utils.q;
import com.bxkj.student.v2.vm.sports.PermissionSetVM;
import com.orhanobut.logger.j;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class PermissionSetActivity extends BaseActivity<AcV2PermissionSetBinding, PermissionSetVM> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Q(PermissionSetActivity permissionSetActivity, String name, String linkUrl) {
        g0.p(name, "name");
        g0.p(linkUrl, "linkUrl");
        SmartWebView smartWebView = permissionSetActivity.L().sw;
        FragmentActivity r5 = permissionSetActivity.r();
        SmartWebView sw = permissionSetActivity.L().sw;
        g0.o(sw, "sw");
        smartWebView.setWebViewClient(new m(r5, sw));
        String str = i.f20904a.a(linkUrl) + b0.d();
        j.d("url:" + str, new Object[0]);
        permissionSetActivity.L().sw.j(str);
        return n1.f44123a;
    }

    public final void N() {
        q.f20918a.e(r());
    }

    public final void O() {
        if (Build.VERSION.SDK_INT >= 22) {
            startActivity(new Intent("android.settings.BATTERY_SAVER_SETTINGS"));
        } else {
            ContextExtKt.m(this, "请手动在手机【设置】->【电池】->【省电模式】中关闭省电模式");
        }
    }

    private final void M() {
        String str;
        Button button = L().btFastSet;
        q.a aVar = q.f20918a;
        button.setEnabled(!aVar.b());
        Button button2 = L().btFastSet;
        if (aVar.b()) {
            str = "权限已开启";
        } else {
            str = "一键自动开启";
        }
        button2.setText(str);
    }

    public final void P() {
        v.o(r());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        M();
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        int i6;
        L().setMActivity(this);
        Button button = L().btFastSet;
        if (com.bxkj.base.v2.data.b.f16998d.a().b0() == 1) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        button.setVisibility(i6);
        D().x(new Function2() { // from class: com.bxkj.student.v2.ui.sports.set.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                n1 Q;
                Q = PermissionSetActivity.Q(PermissionSetActivity.this, (String) obj, (String) obj2);
                return Q;
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}

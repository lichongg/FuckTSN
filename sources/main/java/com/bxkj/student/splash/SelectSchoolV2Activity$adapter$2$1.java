package com.bxkj.student.splash;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.databinding.ItemForSchoolListV2Binding;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SelectSchoolV2Activity$adapter$2$1 extends BaseAdapter<Map<String, Object>, ItemForSchoolListV2Binding> {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ SelectSchoolV2Activity f20463f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectSchoolV2Activity$adapter$2$1(SelectSchoolV2Activity selectSchoolV2Activity, List<? extends Map<String, Object>> list) {
        super(list);
        this.f20463f = selectSchoolV2Activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 q(SelectSchoolV2Activity selectSchoolV2Activity, Map map, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        selectSchoolV2Activity.P();
        c0 c0Var = c0.f16887a;
        String t5 = c0Var.t(map, "school_name");
        LoginUser.getLoginUser().setSchoolId(c0Var.t(map, "school_id"));
        LoginUser.getLoginUser().setSysType(c0Var.k(map, "sysType"));
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().G0(c0Var.k(map, "isOpenLive"));
        aVar.a().I0(c0Var.l(map, "isOpenSQZS", 1));
        aVar.a().F0(c0Var.l(map, "isOpenGGLBT", 1));
        aVar.a().H0(c0Var.l(map, "openPhoneLogin", 0));
        aVar.a().p0(c0Var.k(map, "insideNetwork"));
        aVar.a().q0(c0Var.t(map, "insideNetworkMsg"));
        if (LoginUser.getLoginUser().getSysType() == 2) {
            aVar.a().O0(t5);
            aVar.a().M0(c0Var.t(map, "schoolCode"));
            aVar.a().P0(c0Var.u(map, "lan_url", com.bxkj.student.v2.retrofit.b.f21275a.a()));
            com.bxkj.student.v2.retrofit.e.f21288a.b();
        } else {
            LoginUser.getLoginUser().setSchoolName(t5);
            LoginUser.getLoginUser().setIsOpenKeep(c0Var.k(map, "isOpenKeep"));
            LoginUser.getLoginUser().setIsOpenEncry(c0Var.t(map, "isOpenEncry"));
            LoginUser.getLoginUser().setAppId(JsonParse.getString(map, "openId"));
            LoginUser.getLoginUser().setServerUrl(c0Var.t(map, "school_url"));
            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
        }
        selectSchoolV2Activity.H().startActivity(new Intent(selectSchoolV2Activity.H(), (Class<?>) SplashActivity.class));
        new HashSet().add(t5);
        selectSchoolV2Activity.finish();
        return n1.f44123a;
    }

    @Override // com.bxkj.base.v2.base.BaseAdapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void f(ItemForSchoolListV2Binding itemBinding, final Map<String, Object> bean, int i6) {
        g0.p(itemBinding, "itemBinding");
        g0.p(bean, "bean");
        TextView textView = itemBinding.tvName;
        StringBuilder sb = new StringBuilder();
        c0 c0Var = c0.f16887a;
        sb.append(c0Var.t(bean, "school_name"));
        sb.append(" (");
        sb.append(c0Var.t(bean, "provinceName"));
        sb.append(")");
        textView.setText(sb.toString());
        TextView textView2 = itemBinding.tvName;
        final SelectSchoolV2Activity selectSchoolV2Activity = this.f20463f;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectSchoolV2Activity$adapter$2$1.p(SelectSchoolV2Activity.this, bean, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final SelectSchoolV2Activity selectSchoolV2Activity, final Map map, View view) {
        ContextExtKt.h(selectSchoolV2Activity.r(), null, "确定您要选择" + c0.f16887a.t(map, "school_name") + "吗?", new Function1() { // from class: com.bxkj.student.splash.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 q5;
                q5 = SelectSchoolV2Activity$adapter$2$1.q(SelectSchoolV2Activity.this, map, (iOSTwoButtonDialog) obj);
                return q5;
            }
        }, null, null, null, 57, null);
    }
}

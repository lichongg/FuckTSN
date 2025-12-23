package com.bxkj.student.v2.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nH5Utils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 H5Utils.kt\ncom/bxkj/student/v2/common/utils/H5Utils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n1869#2,2:61\n1869#2,2:63\n*S KotlinDebug\n*F\n+ 1 H5Utils.kt\ncom/bxkj/student/v2/common/utils/H5Utils\n*L\n25#1:61,2\n46#1:63,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f20904a = new i();

    @NotNull
    public final String a(@NotNull String url) {
        g0.p(url, "url");
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        return kotlin.text.u.x2(kotlin.text.u.x2(url, "${school}", aVar.a().J(), false, 4, null), "${token}", aVar.a().g(), false, 4, null);
    }

    public final void b(@NotNull Context mContext, @NotNull Map<String, ? extends Object> menu) {
        g0.p(mContext, "mContext");
        g0.p(menu, "menu");
        c0 c0Var = c0.f16887a;
        if (c0Var.t(menu, "linkUrl").length() == 0) {
            com.orhanobut.logger.j.e("跳转【" + c0Var.t(menu, CommonNetImpl.NAME) + "】地址为空！", new Object[0]);
            return;
        }
        Bundle bundle = new Bundle();
        for (String str : menu.keySet()) {
            bundle.putString(str, c0.f16887a.t(menu, str));
        }
        c0 c0Var2 = c0.f16887a;
        bundle.putString("title", a(c0Var2.t(menu, CommonNetImpl.NAME)));
        bundle.putString("url", a(c0Var2.t(menu, "linkUrl")));
        mContext.startActivity(new Intent(mContext, (Class<?>) H5AppActivity.class).putExtras(bundle));
    }

    public final void c(@NotNull FragmentActivity mActivity, @NotNull Map<String, ? extends Object> menu, @NotNull b.a callBack) {
        g0.p(mActivity, "mActivity");
        g0.p(menu, "menu");
        g0.p(callBack, "callBack");
        c0 c0Var = c0.f16887a;
        if (c0Var.t(menu, "linkUrl").length() == 0) {
            com.orhanobut.logger.j.e("跳转【" + c0Var.t(menu, CommonNetImpl.NAME) + "】地址为空！", new Object[0]);
            return;
        }
        Bundle bundle = new Bundle();
        for (String str : menu.keySet()) {
            bundle.putString(str, c0.f16887a.t(menu, str));
        }
        c0 c0Var2 = c0.f16887a;
        bundle.putString("title", a(c0Var2.t(menu, CommonNetImpl.NAME)));
        bundle.putString("url", a(c0Var2.t(menu, "linkUrl")));
        u.b bVar = new u.b(mActivity);
        Intent putExtras = new Intent(mActivity, (Class<?>) H5AppActivity.class).putExtras(bundle);
        g0.o(putExtras, "putExtras(...)");
        bVar.startActivityForResult(putExtras).c(callBack);
    }

    private i() {
    }
}

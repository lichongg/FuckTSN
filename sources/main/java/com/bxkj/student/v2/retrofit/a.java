package com.bxkj.student.v2.retrofit;

import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.b0;
import com.bxkj.base.v2.data.UserType;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.v2.common.utils.n;
import com.bxkj.student.v2.retrofit.b;
import com.tencent.connect.common.Constants;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final /* synthetic */ class a {
    static {
        b.a aVar = b.f21275a;
    }

    public static /* synthetic */ Object a(b bVar, String str, String str2, String str3, String str4, String str5, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoLogin");
        }
        if ((i6 & 2) != 0) {
            str2 = "server";
        }
        String str6 = str2;
        if ((i6 & 4) != 0) {
            str3 = "refresh_token";
        }
        String str7 = str3;
        if ((i6 & 8) != 0) {
            str4 = Constants.JumpUrlConstants.SRC_TYPE_APP;
        }
        String str8 = str4;
        if ((i6 & 16) != 0) {
            str5 = "stuApp";
        }
        return bVar.w(str, str6, str7, str8, str5, eVar);
    }

    public static /* synthetic */ Object b(b bVar, String str, String str2, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickArticle");
        }
        if ((i6 & 2) != 0) {
            b.a aVar = com.bxkj.base.v2.data.b.f16998d;
            str2 = aVar.a().Y() ? aVar.a().R() : "";
        }
        return bVar.i(str, str2, eVar);
    }

    public static /* synthetic */ Object c(b bVar, String str, String str2, String str3, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteServerAlis");
        }
        if ((i6 & 1) != 0) {
            str = com.bxkj.base.v2.data.b.f16998d.a().R();
        }
        if ((i6 & 2) != 0) {
            byte[] bytes = "371eb09af9255d557b1e697e:911a7768ee6863f19c1765ac".getBytes(kotlin.text.e.f47851b);
            g0.o(bytes, "getBytes(...)");
            str2 = "Basic " + cn.bluemobi.dylan.base.utils.b.b(bytes);
        }
        if ((i6 & 4) != 0) {
            str3 = "application/json";
        }
        return bVar.p(str, str2, str3, eVar);
    }

    public static /* synthetic */ Object d(b bVar, String str, String str2, String str3, String str4, kotlin.coroutines.e eVar, int i6, Object obj) {
        String str5;
        kotlin.coroutines.e eVar2;
        String str6;
        String str7;
        b bVar2;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBanner");
        }
        if ((i6 & 1) != 0) {
            str = "4";
        }
        if ((i6 & 2) != 0) {
            str2 = com.bxkj.base.v2.data.b.f16998d.a().m();
        }
        if ((i6 & 4) != 0) {
            str3 = null;
        }
        if ((i6 & 8) != 0) {
            str5 = null;
            str6 = str2;
            eVar2 = eVar;
            bVar2 = bVar;
            str7 = str3;
        } else {
            str5 = str4;
            eVar2 = eVar;
            str6 = str2;
            str7 = str3;
            bVar2 = bVar;
        }
        return bVar2.B(str, str6, str7, str5, eVar2);
    }

    public static /* synthetic */ Object e(b bVar, String str, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClassifyMenu");
        }
        if ((i6 & 1) != 0) {
            str = "2";
        }
        return bVar.a(str, eVar);
    }

    public static /* synthetic */ Object f(b bVar, String str, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHomeMenu");
        }
        if ((i6 & 1) != 0) {
            str = com.bxkj.base.v2.data.b.f16998d.a().T() == UserType.STUDENT ? "1" : Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        return bVar.N(str, eVar);
    }

    public static /* synthetic */ Object g(b bVar, String str, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLatestUnreadNotice");
        }
        if ((i6 & 1) != 0) {
            str = "1";
        }
        return bVar.F(str, eVar);
    }

    public static /* synthetic */ Object h(b bVar, String str, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyMenu");
        }
        if ((i6 & 1) != 0) {
            str = com.bxkj.base.v2.data.b.f16998d.a().T() == UserType.STUDENT ? "5" : "7";
        }
        return bVar.e(str, eVar);
    }

    public static /* synthetic */ Object i(b bVar, String str, String str2, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPgyerAppVersion");
        }
        if ((i6 & 1) != 0) {
            str = n.f20912b;
        }
        if ((i6 & 2) != 0) {
            str2 = n.f20913c;
        }
        return bVar.j(str, str2, eVar);
    }

    public static /* synthetic */ Object j(b bVar, String str, String str2, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSchoolInfo");
        }
        if ((i6 & 1) != 0) {
            str = LoginUser.getLoginUser().getSchoolId();
            g0.o(str, "getSchoolId(...)");
        }
        if ((i6 & 2) != 0) {
            str2 = b0.d();
            g0.o(str2, "getDeviceName(...)");
        }
        return bVar.n(str, str2, eVar);
    }

    public static /* synthetic */ Object k(b bVar, String str, String str2, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShareCircleUrl");
        }
        if ((i6 & 1) != 0) {
            str = com.bxkj.base.v2.data.b.f16998d.a().J();
        }
        if ((i6 & 2) != 0) {
            str2 = com.bxkj.base.v2.data.b.f16998d.a().S();
        }
        return bVar.f(str, str2, eVar);
    }

    public static /* synthetic */ Object l(b bVar, String str, String str2, String str3, String str4, String str5, String str6, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }
        if ((i6 & 4) != 0) {
            str3 = "password";
        }
        String str7 = str3;
        if ((i6 & 8) != 0) {
            str4 = Constants.JumpUrlConstants.SRC_TYPE_APP;
        }
        String str8 = str4;
        if ((i6 & 16) != 0) {
            str5 = "stuApp";
        }
        String str9 = str5;
        if ((i6 & 32) != 0) {
            str6 = b0.d() + "-" + b0.e();
        }
        return bVar.D(str, str2, str7, str8, str9, str6, eVar);
    }

    public static /* synthetic */ Object m(b bVar, String str, String str2, String str3, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginFromOldSystemToNew");
        }
        if ((i6 & 2) != 0) {
            str2 = "password";
        }
        if ((i6 & 4) != 0) {
            str3 = "oldtsn";
        }
        return bVar.x(str, str2, str3, eVar);
    }

    public static /* synthetic */ Object n(b bVar, String str, String str2, String str3, String str4, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginThird");
        }
        if ((i6 & 2) != 0) {
            str2 = "123456";
        }
        String str5 = str2;
        if ((i6 & 4) != 0) {
            str3 = "password";
        }
        String str6 = str3;
        if ((i6 & 8) != 0) {
            str4 = Constants.JumpUrlConstants.SRC_TYPE_APP;
        }
        return bVar.c(str, str5, str6, str4, eVar);
    }

    public static /* synthetic */ Object o(b bVar, String str, String str2, kotlin.coroutines.e eVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchSchool");
        }
        if ((i6 & 2) != 0) {
            str2 = b0.d();
            g0.o(str2, "getDeviceName(...)");
        }
        return bVar.s(str, str2, eVar);
    }

    public static /* synthetic */ Object p(b bVar, String str, String str2, int i6, String str3, kotlin.coroutines.e eVar, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v3GetSportsRecord");
        }
        if ((i7 & 8) != 0) {
            str3 = null;
        }
        return bVar.q(str, str2, i6, str3, eVar);
    }
}

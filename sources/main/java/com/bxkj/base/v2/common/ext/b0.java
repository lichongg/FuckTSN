package com.bxkj.base.v2.common.ext;

import android.content.Intent;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.b;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16757a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16758b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16759c;

        a(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, Function0<n1> function0) {
            this.f16757a = fragmentActivity;
            this.f16758b = fragmentActivity2;
            this.f16759c = function0;
        }

        @Override // t.b.a
        public void a() {
            this.f16759c.invoke();
        }

        @Override // t.b.a
        public void b(String[] permission) {
            g0.p(permission, "permission");
            b0.l0(this.f16757a, this.f16758b, this.f16759c);
        }

        @Override // t.b.a
        public void c(String[] permission) {
            g0.p(permission, "permission");
            b0.l0(this.f16757a, this.f16758b, this.f16759c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16760a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16761b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16762c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16763d;

        b(Function0<n1> function0, FragmentActivity fragmentActivity, String str, Function0<n1> function02) {
            this.f16760a = function0;
            this.f16761b = fragmentActivity;
            this.f16762c = str;
            this.f16763d = function02;
        }

        @Override // t.b.a
        public void a() {
            this.f16760a.invoke();
        }

        @Override // t.b.a
        public void b(String... permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(this.f16761b, this.f16762c);
            Function0<n1> function0 = this.f16763d;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // t.b.a
        public void c(String... permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(this.f16761b, this.f16762c);
            Function0<n1> function0 = this.f16763d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16764a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16765b;

        c(FragmentActivity fragmentActivity, Function0<n1> function0) {
            this.f16764a = fragmentActivity;
            this.f16765b = function0;
        }

        @Override // t.b.a
        public void a() {
            this.f16765b.invoke();
        }

        @Override // t.b.a
        public void b(String[] permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(this.f16764a, "你拒绝了定位权限无法定位");
        }

        @Override // t.b.a
        public void c(String[] permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(this.f16764a, "你拒绝了定位权限无法定位");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16766a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16767b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16768c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16769d;

        d(Function0<n1> function0, Function0<n1> function02, FragmentActivity fragmentActivity, String str) {
            this.f16766a = function0;
            this.f16767b = function02;
            this.f16768c = fragmentActivity;
            this.f16769d = str;
        }

        @Override // t.b.a
        public void a() {
            this.f16766a.invoke();
        }

        @Override // t.b.a
        public void b(String... permission) {
            g0.p(permission, "permission");
            Function0<n1> function0 = this.f16767b;
            if (function0 != null) {
                function0.invoke();
            }
            ContextExtKt.m(this.f16768c, this.f16769d);
        }

        @Override // t.b.a
        public void c(String... permission) {
            g0.p(permission, "permission");
            Function0<n1> function0 = this.f16767b;
            if (function0 != null) {
                function0.invoke();
            }
            ContextExtKt.m(this.f16768c, this.f16769d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16770a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16771b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16772c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16773d;

        e(Function0<n1> function0, Function0<n1> function02, FragmentActivity fragmentActivity, String str) {
            this.f16770a = function0;
            this.f16771b = function02;
            this.f16772c = fragmentActivity;
            this.f16773d = str;
        }

        @Override // t.b.a
        public void a() {
            this.f16770a.invoke();
        }

        @Override // t.b.a
        public void b(String... permission) {
            g0.p(permission, "permission");
            Function0<n1> function0 = this.f16771b;
            if (function0 != null) {
                function0.invoke();
            }
            ContextExtKt.m(this.f16772c, this.f16773d);
        }

        @Override // t.b.a
        public void c(String... permission) {
            g0.p(permission, "permission");
            Function0<n1> function0 = this.f16771b;
            if (function0 != null) {
                function0.invoke();
            }
            ContextExtKt.m(this.f16772c, this.f16773d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16774a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16775b;

        f(FragmentActivity fragmentActivity, Function0<n1> function0) {
            this.f16774a = fragmentActivity;
            this.f16775b = function0;
        }

        @Override // t.b.a
        public void a() {
            this.f16775b.invoke();
        }

        @Override // t.b.a
        public void b(String[] permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(this.f16774a, "你拒绝了定位权限无法定位");
        }

        @Override // t.b.a
        public void c(String[] permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(this.f16774a, "你拒绝了定位权限无法定位");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16776a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16777b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16778c;

        g(Function0<n1> function0, FragmentActivity fragmentActivity, String str) {
            this.f16776a = function0;
            this.f16777b = fragmentActivity;
            this.f16778c = str;
        }

        @Override // t.b.a
        public void a() {
            this.f16776a.invoke();
        }

        @Override // t.b.a
        public void b(String... permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(this.f16777b, this.f16778c);
        }

        @Override // t.b.a
        public void c(String... permission) {
            g0.p(permission, "permission");
            ContextExtKt.m(this.f16777b, this.f16778c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16780b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16781c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16782d;

        h(Function0<n1> function0, Function0<n1> function02, FragmentActivity fragmentActivity, String str) {
            this.f16779a = function0;
            this.f16780b = function02;
            this.f16781c = fragmentActivity;
            this.f16782d = str;
        }

        @Override // t.b.a
        public void a() {
            this.f16779a.invoke();
        }

        @Override // t.b.a
        public void b(String... permission) {
            g0.p(permission, "permission");
            Function0<n1> function0 = this.f16780b;
            if (function0 != null) {
                function0.invoke();
            }
            ContextExtKt.m(this.f16781c, this.f16782d);
        }

        @Override // t.b.a
        public void c(String... permission) {
            g0.p(permission, "permission");
            Function0<n1> function0 = this.f16780b;
            if (function0 != null) {
                function0.invoke();
            }
            ContextExtKt.m(this.f16781c, this.f16782d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class i implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16783a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16784b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16785c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16786d;

        i(Function0<n1> function0, Function0<n1> function02, FragmentActivity fragmentActivity, String str) {
            this.f16783a = function0;
            this.f16784b = function02;
            this.f16785c = fragmentActivity;
            this.f16786d = str;
        }

        @Override // t.b.a
        public void a() {
            this.f16783a.invoke();
        }

        @Override // t.b.a
        public void b(String... permission) {
            g0.p(permission, "permission");
            Function0<n1> function0 = this.f16784b;
            if (function0 != null) {
                function0.invoke();
            }
            ContextExtKt.m(this.f16785c, this.f16786d);
        }

        @Override // t.b.a
        public void c(String... permission) {
            g0.p(permission, "permission");
            Function0<n1> function0 = this.f16784b;
            if (function0 != null) {
                function0.invoke();
            }
            ContextExtKt.m(this.f16785c, this.f16786d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class j implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16787a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f16788b;

        j(FragmentActivity fragmentActivity, Function0<n1> function0) {
            this.f16787a = fragmentActivity;
            this.f16788b = function0;
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            b0.u(this.f16787a, this.f16788b);
        }
    }

    public static /* synthetic */ void A(FragmentActivity fragmentActivity, String str, Function0 function0, Function0 function02, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "拍照";
        }
        if ((i6 & 4) != 0) {
            function02 = null;
        }
        y(fragmentActivity, str, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 B(FragmentActivity fragmentActivity, Function0 function0, String str, Function0 function02, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        new t.b(fragmentActivity).c("android.permission.CAMERA").d(new b(function0, fragmentActivity, str, function02));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 C(FragmentActivity fragmentActivity, String str, Function0 function0, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        ContextExtKt.m(fragmentActivity, str);
        if (function0 != null) {
        }
        return n1.f44123a;
    }

    public static final void D(@NotNull final FragmentActivity fragmentActivity, @NotNull final Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36048h) == 0 && ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36047g) == 0) {
            agree.invoke();
        } else {
            ContextExtKt.g(fragmentActivity, "定位", "是否允许访问定位,便于获取您当前所在位置", new Function1() { // from class: com.bxkj.base.v2.common.ext.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 E;
                    E = b0.E(FragmentActivity.this, agree, (iOSTwoButtonDialog) obj);
                    return E;
                }
            }, new Function1() { // from class: com.bxkj.base.v2.common.ext.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 F;
                    F = b0.F((iOSTwoButtonDialog) obj);
                    return F;
                }
            }, "拒绝", "同意并使用");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 E(FragmentActivity fragmentActivity, Function0 function0, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        new t.b(fragmentActivity).c(com.kuaishou.weapon.p0.g.f36048h, com.kuaishou.weapon.p0.g.f36047g).d(new c(fragmentActivity, function0));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 F(iOSTwoButtonDialog it) {
        g0.p(it, "it");
        return n1.f44123a;
    }

    public static final void G(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        H(fragmentActivity, str, agree, null);
    }

    public static final void H(@NotNull final FragmentActivity fragmentActivity, @Nullable String str, @NotNull final Function0<n1> agree, @Nullable final Function0<n1> function0) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36049i) == 0) {
            agree.invoke();
            return;
        }
        final String str2 = "您拒绝了访问存储空间权限，无法使用" + str + "功能，请在【设置->应用—>体适能->权限管理->存储空间】设置允许后再进行操作";
        ContextExtKt.g(fragmentActivity, str, "是否允许访问存储空间，便于获取" + str, new Function1() { // from class: com.bxkj.base.v2.common.ext.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 K;
                K = b0.K(FragmentActivity.this, agree, function0, str2, (iOSTwoButtonDialog) obj);
                return K;
            }
        }, new Function1() { // from class: com.bxkj.base.v2.common.ext.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 L;
                L = b0.L(Function0.this, fragmentActivity, str2, (iOSTwoButtonDialog) obj);
                return L;
            }
        }, "拒绝", "同意并使用");
    }

    public static /* synthetic */ void I(FragmentActivity fragmentActivity, String str, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "文件";
        }
        G(fragmentActivity, str, function0);
    }

    public static /* synthetic */ void J(FragmentActivity fragmentActivity, String str, Function0 function0, Function0 function02, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "文件";
        }
        if ((i6 & 4) != 0) {
            function02 = null;
        }
        H(fragmentActivity, str, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 K(FragmentActivity fragmentActivity, Function0 function0, Function0 function02, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        new t.b(fragmentActivity).c(com.kuaishou.weapon.p0.g.f36049i).d(new d(function0, function02, fragmentActivity, str));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 L(Function0 function0, FragmentActivity fragmentActivity, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        if (function0 != null) {
        }
        ContextExtKt.m(fragmentActivity, str);
        return n1.f44123a;
    }

    public static final void M(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        N(fragmentActivity, str, agree, null);
    }

    public static final void N(@NotNull final FragmentActivity fragmentActivity, @Nullable String str, @NotNull final Function0<n1> agree, @Nullable final Function0<n1> function0) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36049i) == 0) {
            agree.invoke();
            return;
        }
        final String str2 = "您拒绝了访问存储空间权限，无法使用" + str + "功能，请在【设置->应用—>体适能->权限管理->存储空间】设置允许后再进行操作";
        ContextExtKt.g(fragmentActivity, str, "是否允许访问存储空间，便于获取" + str, new Function1() { // from class: com.bxkj.base.v2.common.ext.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 Q;
                Q = b0.Q(FragmentActivity.this, agree, function0, str2, (iOSTwoButtonDialog) obj);
                return Q;
            }
        }, new Function1() { // from class: com.bxkj.base.v2.common.ext.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 R;
                R = b0.R(Function0.this, fragmentActivity, str2, (iOSTwoButtonDialog) obj);
                return R;
            }
        }, "拒绝", "同意并使用");
    }

    public static /* synthetic */ void O(FragmentActivity fragmentActivity, String str, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "相册";
        }
        M(fragmentActivity, str, function0);
    }

    public static /* synthetic */ void P(FragmentActivity fragmentActivity, String str, Function0 function0, Function0 function02, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "相册";
        }
        if ((i6 & 4) != 0) {
            function02 = null;
        }
        N(fragmentActivity, str, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Q(FragmentActivity fragmentActivity, Function0 function0, Function0 function02, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        new t.b(fragmentActivity).c(com.kuaishou.weapon.p0.g.f36049i).d(new e(function0, function02, fragmentActivity, str));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 R(Function0 function0, FragmentActivity fragmentActivity, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        if (function0 != null) {
        }
        ContextExtKt.m(fragmentActivity, str);
        return n1.f44123a;
    }

    public static final void S(@NotNull final FragmentActivity fragmentActivity, @NotNull final Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36048h) == 0 && ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36047g) == 0) {
            agree.invoke();
        } else {
            ContextExtKt.g(fragmentActivity, "定位", "是否允许访问定位,便于记录跑步轨迹", new Function1() { // from class: com.bxkj.base.v2.common.ext.a0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 T;
                    T = b0.T(FragmentActivity.this, agree, (iOSTwoButtonDialog) obj);
                    return T;
                }
            }, new Function1() { // from class: com.bxkj.base.v2.common.ext.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 U;
                    U = b0.U((iOSTwoButtonDialog) obj);
                    return U;
                }
            }, "拒绝", "同意并使用");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T(FragmentActivity fragmentActivity, Function0 function0, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        new t.b(fragmentActivity).c(com.kuaishou.weapon.p0.g.f36048h, com.kuaishou.weapon.p0.g.f36047g).d(new f(fragmentActivity, function0));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 U(iOSTwoButtonDialog it) {
        g0.p(it, "it");
        return n1.f44123a;
    }

    public static final void V(@NotNull final FragmentActivity fragmentActivity, @Nullable String str, @NotNull final Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        final String[] strArr = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO", com.kuaishou.weapon.p0.g.f36049i};
        if (ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36049i) == 0 && ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.CAMERA") == 0 && ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.RECORD_AUDIO") == 0) {
            agree.invoke();
            return;
        }
        final String str2 = "您拒绝了摄像头、录音、访问存储空间权限，无法使用" + str + "功能，请在【设置->应用—>体适能->权限管理->摄像头、录音、存储空间】设置允许后再进行操作";
        ContextExtKt.g(fragmentActivity, str, "是否允许摄像头、录音、访问存储空间，便于" + str, new Function1() { // from class: com.bxkj.base.v2.common.ext.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 X;
                X = b0.X(FragmentActivity.this, strArr, agree, str2, (iOSTwoButtonDialog) obj);
                return X;
            }
        }, new Function1() { // from class: com.bxkj.base.v2.common.ext.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 Y;
                Y = b0.Y(FragmentActivity.this, str2, (iOSTwoButtonDialog) obj);
                return Y;
            }
        }, "拒绝", "同意并使用");
    }

    public static /* synthetic */ void W(FragmentActivity fragmentActivity, String str, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "录制视频";
        }
        V(fragmentActivity, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 X(FragmentActivity fragmentActivity, String[] strArr, Function0 function0, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        new t.b(fragmentActivity).c((String[]) Arrays.copyOf(strArr, strArr.length)).d(new g(function0, fragmentActivity, str));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Y(FragmentActivity fragmentActivity, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        ContextExtKt.m(fragmentActivity, str);
        return n1.f44123a;
    }

    public static final void Z(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        a0(fragmentActivity, str, agree, null);
    }

    public static final void a0(@NotNull final FragmentActivity fragmentActivity, @Nullable String str, @NotNull final Function0<n1> agree, @Nullable final Function0<n1> function0) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36050j) == 0) {
            agree.invoke();
            return;
        }
        final String str2 = "您拒绝了写入存储空间权限，无法使用" + str + "功能，请在【设置->应用—>体适能->权限管理->存储空间】设置允许后再进行操作";
        ContextExtKt.g(fragmentActivity, str, "是否允许写入存储空间，便于" + str, new Function1() { // from class: com.bxkj.base.v2.common.ext.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 d02;
                d02 = b0.d0(FragmentActivity.this, agree, function0, str2, (iOSTwoButtonDialog) obj);
                return d02;
            }
        }, new Function1() { // from class: com.bxkj.base.v2.common.ext.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 e02;
                e02 = b0.e0(Function0.this, fragmentActivity, str2, (iOSTwoButtonDialog) obj);
                return e02;
            }
        }, "拒绝", "同意并使用");
    }

    public static /* synthetic */ void b0(FragmentActivity fragmentActivity, String str, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "保存到相册";
        }
        Z(fragmentActivity, str, function0);
    }

    public static /* synthetic */ void c0(FragmentActivity fragmentActivity, String str, Function0 function0, Function0 function02, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "保存到相册";
        }
        if ((i6 & 4) != 0) {
            function02 = null;
        }
        a0(fragmentActivity, str, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 d0(FragmentActivity fragmentActivity, Function0 function0, Function0 function02, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        new t.b(fragmentActivity).c(com.kuaishou.weapon.p0.g.f36050j).d(new h(function0, function02, fragmentActivity, str));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 e0(Function0 function0, FragmentActivity fragmentActivity, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        if (function0 != null) {
        }
        ContextExtKt.m(fragmentActivity, str);
        return n1.f44123a;
    }

    public static final void f0(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        g0(fragmentActivity, str, agree, null);
    }

    public static final void g0(@NotNull final FragmentActivity fragmentActivity, @Nullable String str, @NotNull final Function0<n1> agree, @Nullable final Function0<n1> function0) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36050j) == 0 && ContextCompat.checkSelfPermission(fragmentActivity, com.kuaishou.weapon.p0.g.f36049i) == 0) {
            agree.invoke();
            return;
        }
        final String str2 = "您拒绝了写入存储空间权限，无法使用" + str + "功能，请在【设置->应用—>体适能->权限管理->存储空间】设置允许后再进行操作";
        ContextExtKt.g(fragmentActivity, str, "是否允许写入存储空间，便于" + str, new Function1() { // from class: com.bxkj.base.v2.common.ext.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 j02;
                j02 = b0.j0(FragmentActivity.this, agree, function0, str2, (iOSTwoButtonDialog) obj);
                return j02;
            }
        }, new Function1() { // from class: com.bxkj.base.v2.common.ext.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 k02;
                k02 = b0.k0(Function0.this, fragmentActivity, str2, (iOSTwoButtonDialog) obj);
                return k02;
            }
        }, "拒绝", "同意并使用");
    }

    public static /* synthetic */ void h0(FragmentActivity fragmentActivity, String str, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "下载文件";
        }
        f0(fragmentActivity, str, function0);
    }

    public static /* synthetic */ void i0(FragmentActivity fragmentActivity, String str, Function0 function0, Function0 function02, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "下载文件";
        }
        if ((i6 & 4) != 0) {
            function02 = null;
        }
        g0(fragmentActivity, str, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 j0(FragmentActivity fragmentActivity, Function0 function0, Function0 function02, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        new t.b(fragmentActivity).c(com.kuaishou.weapon.p0.g.f36050j, com.kuaishou.weapon.p0.g.f36049i).d(new i(function0, function02, fragmentActivity, str));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 k0(Function0 function0, FragmentActivity fragmentActivity, String str, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        if (function0 != null) {
        }
        ContextExtKt.m(fragmentActivity, str);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(final FragmentActivity fragmentActivity, final FragmentActivity fragmentActivity2, final Function0<n1> function0) {
        ContextExtKt.h(fragmentActivity, "权限提示", "为了正常记录你的运动数据，需要你将【体适能】APP的【权限设置】中的【位置信息】设置为【始终允许】后再开始跑步。", new Function1() { // from class: com.bxkj.base.v2.common.ext.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 m02;
                m02 = b0.m0(FragmentActivity.this, fragmentActivity, function0, (iOSTwoButtonDialog) obj);
                return m02;
            }
        }, null, null, "去设置", 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 m0(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, Function0 function0, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        com.bxkj.base.util.v.p(fragmentActivity, new j(fragmentActivity2, function0));
        return n1.f44123a;
    }

    public static final void u(@NotNull final FragmentActivity fragmentActivity, @NotNull final Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            agree.invoke();
        } else {
            ContextExtKt.g(fragmentActivity, "始终允许定位", "是否允许应用始终允许定位,便于APP锁屏后继续记录跑步轨迹", new Function1() { // from class: com.bxkj.base.v2.common.ext.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 v5;
                    v5 = b0.v(FragmentActivity.this, agree, fragmentActivity, (iOSTwoButtonDialog) obj);
                    return v5;
                }
            }, new Function1() { // from class: com.bxkj.base.v2.common.ext.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 w5;
                    w5 = b0.w(FragmentActivity.this, fragmentActivity, agree, (iOSTwoButtonDialog) obj);
                    return w5;
                }
            }, "拒绝", "同意并使用");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 v(FragmentActivity fragmentActivity, Function0 function0, FragmentActivity fragmentActivity2, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        if (Build.VERSION.SDK_INT >= 29) {
            new t.b(fragmentActivity).c("android.permission.ACCESS_BACKGROUND_LOCATION").d(new a(fragmentActivity, fragmentActivity2, function0));
        } else {
            function0.invoke();
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 w(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, Function0 function0, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        l0(fragmentActivity, fragmentActivity2, function0);
        return n1.f44123a;
    }

    public static final void x(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull Function0<n1> agree) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        y(fragmentActivity, str, agree, null);
    }

    public static final void y(@NotNull final FragmentActivity fragmentActivity, @Nullable String str, @NotNull final Function0<n1> agree, @Nullable final Function0<n1> function0) {
        g0.p(fragmentActivity, "<this>");
        g0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.CAMERA") == 0) {
            agree.invoke();
            return;
        }
        final String str2 = "您拒绝了摄像头权限，无法使用" + str + "功能，请在【设置->应用—>体适能->权限管理->摄像头】设置允许后再进行操作";
        ContextExtKt.g(fragmentActivity, str, "是否允许访问摄像头，便于" + str, new Function1() { // from class: com.bxkj.base.v2.common.ext.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 B;
                B = b0.B(FragmentActivity.this, agree, str2, function0, (iOSTwoButtonDialog) obj);
                return B;
            }
        }, new Function1() { // from class: com.bxkj.base.v2.common.ext.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 C;
                C = b0.C(FragmentActivity.this, str2, function0, (iOSTwoButtonDialog) obj);
                return C;
            }
        }, "拒绝", "同意并使用");
    }

    public static /* synthetic */ void z(FragmentActivity fragmentActivity, String str, Function0 function0, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "拍照";
        }
        x(fragmentActivity, str, function0);
    }
}

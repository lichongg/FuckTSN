package com.bxkj.student.v2.ui.h5.js;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.v2.ui.face.FaceCheckV2Activity;
import com.bxkj.student.v2.ui.face.FaceCollectActivity;
import com.bxkj.student.v2.ui.face.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFaceJS.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceJS.kt\ncom/bxkj/student/v2/ui/h5/js/FaceJS\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bxkj.student.v2.ui.h5.js.a {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private FragmentActivity f21454h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nFaceJS.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceJS.kt\ncom/bxkj/student/v2/ui/h5/js/FaceJS$faceTest$3$1$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
    public static final class a implements b.a {
        a() {
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (intent != null) {
                if (i6 != -1) {
                    intent = null;
                }
                if (intent != null) {
                    Intent intent2 = intent.hasExtra("code") ? intent : null;
                    if (intent2 != null) {
                        j jVar = j.this;
                        int intExtra = intent2.getIntExtra("code", 1);
                        jVar.b().loadUrl("javascript:faceTestResult('" + intExtra + "')");
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        g0.p(mActivity, "mActivity");
        g0.p(mWebView, "mWebView");
        this.f21454h = mActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final j jVar, final String str, final String str2) {
        f0.f21370a.c(jVar.a(), new Function0() { // from class: com.bxkj.student.v2.ui.h5.js.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 t5;
                t5 = j.t(j.this, str, str2);
                return t5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 u(String str, String str2, j jVar) {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().z0(true);
        if (str != null) {
            aVar.a().e0(str);
        }
        if (str2 != null) {
            aVar.a().M0(str2);
        }
        com.bxkj.student.v2.retrofit.e.f21288a.b();
        jVar.a().startActivity(new Intent(jVar.a(), (Class<?>) FaceCollectActivity.class));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final j jVar) {
        f0.f21370a.c(jVar.a(), new Function0() { // from class: com.bxkj.student.v2.ui.h5.js.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 w5;
                w5 = j.w(j.this);
                return w5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 x(j jVar) {
        u.b bVar = new u.b(jVar.a());
        Intent intent = new Intent().setClass(jVar.a(), FaceCheckV2Activity.class);
        g0.o(intent, "setClass(...)");
        bVar.startActivityForResult(intent).c(jVar.new a());
        return n1.f44123a;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.l
    @NotNull
    public FragmentActivity a() {
        return this.f21454h;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.l
    public void c(@NotNull FragmentActivity fragmentActivity) {
        g0.p(fragmentActivity, "<set-?>");
        this.f21454h = fragmentActivity;
    }

    @JavascriptInterface
    public final void faceTest(@Nullable String str, @Nullable String str2) {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().z0(true);
        if (str != null) {
            aVar.a().e0(str);
        }
        if (str2 != null) {
            aVar.a().M0(str2);
        }
        com.bxkj.student.v2.retrofit.e.f21288a.b();
        a().runOnUiThread(new Runnable() { // from class: com.bxkj.student.v2.ui.h5.js.d
            @Override // java.lang.Runnable
            public final void run() {
                j.v(j.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 t(final j jVar, final String str, final String str2) {
        b0.x(jVar.a(), "人脸采集", new Function0() { // from class: com.bxkj.student.v2.ui.h5.js.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 u5;
                u5 = j.u(str, str2, jVar);
                return u5;
            }
        });
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 w(final j jVar) {
        b0.x(jVar.a(), "人脸验证", new Function0() { // from class: com.bxkj.student.v2.ui.h5.js.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 x5;
                x5 = j.x(j.this);
                return x5;
            }
        });
        return n1.f44123a;
    }

    @JavascriptInterface
    public final void addUserFace(@Nullable final String str, @Nullable final String str2) {
        a().runOnUiThread(new Runnable() { // from class: com.bxkj.student.v2.ui.h5.js.i
            @Override // java.lang.Runnable
            public final void run() {
                j.s(j.this, str, str2);
            }
        });
    }
}

package com.bxkj.student.v2.ui.face;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.student.v2.common.data.PointData;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f0 f21370a = new f0();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f21371a;

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (i6 == -1) {
                this.f21371a.invoke();
            }
        }

        a(Function0<n1> function0) {
            this.f21371a = function0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f21372a;

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (i6 == -1) {
                this.f21372a.invoke();
            }
        }

        b(Function0<n1> function0) {
            this.f21372a = function0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 f(int i6, FragmentActivity fragmentActivity, String str, int i7, String str2, PointData pointData, Function0 function0) {
        Class cls = i6 == 1 ? FaceLiveV3Activity.class : FaceDetectV3Activity.class;
        u.b bVar = new u.b(fragmentActivity);
        Intent putExtra = new Intent().setClass(fragmentActivity, cls).putExtra("identify", str).putExtra("runType", i7).putExtra("type", str2).putExtra("pointData", pointData);
        g0.o(putExtra, "putExtra(...)");
        bVar.startActivityForResult(putExtra).c(new b(function0));
        fragmentActivity.overridePendingTransition(2130771987, 2130771986);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 e(final FragmentActivity fragmentActivity, final int i6, final String str, final int i7, final String str2, final PointData pointData, final Function0 function0) {
        com.bxkj.base.v2.common.ext.b0.x(fragmentActivity, "人脸识别", new Function0() { // from class: com.bxkj.student.v2.ui.face.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 f6;
                f6 = f0.f(i6, fragmentActivity, str, i7, str2, pointData, function0);
                return f6;
            }
        });
        return n1.f44123a;
    }

    public final void c(@NotNull FragmentActivity mActivity, @NotNull Function0<n1> agree) {
        g0.p(mActivity, "mActivity");
        g0.p(agree, "agree");
        if (com.bxkj.base.v2.data.b.f16998d.a().i()) {
            agree.invoke();
            return;
        }
        u.b bVar = new u.b(mActivity);
        Intent intent = new Intent().setClass(mActivity, FaceAgreementActivity.class);
        g0.o(intent, "setClass(...)");
        bVar.startActivityForResult(intent).c(new a(agree));
    }

    public final void d(@NotNull final FragmentActivity mActivity, final int i6, final int i7, @NotNull final String faceType, @NotNull final String identify, @Nullable final PointData pointData, @NotNull final Function0<n1> success) {
        g0.p(mActivity, "mActivity");
        g0.p(faceType, "faceType");
        g0.p(identify, "identify");
        g0.p(success, "success");
        c(mActivity, new Function0() { // from class: com.bxkj.student.v2.ui.face.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 e6;
                e6 = f0.e(FragmentActivity.this, i7, identify, i6, faceType, pointData, success);
                return e6;
            }
        });
    }

    private f0() {
    }
}

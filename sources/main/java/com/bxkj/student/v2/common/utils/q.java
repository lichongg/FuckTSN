package com.bxkj.student.v2.common.utils;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.acse.ottn.activity.AccessibiltyTsnPermissionGreenActivity;
import com.acse.ottn.activity.AcseHelpManager;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.v2.common.utils.q;
import java.security.MessageDigest;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20918a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSQZSManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SQZSManager.kt\ncom/bxkj/student/v2/common/utils/SQZSManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.v2.common.utils.q$a$a, reason: collision with other inner class name */
        public static final class C0278a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FragmentActivity f20919a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function0<n1> f20920b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Function0<n1> f20921c;

            C0278a(FragmentActivity fragmentActivity, Function0<n1> function0, Function0<n1> function02) {
                this.f20919a = fragmentActivity;
                this.f20920b = function0;
                this.f20921c = function02;
            }

            @Override // u.b.a
            public void a(int i6, Intent intent) {
                q.f20918a.c(this.f20919a, this.f20920b, this.f20921c);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function0 function0, Function0 function02, FragmentActivity fragmentActivity, String str) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 48) {
                    if (hashCode != 50) {
                        if (hashCode == 52 && str.equals("4")) {
                            function02.invoke();
                            return;
                        }
                    } else if (str.equals("2")) {
                        function0.invoke();
                        return;
                    }
                } else if (str.equals("0")) {
                    function0.invoke();
                    return;
                }
                new u.b(fragmentActivity).startActivityForResult(new Intent(fragmentActivity, (Class<?>) AccessibiltyTsnPermissionGreenActivity.class)).c(new C0278a(fragmentActivity, function0, function02));
            }
        }

        public final void c(@NotNull final FragmentActivity mActivity, @NotNull final Function0<n1> next, @NotNull final Function0<n1> close) {
            g0.p(mActivity, "mActivity");
            g0.p(next, "next");
            g0.p(close, "close");
            if (com.bxkj.base.v2.data.b.f16998d.a().b0() == 0) {
                com.orhanobut.logger.j.d("LoggedInUser.instance.isOpenSQZS = 0", new Object[0]);
                next.invoke();
                return;
            }
            if (b()) {
                com.orhanobut.logger.j.d("AcseHelpManager.isOPenPermission->权限已开启", new Object[0]);
                next.invoke();
                return;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                String schoolId = LoginUser.getLoginUser().getSchoolId();
                g0.o(schoolId, "getSchoolId(...)");
                String b6 = b.b(messageDigest.digest(kotlin.text.u.V1(schoolId)));
                g0.o(b6, "encode(...)");
                AcseHelpManager.syncUserIdState("0", b6);
            } catch (Exception e6) {
                String message = e6.getMessage();
                if (message != null) {
                    com.orhanobut.logger.j.e(message, new Object[0]);
                }
            }
            AcseHelpManager.startRunning(mActivity, true, new AcseHelpManager.OnCurrentStateCallBack() { // from class: com.bxkj.student.v2.common.utils.p
                @Override // com.acse.ottn.activity.AcseHelpManager.OnCurrentStateCallBack
                public final void onState(String str) {
                    q.a.d(Function0.this, close, mActivity, str);
                }
            });
        }

        public final void e(@NotNull FragmentActivity mActivity) {
            g0.p(mActivity, "mActivity");
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(mActivity, 170);
        }

        public final boolean b() {
            return AcseHelpManager.isOPenPermission();
        }
    }
}

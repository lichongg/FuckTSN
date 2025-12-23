package com.bxkj.student.common.jpush;

import cn.jpush.android.api.JPushInterface;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.App;
import com.bxkj.student.v2.retrofit.b;
import com.orhanobut.logger.j;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17746a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static int f17747b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.common.jpush.JPushManger$setAlias$1", f = "JPushManger.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bxkj.student.common.jpush.a$a, reason: collision with other inner class name */
    static final class C0202a extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f17748a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17749b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0202a(String str, e<? super C0202a> eVar) {
            super(2, eVar);
            this.f17749b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(Object obj, e<?> eVar) {
            return new C0202a(this.f17749b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, e<? super n1> eVar) {
            return ((C0202a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            C0202a c0202a;
            Exception exc;
            b c6;
            String str;
            Throwable th;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f17748a;
            if (i6 != 0) {
                if (i6 == 1) {
                    try {
                        g0.n(obj);
                        c0202a = this;
                    } catch (Exception e6) {
                        exc = e6;
                        c0202a = this;
                        j.e(com.bxkj.base.v2.common.ext.e.a(exc), new Object[0]);
                        JPushInterface.setAlias(App.f17573d.a(), a.f17747b, c0202a.f17749b);
                        return n1.f44123a;
                    } catch (Throwable th2) {
                        th = th2;
                        c0202a = this;
                        JPushInterface.setAlias(App.f17573d.a(), a.f17747b, c0202a.f17749b);
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                try {
                    c6 = com.bxkj.student.v2.retrofit.e.f21288a.c();
                    str = this.f17749b;
                    this.f17748a = 1;
                    c0202a = this;
                } catch (Exception e7) {
                    e = e7;
                    c0202a = this;
                } catch (Throwable th3) {
                    th = th3;
                    c0202a = this;
                    th = th;
                    JPushInterface.setAlias(App.f17573d.a(), a.f17747b, c0202a.f17749b);
                    throw th;
                }
                try {
                    try {
                        if (com.bxkj.student.v2.retrofit.a.c(c6, str, null, null, c0202a, 6, null) == l6) {
                            return l6;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        JPushInterface.setAlias(App.f17573d.a(), a.f17747b, c0202a.f17749b);
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                    exc = e;
                    j.e(com.bxkj.base.v2.common.ext.e.a(exc), new Object[0]);
                    JPushInterface.setAlias(App.f17573d.a(), a.f17747b, c0202a.f17749b);
                    return n1.f44123a;
                }
            }
            JPushInterface.setAlias(App.f17573d.a(), a.f17747b, c0202a.f17749b);
            return n1.f44123a;
        }
    }

    private final void b() {
        f17747b++;
        JPushInterface.deleteAlias(App.f17573d.a(), f17747b);
    }

    private final void c(String str) {
        f17747b++;
        k.f(w1.f49676a, g1.c(), null, new C0202a(str, null), 2, null);
    }

    public final void d(@NotNull String alias, boolean z5) {
        kotlin.jvm.internal.g0.p(alias, "alias");
        if (com.bxkj.base.v2.data.b.f16998d.a().d0() != 1) {
            JPushInterface.stopPush(App.f17573d.a());
        } else if (z5) {
            c(alias);
        } else {
            b();
        }
    }

    public final void e() {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        if (aVar.a().d0() != 1) {
            JPushInterface.stopPush(App.f17573d.a());
        } else {
            f17747b++;
            JPushInterface.setTags(App.f17573d.a(), f17747b, (Set<String>) u1.q(aVar.a().L()));
        }
    }

    private a() {
    }
}

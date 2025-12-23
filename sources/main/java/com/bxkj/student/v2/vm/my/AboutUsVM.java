package com.bxkj.student.v2.vm.my;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.http.result.OldApiResult;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import org.apache.commons.net.telnet.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class AboutUsVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f22330h = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.my.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.my.a u5;
            u5 = AboutUsVM.u();
            return u5;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.my.AboutUsVM$getPgyerAppVersion$1", f = "AboutUsVM.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22331a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, Object>, n1> f22333c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Map<String, Object>, n1> function1, e<? super a> eVar) {
            super(1, eVar);
            this.f22333c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return AboutUsVM.this.new a(this.f22333c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22331a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.my.a w5 = AboutUsVM.this.w();
                this.f22331a = 1;
                obj = w5.a(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                this.f22333c.invoke(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.my.AboutUsVM$getVersionCode$1", f = "AboutUsVM.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22334a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Map<String, Object>> f22336c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.ObjectRef<Map<String, Object>> objectRef, e<? super b> eVar) {
            super(1, eVar);
            this.f22336c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return AboutUsVM.this.new b(this.f22336c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22334a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.my.a w5 = AboutUsVM.this.w();
                this.f22334a = 1;
                obj = w5.b(this);
                if (obj == l6) {
                    return l6;
                }
            }
            OldApiResult oldApiResult = (OldApiResult) obj;
            if (oldApiResult != null) {
                this.f22336c.element = oldApiResult.getData();
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.my.AboutUsVM$getVersionCode$2", f = "AboutUsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22337a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, Object>, n1> f22338b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Map<String, Object>> f22339c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Map<String, Object>, n1> function1, Ref.ObjectRef<Map<String, Object>> objectRef, e<? super c> eVar) {
            super(1, eVar);
            this.f22338b = function1;
            this.f22339c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return new c(this.f22338b, this.f22339c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((c) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22337a == 0) {
                g0.n(obj);
                this.f22338b.invoke(this.f22339c.element);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.my.a u() {
        return new com.bxkj.student.v2.repository.my.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.my.a w() {
        return (com.bxkj.student.v2.repository.my.a) this.f22330h.getValue();
    }

    public final void x(@NotNull Function1<? super Map<String, Object>, n1> result) {
        kotlin.jvm.internal.g0.p(result, "result");
        BaseViewModel.j(this, new a(result, null), null, null, null, null, null, null, null, 254, null);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.LinkedHashMap] */
    public final void y(@NotNull Function1<? super Map<String, Object>, n1> result) {
        kotlin.jvm.internal.g0.p(result, "result");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new LinkedHashMap();
        BaseViewModel.j(this, new b(objectRef, null), null, null, null, new c(result, objectRef, null), null, null, null, f.f51103s, null);
    }
}

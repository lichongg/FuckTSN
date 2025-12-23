package com.bxkj.student.run.app.vm;

import android.text.TextUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.run.app.offline.table.RunDb;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RunVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f20366h = t.c(new Function0() { // from class: com.bxkj.student.run.app.vm.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            i0.a C;
            C = RunVM.C();
            return C;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$deleteExceptionRecord$1", f = "RunVM.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20367a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20368b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, kotlin.coroutines.e<? super a> eVar) {
            super(1, eVar);
            this.f20368b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new a(this.f20368b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20367a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                i0.a aVar = new i0.a();
                String str = this.f20368b;
                this.f20367a = 1;
                if (aVar.a(str, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$getLocalRecordById$1", f = "RunVM.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f20369a;

        /* renamed from: b, reason: collision with root package name */
        int f20370b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f20371c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f20372d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.ObjectRef<List<RunDb>> objectRef, String str, kotlin.coroutines.e<? super b> eVar) {
            super(1, eVar);
            this.f20371c = objectRef;
            this.f20372d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new b(this.f20371c, this.f20372d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t5;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20370b;
            if (i6 != 0) {
                if (i6 == 1) {
                    objectRef = (Ref.ObjectRef) this.f20369a;
                    g0.n(obj);
                    t5 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f20371c;
                i0.a aVar = new i0.a();
                String str = this.f20372d;
                this.f20369a = objectRef2;
                this.f20370b = 1;
                Object c6 = aVar.c(str, this);
                if (c6 == l6) {
                    return l6;
                }
                objectRef = objectRef2;
                t5 = c6;
            }
            objectRef.element = t5;
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$getLocalRecordById$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20373a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<List<RunDb>, n1> f20374b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f20375c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super List<RunDb>, n1> function1, Ref.ObjectRef<List<RunDb>> objectRef, kotlin.coroutines.e<? super c> eVar) {
            super(1, eVar);
            this.f20374b = function1;
            this.f20375c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new c(this.f20374b, this.f20375c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f20373a == 0) {
                g0.n(obj);
                this.f20374b.invoke(this.f20375c.element);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$getUploadFailSportsByType$1", f = "RunVM.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f20376a;

        /* renamed from: b, reason: collision with root package name */
        int f20377b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f20378c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RunVM f20379d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f20380e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, int i6, kotlin.coroutines.e<? super d> eVar) {
            super(1, eVar);
            this.f20378c = objectRef;
            this.f20379d = runVM;
            this.f20380e = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new d(this.f20378c, this.f20379d, this.f20380e, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t5;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20377b;
            if (i6 != 0) {
                if (i6 == 1) {
                    objectRef = (Ref.ObjectRef) this.f20376a;
                    g0.n(obj);
                    t5 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f20378c;
                i0.a x5 = this.f20379d.x();
                String account = LoginUser.getLoginUser().getAccount();
                kotlin.jvm.internal.g0.o(account, "getAccount(...)");
                int i7 = this.f20380e;
                this.f20376a = objectRef2;
                this.f20377b = 1;
                Object e6 = x5.e(account, i7, this);
                if (e6 == l6) {
                    return l6;
                }
                objectRef = objectRef2;
                t5 = e6;
            }
            objectRef.element = t5;
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$getUploadFailSportsByType$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20381a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<List<RunDb>, n1> f20382b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f20383c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super List<RunDb>, n1> function1, Ref.ObjectRef<List<RunDb>> objectRef, kotlin.coroutines.e<? super e> eVar) {
            super(1, eVar);
            this.f20382b = function1;
            this.f20383c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new e(this.f20382b, this.f20383c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f20381a == 0) {
                g0.n(obj);
                this.f20382b.invoke(this.f20383c.element);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$insertRun$1", f = "RunVM.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20384a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RunDb f20385b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(RunDb runDb, kotlin.coroutines.e<? super f> eVar) {
            super(1, eVar);
            this.f20385b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new f(this.f20385b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20384a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                i0.a aVar = new i0.a();
                RunDb runDb = this.f20385b;
                this.f20384a = 1;
                if (aVar.f(runDb, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$queryExceptionSports$1", f = "RunVM.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f20386a;

        /* renamed from: b, reason: collision with root package name */
        int f20387b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f20388c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RunVM f20389d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, kotlin.coroutines.e<? super g> eVar) {
            super(1, eVar);
            this.f20388c = objectRef;
            this.f20389d = runVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new g(this.f20388c, this.f20389d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((g) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t5;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20387b;
            if (i6 != 0) {
                if (i6 == 1) {
                    objectRef = (Ref.ObjectRef) this.f20386a;
                    g0.n(obj);
                    t5 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f20388c;
                i0.a x5 = this.f20389d.x();
                String account = LoginUser.getLoginUser().getAccount();
                kotlin.jvm.internal.g0.o(account, "getAccount(...)");
                this.f20386a = objectRef2;
                this.f20387b = 1;
                Object b6 = x5.b(account, this);
                if (b6 == l6) {
                    return l6;
                }
                objectRef = objectRef2;
                t5 = b6;
            }
            objectRef.element = t5;
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$queryExceptionSports$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20390a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<List<RunDb>, n1> f20391b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f20392c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(Function1<? super List<RunDb>, n1> function1, Ref.ObjectRef<List<RunDb>> objectRef, kotlin.coroutines.e<? super h> eVar) {
            super(1, eVar);
            this.f20391b = function1;
            this.f20392c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new h(this.f20391b, this.f20392c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((h) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f20390a == 0) {
                g0.n(obj);
                this.f20391b.invoke(this.f20392c.element);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$queryFailRecord$1", f = "RunVM.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    static final class i extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f20393a;

        /* renamed from: b, reason: collision with root package name */
        int f20394b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f20395c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RunVM f20396d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, kotlin.coroutines.e<? super i> eVar) {
            super(1, eVar);
            this.f20395c = objectRef;
            this.f20396d = runVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new i(this.f20395c, this.f20396d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((i) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t5;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20394b;
            if (i6 != 0) {
                if (i6 == 1) {
                    objectRef = (Ref.ObjectRef) this.f20393a;
                    g0.n(obj);
                    t5 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f20395c;
                i0.a x5 = this.f20396d.x();
                String account = LoginUser.getLoginUser().getAccount();
                kotlin.jvm.internal.g0.o(account, "getAccount(...)");
                this.f20393a = objectRef2;
                this.f20394b = 1;
                Object d6 = x5.d(account, this);
                if (d6 == l6) {
                    return l6;
                }
                objectRef = objectRef2;
                t5 = d6;
            }
            objectRef.element = t5;
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$queryFailRecord$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class j extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20397a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<List<RunDb>, n1> f20398b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f20399c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        j(Function1<? super List<RunDb>, n1> function1, Ref.ObjectRef<List<RunDb>> objectRef, kotlin.coroutines.e<? super j> eVar) {
            super(1, eVar);
            this.f20398b = function1;
            this.f20399c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new j(this.f20398b, this.f20399c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((j) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f20397a == 0) {
                g0.n(obj);
                this.f20398b.invoke(this.f20399c.element);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionStatus$1", f = "RunVM.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    static final class k extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20400a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RunDb f20401b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(RunDb runDb, kotlin.coroutines.e<? super k> eVar) {
            super(1, eVar);
            this.f20401b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new k(this.f20401b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((k) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20400a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                this.f20401b.setEndTime(String.valueOf(System.currentTimeMillis()));
                i0.a aVar = new i0.a();
                String endTime = this.f20401b.getEndTime();
                String uploadType = this.f20401b.getUploadType();
                String identify = this.f20401b.getIdentify();
                this.f20400a = 1;
                if (aVar.g(endTime, uploadType, identify, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionStatus$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class l extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20402a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f20403b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Function0<n1> function0, kotlin.coroutines.e<? super l> eVar) {
            super(1, eVar);
            this.f20403b = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new l(this.f20403b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((l) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f20402a == 0) {
                g0.n(obj);
                this.f20403b.invoke();
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionToFail$1", f = "RunVM.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20404a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RunDb f20405b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(RunDb runDb, kotlin.coroutines.e<? super m> eVar) {
            super(1, eVar);
            this.f20405b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new m(this.f20405b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((m) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20404a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                this.f20405b.setEndTime(String.valueOf(System.currentTimeMillis()));
                this.f20405b.setUploadType("2");
                i0.a aVar = new i0.a();
                String endTime = this.f20405b.getEndTime();
                String uploadType = this.f20405b.getUploadType();
                String identify = this.f20405b.getIdentify();
                this.f20404a = 1;
                if (aVar.g(endTime, uploadType, identify, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionToFail$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class n extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f20406a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f20407b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(Function0<n1> function0, kotlin.coroutines.e<? super n> eVar) {
            super(1, eVar);
            this.f20407b = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new n(this.f20407b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((n) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f20406a == 0) {
                g0.n(obj);
                this.f20407b.invoke();
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i0.a C() {
        return new i0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i0.a x() {
        return (i0.a) this.f20366h.getValue();
    }

    public final void A(@NotNull Function1<? super List<RunDb>, n1> complete) {
        kotlin.jvm.internal.g0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.j(this, new g(objectRef, this, null), null, null, null, new h(complete, objectRef, null), null, null, null, org.apache.commons.net.telnet.f.f51103s, null);
    }

    public final void B(@NotNull Function1<? super List<RunDb>, n1> complete) {
        kotlin.jvm.internal.g0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.j(this, new i(objectRef, this, null), null, null, null, new j(complete, objectRef, null), null, null, null, org.apache.commons.net.telnet.f.f51103s, null);
    }

    public final void D(@NotNull RunDb runDb, @NotNull Function0<n1> complete) {
        kotlin.jvm.internal.g0.p(runDb, "runDb");
        kotlin.jvm.internal.g0.p(complete, "complete");
        if (TextUtils.isEmpty(runDb.getEndTime())) {
            BaseViewModel.j(this, new k(runDb, null), null, null, null, new l(complete, null), null, null, null, org.apache.commons.net.telnet.f.f51103s, null);
        }
    }

    public final void E(@NotNull RunDb runDb, @NotNull Function0<n1> complete) {
        kotlin.jvm.internal.g0.p(runDb, "runDb");
        kotlin.jvm.internal.g0.p(complete, "complete");
        if (TextUtils.isEmpty(runDb.getEndTime())) {
            BaseViewModel.j(this, new m(runDb, null), null, null, null, new n(complete, null), null, null, null, org.apache.commons.net.telnet.f.f51103s, null);
        }
    }

    public final void v(@NotNull String identify) {
        kotlin.jvm.internal.g0.p(identify, "identify");
        BaseViewModel.j(this, new a(identify, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void w(@NotNull String identify, @NotNull Function1<? super List<RunDb>, n1> complete) {
        kotlin.jvm.internal.g0.p(identify, "identify");
        kotlin.jvm.internal.g0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.j(this, new b(objectRef, identify, null), null, null, null, new c(complete, objectRef, null), null, null, null, org.apache.commons.net.telnet.f.f51103s, null);
    }

    public final void y(int i6, @NotNull Function1<? super List<RunDb>, n1> complete) {
        kotlin.jvm.internal.g0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.j(this, new d(objectRef, this, i6, null), null, null, null, new e(complete, objectRef, null), null, null, null, org.apache.commons.net.telnet.f.f51103s, null);
    }

    public final void z(@NotNull RunDb runDb) {
        kotlin.jvm.internal.g0.p(runDb, "runDb");
        BaseViewModel.j(this, new f(runDb, null), null, null, null, null, null, null, null, 254, null);
    }
}

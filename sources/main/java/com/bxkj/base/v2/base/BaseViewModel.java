package com.bxkj.base.v2.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bxkj.base.v2.http.exception.ApiException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBaseViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseViewModel.kt\ncom/bxkj/base/v2/base/BaseViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,260:1\n1#2:261\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public class BaseViewModel extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final MutableLiveData<Integer> f16694a = new MutableLiveData<>();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private MutableLiveData<String> f16695b = new MutableLiveData<>("Loading...");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private MutableLiveData<String> f16696c = new MutableLiveData<>();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private MutableLiveData<String> f16697d = new MutableLiveData<>();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private MutableLiveData<String> f16698e = new MutableLiveData<>();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private MutableLiveData<String> f16699f = new MutableLiveData<>();

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private e2 f16700g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.base.BaseViewModel$launch$job$1", f = "BaseViewModel.kt", i = {2, 3, 3, 4, 4, 5, 5, 5}, l = {94, 117, 96, 101, 106, 108, 117, 117}, m = "invokeSuspend", n = {"e", "e", "failInvokeResult", "e", "failInvokeResult", "e", "failInvokeResult", "onErrorResult"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nBaseViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseViewModel.kt\ncom/bxkj/base/v2/base/BaseViewModel$launch$job$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,260:1\n1#2:261\n*E\n"})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f16701a;

        /* renamed from: b, reason: collision with root package name */
        Object f16702b;

        /* renamed from: c, reason: collision with root package name */
        Object f16703c;

        /* renamed from: d, reason: collision with root package name */
        int f16704d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f16705e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Boolean f16706f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ BaseViewModel f16707g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function1<kotlin.coroutines.e<? super n1>, Object> f16708h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> f16709i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Function2<Exception, kotlin.coroutines.e<? super n1>, Object> f16710j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> f16711k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Function2<ApiException, kotlin.coroutines.e<? super Boolean>, Object> f16712l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Function1<kotlin.coroutines.e<? super n1>, Object> f16713m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Boolean bool, BaseViewModel baseViewModel, Function1<? super kotlin.coroutines.e<? super n1>, ? extends Object> function1, Function2<? super Exception, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, Function2<? super Exception, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function22, Function2<? super Exception, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function23, Function2<? super ApiException, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function24, Function1<? super kotlin.coroutines.e<? super n1>, ? extends Object> function12, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f16705e = str;
            this.f16706f = bool;
            this.f16707g = baseViewModel;
            this.f16708h = function1;
            this.f16709i = function2;
            this.f16710j = function22;
            this.f16711k = function23;
            this.f16712l = function24;
            this.f16713m = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new a(this.f16705e, this.f16706f, this.f16707g, this.f16708h, this.f16709i, this.f16710j, this.f16711k, this.f16712l, this.f16713m, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x01c4, code lost:
        
            if (r10.invoke(r9) == r0) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x017e, code lost:
        
            if (r6.m(r5, r7, r9) == r0) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00dd, code lost:
        
            if (r10.invoke(r9) == r0) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x009d, code lost:
        
            if (r10.invoke(r9) == r0) goto L103;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x018e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x01b7  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0157 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:12:0x0029, B:28:0x0039, B:29:0x0151, B:31:0x0157, B:33:0x0161, B:36:0x0042, B:37:0x00f2, B:39:0x00fb, B:41:0x0105, B:43:0x0109, B:45:0x0123, B:48:0x013a, B:50:0x013e, B:55:0x004c, B:78:0x0095, B:82:0x00e1, B:84:0x00e5), top: B:2:0x0009, inners: #0 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 548
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.base.BaseViewModel.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.base.BaseViewModel", f = "BaseViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3}, l = {176, 176, 176, 184}, m = "onError", n = {"e", "otherCode", "code", "msg", "e", "otherCode", "code", "msg", "e", "otherCode", "code", "msg", "e", "otherCode"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f16714a;

        /* renamed from: b, reason: collision with root package name */
        Object f16715b;

        /* renamed from: c, reason: collision with root package name */
        Object f16716c;

        /* renamed from: d, reason: collision with root package name */
        Object f16717d;

        /* renamed from: e, reason: collision with root package name */
        Object f16718e;

        /* renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f16719f;

        /* renamed from: h, reason: collision with root package name */
        int f16721h;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f16719f = obj;
            this.f16721h |= Integer.MIN_VALUE;
            return BaseViewModel.this.m(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ e2 j(BaseViewModel baseViewModel, Function1 function1, Function2 function2, Function2 function22, Function2 function23, Function1 function12, Function2 function24, Boolean bool, String str, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
        }
        if ((i6 & 2) != 0) {
            function2 = null;
        }
        if ((i6 & 4) != 0) {
            function22 = null;
        }
        if ((i6 & 8) != 0) {
            function23 = null;
        }
        if ((i6 & 16) != 0) {
            function12 = null;
        }
        if ((i6 & 32) != 0) {
            function24 = null;
        }
        if ((i6 & 64) != 0) {
            bool = Boolean.TRUE;
        }
        if ((i6 & 128) != 0) {
            str = "Loading..";
        }
        return baseViewModel.i(function1, function2, function22, function23, function12, function24, bool, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(BaseViewModel baseViewModel, Function1 function1, Function2 function2, Function2 function22, Function2 function23, Function1 function12, Function2 function24, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchWithOutLoading");
        }
        if ((i6 & 2) != 0) {
            function2 = null;
        }
        if ((i6 & 4) != 0) {
            function22 = null;
        }
        if ((i6 & 8) != 0) {
            function23 = null;
        }
        if ((i6 & 16) != 0) {
            function12 = null;
        }
        if ((i6 & 32) != 0) {
            function24 = null;
        }
        baseViewModel.k(function1, function2, function22, function23, function12, function24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016d, code lost:
    
        if (m(r2, r14, r0) == r1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0252, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a7, code lost:
    
        if (m(r2, r14, r0) != r1) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0250, code lost:
    
        if (r15 == r1) goto L79;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(java.lang.Exception r13, kotlin.jvm.functions.Function2<? super com.bxkj.base.v2.http.exception.ApiException, ? super kotlin.coroutines.e<? super java.lang.Boolean>, ? extends java.lang.Object> r14, kotlin.coroutines.e<? super kotlin.n1> r15) {
        /*
            Method dump skipped, instructions count: 832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.base.BaseViewModel.m(java.lang.Exception, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public final e2 b() {
        return this.f16700g;
    }

    @NotNull
    public final MutableLiveData<Integer> c() {
        return this.f16694a;
    }

    @NotNull
    public final MutableLiveData<String> d() {
        return this.f16695b;
    }

    @NotNull
    public final MutableLiveData<String> e() {
        return this.f16696c;
    }

    @NotNull
    public final MutableLiveData<String> f() {
        return this.f16699f;
    }

    @NotNull
    public final MutableLiveData<String> g() {
        return this.f16698e;
    }

    @NotNull
    public final MutableLiveData<String> h() {
        return this.f16697d;
    }

    @NotNull
    protected final e2 i(@NotNull Function1<? super kotlin.coroutines.e<? super n1>, ? extends Object> success, @Nullable Function2<? super ApiException, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, @Nullable Function2<? super Exception, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function22, @Nullable Function2<? super Exception, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function23, @Nullable Function1<? super kotlin.coroutines.e<? super n1>, ? extends Object> function1, @Nullable Function2<? super Exception, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function24, @Nullable Boolean bool, @Nullable String str) {
        e2 f6;
        g0.p(success, "success");
        f6 = kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(this), null, null, new a(str, bool, this, success, function24, function23, function22, function2, function1, null), 3, null);
        this.f16700g = f6;
        return f6;
    }

    protected final void k(@NotNull Function1<? super kotlin.coroutines.e<? super n1>, ? extends Object> success, @Nullable Function2<? super ApiException, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, @Nullable Function2<? super Exception, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function22, @Nullable Function2<? super Exception, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function23, @Nullable Function1<? super kotlin.coroutines.e<? super n1>, ? extends Object> function1, @Nullable Function2<? super Exception, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function24) {
        g0.p(success, "success");
        this.f16700g = j(this, success, function2, function22, function23, function1, function24, Boolean.FALSE, null, 128, null);
    }

    public final void n(@Nullable e2 e2Var) {
        this.f16700g = e2Var;
    }

    public final void o(@NotNull MutableLiveData<String> mutableLiveData) {
        g0.p(mutableLiveData, "<set-?>");
        this.f16695b = mutableLiveData;
    }

    public final void p(@NotNull MutableLiveData<String> mutableLiveData) {
        g0.p(mutableLiveData, "<set-?>");
        this.f16696c = mutableLiveData;
    }

    public final void q(@NotNull MutableLiveData<String> mutableLiveData) {
        g0.p(mutableLiveData, "<set-?>");
        this.f16699f = mutableLiveData;
    }

    public final void r(@NotNull MutableLiveData<String> mutableLiveData) {
        g0.p(mutableLiveData, "<set-?>");
        this.f16698e = mutableLiveData;
    }

    public final void s(@NotNull MutableLiveData<String> mutableLiveData) {
        g0.p(mutableLiveData, "<set-?>");
        this.f16697d = mutableLiveData;
    }
}

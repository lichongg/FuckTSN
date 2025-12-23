package com.bxkj.student.v2.vm.face;

import androidx.lifecycle.ViewModelKt;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.db.dao.g;
import com.orhanobut.logger.j;
import java.io.File;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import retrofit2.c0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceDetectVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private e2 f22295h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private e2 f22296i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3$2", f = "FaceDetectVM.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22297a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f22298b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22299c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22300d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f22301e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f22302f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f22303g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22304h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, String str3, File file, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Function0<n1> function0, e<? super a> eVar) {
            super(1, eVar);
            this.f22298b = str;
            this.f22299c = str2;
            this.f22300d = str3;
            this.f22301e = file;
            this.f22302f = objectRef;
            this.f22303g = objectRef2;
            this.f22304h = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return new a(this.f22298b, this.f22299c, this.f22300d, this.f22301e, this.f22302f, this.f22303g, this.f22304h, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar;
            Object a6;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22297a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                    aVar = this;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.face.c cVar = new com.bxkj.student.v2.repository.face.c();
                String str = this.f22298b;
                String str2 = this.f22299c;
                String str3 = this.f22300d;
                String path = this.f22301e.getPath();
                kotlin.jvm.internal.g0.o(path, "getPath(...)");
                String str4 = this.f22302f.element;
                String str5 = this.f22303g.element;
                this.f22297a = 1;
                aVar = this;
                a6 = cVar.a(str, str2, str3, path, str4, str5, (r19 & 64) != 0 ? 0 : 0, aVar);
                if (a6 == l6) {
                    return l6;
                }
            }
            aVar.f22304h.invoke();
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3$3", f = "FaceDetectVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22305a;

        b(e<? super b> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return FaceDetectVM.this.new b(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22305a == 0) {
                g0.n(obj);
                e2 e2Var = FaceDetectVM.this.f22296i;
                if (e2Var != null) {
                    e2.a.b(e2Var, null, 1, null);
                }
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3$4", f = "FaceDetectVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<Exception, e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22307a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22308b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PointData f22310d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22311e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f22312f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ File f22313g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22314h;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3$4$1", f = "FaceDetectVM.kt", i = {0, 0, 0}, l = {70}, m = "invokeSuspend", n = {"coordinates", "timeStamp", "faceDb"}, s = {"L$0", "L$1", "L$2"})
        @SourceDebugExtension({"SMAP\nFaceDetectVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceDetectVM.kt\ncom/bxkj/student/v2/vm/face/FaceDetectVM$faceDetectV3$4$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
        static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            Object f22315a;

            /* renamed from: b, reason: collision with root package name */
            Object f22316b;

            /* renamed from: c, reason: collision with root package name */
            Object f22317c;

            /* renamed from: d, reason: collision with root package name */
            int f22318d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FaceDetectVM f22319e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ PointData f22320f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f22321g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f22322h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ File f22323i;

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ Function0<n1> f22324j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(FaceDetectVM faceDetectVM, PointData pointData, String str, String str2, File file, Function0<n1> function0, e<? super a> eVar) {
                super(1, eVar);
                this.f22319e = faceDetectVM;
                this.f22320f = pointData;
                this.f22321g = str;
                this.f22322h = str2;
                this.f22323i = file;
                this.f22324j = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final e<n1> create(e<?> eVar) {
                return new a(this.f22319e, this.f22320f, this.f22321g, this.f22322h, this.f22323i, this.f22324j, eVar);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(e<? super n1> eVar) {
                return ((a) create(eVar)).invokeSuspend(n1.f44123a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.String] */
            /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f22318d;
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    j.d("离线跑步人脸识别,将中途人脸识别的照片存储本地！", new Object[0]);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = "";
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = "";
                    PointData pointData = this.f22320f;
                    if (pointData != null) {
                        objectRef.element = pointData.getA() + "," + pointData.getO();
                        objectRef2.element = String.valueOf(pointData.getT());
                    }
                    String str = this.f22321g;
                    String str2 = this.f22322h;
                    String path = this.f22323i.getPath();
                    kotlin.jvm.internal.g0.o(path, "getPath(...)");
                    m0.b bVar = new m0.b(0L, str, str2, path, (String) objectRef.element, (String) objectRef2.element, 1, null);
                    g v5 = AppDatabase.f20686a.a().v();
                    if (v5 != null) {
                        this.f22315a = kotlin.coroutines.jvm.internal.j.a(objectRef);
                        this.f22316b = kotlin.coroutines.jvm.internal.j.a(objectRef2);
                        this.f22317c = kotlin.coroutines.jvm.internal.j.a(bVar);
                        this.f22318d = 1;
                        if (v5.insert(bVar, this) == l6) {
                            return l6;
                        }
                    }
                }
                this.f22324j.invoke();
                return n1.f44123a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PointData pointData, String str, String str2, File file, Function0<n1> function0, e<? super c> eVar) {
            super(2, eVar);
            this.f22310d = pointData;
            this.f22311e = str;
            this.f22312f = str2;
            this.f22313g = file;
            this.f22314h = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(Object obj, e<?> eVar) {
            c cVar = FaceDetectVM.this.new c(this.f22310d, this.f22311e, this.f22312f, this.f22313g, this.f22314h, eVar);
            cVar.f22308b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z5;
            Exception exc = (Exception) this.f22308b;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22307a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            if (com.bxkj.base.v2.common.ext.e.b(exc)) {
                FaceDetectVM faceDetectVM = FaceDetectVM.this;
                BaseViewModel.j(faceDetectVM, new a(faceDetectVM, this.f22310d, this.f22311e, this.f22312f, this.f22313g, this.f22314h, null), null, null, null, null, null, null, null, 254, null);
                z5 = true;
            } else {
                z5 = false;
            }
            return kotlin.coroutines.jvm.internal.a.a(z5);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, e<? super Boolean> eVar) {
            return ((c) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$startTimeOut$1", f = "FaceDetectVM.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22325a;

        d(e<? super d> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(Object obj, e<?> eVar) {
            return FaceDetectVM.this.new d(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, e<? super n1> eVar) {
            return ((d) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22325a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                this.f22325a = 1;
                if (a1.b(5000L, this) == l6) {
                    return l6;
                }
            }
            j.d("3秒未请求到接口主动取消", new Object[0]);
            e2 e2Var = FaceDetectVM.this.f22295h;
            if (e2Var != null) {
                ResponseBody.Companion companion = ResponseBody.Companion;
                MediaType parse = MediaType.Companion.parse("text/plain");
                byte[] bytes = "3秒未请求到接口主动取消".getBytes(kotlin.text.e.f47851b);
                kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
                h2.g(e2Var, "3秒未请求到接口主动取消", new HttpException(c0.c(502, companion.create(parse, bytes))));
            }
            return n1.f44123a;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        e2 e2Var = this.f22296i;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        super.onCleared();
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, java.lang.String] */
    public final void v(@NotNull String identify, @NotNull String type, @NotNull String runType, @NotNull File faceFile, @Nullable PointData pointData, @NotNull Function0<n1> result) {
        kotlin.jvm.internal.g0.p(identify, "identify");
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.jvm.internal.g0.p(runType, "runType");
        kotlin.jvm.internal.g0.p(faceFile, "faceFile");
        kotlin.jvm.internal.g0.p(result, "result");
        w();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        if (pointData != null) {
            objectRef.element = pointData.getA() + "," + pointData.getO();
            objectRef2.element = String.valueOf(pointData.getT());
        }
        this.f22295h = BaseViewModel.j(this, new a(identify, type, runType, faceFile, objectRef, objectRef2, result, null), null, null, null, new b(null), new c(pointData, identify, type, faceFile, result, null), null, null, 206, null);
    }

    private final void w() {
        e2 f6;
        f6 = k.f(ViewModelKt.getViewModelScope(this), null, null, new d(null), 3, null);
        this.f22296i = f6;
    }
}

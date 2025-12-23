package com.bxkj.student.v2.vm.face;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.http.exception.ApiException;
import java.io.File;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceCheckVM extends BaseViewModel {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceCheckVM$faceDetect$1", f = "FaceCheckVM.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function1<e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22286a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f22287b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<ApiException, n1> f22288c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(File file, Function1<? super ApiException, n1> function1, e<? super a> eVar) {
            super(1, eVar);
            this.f22287b = file;
            this.f22288c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(e<?> eVar) {
            return new a(this.f22287b, this.f22288c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22286a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.face.a aVar = new com.bxkj.student.v2.repository.face.a();
                MultipartBody.Part createFormData = MultipartBody.Part.Companion.createFormData(master.flame.danmaku.danmaku.parser.b.f50156c, this.f22287b.getName(), RequestBody.Companion.create(this.f22287b, MediaType.Companion.get("image/png")));
                this.f22286a = 1;
                if (aVar.a(createFormData, this) == l6) {
                    return l6;
                }
            }
            this.f22288c.invoke(new ApiException(kotlin.coroutines.jvm.internal.a.f(0), "人脸验证成功"));
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceCheckVM$faceDetect$2", f = "FaceCheckVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<ApiException, e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22289a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22290b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<ApiException, n1> f22291c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super ApiException, n1> function1, e<? super b> eVar) {
            super(2, eVar);
            this.f22291c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(Object obj, e<?> eVar) {
            b bVar = new b(this.f22291c, eVar);
            bVar.f22290b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ApiException apiException = (ApiException) this.f22290b;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22289a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            this.f22291c.invoke(apiException);
            return kotlin.coroutines.jvm.internal.a.a(true);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ApiException apiException, e<? super Boolean> eVar) {
            return ((b) create(apiException, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    public final void t(@NotNull File faceFile, @NotNull Function1<? super ApiException, n1> result) {
        kotlin.jvm.internal.g0.p(faceFile, "faceFile");
        kotlin.jvm.internal.g0.p(result, "result");
        BaseViewModel.j(this, new a(faceFile, result, null), new b(result, null), null, null, null, null, null, null, 252, null);
    }
}

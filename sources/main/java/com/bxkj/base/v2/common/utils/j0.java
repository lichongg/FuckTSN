package com.bxkj.base.v2.common.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.tencent.open.SocialConstants;
import java.io.OutputStream;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j0 f16904a = new j0();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.common.utils.SaveToGalleyUtils$downloadToGallery$1$1", f = "SaveToGalleyUtils.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3}, l = {67, 71, 76, 81}, m = "invokeSuspend", n = {"connection", "inputStream", "bitmap", "savedImageURL", "filePath", "connection", "inputStream", "bitmap", "savedImageURL", "connection", "inputStream", "bitmap", "e"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0"})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f16905a;

        /* renamed from: b, reason: collision with root package name */
        Object f16906b;

        /* renamed from: c, reason: collision with root package name */
        Object f16907c;

        /* renamed from: d, reason: collision with root package name */
        Object f16908d;

        /* renamed from: e, reason: collision with root package name */
        Object f16909e;

        /* renamed from: f, reason: collision with root package name */
        int f16910f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f16911g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16912h;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.base.v2.common.utils.SaveToGalleyUtils$downloadToGallery$1$1$1", f = "SaveToGalleyUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bxkj.base.v2.common.utils.j0$a$a, reason: collision with other inner class name */
        static final class C0191a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super Toast>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f16913a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FragmentActivity f16914b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0191a(FragmentActivity fragmentActivity, kotlin.coroutines.e<? super C0191a> eVar) {
                super(2, eVar);
                this.f16914b = fragmentActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new C0191a(this.f16914b, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super Toast> eVar) {
                return ((C0191a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f16913a == 0) {
                    kotlin.g0.n(obj);
                    return ContextExtKt.s(this.f16914b, "图片已保存到相册", 0, 2, null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.base.v2.common.utils.SaveToGalleyUtils$downloadToGallery$1$1$2", f = "SaveToGalleyUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f16915a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FragmentActivity f16916b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(FragmentActivity fragmentActivity, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f16916b = fragmentActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new b(this.f16916b, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f16915a == 0) {
                    kotlin.g0.n(obj);
                    ContextExtKt.q(this.f16916b, "保存失败");
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.base.v2.common.utils.SaveToGalleyUtils$downloadToGallery$1$1$3", f = "SaveToGalleyUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f16917a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FragmentActivity f16918b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(FragmentActivity fragmentActivity, kotlin.coroutines.e<? super c> eVar) {
                super(2, eVar);
                this.f16918b = fragmentActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new c(this.f16918b, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f16917a == 0) {
                    kotlin.g0.n(obj);
                    ContextExtKt.q(this.f16918b, "保存失败");
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.base.v2.common.utils.SaveToGalleyUtils$downloadToGallery$1$1$4", f = "SaveToGalleyUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class d extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f16919a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FragmentActivity f16920b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(FragmentActivity fragmentActivity, kotlin.coroutines.e<? super d> eVar) {
                super(2, eVar);
                this.f16920b = fragmentActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new d(this.f16920b, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((d) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f16919a == 0) {
                    kotlin.g0.n(obj);
                    ContextExtKt.q(this.f16920b, "保存失败");
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, FragmentActivity fragmentActivity, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f16911g = str;
            this.f16912h = fragmentActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new a(this.f16911g, this.f16912h, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0152, code lost:
        
            if (kotlinx.coroutines.i.h(r1, r3, r11) != r0) goto L45;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 344
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.utils.j0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            String string = cursor2.moveToFirst() ? cursor2.getString(cursor2.getColumnIndexOrThrow("_data")) : null;
            n1 n1Var = n1.f44123a;
            kotlin.io.b.a(cursor, null);
            return string;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri g(Context context, Bitmap bitmap, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(SocialConstants.PARAM_COMMENT, str2);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM);
        }
        Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert != null) {
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
                if (openOutputStream == null) {
                    return insert;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, openOutputStream);
                    kotlin.io.b.a(openOutputStream, null);
                    return insert;
                } finally {
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    public final void d(@NotNull final FragmentActivity mActivity, @Nullable final String str) {
        kotlin.jvm.internal.g0.p(mActivity, "mActivity");
        if (str == null || str.length() == 0) {
            return;
        }
        com.bxkj.base.v2.common.ext.b0.b0(mActivity, null, new Function0() { // from class: com.bxkj.base.v2.common.utils.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 e6;
                e6 = j0.e(FragmentActivity.this, str);
                return e6;
            }
        }, 1, null);
    }

    private j0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 e(FragmentActivity fragmentActivity, String str) {
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(fragmentActivity), g1.c(), null, new a(str, fragmentActivity, null), 2, null);
        return n1.f44123a;
    }
}

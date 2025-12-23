package com.bxkj.base.v2.h5;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.base.v2.h5.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.text.Regex;
import kotlin.text.u;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f17051b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static String f17052c = "";

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static String f17053d = "";

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final FragmentActivity f17054a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final String a(@NotNull String blobUrl, @Nullable String str, @Nullable String str2) {
            g0.p(blobUrl, "blobUrl");
            if (!u.H2(blobUrl, "blob", false, 2, null)) {
                return "javascript: console.log('It is not a Blob URL');";
            }
            h.f17052c = str;
            h.f17053d = str2;
            return "javascript: var xhr = new XMLHttpRequest();xhr.open('GET', '" + blobUrl + "', true);xhr.setRequestHeader('Content-type','" + str + ";charset=UTF-8');xhr.responseType = 'blob';xhr.onload = function(e) {    if (this.status == 200) {        var blobFile = this.response;        var reader = new FileReader();        reader.readAsDataURL(blobFile);        reader.onloadend = function() {            base64data = reader.result;            Android.getBase64FromBlobData(base64data);        }    }};xhr.send();";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.h5.DownloadBlobFileJSInterface$convertToGifAndProcess$1", f = "DownloadBlobFileJSInterface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f17055a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17057c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.base.v2.h5.DownloadBlobFileJSInterface$convertToGifAndProcess$1$1$1", f = "DownloadBlobFileJSInterface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f17058a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f17059b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f17060c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(h hVar, String str, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f17059b = hVar;
                this.f17060c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(this.f17059b, this.f17060c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                String str;
                kotlin.coroutines.intrinsics.a.l();
                if (this.f17058a == 0) {
                    kotlin.g0.n(obj);
                    g1.c();
                    h hVar = this.f17059b;
                    String str2 = this.f17060c;
                    File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    if (externalStoragePublicDirectory != null) {
                        str = externalStoragePublicDirectory.getPath();
                    } else {
                        str = null;
                    }
                    hVar.m(str2, new File(str + "/" + h.f17053d));
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f17057c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return h.this.new b(this.f17057c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 i(h hVar, String str) {
            kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(hVar.f17054a), g1.e(), null, new a(hVar, str, null), 2, null);
            return n1.f44123a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f17055a == 0) {
                kotlin.g0.n(obj);
                FragmentActivity fragmentActivity = h.this.f17054a;
                final h hVar = h.this;
                final String str = this.f17057c;
                b0.h0(fragmentActivity, null, new Function0() { // from class: com.bxkj.base.v2.h5.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        n1 i6;
                        i6 = h.b.i(h.this, str);
                        return i6;
                    }
                }, 1, null);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.h5.DownloadBlobFileJSInterface$saveGifToPath$1", f = "DownloadBlobFileJSInterface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f17061a;

        c(kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return h.this.new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f17061a == 0) {
                kotlin.g0.n(obj);
                ContextExtKt.q(h.this.f17054a, "下载失败");
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String str, File file) {
        String path;
        LifecycleCoroutineScope lifecycleScope;
        if (file != null) {
            try {
                path = file.getPath();
            } catch (Exception e6) {
                FragmentActivity fragmentActivity = this.f17054a;
                if (fragmentActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) != null) {
                    kotlinx.coroutines.k.f(lifecycleScope, g1.e(), null, new c(null), 2, null);
                }
                e6.printStackTrace();
                return;
            }
        } else {
            path = null;
        }
        com.orhanobut.logger.j.d("《《下载请求》》开始保存数据：\n" + str + "\n路径：" + path + "mimeType=" + f17052c + "\n文件名：" + f17053d, new Object[0]);
        String str2 = f17052c;
        StringBuilder sb = new StringBuilder();
        sb.append("data:");
        sb.append(str2);
        sb.append(";base64,");
        byte[] decode = Base64.decode(new Regex(sb.toString()).replaceFirst(str, ""), 0);
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        fileOutputStream.write(decode);
        fileOutputStream.flush();
        fileOutputStream.close();
        FragmentActivity fragmentActivity2 = this.f17054a;
        if (fragmentActivity2 != null) {
            ContextExtKt.s(fragmentActivity2, "下载成功", 0, 2, null);
        }
    }

    private final void h(String str) {
        LifecycleCoroutineScope lifecycleScope;
        if (Build.VERSION.SDK_INT >= 29) {
            j(str, f17053d);
            return;
        }
        FragmentActivity fragmentActivity = this.f17054a;
        if (fragmentActivity == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) == null) {
            return;
        }
        kotlinx.coroutines.k.f(lifecycleScope, g1.e(), null, new b(str, null), 2, null);
    }

    private final void i(Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, f17052c);
            intent.addFlags(1);
            intent.addFlags(268435456);
            FragmentActivity fragmentActivity = this.f17054a;
            PackageManager packageManager = fragmentActivity != null ? fragmentActivity.getPackageManager() : null;
            g0.m(packageManager);
            if (intent.resolveActivity(packageManager) != null) {
                this.f17054a.startActivity(intent);
            } else {
                ContextExtKt.q(this.f17054a, "没有找到可以打开此文件的应用");
            }
        } catch (Exception e6) {
            FragmentActivity fragmentActivity2 = this.f17054a;
            if (fragmentActivity2 != null) {
                ContextExtKt.q(fragmentActivity2, "打开文件失败: " + e6.getMessage());
            }
        }
    }

    @RequiresApi(29)
    private final void j(String str, String str2) {
        ContentResolver contentResolver;
        Uri uri;
        OutputStream openOutputStream;
        FragmentActivity fragmentActivity = this.f17054a;
        if (fragmentActivity == null || (contentResolver = fragmentActivity.getContentResolver()) == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", f17052c);
        contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS);
        try {
            com.orhanobut.logger.j.d("《《下载请求》》开始保存数据：\n" + str + "\nmimeType=" + f17052c + "\n文件名：" + f17053d, new Object[0]);
            uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
            final Uri insert = contentResolver.insert(uri, contentValues);
            if (insert == null || (openOutputStream = contentResolver.openOutputStream(insert)) == null) {
                return;
            }
            try {
                openOutputStream.write(Base64.decode(new Regex("data:" + f17052c + ";base64,").replaceFirst(str, ""), 0));
                ContextExtKt.g(this.f17054a, "下载成功", "已保存至手机根目录下的Download文件夹下的" + f17053d + ",是否打开文件？", new Function1() { // from class: com.bxkj.base.v2.h5.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 k6;
                        k6 = h.k(h.this, insert, (iOSTwoButtonDialog) obj);
                        return k6;
                    }
                }, new Function1() { // from class: com.bxkj.base.v2.h5.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 l6;
                        l6 = h.l((iOSTwoButtonDialog) obj);
                        return l6;
                    }
                }, "稍后再说", "现在打开");
                kotlin.io.b.a(openOutputStream, null);
            } finally {
            }
        } catch (Exception unused) {
            ContextExtKt.m(this.f17054a, "下载失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 k(h hVar, Uri uri, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        hVar.i(uri);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(iOSTwoButtonDialog it) {
        g0.p(it, "it");
        return n1.f44123a;
    }

    @JavascriptInterface
    public final void getBase64FromBlobData(@NotNull String base64Data) {
        g0.p(base64Data, "base64Data");
        h(base64Data);
    }

    public h(@Nullable FragmentActivity fragmentActivity) {
        this.f17054a = fragmentActivity;
    }
}

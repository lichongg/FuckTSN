package com.bxkj.base.v2.h5;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlin.text.Regex;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f17046a = new e();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.h5.DownloadBlobFile$saveGifToPath$1", f = "DownloadBlobFile.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f17047a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f17048b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FragmentActivity fragmentActivity, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f17048b = fragmentActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new a(this.f17048b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f17047a == 0) {
                g0.n(obj);
                ContextExtKt.q(this.f17048b, "下载失败");
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void h(FragmentActivity fragmentActivity, String str, String str2, String str3) {
        try {
            byte[] decode = Base64.decode(new Regex("data:" + str2 + ";base64,").replaceFirst(str3, ""), 0);
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            FileOutputStream fileOutputStream = new FileOutputStream(new File((externalStoragePublicDirectory != null ? externalStoragePublicDirectory.getPath() : null) + "/" + str), false);
            fileOutputStream.write(decode);
            fileOutputStream.flush();
            fileOutputStream.close();
            ContextExtKt.s(fragmentActivity, "下载成功", 0, 2, null);
        } catch (Exception e6) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity);
            if (lifecycleScope != null) {
                kotlinx.coroutines.k.f(lifecycleScope, g1.e(), null, new a(fragmentActivity, null), 2, null);
            }
            e6.printStackTrace();
        }
    }

    private final void d(FragmentActivity fragmentActivity, String str, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, str);
            intent.addFlags(1);
            intent.addFlags(268435456);
            if (intent.resolveActivity(fragmentActivity.getPackageManager()) != null) {
                fragmentActivity.startActivity(intent);
            } else {
                ContextExtKt.q(fragmentActivity, "没有找到可以打开此文件的应用");
            }
        } catch (Exception e6) {
            ContextExtKt.q(fragmentActivity, "打开文件失败: " + e6.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 f(FragmentActivity fragmentActivity, String str, Uri uri, iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        f17046a.d(fragmentActivity, str, uri);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 g(iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return n1.f44123a;
    }

    public final void c(@NotNull FragmentActivity mActivity, @Nullable String str, @Nullable String str2, @NotNull String base64Data) {
        kotlin.jvm.internal.g0.p(mActivity, "mActivity");
        kotlin.jvm.internal.g0.p(base64Data, "base64Data");
        if (Build.VERSION.SDK_INT >= 29) {
            e(mActivity, str, str2, base64Data);
        } else {
            h(mActivity, str, str2, base64Data);
        }
    }

    private e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.content.Context] */
    @RequiresApi(29)
    private final void e(final FragmentActivity fragmentActivity, String str, final String str2, String str3) {
        Uri uri;
        ?? contentResolver = fragmentActivity.getContentResolver();
        if (contentResolver != 0) {
            ?? contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", str2);
            ?? r32 = Environment.DIRECTORY_DOWNLOADS;
            contentValues.put("relative_path", r32);
            try {
                uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                final Uri insert = contentResolver.insert(uri, contentValues);
                if (insert != null) {
                    OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                    try {
                        if (openOutputStream != null) {
                            try {
                                openOutputStream.write(Base64.decode(new Regex("data:" + str2 + ";base64,").replaceFirst(str3, ""), 0));
                                openOutputStream.flush();
                                openOutputStream.close();
                                r32 = fragmentActivity;
                            } catch (Throwable th) {
                                th = th;
                                r32 = fragmentActivity;
                            }
                            try {
                                ContextExtKt.g(r32, "下载成功", "已保存至手机根目录下的Download文件夹下的" + str + ",是否打开文件？", new Function1() { // from class: com.bxkj.base.v2.h5.c
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        n1 f6;
                                        f6 = e.f(FragmentActivity.this, str2, insert, (iOSTwoButtonDialog) obj);
                                        return f6;
                                    }
                                }, new Function1() { // from class: com.bxkj.base.v2.h5.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        n1 g6;
                                        g6 = e.g((iOSTwoButtonDialog) obj);
                                        return g6;
                                    }
                                }, "稍后再说", "现在打开");
                                kotlin.io.b.a(openOutputStream, null);
                            } catch (Throwable th2) {
                                th = th2;
                                Throwable th3 = th;
                                try {
                                    throw th3;
                                } catch (Throwable th4) {
                                    kotlin.io.b.a(openOutputStream, th3);
                                    throw th4;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        ContextExtKt.m(r32, "下载失败");
                    }
                }
            } catch (Exception unused2) {
                r32 = fragmentActivity;
            }
        }
    }
}

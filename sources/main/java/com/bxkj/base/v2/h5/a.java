package com.bxkj.base.v2.h5;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Environment;
import android.webkit.URLUtil;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17042a = new a();

    public final void a(@NotNull FragmentActivity mActivity, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        g0.p(mActivity, "mActivity");
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setNotificationVisibility(1);
            String guessFileName = URLUtil.guessFileName(str, str2, str3);
            request.setTitle(guessFileName);
            request.setDescription("正在下载...");
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessFileName);
            DownloadManager downloadManager = (DownloadManager) mActivity.getSystemService("download");
            if (downloadManager == null) {
                ContextExtKt.q(mActivity, "下载服务不可用");
            } else {
                downloadManager.enqueue(request);
                ContextExtKt.s(mActivity, "开始下载", 0, 2, null);
            }
        } catch (Exception unused) {
            ContextExtKt.q(mActivity, "下载服务不可用");
        }
    }

    private a() {
    }
}

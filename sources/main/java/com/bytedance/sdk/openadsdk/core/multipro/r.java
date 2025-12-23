package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.web.MultiWebview;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.l.ae;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static void j(final Context context) {
        if (context == null) {
            return;
        }
        MultiWebview.f27177r = new com.bytedance.sdk.component.widget.j() { // from class: com.bytedance.sdk.openadsdk.core.multipro.r.1
            @Override // com.bytedance.sdk.component.widget.j
            public void j(String str, Throwable th) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("threadName", str);
                    jSONObject.put("record", Arrays.toString(th.getStackTrace()));
                } catch (Exception unused) {
                }
                ws.j().j("webview_init_failed", jSONObject, th);
            }
        };
        com.bytedance.sdk.component.ae.cw.j(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (i.j(context)) {
                    ae.j(new g("tt_webview_file_path") { // from class: com.bytedance.sdk.openadsdk.core.multipro.r.2
                        @Override // java.lang.Runnable
                        public void run() {
                            r.cw(context);
                        }
                    });
                    return;
                }
                String xt = i.xt(context);
                try {
                    if (TextUtils.isEmpty(xt)) {
                        xt = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(xt);
                } catch (IllegalStateException unused) {
                    j(xt);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            vl.cw(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(Context context) {
        String concat;
        RandomAccessFile randomAccessFile;
        Throwable th;
        String j6 = j();
        if (TextUtils.isEmpty(j6)) {
            concat = "webview";
        } else {
            concat = "webview_".concat(String.valueOf(j6));
        }
        boolean z5 = false;
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(context, concat, 0).getPath(), "webview_data.lock");
        vl.j("TTMultiInitHelper", file.getAbsolutePath());
        if (!file.exists()) {
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock tryLock = randomAccessFile.getChannel().tryLock();
                    if (tryLock != null) {
                        tryLock.close();
                    } else {
                        j(file, file.delete());
                    }
                    com.bytedance.sdk.component.m.cw.cw.xt.j(randomAccessFile);
                } catch (Exception unused) {
                    randomAccessFile2 = randomAccessFile;
                    if (file.exists()) {
                        z5 = file.delete();
                    }
                    j(file, z5);
                    com.bytedance.sdk.component.m.cw.cw.xt.j(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    com.bytedance.sdk.component.m.cw.cw.xt.j(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th3) {
                randomAccessFile = randomAccessFile2;
                th = th3;
            }
        } catch (Exception unused2) {
        }
    }

    private static void j(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static void j(File file, boolean z5) {
        if (!z5 || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e6) {
            vl.j(e6);
        }
    }

    private static String j() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}

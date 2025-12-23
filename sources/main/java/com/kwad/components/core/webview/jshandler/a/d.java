package com.kwad.components.core.webview.jshandler.a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private final WeakReference<Context> aeJ;

    @SuppressLint({"WrongConstant"})
    private static boolean aD(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            intent.setFlags(335544320);
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.aeJ.get() != null) {
            boolean aD = aD(this.aeJ.get());
            if (cVar != null) {
                if (aD) {
                    cVar.a(null);
                } else {
                    cVar.onError(-1, "wechat launch error");
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openWechatQRScan";
    }

    public d(Context context) {
        this.aeJ = new WeakReference<>(context);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}

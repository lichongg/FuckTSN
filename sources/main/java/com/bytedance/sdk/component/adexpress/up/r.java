package com.bytedance.sdk.component.adexpress.up;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.j.ch;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<ch> f25857j;

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<ch> weakReference = this.f25857j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f25857j.get().invokeMethod(str);
    }

    public void j(ch chVar) {
        this.f25857j = new WeakReference<>(chVar);
    }

    public r(ch chVar) {
        this.f25857j = new WeakReference<>(chVar);
    }
}

package com.kwad.library.b.c;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.utils.z;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"RestrictedApi"})
/* loaded from: D:\Downloads\app\classes6.dex */
final class d extends ContextThemeWrapper implements b {
    private Resources.Theme aqh;
    private int aqi;
    private String aqj;
    private final ContextThemeWrapper aqk;

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.j(StubApp.getOrigApplicationContext(this.aqk.getApplicationContext()), this.aqj);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.aqk;
    }

    @Override // com.kwad.library.b.c.b
    public final Context getDelegatedContext() {
        return this.aqk;
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.aqk.getResources(), this.aqj);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(this.aqk.getSystemService(str), str, this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aqk.registerComponentCallbacks(componentCallbacks);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i6) {
        this.aqi = i6;
        super.setTheme(i6);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aqk.unregisterComponentCallbacks(componentCallbacks);
    }

    public d(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, contextThemeWrapper.getThemeResId());
        this.aqk = contextThemeWrapper;
        this.aqj = str;
        try {
            Object a6 = z.a((Object) contextThemeWrapper, "android.view.ContextThemeWrapper", "getThemeResId");
            if (a6 != null) {
                this.aqi = ((Integer) a6).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.a(super.getClassLoader(), this.aqj);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e6) {
            e6.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.aqh;
        if (theme2 == null || theme2 == theme) {
            this.aqh = a.a(theme, theme2, this.aqi, this.aqj);
        }
        return this.aqh;
    }
}

package com.kwad.library.b.c;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class e extends ContextWrapper implements b {
    private Resources.Theme aqh;
    private int aqi;
    private String aqj;
    private final Context mContext;

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return a.j(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext()), this.aqj);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.mContext;
    }

    @Override // com.kwad.library.b.c.b
    public final Context getDelegatedContext() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return a.a(this.mContext.getResources(), this.aqj);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mContext.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i6) {
        this.aqi = i6;
        super.setTheme(i6);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mContext.unregisterComponentCallbacks(componentCallbacks);
    }

    e(Context context, String str) {
        super(context);
        this.aqi = -1;
        this.mContext = context;
        this.aqj = str;
        this.aqi = a.getThemeResId(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return a.a(super.getClassLoader(), this.aqj);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return a.wrapSystemService(super.getSystemService(str), str, this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
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

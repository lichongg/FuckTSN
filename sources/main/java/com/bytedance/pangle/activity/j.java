package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements View.OnClickListener {
    private final int cw;

    /* renamed from: j, reason: collision with root package name */
    private final Activity f25373j;

    /* renamed from: r, reason: collision with root package name */
    private Method f25374r;
    private final String xt;

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        if (this.f25374r == null) {
            j(this.f25373j, this.xt);
        }
        try {
            this.f25374r.invoke(this.f25373j, view);
        } catch (IllegalAccessException e6) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e6);
        } catch (InvocationTargetException e7) {
            throw new IllegalStateException("Could not execute method for android:onClick", e7);
        }
    }

    public j(@NonNull Activity activity, int i6, @NonNull String str) {
        this.f25373j = activity;
        this.xt = str;
        this.cw = i6;
    }

    @NonNull
    private void j(@Nullable Activity activity, @NonNull String str) {
        try {
            Method method = activity.getClass().getMethod(this.xt, View.class);
            if (method != null) {
                this.f25374r = method;
                return;
            }
        } catch (NoSuchMethodException unused) {
        }
        throw new IllegalStateException("Could not find method " + this.xt + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.cw);
    }
}

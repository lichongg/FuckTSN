package com.bytedance.sdk.component.cw.xt.j.xt;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class up extends RuntimeException {

    /* renamed from: j, reason: collision with root package name */
    private static final Method f26319j;
    private IOException xt;

    public IOException j() {
        return this.xt;
    }

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f26319j = method;
    }

    public void j(IOException iOException) {
        j(iOException, this.xt);
        this.xt = iOException;
    }

    public up(IOException iOException) {
        super(iOException);
        this.xt = iOException;
    }

    private void j(IOException iOException, IOException iOException2) {
        Method method = f26319j;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}

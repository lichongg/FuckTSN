package org.slf4j.impl;

import android.util.Log;
import org.slf4j.helpers.MarkerIgnoringBase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class a extends MarkerIgnoringBase {
    private static final long serialVersionUID = -1227274521521287937L;

    @Override // org.slf4j.c
    public void debug(String str) {
        d(3, str, null);
    }

    @Override // org.slf4j.c
    public void error(String str) {
        d(6, str, null);
    }

    @Override // org.slf4j.c
    public void info(String str) {
        d(4, str, null);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled() {
        return c(3);
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled() {
        return c(6);
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled() {
        return c(4);
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled() {
        return c(2);
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled() {
        return c(5);
    }

    @Override // org.slf4j.c
    public void trace(String str) {
        d(2, str, null);
    }

    @Override // org.slf4j.c
    public void warn(String str) {
        d(5, str, null);
    }

    private boolean c(int i6) {
        return Log.isLoggable(this.name, i6);
    }

    private void e(int i6, String str, Throwable th) {
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        Log.println(i6, this.name, str);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj) {
        b(3, str, obj);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj) {
        b(6, str, obj);
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj) {
        b(4, str, obj);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj) {
        b(2, str, obj);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj) {
        b(5, str, obj);
    }

    a(String str) {
        this.name = str;
    }

    private void b(int i6, String str, Object... objArr) {
        if (c(i6)) {
            org.slf4j.helpers.c a6 = org.slf4j.helpers.d.a(str, objArr);
            e(i6, a6.b(), a6.c());
        }
    }

    private void d(int i6, String str, Throwable th) {
        if (c(i6)) {
            e(i6, str, th);
        }
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj, Object obj2) {
        b(3, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj, Object obj2) {
        b(6, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj, Object obj2) {
        b(4, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj, Object obj2) {
        b(2, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj, Object obj2) {
        b(5, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object... objArr) {
        b(3, str, objArr);
    }

    @Override // org.slf4j.c
    public void error(String str, Object... objArr) {
        b(6, str, objArr);
    }

    @Override // org.slf4j.c
    public void info(String str, Object... objArr) {
        b(4, str, objArr);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object... objArr) {
        b(2, str, objArr);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object... objArr) {
        b(5, str, objArr);
    }

    @Override // org.slf4j.c
    public void debug(String str, Throwable th) {
        d(2, str, th);
    }

    @Override // org.slf4j.c
    public void error(String str, Throwable th) {
        d(6, str, th);
    }

    @Override // org.slf4j.c
    public void info(String str, Throwable th) {
        d(4, str, th);
    }

    @Override // org.slf4j.c
    public void trace(String str, Throwable th) {
        d(2, str, th);
    }

    @Override // org.slf4j.c
    public void warn(String str, Throwable th) {
        d(5, str, th);
    }
}

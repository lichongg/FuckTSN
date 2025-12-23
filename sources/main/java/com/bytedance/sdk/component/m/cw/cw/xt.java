package com.bytedance.sdk.component.m.cw.cw;

import java.io.Closeable;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }
}

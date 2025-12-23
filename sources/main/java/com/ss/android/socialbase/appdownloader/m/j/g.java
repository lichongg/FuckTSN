package com.ss.android.socialbase.appdownloader.m.j;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes6.dex */
public class g {
    public static final void a(e eVar, int i6) throws IOException {
        int g6 = eVar.g();
        if (g6 == i6) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i6) + ", read 0x" + Integer.toHexString(g6) + ".");
    }
}

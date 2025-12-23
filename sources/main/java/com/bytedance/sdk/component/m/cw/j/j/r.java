package com.bytedance.sdk.component.m.cw.j.j;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
final class r {

    /* renamed from: j, reason: collision with root package name */
    static final Charset f26567j = Charset.forName("US-ASCII");
    static final Charset xt = Charset.forName("UTF-8");

    static void j(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    j(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }
}

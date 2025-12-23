package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class t implements com.bumptech.glide.load.a<InputStream> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f15515b = "StreamEncoder";

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f15516a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        byte[] bArr = (byte[]) this.f15516a.c(65536, byte[].class);
        boolean z5 = false;
        ?? r12 = 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        r12 = -1;
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (IOException unused) {
                        fileOutputStream = fileOutputStream2;
                        Log.isLoggable(f15515b, 3);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        this.f15516a.put(bArr);
                        r12 = fileOutputStream;
                        return z5;
                    } catch (Throwable th) {
                        th = th;
                        r12 = fileOutputStream2;
                        if (r12 != 0) {
                            try {
                                r12.close();
                            } catch (IOException unused3) {
                            }
                        }
                        this.f15516a.put(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                }
                this.f15516a.put(bArr);
                z5 = true;
            } catch (IOException unused5) {
            }
            return z5;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public t(com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f15516a = bVar;
    }
}

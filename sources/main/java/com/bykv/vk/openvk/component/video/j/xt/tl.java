package com.bykv.vk.openvk.component.video.j.xt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\Downloads\app\classes3.dex */
class tl {

    /* renamed from: j, reason: collision with root package name */
    private final RandomAccessFile f23101j;

    void j(long j6) throws j {
        try {
            this.f23101j.seek(j6);
        } catch (IOException e6) {
            throw new j(e6);
        }
    }

    static class j extends Exception {
        j(Throwable th) {
            super(th);
        }
    }

    tl(File file, String str) throws j {
        try {
            this.f23101j = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e6) {
            throw new j(e6);
        }
    }

    void j(byte[] bArr, int i6, int i7) throws j {
        try {
            this.f23101j.write(bArr, i6, i7);
        } catch (IOException e6) {
            throw new j(e6);
        }
    }

    int j(byte[] bArr) throws j {
        try {
            return this.f23101j.read(bArr);
        } catch (IOException e6) {
            throw new j(e6);
        }
    }

    void j() {
        com.bykv.vk.openvk.component.video.j.cw.j.j(this.f23101j);
    }
}

package com.ss.android.cw;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f37555a;

    @Override // com.ss.android.cw.c
    public long j() throws IOException {
        return this.f37555a.length();
    }

    @Override // com.ss.android.cw.c
    public int j(byte[] bArr, int i6, int i7) throws IOException {
        return this.f37555a.read(bArr, i6, i7);
    }

    @Override // com.ss.android.cw.c
    public void xt() throws IOException {
        this.f37555a.close();
    }

    public b(File file) throws FileNotFoundException {
        this.f37555a = new RandomAccessFile(file, t.f36150k);
    }

    @Override // com.ss.android.cw.c
    public void j(long j6, long j7) throws IOException {
        this.f37555a.seek(j6);
    }
}

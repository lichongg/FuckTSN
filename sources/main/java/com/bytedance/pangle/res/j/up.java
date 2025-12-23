package com.bytedance.pangle.res.j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends oq {

    /* renamed from: j, reason: collision with root package name */
    private long f25484j;

    @Override // com.bytedance.pangle.res.j.oq
    protected synchronized void j(int i6) {
        if (i6 != -1) {
            this.f25484j += i6;
        }
    }

    @Override // com.bytedance.pangle.res.j.oq, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j6) throws IOException {
        long skip;
        skip = super.skip(j6);
        this.f25484j += skip;
        return skip;
    }

    public synchronized long xt() {
        return this.f25484j;
    }

    public up(InputStream inputStream) {
        super(inputStream);
    }

    public int j() {
        long xt = xt();
        if (xt <= 2147483647L) {
            return (int) xt;
        }
        throw new ArithmeticException("The byte count " + xt + " is too large to be converted to an int");
    }
}

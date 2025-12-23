package com.bytedance.pangle.util.xt.j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f25550j = new byte[2];
    private final byte[] xt = new byte[4];

    public int j(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.xt);
        return xt(this.xt);
    }

    public int xt(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f25550j);
        return j(this.f25550j);
    }

    private int xt(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public void j(RandomAccessFile randomAccessFile, int i6) throws IOException {
        j(this.f25550j, i6);
        randomAccessFile.write(this.f25550j);
    }

    private void xt(byte[] bArr, int i6) {
        bArr[3] = (byte) (i6 >>> 24);
        bArr[2] = (byte) (i6 >>> 16);
        bArr[1] = (byte) (i6 >>> 8);
        bArr[0] = (byte) (i6 & 255);
    }

    public void j(ByteArrayOutputStream byteArrayOutputStream, int i6) throws IOException {
        j(this.f25550j, i6);
        byteArrayOutputStream.write(this.f25550j);
    }

    public void j(OutputStream outputStream, int i6) throws IOException {
        xt(this.xt, i6);
        outputStream.write(this.xt);
    }

    private int j(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    private void j(byte[] bArr, int i6) {
        bArr[1] = (byte) (i6 >>> 8);
        bArr[0] = (byte) (i6 & 255);
    }
}

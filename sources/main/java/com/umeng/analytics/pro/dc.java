package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class dc extends de {

    /* renamed from: a, reason: collision with root package name */
    protected InputStream f41208a;

    /* renamed from: b, reason: collision with root package name */
    protected OutputStream f41209b;

    protected dc() {
        this.f41208a = null;
        this.f41209b = null;
    }

    @Override // com.umeng.analytics.pro.de
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.de
    public void b() throws df {
    }

    @Override // com.umeng.analytics.pro.de
    public int a(byte[] bArr, int i6, int i7) throws df {
        InputStream inputStream = this.f41208a;
        if (inputStream == null) {
            throw new df(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i6, i7);
            if (read >= 0) {
                return read;
            }
            throw new df(4);
        } catch (IOException e6) {
            throw new df(0, e6);
        }
    }

    @Override // com.umeng.analytics.pro.de
    public void b(byte[] bArr, int i6, int i7) throws df {
        OutputStream outputStream = this.f41209b;
        if (outputStream == null) {
            throw new df(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i6, i7);
        } catch (IOException e6) {
            throw new df(0, e6);
        }
    }

    @Override // com.umeng.analytics.pro.de
    public void c() {
        InputStream inputStream = this.f41208a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            this.f41208a = null;
        }
        OutputStream outputStream = this.f41209b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            this.f41209b = null;
        }
    }

    @Override // com.umeng.analytics.pro.de
    public void d() throws df {
        OutputStream outputStream = this.f41209b;
        if (outputStream == null) {
            throw new df(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e6) {
            throw new df(0, e6);
        }
    }

    public dc(InputStream inputStream) {
        this.f41209b = null;
        this.f41208a = inputStream;
    }

    public dc(OutputStream outputStream) {
        this.f41208a = null;
        this.f41209b = outputStream;
    }

    public dc(InputStream inputStream, OutputStream outputStream) {
        this.f41208a = inputStream;
        this.f41209b = outputStream;
    }
}

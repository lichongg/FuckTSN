package com.bytedance.sdk.component.xt.j.j.xt;

import com.bytedance.sdk.component.xt.j.i;
import com.bytedance.sdk.component.xt.j.oq;
import com.snail.antifake.deviceid.e;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends i {

    /* renamed from: j, reason: collision with root package name */
    HttpURLConnection f27280j;
    InputStream xt;

    @Override // com.bytedance.sdk.component.xt.j.i, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.xt.close();
            this.f27280j.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public InputStream cw() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public long j() {
        try {
            return this.f27280j.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public byte[] r() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = this.xt.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, read);
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return new byte[0];
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable unused4) {
            }
            return byteArray;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public oq up() {
        if (this.f27280j.getContentType() != null) {
            return oq.j(this.f27280j.getContentType());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.xt.j.i
    public String xt() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.xt));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String stringBuffer2 = stringBuffer.toString();
                    close();
                    return stringBuffer2;
                }
                stringBuffer.append(readLine + e.f37542d);
            }
        } catch (Exception unused) {
            return "";
        }
    }

    ae(HttpURLConnection httpURLConnection) throws IOException {
        this.f27280j = httpURLConnection;
        this.xt = new up(httpURLConnection.getInputStream(), httpURLConnection);
    }
}

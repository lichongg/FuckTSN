package com.bytedance.pangle.util.xt.j;

import com.bytedance.pangle.util.xt.xt.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public void j(r rVar, RandomAccessFile randomAccessFile) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (rVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            long filePointer = randomAccessFile.getFilePointer();
            j(rVar, byteArrayOutputStream);
            j(rVar, byteArrayOutputStream.size(), (int) filePointer, byteArrayOutputStream);
            randomAccessFile.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th;
        }
    }

    private void j(r rVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        if (rVar.j() == null || rVar.j().j() == null || rVar.j().j().size() <= 0) {
            return;
        }
        Iterator<com.bytedance.pangle.util.xt.xt.cw> it = rVar.j().j().iterator();
        while (it.hasNext()) {
            j(it.next(), byteArrayOutputStream, rVar.r());
        }
    }

    private void j(com.bytedance.pangle.util.xt.xt.cw cwVar, ByteArrayOutputStream byteArrayOutputStream, cw cwVar2) throws IOException {
        if (cwVar != null) {
            byte[] bArr = {0, 0};
            cwVar2.j((OutputStream) byteArrayOutputStream, 33639248);
            cwVar2.j(byteArrayOutputStream, 0);
            cwVar2.j(byteArrayOutputStream, 0);
            cwVar2.j(byteArrayOutputStream, 0);
            cwVar2.j(byteArrayOutputStream, cwVar.j());
            cwVar2.j(byteArrayOutputStream, 2081);
            cwVar2.j(byteArrayOutputStream, 545);
            cwVar2.j((OutputStream) byteArrayOutputStream, (int) cwVar.ae());
            cwVar2.j((OutputStream) byteArrayOutputStream, (int) cwVar.tl());
            cwVar2.j((OutputStream) byteArrayOutputStream, (int) cwVar.g());
            byte[] bArr2 = new byte[0];
            if (cwVar.vl() != null && cwVar.vl().trim().length() > 0) {
                bArr2 = j(cwVar.vl());
            }
            cwVar2.j(byteArrayOutputStream, bArr2.length);
            int qv = cwVar.qv();
            cwVar2.j(byteArrayOutputStream, qv);
            cwVar2.j(byteArrayOutputStream, 0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            cwVar2.j((OutputStream) byteArrayOutputStream, (int) cwVar.jy());
            if (bArr2.length > 0) {
                byteArrayOutputStream.write(bArr2);
            }
            if (qv > 0) {
                byteArrayOutputStream.write(new byte[qv]);
                return;
            }
            return;
        }
        throw new IOException("input parameters is null, cannot write local file header");
    }

    private void j(r rVar, int i6, int i7, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        rVar.r().j((OutputStream) byteArrayOutputStream, 101010256);
        rVar.r().j(byteArrayOutputStream, 0);
        rVar.r().j(byteArrayOutputStream, 0);
        int size = rVar.j().j().size();
        rVar.r().j(byteArrayOutputStream, size);
        rVar.r().j(byteArrayOutputStream, size);
        rVar.r().j((OutputStream) byteArrayOutputStream, i6);
        rVar.r().j((OutputStream) byteArrayOutputStream, i7);
        rVar.r().j(byteArrayOutputStream, 0);
    }

    private byte[] j(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }
}

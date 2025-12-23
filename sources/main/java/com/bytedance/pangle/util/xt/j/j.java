package com.bytedance.pangle.util.xt.j;

import com.bytedance.pangle.util.xt.xt.r;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public r j(String str) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.f36150k);
            try {
                if (randomAccessFile2.length() < 22) {
                    throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
                }
                r rVar = new r(str);
                j(randomAccessFile2, rVar);
                if (rVar.xt().j() == 0) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused) {
                    }
                    return rVar;
                }
                xt(randomAccessFile2, rVar);
                try {
                    randomAccessFile2.close();
                } catch (IOException unused2) {
                }
                return rVar;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void xt(RandomAccessFile randomAccessFile, r rVar) throws IOException {
        com.bytedance.pangle.util.xt.xt.j jVar = new com.bytedance.pangle.util.xt.xt.j();
        ArrayList arrayList = new ArrayList();
        long xt = rVar.xt().xt();
        long j6 = rVar.xt().j();
        randomAccessFile.seek(xt);
        for (int i6 = 0; i6 < j6; i6++) {
            com.bytedance.pangle.util.xt.xt.cw cwVar = new com.bytedance.pangle.util.xt.xt.cw();
            if (rVar.r().j(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i6 + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            cwVar.j(rVar.r().xt(randomAccessFile));
            randomAccessFile.skipBytes(4);
            cwVar.j(rVar.r().j(randomAccessFile));
            cwVar.xt(rVar.r().j(randomAccessFile));
            cwVar.cw(rVar.r().j(randomAccessFile));
            int xt2 = rVar.r().xt(randomAccessFile);
            cwVar.cw(xt2);
            cwVar.r(rVar.r().xt(randomAccessFile));
            int xt3 = rVar.r().xt(randomAccessFile);
            randomAccessFile.skipBytes(8);
            cwVar.r(rVar.r().j(randomAccessFile));
            if (xt2 <= 0) {
                throw new IOException("Invalid entry name in file header");
            }
            byte[] bArr = new byte[xt2];
            randomAccessFile.readFully(bArr);
            cwVar.j(j(bArr));
            randomAccessFile.skipBytes(cwVar.qv());
            if (xt3 > 0) {
                randomAccessFile.skipBytes(xt3);
            }
            long filePointer = randomAccessFile.getFilePointer();
            randomAccessFile.seek(cwVar.jy() + 28);
            cwVar.xt(rVar.r().xt(randomAccessFile));
            randomAccessFile.seek(filePointer);
            arrayList.add(cwVar);
        }
        jVar.j(arrayList);
        rVar.j(jVar);
    }

    private long cw(RandomAccessFile randomAccessFile, r rVar) throws IOException {
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j6 = length - 22;
            randomAccessFile.seek(j6);
            if (rVar.r().j(randomAccessFile) == 101010256) {
                return j6;
            }
            return r(randomAccessFile, rVar);
        }
        throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
    }

    private long r(RandomAccessFile randomAccessFile, r rVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        long j6 = 65536;
        if (randomAccessFile.length() < 65536) {
            j6 = randomAccessFile.length();
        }
        while (j6 > 0 && length > 0) {
            length--;
            randomAccessFile.seek(length);
            if (rVar.r().j(randomAccessFile) == 101010256) {
                return length;
            }
            j6--;
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private void j(RandomAccessFile randomAccessFile, r rVar) throws IOException {
        randomAccessFile.seek(cw(randomAccessFile, rVar) + 4);
        com.bytedance.pangle.util.xt.xt.xt xtVar = new com.bytedance.pangle.util.xt.xt.xt();
        randomAccessFile.skipBytes(6);
        xtVar.j(rVar.r().xt(randomAccessFile));
        randomAccessFile.skipBytes(4);
        xtVar.j(rVar.r().j(randomAccessFile));
        rVar.j(xtVar);
    }

    private String j(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}

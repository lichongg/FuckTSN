package com.bytedance.pangle.util.xt;

import com.bytedance.pangle.util.ae;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.xt.xt.cw;
import com.bytedance.pangle.util.xt.xt.r;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final r f25549j;
    private final com.bytedance.pangle.util.xt.j.xt xt = new com.bytedance.pangle.util.xt.j.xt();

    public void j(boolean z5, boolean z6) throws IOException, InterruptedException {
        RandomAccessFile randomAccessFile;
        Iterator<cw> it;
        long m6;
        j jVar = this;
        File file = new File(jVar.f25549j.cw().getAbsolutePath() + ".rm_tmp");
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile2 = new RandomAccessFile(jVar.f25549j.cw(), t.f36150k);
                try {
                    List<cw> j6 = jVar.f25549j.j().j();
                    HashSet hashSet = new HashSet();
                    Iterator<cw> it2 = j6.iterator();
                    int i6 = 0;
                    while (it2.hasNext()) {
                        cw next = it2.next();
                        if (jVar.j(next, z5, z6)) {
                            hashSet.add(next.vl());
                        } else {
                            long jy = next.jy();
                            if ("resources.arsc".equals(next.vl())) {
                                try {
                                    long filePointer = randomAccessFile.getFilePointer() + next.r();
                                    if (filePointer % 4096 == 0) {
                                        it = it2;
                                        m6 = 0;
                                    } else {
                                        it = it2;
                                        m6 = 4096 - ((filePointer - next.m()) % 4096);
                                    }
                                    if (m6 != 0) {
                                        int m7 = next.m();
                                        int i7 = (int) m6;
                                        next.xt(i7);
                                        j(randomAccessFile2, randomAccessFile, jy, next.up(), next.vl());
                                        this.f25549j.r().j(randomAccessFile, i7);
                                        j(randomAccessFile2, randomAccessFile, jy + next.up() + 2, next.oq(), next.vl());
                                        randomAccessFile.write(new byte[i7]);
                                        j(randomAccessFile2, randomAccessFile, jy + next.up() + 2 + next.oq() + m7, next.xt(), next.vl());
                                        jVar = this;
                                        long j7 = i6;
                                        next.r(j7);
                                        i6 = (int) (j7 + next.cw());
                                        it2 = it;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    jVar = this;
                                    if (randomAccessFile2 != null) {
                                        randomAccessFile2.close();
                                    }
                                    if (randomAccessFile != null) {
                                        randomAccessFile.close();
                                    }
                                    jVar.j(file);
                                    throw th;
                                }
                            } else {
                                it = it2;
                            }
                            jVar = this;
                            jVar.j(randomAccessFile2, randomAccessFile, jy, next.cw(), next.vl());
                            long j72 = i6;
                            next.r(j72);
                            i6 = (int) (j72 + next.cw());
                            it2 = it;
                        }
                    }
                    jVar.f25549j.j().j(hashSet);
                    jVar.xt.j(jVar.f25549j, randomAccessFile);
                    jVar.j(jVar.f25549j.cw(), file);
                    randomAccessFile2.close();
                    randomAccessFile.close();
                    jVar.j(file);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public j(r rVar) {
        this.f25549j = rVar;
    }

    private boolean j(cw cwVar, boolean z5, boolean z6) {
        if (z5) {
            if (g.m() && cwVar.vl().equals("classes.dex")) {
                return false;
            }
            if (cwVar.vl().startsWith("classes") && cwVar.vl().endsWith(".dex")) {
                return true;
            }
        }
        return z6 && cwVar.vl().startsWith("lib/") && cwVar.vl().endsWith(".so");
    }

    void j(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    void j(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j6, long j7, String str) throws IOException {
        ae.j(randomAccessFile, randomAccessFile2, j6, j7 + j6, str);
    }

    private void j(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}

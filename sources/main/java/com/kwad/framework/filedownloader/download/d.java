package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements Handler.Callback {
    private volatile Thread amO;
    private final com.kwad.framework.filedownloader.d.c ant;
    private final a aob;
    private final int aoc;
    private final int aod;
    private final int aoe;
    private long aof;
    private HandlerThread aog;
    private volatile boolean aoj;
    private Handler handler;
    private volatile boolean aoh = false;
    private volatile long anN = 0;
    private final AtomicLong aoi = new AtomicLong();
    private boolean aok = true;
    private final com.kwad.framework.filedownloader.b.a ano = b.yc().ye();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private boolean aol;
        private Exception aom;
        private int aon;

        final void bN(int i6) {
            this.aon = i6;
        }

        final void bh(boolean z5) {
            this.aol = z5;
        }

        final void f(Exception exc) {
            this.aom = exc;
        }

        public final Exception getException() {
            return this.aom;
        }

        public final int wN() {
            return this.aon;
        }

        public final boolean yE() {
            return this.aol;
        }
    }

    private synchronized void b(Message message) {
        if (!this.aog.isAlive()) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e6) {
            if (this.aog.isAlive()) {
                throw e6;
            }
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
        }
    }

    final void a(boolean z5, long j6, String str, String str2) {
        String za = this.ant.za();
        if (za != null && !za.equals(str)) {
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, za));
        }
        this.aob.bh(z5);
        this.ant.d((byte) 2);
        this.ant.ab(j6);
        this.ant.bx(str);
        this.ant.bz(str2);
        this.ano.a(this.ant.getId(), j6, str, str2);
        c((byte) 2);
        this.aof = h(j6, this.aoe);
        this.aoj = true;
    }

    final void c(Exception exc) {
        e(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.aoh = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L19
            r2 = 5
            if (r1 == r2) goto Ld
            goto L20
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L17
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L17
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L17
            r4.a(r1, r5)     // Catch: java.lang.Throwable -> L17
            goto L20
        L17:
            r5 = move-exception
            goto L2c
        L19:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L17
            r4.b(r1, r0)     // Catch: java.lang.Throwable -> L17
        L20:
            r4.aoh = r3
            java.lang.Thread r5 = r4.amO
            if (r5 == 0) goto L2b
            java.lang.Thread r5 = r4.amO
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L2b:
            return r0
        L2c:
            r4.aoh = r3
            java.lang.Thread r0 = r4.amO
            if (r0 == 0) goto L37
            java.lang.Thread r0 = r4.amO
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L37:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.d.handleMessage(android.os.Message):boolean");
    }

    private boolean W(long j6) {
        if (!this.aok) {
            return this.aof != -1 && this.aoi.get() >= this.aof && j6 - this.anN >= ((long) this.aod);
        }
        this.aok = false;
        return true;
    }

    private void c(byte b6) {
        if (b6 != -2) {
            com.kwad.framework.filedownloader.message.e.yT().s(com.kwad.framework.filedownloader.message.f.a(b6, this.ant, this.aob));
        } else if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.ant.getId()));
        }
    }

    private Exception d(Exception exc) {
        long length;
        String yr = this.ant.yr();
        if ((this.ant.isChunked() || com.kwad.framework.filedownloader.f.e.zB().apJ) && (exc instanceof IOException) && new File(yr).exists()) {
            long availableBytes = h.getAvailableBytes(yr);
            if (availableBytes <= 4096) {
                File file = new File(yr);
                if (file.exists()) {
                    length = file.length();
                } else {
                    com.kwad.framework.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                    length = 0;
                }
                return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
            }
        }
        return exc;
    }

    private static long h(long j6, long j7) {
        if (j7 <= 0) {
            return -1L;
        }
        if (j6 == -1) {
            return 1L;
        }
        long j8 = j6 / (j7 + 1);
        if (j8 <= 0) {
            return 1L;
        }
        return j8;
    }

    private void yA() {
        String yr = this.ant.yr();
        String targetFilePath = this.ant.getTargetFilePath();
        File file = new File(yr);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwad.framework.filedownloader.f.f.c("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                com.kwad.framework.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwad.framework.filedownloader.f.f.c("Can't rename the  temp downloaded file(%s) to the target file(%s)", yr, targetFilePath));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", yr);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", yr);
            }
            throw th;
        }
    }

    private boolean yC() {
        if (this.ant.isChunked()) {
            com.kwad.framework.filedownloader.d.c cVar = this.ant;
            cVar.ab(cVar.yZ());
            return false;
        }
        if (this.ant.yZ() == this.ant.getTotal()) {
            return false;
        }
        c(new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("sofar[%d] not equal total[%d]", Long.valueOf(this.ant.yZ()), Long.valueOf(this.ant.getTotal()))));
        return true;
    }

    private void yD() {
        this.ant.d((byte) -2);
        this.ano.d(this.ant.getId(), this.ant.yZ());
        c((byte) -2);
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.aog;
        return handlerThread != null && handlerThread.isAlive();
    }

    final void onProgress(long j6) {
        this.aoi.addAndGet(j6);
        this.ant.aa(j6);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean W = W(elapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(elapsedRealtime, W);
        } else if (W) {
            b(handler.obtainMessage(3));
        }
    }

    final void yu() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.aog.quit();
            this.amO = Thread.currentThread();
            while (this.aoh) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.amO = null;
        }
    }

    public final void yv() {
        this.ant.d((byte) 1);
        this.ano.bH(this.ant.getId());
        c((byte) 1);
    }

    final void yw() {
        this.ant.d((byte) 6);
        c((byte) 6);
        this.ano.bC(this.ant.getId());
    }

    final void yx() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.aog = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.aog.getLooper(), this);
    }

    d(com.kwad.framework.filedownloader.d.c cVar, int i6, int i7, int i8) {
        this.ant = cVar;
        this.aod = i7 < 5 ? 5 : i7;
        this.aoe = i8;
        this.aob = new a();
        this.aoc = i6;
    }

    private void e(Exception exc) {
        Exception exc2;
        Exception d6 = d(exc);
        if (d6 instanceof SQLiteFullException) {
            a((SQLiteFullException) d6);
            exc2 = d6;
        } else {
            try {
                this.ant.d((byte) -1);
                this.ant.by(exc.toString());
                this.ano.a(this.ant.getId(), d6, this.ant.yZ());
                exc2 = d6;
            } catch (SQLiteFullException e6) {
                SQLiteFullException sQLiteFullException = e6;
                a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.aob.f(exc2);
        c((byte) -1);
    }

    private void yB() {
        yA();
        this.ant.d((byte) -3);
        this.ano.c(this.ant.getId(), this.ant.getTotal());
        this.ano.bF(this.ant.getId());
        c((byte) -3);
        if (com.kwad.framework.filedownloader.f.e.zB().apK) {
            com.kwad.framework.filedownloader.services.f.f(this.ant);
        }
    }

    final void yy() {
        yD();
    }

    final void yz() {
        if (yC()) {
            return;
        }
        yB();
    }

    private void b(long j6, boolean z5) {
        if (this.ant.yZ() == this.ant.getTotal()) {
            this.ano.b(this.ant.getId(), this.ant.yZ());
            return;
        }
        if (this.aoj) {
            this.aoj = false;
            this.ant.d((byte) 3);
        }
        if (z5) {
            this.anN = j6;
            c((byte) 3);
            this.aoi.set(0L);
        }
    }

    final void a(Exception exc, int i6, long j6) {
        this.aoi.set(0L);
        this.ant.aa(-j6);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i6);
        } else {
            b(handler.obtainMessage(5, i6, 0, exc));
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.ant.getId();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.ant.by(sQLiteFullException.toString());
        this.ant.d((byte) -1);
        this.ano.bG(id);
        this.ano.bF(id);
    }

    private void a(Exception exc, int i6) {
        Exception d6 = d(exc);
        this.aob.f(d6);
        this.aob.bN(this.aoc - i6);
        this.ant.d((byte) 5);
        this.ant.by(d6.toString());
        this.ano.a(this.ant.getId(), d6);
        c((byte) 5);
    }
}

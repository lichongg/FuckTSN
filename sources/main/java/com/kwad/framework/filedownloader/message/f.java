package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.download.d;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.a;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f {
    public static MessageSnapshot a(int i6, File file, boolean z5) {
        long length = file.length();
        return length > 2147483647L ? z5 ? new d.a(i6, true, length) : new d.b(i6, true, length) : z5 ? new h.a(i6, true, (int) length) : new h.b(i6, true, (int) length);
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.wP()) {
            return new d.e(aVar.getId(), aVar.wH(), aVar.wI());
        }
        return new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.wJ() == -3) {
            return new a.C0660a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.wJ())));
    }

    public static MessageSnapshot a(int i6, long j6, long j7, boolean z5) {
        if (j7 > 2147483647L) {
            if (z5) {
                return new d.i(i6, j6, j7);
            }
            return new d.j(i6, j6, j7);
        }
        if (z5) {
            return new h.i(i6, (int) j6, (int) j7);
        }
        return new h.j(i6, (int) j6, (int) j7);
    }

    public static MessageSnapshot a(int i6, long j6, Throwable th) {
        if (j6 > 2147483647L) {
            return new d.C0661d(i6, j6, th);
        }
        return new h.d(i6, (int) j6, th);
    }

    public static MessageSnapshot a(byte b6, com.kwad.framework.filedownloader.d.c cVar, d.a aVar) {
        IllegalStateException illegalStateException;
        int id = cVar.getId();
        if (b6 == -4) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("please use #catchWarn instead %d", Integer.valueOf(id)));
        }
        if (b6 == -3) {
            if (cVar.wP()) {
                return new d.b(id, false, cVar.getTotal());
            }
            return new h.b(id, false, (int) cVar.getTotal());
        }
        if (b6 == -1) {
            if (cVar.wP()) {
                return new d.C0661d(id, cVar.yZ(), aVar.getException());
            }
            return new h.d(id, (int) cVar.yZ(), aVar.getException());
        }
        if (b6 == 1) {
            if (cVar.wP()) {
                return new d.f(id, cVar.yZ(), cVar.getTotal());
            }
            return new h.f(id, (int) cVar.yZ(), (int) cVar.getTotal());
        }
        if (b6 == 2) {
            String filename = cVar.wF() ? cVar.getFilename() : null;
            if (cVar.wP()) {
                return new d.c(id, aVar.yE(), cVar.getTotal(), cVar.za(), filename);
            }
            return new h.c(id, aVar.yE(), (int) cVar.getTotal(), cVar.za(), filename);
        }
        if (b6 == 3) {
            if (cVar.wP()) {
                return new d.g(id, cVar.yZ());
            }
            return new h.g(id, (int) cVar.yZ());
        }
        if (b6 == 5) {
            if (cVar.wP()) {
                return new d.h(id, cVar.yZ(), aVar.getException(), aVar.wN());
            }
            return new h.C0662h(id, (int) cVar.yZ(), aVar.getException(), aVar.wN());
        }
        if (b6 != 6) {
            String c6 = com.kwad.framework.filedownloader.f.f.c("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b6));
            com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b6));
            if (aVar.getException() != null) {
                illegalStateException = new IllegalStateException(c6, aVar.getException());
            } else {
                illegalStateException = new IllegalStateException(c6);
            }
            if (cVar.wP()) {
                return new d.C0661d(id, cVar.yZ(), illegalStateException);
            }
            return new h.d(id, (int) cVar.yZ(), illegalStateException);
        }
        return new MessageSnapshot.b(id);
    }
}

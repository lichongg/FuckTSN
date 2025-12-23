package com.kwad.framework.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.c.a;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class p extends com.kwad.framework.filedownloader.services.a<a, com.kwad.framework.filedownloader.c.b> {
    @Override // com.kwad.framework.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        a2(bVar, aVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class a extends a.AbstractBinderC0656a {
        protected a() {
        }

        @Override // com.kwad.framework.filedownloader.c.a
        public final void q(MessageSnapshot messageSnapshot) {
            com.kwad.framework.filedownloader.message.e.yT().s(messageSnapshot);
        }
    }

    private static com.kwad.framework.filedownloader.c.b a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    private static a xE() {
        return new a();
    }

    p(Class<?> cls) {
        super(cls);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        bVar.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ com.kwad.framework.filedownloader.c.b b(IBinder iBinder) {
        return a(iBinder);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bw(int i6) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bw(i6);
        }
        try {
            return ze().bw(i6);
        } catch (RemoteException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte bx(int i6) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bx(i6);
        }
        try {
            return ze().bx(i6);
        } catch (RemoteException e6) {
            e6.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean by(int i6) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.by(i6);
        }
        try {
            return ze().by(i6);
        } catch (RemoteException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ a xF() {
        return xE();
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z5, int i6, int i7, int i8, boolean z6, com.kwad.framework.filedownloader.d.b bVar, boolean z7) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z5);
        }
        try {
            ze().b(str, str2, z5, i6, i7, i8, z6, bVar, z7);
            return true;
        } catch (RemoteException e6) {
            e6.printStackTrace();
            return false;
        }
    }
}

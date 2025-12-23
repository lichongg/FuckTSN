package org.apache.commons.net.ftp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final h f50667a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final h f50668b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final h f50669c = new c();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements h {
        @Override // org.apache.commons.net.ftp.h
        public boolean a(FTPFile fTPFile) {
            return fTPFile != null;
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements h {
        @Override // org.apache.commons.net.ftp.h
        public boolean a(FTPFile fTPFile) {
            return fTPFile != null && fTPFile.isDirectory();
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements h {
        @Override // org.apache.commons.net.ftp.h
        public boolean a(FTPFile fTPFile) {
            return true;
        }

        a() {
        }
    }
}

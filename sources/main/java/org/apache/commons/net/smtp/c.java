package org.apache.commons.net.smtp;

import java.io.IOException;
import java.io.Writer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends b {
    public c() {
    }

    public c(String str) {
        super(str);
    }

    public boolean A0(String str) throws IOException {
        return e.c(o0("<" + str + ">"));
    }

    public boolean O0(String str) throws IOException {
        return e.c(l0("<" + str + ">"));
    }

    public boolean B0(a aVar) throws IOException {
        return e.c(o0(aVar.toString()));
    }

    public boolean C0() throws IOException {
        return e.c(e0());
    }

    public String D0() throws IOException {
        if (e.c(j0())) {
            return g0();
        }
        return null;
    }

    public String E0(String str) throws IOException {
        if (e.c(k0(str))) {
            return g0();
        }
        return null;
    }

    public boolean F0() throws IOException {
        String hostName = x().getHostName();
        if (hostName == null) {
            return false;
        }
        return e.c(i0(hostName));
    }

    public boolean G0(String str) throws IOException {
        return e.c(i0(str));
    }

    public boolean H0() throws IOException {
        return e.c(n0());
    }

    public boolean I0() throws IOException {
        return e.c(q0());
    }

    public Writer J0() throws IOException {
        if (!e.d(c0())) {
            return null;
        }
        return new org.apache.commons.net.io.e(this.f51023x);
    }

    public boolean K0() throws IOException {
        return e.c(m0());
    }

    public boolean L0(String str) throws IOException {
        Writer J0 = J0();
        if (J0 == null) {
            return false;
        }
        J0.write(str);
        J0.close();
        return C0();
    }

    public boolean M0(String str, String str2, String str3) throws IOException {
        if (!O0(str) || !A0(str2)) {
            return false;
        }
        return L0(str3);
    }

    public boolean N0(String str, String[] strArr, String str2) throws IOException {
        if (!O0(str)) {
            return false;
        }
        boolean z5 = false;
        for (String str3 : strArr) {
            if (A0(str3)) {
                z5 = true;
            }
        }
        if (!z5) {
            return false;
        }
        return L0(str2);
    }

    public boolean P0(a aVar) throws IOException {
        return e.c(l0(aVar.toString()));
    }

    public boolean Q0(String str) throws IOException {
        int z02 = z0(str);
        if (z02 != 250 && z02 != 251) {
            return false;
        }
        return true;
    }
}

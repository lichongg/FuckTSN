package org.apache.commons.net.ntp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final d f50983a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f50984b;

    /* renamed from: c, reason: collision with root package name */
    private Long f50985c;

    /* renamed from: d, reason: collision with root package name */
    private Long f50986d;

    /* renamed from: e, reason: collision with root package name */
    private final long f50987e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f50988f;

    public e(d dVar, long j6) {
        this(dVar, j6, null, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            e eVar = (e) obj;
            if (this.f50987e == eVar.f50987e && this.f50983a.equals(eVar.f50983a)) {
                return true;
            }
        }
        return false;
    }

    public e(d dVar, long j6, List<String> list) {
        this(dVar, j6, list, true);
    }

    public void a(String str) {
        if (this.f50984b == null) {
            this.f50984b = new ArrayList();
        }
        this.f50984b.add(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ntp.e.b():void");
    }

    public InetAddress c() {
        DatagramPacket s5 = this.f50983a.s();
        if (s5 == null) {
            return null;
        }
        return s5.getAddress();
    }

    public List<String> d() {
        return this.f50984b;
    }

    public Long e() {
        return this.f50985c;
    }

    public d f() {
        return this.f50983a;
    }

    public Long g() {
        return this.f50986d;
    }

    public long h() {
        return this.f50987e;
    }

    public int hashCode() {
        return (((int) this.f50987e) * 31) + this.f50983a.hashCode();
    }

    public e(d dVar, long j6, boolean z5) {
        this(dVar, j6, null, z5);
    }

    public e(d dVar, long j6, List<String> list, boolean z5) {
        if (dVar != null) {
            this.f50987e = j6;
            this.f50983a = dVar;
            this.f50984b = list;
            if (z5) {
                b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("message cannot be null");
    }
}

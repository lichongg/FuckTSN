package com.clj.fastble.scan;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import e1.h;
import e1.i;
import e1.j;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private BleScanState f32137a = BleScanState.STATE_IDLE;

    /* renamed from: b, reason: collision with root package name */
    private com.clj.fastble.scan.a f32138b = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends com.clj.fastble.scan.a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.clj.fastble.scan.c$a$a, reason: collision with other inner class name */
        class RunnableC0513a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f32140a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f32141b;

            RunnableC0513a(List list, h hVar) {
                this.f32140a = list;
                this.f32141b = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.clj.fastble.a.v().c((BleDevice) this.f32140a.get(0), this.f32141b);
            }
        }

        a() {
        }

        @Override // com.clj.fastble.scan.a
        public void j(BleDevice bleDevice) {
            if (c.this.f32138b.g()) {
                h hVar = (h) c.this.f32138b.e();
                if (hVar != null) {
                    hVar.g(bleDevice);
                    return;
                }
                return;
            }
            i iVar = (i) c.this.f32138b.e();
            if (iVar != null) {
                iVar.c(bleDevice);
            }
        }

        @Override // com.clj.fastble.scan.a
        public void k(List<BleDevice> list) {
            if (!c.this.f32138b.g()) {
                i iVar = (i) c.this.f32138b.e();
                if (iVar != null) {
                    iVar.d(list);
                    return;
                }
                return;
            }
            h hVar = (h) c.this.f32138b.e();
            if (list == null || list.size() < 1) {
                if (hVar != null) {
                    hVar.h(null);
                }
            } else {
                if (hVar != null) {
                    hVar.h(list.get(0));
                }
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0513a(list, hVar), 100L);
            }
        }

        @Override // com.clj.fastble.scan.a
        public void l(boolean z5) {
            j e6 = c.this.f32138b.e();
            if (e6 != null) {
                e6.a(z5);
            }
        }

        @Override // com.clj.fastble.scan.a
        public void m(BleDevice bleDevice) {
            j e6 = c.this.f32138b.e();
            if (e6 != null) {
                e6.b(bleDevice);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f32143a = new c();

        private b() {
        }
    }

    public void d(UUID[] uuidArr, String[] strArr, String str, boolean z5, long j6, i iVar) {
        f(uuidArr, strArr, str, z5, false, j6, iVar);
    }

    public void e(UUID[] uuidArr, String[] strArr, String str, boolean z5, long j6, h hVar) {
        f(uuidArr, strArr, str, z5, true, j6, hVar);
    }

    public synchronized void g() {
        com.clj.fastble.a.v().o().stopLeScan(this.f32138b);
        this.f32137a = BleScanState.STATE_IDLE;
        this.f32138b.i();
    }

    private synchronized void f(UUID[] uuidArr, String[] strArr, String str, boolean z5, boolean z6, long j6, j jVar) {
        BleScanState bleScanState = this.f32137a;
        BleScanState bleScanState2 = BleScanState.STATE_IDLE;
        if (bleScanState != bleScanState2) {
            com.clj.fastble.utils.a.d("scan action already exists, complete the previous scan action first");
            if (jVar != null) {
                jVar.a(false);
            }
        } else {
            this.f32138b.n(strArr, str, z5, z6, j6, jVar);
            boolean startLeScan = com.clj.fastble.a.v().o().startLeScan(uuidArr, this.f32138b);
            if (startLeScan) {
                bleScanState2 = BleScanState.STATE_SCANNING;
            }
            this.f32137a = bleScanState2;
            this.f32138b.h(startLeScan);
        }
    }

    public BleScanState c() {
        return this.f32137a;
    }

    public static c b() {
        return b.f32143a;
    }
}

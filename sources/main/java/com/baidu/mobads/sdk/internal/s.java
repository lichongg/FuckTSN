package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static volatile s f11096a;

    /* renamed from: b, reason: collision with root package name */
    private List<aa.a> f11097b = new CopyOnWriteArrayList();

    public static s a() {
        if (f11096a == null) {
            synchronized (s.class) {
                try {
                    if (f11096a == null) {
                        f11096a = new s();
                    }
                } finally {
                }
            }
        }
        return f11096a;
    }

    private void b(aa.a aVar) {
        if (this.f11097b.contains(aVar)) {
            this.f11097b.remove(aVar);
        }
    }

    private s() {
    }

    public void a(aa.a aVar) {
        if (aVar == null || this.f11097b.contains(aVar)) {
            return;
        }
        this.f11097b.add(aVar);
    }

    public void a(int i6) {
        for (aa.a aVar : this.f11097b) {
            if (i6 == 1) {
                aVar.onSuccess();
            } else if (i6 == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}

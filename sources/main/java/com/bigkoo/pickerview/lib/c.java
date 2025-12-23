package com.bigkoo.pickerview.lib;

import android.os.Handler;
import android.os.Message;
import com.bigkoo.pickerview.lib.WheelView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class c extends Handler {

    /* renamed from: b, reason: collision with root package name */
    public static final int f14420b = 1000;

    /* renamed from: c, reason: collision with root package name */
    public static final int f14421c = 2000;

    /* renamed from: d, reason: collision with root package name */
    public static final int f14422d = 3000;

    /* renamed from: a, reason: collision with root package name */
    final WheelView f14423a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i6 = message.what;
        if (i6 == 1000) {
            this.f14423a.invalidate();
        } else if (i6 == 2000) {
            this.f14423a.o(WheelView.ACTION.FLING);
        } else {
            if (i6 != 3000) {
                return;
            }
            this.f14423a.k();
        }
    }

    c(WheelView wheelView) {
        this.f14423a = wheelView;
    }
}

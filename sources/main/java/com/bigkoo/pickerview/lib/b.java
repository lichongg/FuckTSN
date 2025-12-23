package com.bigkoo.pickerview.lib;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    final WheelView f14419a;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        this.f14419a.n(f7);
        return true;
    }

    b(WheelView wheelView) {
        this.f14419a = wheelView;
    }
}

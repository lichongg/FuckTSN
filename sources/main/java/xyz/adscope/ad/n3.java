package xyz.adscope.ad;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface n3 extends m2<m3> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a implements l2 {
        CLICK_INTERACTIVE_TRIGGER(0, "click_interactive_trigger"),
        GESTURE_INTERACTIVE_TRIGGER(1, "gesture_interactive_trigger"),
        SHAKE_INTERACTIVE_TRIGGER(2, "shake_interactive_trigger"),
        EULER_INTERACTIVE_TRIGGER(3, "euler_interactive_trigger"),
        OPTIMIZE_INTERACTIVE_TRIGGER(0, "optimize_interactive_trigger");


        /* renamed from: a, reason: collision with root package name */
        private final int f55722a;

        /* renamed from: b, reason: collision with root package name */
        private final String f55723b;

        @Override // xyz.adscope.ad.l2
        public int getEventCode() {
            return this.f55722a;
        }

        a(int i6, String str) {
            this.f55722a = i6;
            this.f55723b = str;
        }
    }

    void a(View view, a aVar);
}

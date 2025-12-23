package xyz.adscope.ad;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface a3 extends m2<y2> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a implements l2 {
        AD_EXPOSURE(501, "ad exposure"),
        ADN_RECOGNIZE(64, "adn recognize"),
        AD_VIEW_SHOWN(67, "ad view shown"),
        AD_VIEW_PAUSE(68, "ad view pause");


        /* renamed from: a, reason: collision with root package name */
        private final int f54789a;

        /* renamed from: b, reason: collision with root package name */
        private final String f54790b;

        @Override // xyz.adscope.ad.l2
        public int getEventCode() {
            return this.f54789a;
        }

        a(int i6, String str) {
            this.f54789a = i6;
            this.f54790b = str;
        }
    }

    void a(View view);

    void a(l2 l2Var, View view);

    void b(View view);

    void b(l2 l2Var, View view);
}

package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface g {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements g {
        private long WG;

        public final boolean K(long j6) {
            return this.WG > 0 && System.currentTimeMillis() - j6 >= this.WG;
        }

        public final String toString() {
            return "DurationMoreThanItem{mDuration=" + this.WG + '}';
        }

        public a(long j6) {
            this.WG = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements g {
        private Lifecycle.Event Wz;

        public final boolean b(Lifecycle.Event event) {
            return this.Wz.equals(event);
        }

        public final String toString() {
            return "PageEventItem{mEvent=" + this.Wz + '}';
        }

        public b(Lifecycle.Event event) {
            this.Wz = event;
        }
    }
}

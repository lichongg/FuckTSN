package com.umeng.socialize.shareboard.widgets;

import android.view.VelocityTracker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class VelocityTrackerCompat {
    private static final VelocityTrackerVersionImpl IMPL = new HoneycombVelocityTrackerVersionImpl(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        private BaseVelocityTrackerVersionImpl() {
        }

        /* synthetic */ BaseVelocityTrackerVersionImpl(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i6) {
            return velocityTracker.getXVelocity();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        private HoneycombVelocityTrackerVersionImpl() {
        }

        /* synthetic */ HoneycombVelocityTrackerVersionImpl(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.socialize.shareboard.widgets.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker velocityTracker, int i6) {
            return velocityTracker.getXVelocity(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i6);
    }

    static float getXVelocity(VelocityTracker velocityTracker, int i6) {
        return IMPL.getXVelocity(velocityTracker, i6);
    }

    VelocityTrackerCompat() {
    }
}

package com.umeng.socialize.shareboard.widgets;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class ViewCompat {
    private static final long FAKE_FRAME_TIME = 10;
    private static final ViewCompatImpl IMPL;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.socialize.shareboard.widgets.ViewCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Api24ViewCompatImpl extends MarshmallowViewCompatImpl {
        private Api24ViewCompatImpl() {
            super(null);
        }

        /* synthetic */ Api24ViewCompatImpl(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class BaseViewCompatImpl implements ViewCompatImpl {
        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i6) {
            return false;
        }

        long getFrameTime() {
            return 10L;
        }

        BaseViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            view.invalidate();
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postDelayed(runnable, getFrameTime());
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        private JbMr1ViewCompatImpl() {
        }

        /* synthetic */ JbMr1ViewCompatImpl(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        private JbMr2ViewCompatImpl() {
            super(null);
        }

        /* synthetic */ JbMr2ViewCompatImpl(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        private KitKatViewCompatImpl() {
            super(null);
        }

        /* synthetic */ KitKatViewCompatImpl(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @TargetApi(20)
    private static class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        private LollipopViewCompatImpl() {
            super(null);
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.wrap(dispatchApplyWindowInsets(view, WindowInsetsCompat.unwrap(windowInsetsCompat)));
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.wrap(onApplyWindowInsets(view, WindowInsetsCompat.unwrap(windowInsetsCompat)));
        }

        /* synthetic */ LollipopViewCompatImpl(AnonymousClass1 anonymousClass1) {
            this();
        }

        private static Object dispatchApplyWindowInsets(View view, Object obj) {
            WindowInsets windowInsets = (WindowInsets) obj;
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            return dispatchApplyWindowInsets != windowInsets ? new WindowInsets(dispatchApplyWindowInsets) : obj;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                final OnApplyWindowInsetsListenerBridge onApplyWindowInsetsListenerBridge = new OnApplyWindowInsetsListenerBridge() { // from class: com.umeng.socialize.shareboard.widgets.ViewCompat.LollipopViewCompatImpl.1
                    @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.OnApplyWindowInsetsListenerBridge
                    public Object onApplyWindowInsets(View view2, Object obj) {
                        return WindowInsetsCompat.unwrap(onApplyWindowInsetsListener.onApplyWindowInsets(view2, WindowInsetsCompat.wrap(obj)));
                    }
                };
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.umeng.socialize.shareboard.widgets.ViewCompat.LollipopViewCompatImpl.2
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return (WindowInsets) onApplyWindowInsetsListenerBridge.onApplyWindowInsets(view2, windowInsets);
                    }
                });
            }
        }

        private static Object onApplyWindowInsets(View view, Object obj) {
            WindowInsets windowInsets = (WindowInsets) obj;
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            return onApplyWindowInsets != windowInsets ? new WindowInsets(onApplyWindowInsets) : obj;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class MarshmallowViewCompatImpl extends LollipopViewCompatImpl {
        private MarshmallowViewCompatImpl() {
            super(null);
        }

        /* synthetic */ MarshmallowViewCompatImpl(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface OnApplyWindowInsetsListenerBridge {
        Object onApplyWindowInsets(View view, Object obj);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface ViewCompatImpl {
        boolean canScrollHorizontally(View view, int i6);

        WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        void postInvalidateOnAnimation(View view);

        void postOnAnimation(View view, Runnable runnable);

        void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @TargetApi(11)
    static class HCViewCompatImpl extends BaseViewCompatImpl {
        HCViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl
        long getFrameTime() {
            return ValueAnimator.getFrameDelay();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ICSMr1ViewCompatImpl extends ICSViewCompatImpl {
        ICSMr1ViewCompatImpl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @TargetApi(14)
    static class ICSViewCompatImpl extends HCViewCompatImpl {
        ICSViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i6) {
            return view.canScrollHorizontally(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @TargetApi(16)
    static class JBViewCompatImpl extends ICSMr1ViewCompatImpl {
        JBViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        AnonymousClass1 anonymousClass1 = null;
        if (i6 >= 24) {
            IMPL = new Api24ViewCompatImpl(anonymousClass1);
        } else if (i6 >= 23) {
            IMPL = new MarshmallowViewCompatImpl(anonymousClass1);
        } else {
            IMPL = new LollipopViewCompatImpl(anonymousClass1);
        }
    }

    static boolean canScrollHorizontally(View view, int i6) {
        return IMPL.canScrollHorizontally(view, i6);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }

    static void postInvalidateOnAnimation(View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    static void postOnAnimation(View view, Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    ViewCompat() {
    }
}

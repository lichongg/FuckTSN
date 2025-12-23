package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class VideoAdapters {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d {
        float abb;
        float height;
        float width;

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.abb;
        }

        public final float getWidth() {
            return this.width;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.abb + '}';
        }

        public d(float f6, float f7) {
            this.abb = -1.0f;
            this.width = f6;
            this.height = f7;
            if (f6 > 0.0f && f7 > 0.0f) {
                this.abb = f7 / f6;
            }
        }

        public final float ua() {
            if (!isValid()) {
                return -1.0f;
            }
            return Math.max(this.width, this.height);
        }

        public final float ub() {
            if (!isValid()) {
                return -1.0f;
            }
            return Math.min(this.width, this.height);
        }

        public final float uc() {
            if (!isValid()) {
                return -1.0f;
            }
            float f6 = this.height;
            float f7 = this.width;
            if (f6 > f7) {
                return f6 / f7;
            }
            return f7 / f6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.video.VideoAdapters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aaV;

        static {
            int[] iArr = new int[AdaptType.values().length];
            aaV = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aaV[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aaV[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aaV[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean b(View view, View view2, int i6, int i7) {
            if (view == null || i6 == 0 || i7 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(final View view, View view2, int i6, int i7) {
            if (!b(view, view2, i6, i7)) {
                com.kwad.sdk.core.d.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i6, i7);
            boolean z5 = dVar2.getRatio() >= 1.0f;
            boolean z6 = dVar.getRatio() >= 1.0f;
            AdaptType adaptType = (z6 && z5) ? AdaptType.PORTRAIT_VERTICAL : z6 ? AdaptType.PORTRAIT_HORIZONTAL : z5 ? AdaptType.LANDSCAPE_VERTICAL : AdaptType.LANDSCAPE_HORIZONTAL;
            final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            if (C(view)) {
                view.post(new Runnable() { // from class: com.kwad.components.core.video.VideoAdapters.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setLayoutParams(layoutParams);
                    }
                });
            } else {
                view.setLayoutParams(layoutParams);
            }
        }

        protected abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);

        private static boolean C(View view) {
            if (!view.isInLayout() && !view.isLayoutRequested()) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends a {
        private float aaY = 0.8f;
        private float aaZ = 0.9375f;
        private float aba = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float ub;
            float f6;
            float uc = dVar.uc();
            float uc2 = dVar2.uc();
            float ub2 = dVar.ub();
            float ua = dVar.ua();
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + ua + ", " + ub2);
            int i6 = AnonymousClass1.aaV[adaptType.ordinal()];
            if (i6 != 1 && i6 != 2) {
                if (i6 != 3 && i6 != 4) {
                    ub = -2.1474836E9f;
                    f6 = -2.1474836E9f;
                } else {
                    f6 = ub2 * this.aba;
                    ub = f6 / uc2;
                }
            } else if (uc > uc2) {
                float ua2 = dVar.ua();
                float f7 = ua2 / uc2;
                float f8 = ub2 / f7;
                float f9 = this.aaY;
                if (f8 >= f9) {
                    f6 = ua2;
                    ub = f7;
                } else {
                    ub = ub2 / f9;
                    f6 = ub * uc2;
                }
            } else {
                ub = dVar.ub();
                f6 = uc2 * ub;
                float f10 = ua / f6;
                float f11 = this.aaZ;
                if (f10 < f11) {
                    f6 = ua / f11;
                    ub = f6 / uc2;
                }
            }
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo result: " + f6 + ", " + ub);
            if (f6 != -2.1474836E9f && ub != -2.1474836E9f) {
                if (dVar2.getHeight() >= dVar2.getWidth()) {
                    layoutParams.width = (int) ub;
                    layoutParams.height = (int) f6;
                } else {
                    layoutParams.height = (int) ub;
                    layoutParams.width = (int) f6;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float ua;
            float ub;
            float uc = dVar.uc();
            float uc2 = dVar2.uc();
            int i6 = AnonymousClass1.aaV[adaptType.ordinal()];
            if (i6 != 1 && i6 != 2) {
                if (i6 != 3 && i6 != 4) {
                    ua = 0.0f;
                    ub = -2.1474836E9f;
                } else {
                    ua = dVar.ub();
                    ub = ua / uc2;
                }
            } else if (uc >= uc2) {
                ub = dVar.ub();
                ua = ub * uc2;
            } else {
                ua = dVar.ua();
                ub = ua / uc2;
            }
            if (ub != -2.1474836E9f && ua != -2.1474836E9f) {
                if (dVar2.getHeight() > dVar2.getWidth()) {
                    layoutParams.width = (int) ub;
                    layoutParams.height = (int) ua;
                } else {
                    layoutParams.height = (int) ub;
                    layoutParams.width = (int) ua;
                }
            }
        }
    }
}

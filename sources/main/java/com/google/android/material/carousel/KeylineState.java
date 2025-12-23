package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.material.carousel.KeylineState$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;

        private static float calculateKeylineLocationForItemPosition(float f6, float f7, int i6, int i7) {
            return (f6 - (i6 * f7)) + (i7 * f7);
        }

        @NonNull
        @CanIgnoreReturnValue
        Builder addKeyline(float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, float f8) {
            return addKeyline(f6, f7, f8, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        Builder addKeylineRange(float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, float f8, int i6) {
            return addKeylineRange(f6, f7, f8, i6, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        Builder addKeyline(float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, float f8, boolean z5) {
            if (f8 <= 0.0f) {
                return this;
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f6, f7, f8);
            if (z5) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f8 != this.tmpFirstFocalKeyline.maskedItemSize) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.tmpLastFocalKeyline = keyline;
                this.lastFocalKeylineIndex = this.tmpKeylines.size();
            } else {
                if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        Builder addKeylineRange(float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, float f8, int i6, boolean z5) {
            if (i6 > 0 && f8 > 0.0f) {
                for (int i7 = 0; i7 < i6; i7++) {
                    addKeyline((i7 * f8) + f6, f7, f8, z5);
                }
            }
            return this;
        }

        @NonNull
        KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < this.tmpKeylines.size(); i6++) {
                Keyline keyline = this.tmpKeylines.get(i6);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i6), keyline.locOffset, keyline.mask, keyline.maskedItemSize));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex, null);
        }

        Builder(float f6) {
            this.itemSize = f6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Keyline {
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;

        static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f6), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f6), AnimationUtils.lerp(keyline.mask, keyline2.mask, f6), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f6));
        }

        Keyline(float f6, float f7, float f8, float f9) {
            this.loc = f6;
            this.locOffset = f7;
            this.mask = f8;
            this.maskedItemSize = f9;
        }
    }

    /* synthetic */ KeylineState(float f6, List list, int i6, int i7, AnonymousClass1 anonymousClass1) {
        this(f6, list, i6, i7);
    }

    private KeylineState(float f6, List<Keyline> list, int i6, int i7) {
        this.itemSize = f6;
        this.keylines = Collections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i6;
        this.lastFocalKeylineIndex = i7;
    }

    static KeylineState reverse(KeylineState keylineState) {
        Builder builder = new Builder(keylineState.getItemSize());
        float f6 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f6, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex());
            f6 += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    float getItemSize() {
        return this.itemSize;
    }

    List<Keyline> getKeylines() {
        return this.keylines;
    }

    Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    Keyline getLastKeyline() {
        return this.keylines.get(r0.size() - 1);
    }

    static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f6) {
        if (keylineState.getItemSize() == keylineState2.getItemSize()) {
            List<Keyline> keylines = keylineState.getKeylines();
            List<Keyline> keylines2 = keylineState2.getKeylines();
            if (keylines.size() == keylines2.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < keylineState.getKeylines().size(); i6++) {
                    arrayList.add(Keyline.lerp(keylines.get(i6), keylines2.get(i6), f6));
                }
                return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f6), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f6));
            }
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }
}

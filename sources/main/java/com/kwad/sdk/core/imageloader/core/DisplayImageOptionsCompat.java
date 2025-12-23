package com.kwad.sdk.core.imageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class DisplayImageOptionsCompat {
    private final int blurRadius;
    private final boolean cacheInMemory;
    private final boolean cacheOnDisk;
    private final boolean considerExifParams;
    private final int cornerRound;
    private final BitmapFactory.Options decodingOptions;
    private final int delayBeforeLoading;
    private final Drawable imageForEmptyUri;
    private final Drawable imageOnFail;
    private final Drawable imageOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final boolean isCircle;
    private final boolean isFrameSequence;
    private final boolean isSyncLoading;
    private final boolean resetViewBeforeLoading;
    private final int strokeColor;
    private final float strokeWidth;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private int blurRadius;
        private int cornerRound;
        private boolean isCircle;
        private boolean isFrameSequence;
        private int strokeColor;
        private float strokeWidth;
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private Drawable imageOnLoading = null;
        private Drawable imageForEmptyUri = null;
        private Drawable imageOnFail = null;
        private boolean resetViewBeforeLoading = false;
        private boolean cacheInMemory = false;
        private boolean cacheOnDisk = false;
        private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        private int delayBeforeLoading = 0;
        private boolean considerExifParams = false;
        private boolean isSyncLoading = false;

        @Deprecated
        public Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        @Deprecated
        public Builder cacheOnDisc() {
            return cacheOnDisk(true);
        }

        public Builder setStrokeWidth(float f6) {
            if (f6 > 0.0f) {
                this.strokeWidth = f6;
                this.isCircle = true;
            }
            return this;
        }

        public Builder showImageForEmptyUri(int i6) {
            this.imageResForEmptyUri = i6;
            return this;
        }

        public Builder showImageOnFail(int i6) {
            this.imageResOnFail = i6;
            return this;
        }

        public Builder showImageOnLoading(int i6) {
            this.imageResOnLoading = i6;
            return this;
        }

        public Builder bitmapConfig(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.decodingOptions.inPreferredConfig = config;
            return this;
        }

        public DisplayImageOptionsCompat build() {
            return new DisplayImageOptionsCompat(this, null);
        }

        public Builder cacheInMemory(boolean z5) {
            this.cacheInMemory = z5;
            return this;
        }

        @Deprecated
        public Builder cacheOnDisc(boolean z5) {
            return cacheOnDisk(z5);
        }

        public Builder cacheOnDisk(boolean z5) {
            this.cacheOnDisk = z5;
            return this;
        }

        public Builder considerExifParams(boolean z5) {
            this.considerExifParams = z5;
            return this;
        }

        public Builder setBlurRadius(int i6) {
            this.blurRadius = i6;
            return this;
        }

        public Builder setCircle(boolean z5) {
            this.isCircle = z5;
            return this;
        }

        public Builder setCornerRound(int i6) {
            this.cornerRound = i6;
            return this;
        }

        public Builder setFrameSequence(boolean z5) {
            this.isFrameSequence = z5;
            return this;
        }

        public Builder setStrokeColor(int i6) {
            this.strokeColor = i6;
            return this;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        public Builder showImageOnFail(Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }

        @Deprecated
        public Builder showStubImage(int i6) {
            this.imageResOnLoading = i6;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptionsCompat displayImageOptionsCompat) {
            this.imageResOnLoading = displayImageOptionsCompat.imageResOnLoading;
            this.imageResForEmptyUri = displayImageOptionsCompat.imageResForEmptyUri;
            this.imageResOnFail = displayImageOptionsCompat.imageResOnFail;
            this.imageOnLoading = displayImageOptionsCompat.imageOnLoading;
            this.imageForEmptyUri = displayImageOptionsCompat.imageForEmptyUri;
            this.imageOnFail = displayImageOptionsCompat.imageOnFail;
            this.resetViewBeforeLoading = displayImageOptionsCompat.resetViewBeforeLoading;
            this.cacheInMemory = displayImageOptionsCompat.cacheInMemory;
            this.cacheOnDisk = displayImageOptionsCompat.cacheOnDisk;
            this.decodingOptions = displayImageOptionsCompat.decodingOptions;
            this.delayBeforeLoading = displayImageOptionsCompat.delayBeforeLoading;
            this.considerExifParams = displayImageOptionsCompat.considerExifParams;
            this.isSyncLoading = displayImageOptionsCompat.isSyncLoading;
            this.blurRadius = displayImageOptionsCompat.blurRadius;
            this.isFrameSequence = displayImageOptionsCompat.isFrameSequence;
            this.cornerRound = displayImageOptionsCompat.cornerRound;
            this.isCircle = displayImageOptionsCompat.isCircle;
            this.strokeColor = displayImageOptionsCompat.strokeColor;
            this.strokeWidth = displayImageOptionsCompat.strokeWidth;
            return this;
        }
    }

    /* synthetic */ DisplayImageOptionsCompat(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private DisplayImageOptionsCompat(Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisk = builder.cacheOnDisk;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.isSyncLoading = builder.isSyncLoading;
        this.blurRadius = builder.blurRadius;
        this.isFrameSequence = builder.isFrameSequence;
        this.cornerRound = builder.cornerRound;
        this.isCircle = builder.isCircle;
        this.strokeColor = builder.strokeColor;
        this.strokeWidth = builder.strokeWidth;
    }

    public static DisplayImageOptionsCompat createSimple() {
        return new Builder().build();
    }

    public final int getBlurRadius() {
        return this.blurRadius;
    }

    public final int getCornerRound() {
        return this.cornerRound;
    }

    public final BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public final int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public final Drawable getImageForEmptyUri(Resources resources) {
        int i6 = this.imageResForEmptyUri;
        return i6 != 0 ? resources.getDrawable(i6) : this.imageForEmptyUri;
    }

    public final Drawable getImageOnFail(Resources resources) {
        int i6 = this.imageResOnFail;
        return i6 != 0 ? resources.getDrawable(i6) : this.imageOnFail;
    }

    public final Drawable getImageOnLoading(Resources resources) {
        int i6 = this.imageResOnLoading;
        return i6 != 0 ? resources.getDrawable(i6) : this.imageOnLoading;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public final boolean isCacheOnDisk() {
        return this.cacheOnDisk;
    }

    public final boolean isCircle() {
        return this.isCircle;
    }

    public final boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public final boolean isFrameSequence() {
        return this.isFrameSequence;
    }

    public final boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    public final boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    public final boolean shouldShowImageForEmptyUri() {
        return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
    }

    public final boolean shouldShowImageOnFail() {
        return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
    }

    public final boolean shouldShowImageOnLoading() {
        return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
    }
}

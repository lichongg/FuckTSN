package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class VideoOption {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f36577a;

    /* renamed from: b, reason: collision with root package name */
    private final int f36578b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f36579c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f36580d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f36581e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f36582f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f36583g;

    /* renamed from: h, reason: collision with root package name */
    private final int f36584h;

    /* renamed from: i, reason: collision with root package name */
    private final int f36585i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.qq.e.ads.cfg.VideoOption$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f36586a = true;

        /* renamed from: b, reason: collision with root package name */
        private int f36587b = 1;

        /* renamed from: c, reason: collision with root package name */
        private boolean f36588c = true;

        /* renamed from: d, reason: collision with root package name */
        private boolean f36589d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f36590e = true;

        /* renamed from: f, reason: collision with root package name */
        private boolean f36591f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f36592g = false;

        /* renamed from: h, reason: collision with root package name */
        private int f36593h;

        /* renamed from: i, reason: collision with root package name */
        private int f36594i;

        public VideoOption build() {
            return new VideoOption(this, null);
        }

        public Builder setAutoPlayMuted(boolean z5) {
            this.f36586a = z5;
            return this;
        }

        public Builder setAutoPlayPolicy(int i6) {
            if (i6 < 0 || i6 > 2) {
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
                i6 = 1;
            }
            this.f36587b = i6;
            return this;
        }

        @Deprecated
        public Builder setDetailPageMuted(boolean z5) {
            this.f36592g = z5;
            return this;
        }

        @Deprecated
        public Builder setEnableDetailPage(boolean z5) {
            this.f36590e = z5;
            return this;
        }

        public Builder setEnableUserControl(boolean z5) {
            this.f36591f = z5;
            return this;
        }

        public Builder setMaxVideoDuration(int i6) {
            this.f36593h = i6;
            return this;
        }

        public Builder setMinVideoDuration(int i6) {
            this.f36594i = i6;
            return this;
        }

        public Builder setNeedCoverImage(boolean z5) {
            this.f36589d = z5;
            return this;
        }

        public Builder setNeedProgressBar(boolean z5) {
            this.f36588c = z5;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.f36577a = builder.f36586a;
        this.f36578b = builder.f36587b;
        this.f36579c = builder.f36588c;
        this.f36580d = builder.f36589d;
        this.f36581e = builder.f36590e;
        this.f36582f = builder.f36591f;
        this.f36583g = builder.f36592g;
        this.f36584h = builder.f36593h;
        this.f36585i = builder.f36594i;
    }

    /* synthetic */ VideoOption(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f36577a;
    }

    public int getAutoPlayPolicy() {
        return this.f36578b;
    }

    public int getMaxVideoDuration() {
        return this.f36584h;
    }

    public int getMinVideoDuration() {
        return this.f36585i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f36577a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f36578b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f36583g));
            return jSONObject;
        } catch (Exception e6) {
            e6.getMessage();
            return jSONObject;
        }
    }

    @Deprecated
    public boolean isDetailPageMuted() {
        return this.f36583g;
    }

    @Deprecated
    public boolean isEnableDetailPage() {
        return this.f36581e;
    }

    public boolean isEnableUserControl() {
        return this.f36582f;
    }

    public boolean isNeedCoverImage() {
        return this.f36580d;
    }

    public boolean isNeedProgressBar() {
        return this.f36579c;
    }
}

package com.huawei.hms.ml.scan;

import com.huawei.hms.scankit.p.w7;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HmsScanAnalyzerOptions {
    public final boolean errorCheck;
    public final int mode;
    public final boolean parseResult;
    public final boolean photoMode;
    public final boolean showGuide;
    public final int viewType;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.ml.scan.HmsScanAnalyzerOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Creator {
        private int type = 0;
        private boolean photoMode = false;
        private int viewType = 0;
        private boolean errorCheck = false;
        private boolean parseResult = true;
        private boolean showGuide = false;

        public HmsScanAnalyzerOptions create() {
            return new HmsScanAnalyzerOptions(this.type, this.photoMode, this.viewType, this.errorCheck, this.parseResult, this.showGuide, null);
        }

        public Creator setErrorCheck(boolean z5) {
            this.errorCheck = z5;
            return this;
        }

        public Creator setParseResult(boolean z5) {
            this.parseResult = z5;
            return this;
        }

        public Creator setPhotoMode(boolean z5) {
            this.photoMode = z5;
            return this;
        }

        public Creator setShowGuide(boolean z5) {
            this.showGuide = z5;
            return this;
        }

        public Creator setViewType(int i6) {
            this.viewType = i6;
            return this;
        }

        public Creator setHmsScanTypes(int i6, int... iArr) {
            int a6 = w7.a(i6);
            this.type = a6;
            if (iArr != null && iArr.length > 0) {
                this.type = w7.b(a6);
                for (int i7 : iArr) {
                    this.type = w7.b(i7) | this.type;
                }
            }
            return this;
        }
    }

    /* synthetic */ HmsScanAnalyzerOptions(int i6, boolean z5, int i7, boolean z6, boolean z7, boolean z8, AnonymousClass1 anonymousClass1) {
        this(i6, z5, i7, z6, z7, z8);
    }

    private HmsScanAnalyzerOptions(int i6, boolean z5, int i7, boolean z6, boolean z7, boolean z8) {
        this.mode = i6;
        this.photoMode = z5;
        this.viewType = i7;
        this.errorCheck = z6;
        this.parseResult = z7;
        this.showGuide = z8;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

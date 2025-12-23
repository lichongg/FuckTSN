package com.huawei.hms.ml.scan;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HmsScanFrameOptions {
    private boolean multiMode;
    private boolean parseResult;
    private boolean photoMode;
    private int type;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.ml.scan.HmsScanFrameOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Creator {
        private int type = 0;
        private boolean multiMode = false;
        private boolean photoMode = false;
        private boolean parseResult = true;

        public HmsScanFrameOptions create() {
            return new HmsScanFrameOptions(this.type, this.photoMode, this.multiMode, this.parseResult, null);
        }

        public Creator setHmsScanTypes(int i6, int... iArr) {
            this.type = i6;
            if (iArr != null && iArr.length > 0) {
                for (int i7 : iArr) {
                    this.type = i7 | this.type;
                }
            }
            return this;
        }

        public Creator setMultiMode(boolean z5) {
            this.multiMode = z5;
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
    }

    /* synthetic */ HmsScanFrameOptions(int i6, boolean z5, boolean z6, boolean z7, AnonymousClass1 anonymousClass1) {
        this(i6, z5, z6, z7);
    }

    private HmsScanFrameOptions(int i6, boolean z5, boolean z6, boolean z7) {
        this.type = i6;
        this.photoMode = z5;
        this.multiMode = z6;
        this.parseResult = z7;
    }

    public int getType() {
        return this.type;
    }

    public boolean isMultiMode() {
        return this.multiMode;
    }

    public boolean isParseResult() {
        return this.parseResult;
    }

    public boolean isPhotoMode() {
        return this.photoMode;
    }
}

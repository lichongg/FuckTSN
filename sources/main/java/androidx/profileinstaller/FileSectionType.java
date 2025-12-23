package androidx.profileinstaller;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    public long getValue() {
        return this.mValue;
    }

    FileSectionType(long j6) {
        this.mValue = j6;
    }

    static FileSectionType fromValue(long j6) {
        FileSectionType[] values = values();
        for (int i6 = 0; i6 < values.length; i6++) {
            if (values[i6].getValue() == j6) {
                return values[i6];
            }
        }
        throw new IllegalArgumentException("Unsupported FileSection Type " + j6);
    }
}

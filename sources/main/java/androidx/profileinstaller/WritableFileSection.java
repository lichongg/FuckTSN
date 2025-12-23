package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    WritableFileSection(@NonNull FileSectionType fileSectionType, int i6, @NonNull byte[] bArr, boolean z5) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i6;
        this.mContents = bArr;
        this.mNeedsCompression = z5;
    }
}

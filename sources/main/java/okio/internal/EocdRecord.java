package okio.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final class EocdRecord {
    private final long centralDirectoryOffset;
    private final int commentByteCount;
    private final long entryCount;

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    public final int getCommentByteCount() {
        return this.commentByteCount;
    }

    public final long getEntryCount() {
        return this.entryCount;
    }

    public EocdRecord(long j6, long j7, int i6) {
        this.entryCount = j6;
        this.centralDirectoryOffset = j7;
        this.commentByteCount = i6;
    }
}

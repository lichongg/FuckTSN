package net.sqlcipher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class CustomCursorWindowAllocation implements CursorWindowAllocation {
    private long growthPaddingSize;
    private long initialAllocationSize;
    private long maxAllocationSize;

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.growthPaddingSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.maxAllocationSize;
    }

    public CustomCursorWindowAllocation(long j6, long j7, long j8) {
        this.initialAllocationSize = j6;
        this.growthPaddingSize = j7;
        this.maxAllocationSize = j8;
    }
}

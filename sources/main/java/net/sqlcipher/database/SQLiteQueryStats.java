package net.sqlcipher.database;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SQLiteQueryStats {
    long largestIndividualRowSize;
    long totalQueryResultSize;

    public long getLargestIndividualRowSize() {
        return this.largestIndividualRowSize;
    }

    public long getTotalQueryResultSize() {
        return this.totalQueryResultSize;
    }

    public SQLiteQueryStats(long j6, long j7) {
        this.totalQueryResultSize = j6;
        this.largestIndividualRowSize = j7;
    }
}

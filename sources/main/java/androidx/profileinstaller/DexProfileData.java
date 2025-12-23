package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class DexProfileData {

    @NonNull
    final String apkName;
    int classSetSize;

    @NonNull
    int[] classes;
    final long dexChecksum;

    @NonNull
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;

    @NonNull
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    DexProfileData(@NonNull String str, @NonNull String str2, long j6, long j7, int i6, int i7, int i8, @NonNull int[] iArr, @NonNull TreeMap<Integer, Integer> treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j6;
        this.mTypeIdCount = j7;
        this.classSetSize = i6;
        this.hotMethodRegionSize = i7;
        this.numMethodIds = i8;
        this.classes = iArr;
        this.methods = treeMap;
    }
}

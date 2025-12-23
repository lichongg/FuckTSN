package com.umeng.commonsdk.utils;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface FileLockCallback {
    boolean onFileLock(File file, int i6);

    boolean onFileLock(String str);

    boolean onFileLock(String str, Object obj);
}

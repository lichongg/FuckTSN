package com.bytedance.sdk.component.panglearmor.j.xt;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw {
    public static xt j(RandomAccessFile randomAccessFile, long j6, long j7) {
        return j(randomAccessFile.getChannel(), j6, j7);
    }

    public static xt j(FileChannel fileChannel, long j6, long j7) {
        fileChannel.getClass();
        return new r(fileChannel, j6, j7);
    }
}

package com.kwad.framework.filedownloader.exception;

import com.kwad.framework.filedownloader.f.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class PathConflictException extends IllegalAccessException {
    private final int mAnotherSamePathTaskId;
    private final String mDownloadingConflictPath;
    private final String mTargetFilePath;

    public int getAnotherSamePathTaskId() {
        return this.mAnotherSamePathTaskId;
    }

    public String getDownloadingConflictPath() {
        return this.mDownloadingConflictPath;
    }

    public String getTargetFilePath() {
        return this.mTargetFilePath;
    }

    public PathConflictException(int i6, String str, String str2) {
        super(f.c("There is an another running task(%d) with the same downloading path(%s), because of they are with the same target-file-path(%s), so if the current task is started, the path of the file is sure to be written by multiple tasks, it is wrong, then you receive this exception to avoid such conflict.", Integer.valueOf(i6), str, str2));
        this.mAnotherSamePathTaskId = i6;
        this.mDownloadingConflictPath = str;
        this.mTargetFilePath = str2;
    }
}

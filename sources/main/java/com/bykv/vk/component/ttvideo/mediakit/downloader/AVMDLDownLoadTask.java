package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLThreadPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLDownLoadTask {
    public static final int IsHttpOpen = 0;
    public static final int IsHttpRead = 1;
    public static final int IsInValidStep = -1;
    public static final int IsReponseHeader = 0;
    public static final int IsResponseComplete = 3;
    public static final int IsResponseData = 1;
    public static final int IsResponseError = 2;
    private static final String TAG = "AVMDLDownLoadTask";
    private File file;
    FileOutputStream fos;
    private Future mFuture;
    private AVMDLRequest mRequest;
    private AVMDLResponse mResponse;
    private long mHandle = 0;
    private boolean mIsRunning = false;
    private int mStep = -1;
    private Lock mHandleLock = new ReentrantLock();
    private Lock mResonseLock = new ReentrantLock();

    private static native void _notifyLoadInfo(long j6, int i6, long j7, long j8, String str);

    private static native int _onRecvData(long j6, byte[] bArr, int i6);

    @SuppressLint({"CI_DefaultLocale"})
    private void cancelResponse() {
        try {
            this.mResonseLock.lock();
            if (this.mResponse != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mResponse.cancel();
                String.format("end cancel cost time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        } finally {
            this.mResonseLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public AVMDLResponse httOpen(AVMDLRequest aVMDLRequest) {
        int i6;
        AVMDLResponse aVMDLResponse;
        int i7;
        int i8 = aVMDLRequest.mCurlUrlIndex;
        setResponse(null);
        int i9 = i8;
        do {
            String.format("http open index:%d state:%d trycount:%d maxTry:%d", Integer.valueOf(i9), Integer.valueOf(aVMDLRequest.mUrlState[i9]), Integer.valueOf(aVMDLRequest.mUrlErrCount[i9]), Integer.valueOf(aVMDLRequest.mMaxTryCout));
            if (aVMDLRequest.mUrlState[i9] == 0 && ((i6 = aVMDLRequest.mMaxTryCout) <= 0 || aVMDLRequest.mUrlErrCount[i9] < i6)) {
                try {
                    aVMDLResponse = AVMDLHttpExcutor.excute(aVMDLRequest, i9);
                } catch (IOException e6) {
                    e6.getLocalizedMessage();
                    aVMDLResponse = null;
                }
                if (aVMDLResponse != null && aVMDLResponse.isOpenSuccessful()) {
                    setResponse(aVMDLResponse);
                    notifyToNative(0, aVMDLResponse.statusCode, aVMDLResponse.contentlength, null);
                    aVMDLResponse.request = aVMDLRequest;
                    return aVMDLResponse;
                }
                int[] iArr = aVMDLRequest.mUrlErrCount;
                iArr[i9] = iArr[i9] + 1;
                if (aVMDLResponse != null && (i7 = aVMDLResponse.statusCode) >= 400 && i7 < 600) {
                    aVMDLRequest.mUrlState[i9] = 1;
                    String.format("set url state forbidden index:%d", Integer.valueOf(i9));
                }
            }
            i9 = (i9 + 1) % aVMDLRequest.urls.length;
        } while (i9 != i8);
        return null;
    }

    @SuppressLint({"CI_DefaultLocale"})
    private void setHandle(long j6) {
        try {
            this.mHandleLock.lock();
            this.mHandle = j6;
            String.format("set handle:%d", Long.valueOf(j6));
        } finally {
            this.mHandleLock.unlock();
        }
    }

    private void setResponse(AVMDLResponse aVMDLResponse) {
        this.mResonseLock.lock();
        this.mResponse = aVMDLResponse;
        this.mResonseLock.unlock();
    }

    public void close() {
        setHandle(0L);
        this.mIsRunning = false;
        cancelResponse();
    }

    public int open(long j6, Object obj, Object obj2, int i6, int i7, int i8) {
        if (j6 == 0 || obj == null) {
            AVMDLLog.e(TAG, "handle zero err");
            return -1;
        }
        AVMDLRequest aVMDLRequest = (AVMDLRequest) obj;
        String[] strArr = aVMDLRequest.urls;
        if (strArr == null || strArr.length == 0) {
            AVMDLLog.e(TAG, "no url err");
            return -2;
        }
        this.mRequest = aVMDLRequest;
        setHandle(j6);
        this.mStep = 0;
        this.mIsRunning = true;
        this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.downloader.AVMDLDownLoadTask.1
            @Override // java.lang.Runnable
            public void run() {
                AVMDLResponse aVMDLResponse = new AVMDLResponse(AVMDLDownLoadTask.this.mRequest, null, null);
                byte[] bArr = new byte[32768];
                while (AVMDLDownLoadTask.this.mIsRunning) {
                    int i9 = AVMDLDownLoadTask.this.mStep;
                    if (i9 == 0) {
                        aVMDLResponse = AVMDLDownLoadTask.this.httOpen(aVMDLResponse.request);
                        if (aVMDLResponse == null || !aVMDLResponse.isOpenSuccessful()) {
                            AVMDLDownLoadTask.this.notifyToNative(2, -777L, 0L, null);
                            return;
                        }
                        AVMDLDownLoadTask.this.mStep = 1;
                    } else if (i9 != 1) {
                        continue;
                    } else {
                        aVMDLResponse = AVMDLDownLoadTask.this.httpRead(aVMDLResponse, bArr);
                        if (!aVMDLResponse.isReadSuccessful()) {
                            AVMDLDownLoadTask.this.mStep = 0;
                        } else if (aVMDLResponse.isFinish()) {
                            AVMDLDownLoadTask.this.notifyToNative(3, 0L, aVMDLResponse.contentlength, null);
                            return;
                        }
                    }
                }
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public AVMDLResponse httpRead(AVMDLResponse aVMDLResponse, byte[] bArr) {
        int readData = aVMDLResponse.readData(bArr);
        if (readData > 0) {
            try {
                this.mHandleLock.lock();
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _onRecvData(j6, bArr, readData);
                }
                return aVMDLResponse;
            } finally {
                this.mHandleLock.unlock();
            }
        }
        return aVMDLResponse;
    }

    @SuppressLint({"CI_DefaultLocale"})
    public void notifyToNative(int i6, long j6, long j7, String str) {
        String.format("notify type:%d code:%d param:%d ", Integer.valueOf(i6), Long.valueOf(j6), Long.valueOf(j7));
        try {
            this.mHandleLock.lock();
            long j8 = this.mHandle;
            if (j8 != 0) {
                _notifyLoadInfo(j8, i6, j6, j7, str);
            }
            this.mHandleLock.unlock();
        } catch (Throwable th) {
            this.mHandleLock.unlock();
            throw th;
        }
    }
}

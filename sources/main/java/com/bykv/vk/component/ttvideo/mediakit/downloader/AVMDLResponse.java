package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.xt;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public xt call;
    public long readOff;
    public AVMDLRequest request;
    public av response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1L;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    private void parseResponse() {
        int lastIndexOf;
        av avVar = this.response;
        if (avVar == null) {
            return;
        }
        int cw = avVar.cw();
        this.statusCode = cw;
        if (cw == 200) {
            this.contentlength = toInt(this.response.j("Content-Length"));
            return;
        }
        if (cw == 206) {
            String j6 = this.response.j("Content-Range");
            if (TextUtils.isEmpty(j6) || (lastIndexOf = j6.lastIndexOf("/")) < 0 || lastIndexOf >= j6.length() - 1) {
                return;
            }
            this.contentlength = toInt(j6.substring(lastIndexOf + 1), -1);
        }
    }

    public static int toInt(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return i6;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i6;
        }
    }

    public void cancel() {
        xt xtVar = this.call;
        if (xtVar != null) {
            xtVar.xt();
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    public boolean isFinish() {
        AVMDLRequest aVMDLRequest = this.request;
        long j6 = aVMDLRequest.size;
        long j7 = j6 >= 0 ? aVMDLRequest.reqOff + j6 : this.contentlength;
        long j8 = this.contentlength;
        if (j7 > j8) {
            j7 = j8;
        }
        String.format("check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j7));
        return this.readOff >= j7;
    }

    public boolean isOpenSuccessful() {
        int i6 = this.statusCode;
        return i6 >= 200 && i6 < 300;
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    @SuppressLint({"CI_DefaultLocale"})
    public int readData(byte[] bArr) {
        if (this.response.m() == null) {
            return 0;
        }
        try {
            int read = this.response.m().cw().read(bArr);
            if (read <= 0) {
                return -1;
            }
            String.format("before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            long j6 = read;
            this.readOff += j6;
            AVMDLRequest aVMDLRequest = this.request;
            aVMDLRequest.reqOff += j6;
            long j7 = aVMDLRequest.size;
            if (j7 > 0) {
                aVMDLRequest.size = j7 - j6;
            }
            String.format("after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(read), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            return read;
        } catch (IOException e6) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e6.getLocalizedMessage());
            return -1;
        }
    }

    public AVMDLResponse(AVMDLRequest aVMDLRequest, av avVar, xt xtVar) {
        this.request = aVMDLRequest;
        this.response = avVar;
        this.call = xtVar;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }
}

package com.bykv.vk.component.ttvideo.mediakit.net;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLHostProcessor {
    private static final int BACKUP_DNS = 1;
    private static final int MAIN_DNS = 0;
    public static final int STATE_IS_IDLE = 0;
    public static final int STATE_IS_PARSE_END_ERROR = 2;
    public static final int STATE_IS_PARSE_END_SUC = 3;
    public static final int STATE_IS_WAIT_RESULT = 1;
    private static final String TAG = "AVMDLHostProcessor";
    private int mBackUpDelayedTime;
    private int mBackUpType;
    private int mEnableParallel;
    private Handler mHandler;
    public String mHost;
    public HashMap<AVMDLDNSParserListener, Integer> mListeners;
    private int mMainType;
    private int[] mStates = new int[2];
    private BaseDNS[] mParsers = new BaseDNS[2];

    @SuppressLint({"CI_DefaultLocale"})
    private BaseDNS createDNSParser(String str, int i6, int i7) {
        CreateConstructor createConstructor;
        try {
            createConstructor = AVMDLDNSManager.getInstance().getCreateConstructor(i6);
        } catch (Exception e6) {
            vl.j(e6);
            createConstructor = null;
        }
        if (createConstructor != null) {
            return createConstructor.createDns(str, null, i6, this.mHandler);
        }
        if (i6 != 4 || AVMDLDNSParser.mCustomHttpDNSParser == null) {
            String.format("create local dns parser for host:%s type:%d", str, Integer.valueOf(i6));
            return new LocalDNS(str, this.mHandler);
        }
        String.format("create custom httpdns parser for host:%s type:%d", str, Integer.valueOf(i6));
        return new CustomHTTPDNS(str, this.mHandler);
    }

    public boolean isEnd() {
        int i6;
        for (int i7 = 0; i7 < 2; i7++) {
            if (this.mParsers[i7] != null && (i6 = this.mStates[i7]) != 3 && i6 != 2) {
                return false;
            }
        }
        return true;
    }

    public AVMDLHostProcessor(String str, Handler handler, int i6, int i7, int i8, int i9) {
        this.mMainType = i6;
        this.mBackUpType = i7;
        this.mHandler = handler;
        this.mHost = str;
        this.mBackUpDelayedTime = i8;
        this.mEnableParallel = i9;
        for (int i10 = 0; i10 < 2; i10++) {
            this.mParsers[i10] = null;
        }
        for (int i11 = 0; i11 < 2; i11++) {
            this.mStates[i11] = 0;
        }
        this.mListeners = new HashMap<>();
    }

    private void doParseInternal(int i6, AVMDLDNSInfo aVMDLDNSInfo) {
        String.format("----do parse internal what:%d info:%s", Integer.valueOf(i6), aVMDLDNSInfo);
        if (aVMDLDNSInfo == null) {
            return;
        }
        if (i6 == 5 && this.mParsers[0] == null) {
            String.format("create main dns type:%d host:%s", Integer.valueOf(this.mMainType), aVMDLDNSInfo.mHost);
            this.mStates[0] = 1;
            this.mParsers[0] = createDNSParser(aVMDLDNSInfo.mHost, this.mMainType, 0);
            this.mParsers[0].start();
            Message message = new Message();
            message.what = 6;
            message.obj = aVMDLDNSInfo;
            if (this.mBackUpDelayedTime > 0 || this.mEnableParallel > 0) {
                String.format("BackUpDelayedTime:%d enableparallel:%d send backup delay first", Integer.valueOf(this.mMainType), Integer.valueOf(this.mEnableParallel));
                this.mHandler.sendMessageDelayed(message, this.mBackUpDelayedTime * 1000);
            }
        } else if (i6 == 6 && this.mParsers[1] == null) {
            String.format("create backup dns type:%d host:%s", Integer.valueOf(this.mBackUpType), aVMDLDNSInfo.mHost);
            this.mStates[1] = 1;
            this.mParsers[1] = createDNSParser(aVMDLDNSInfo.mHost, this.mBackUpType, 1);
            this.mParsers[1].start();
        }
        String.format("****do parse internal end", new Object[0]);
    }

    public boolean isValidSourceId(String str) {
        if (TextUtils.isEmpty(str)) {
            String.format("id: %s is empty", str);
            return false;
        }
        for (int i6 = 0; i6 < 2; i6++) {
            BaseDNS baseDNS = this.mParsers[i6];
            if (baseDNS != null && str.equals(baseDNS.mId)) {
                String.format("id: %s is valid index: %d", str, Integer.valueOf(i6));
                return true;
            }
        }
        String.format("id: %s is valid", str);
        return false;
    }

    public void processMsg(int i6, AVMDLDNSInfo aVMDLDNSInfo) {
        int[] iArr;
        int i7;
        String.format("----processor pro msg what:%d host:%s info:%s", Integer.valueOf(i6), aVMDLDNSInfo.mHost, aVMDLDNSInfo);
        if (i6 != 5) {
            if (i6 == 6 && (((i7 = (iArr = this.mStates)[0]) == 1 || i7 == 2 || i7 == 3 || this.mEnableParallel > 0) && iArr[1] == 0)) {
                String.format("main dns is not end or enable parrallel and backup dns is idle call backup dns", new Object[0]);
                doParseInternal(i6, aVMDLDNSInfo);
            }
        } else if (this.mStates[0] == 0) {
            String.format("main dns is idle call main dns", new Object[0]);
            doParseInternal(i6, aVMDLDNSInfo);
        }
        String.format("****end processor pro msg what:%d host:%s info:%s", Integer.valueOf(i6), aVMDLDNSInfo.mHost, aVMDLDNSInfo);
    }

    public void processResult(int i6, AVMDLDNSInfo aVMDLDNSInfo) {
        String str;
        String.format("----process result what:%d id:%s host:%s", Integer.valueOf(i6), aVMDLDNSInfo.mId, aVMDLDNSInfo.mHost);
        if (i6 != 2 && i6 != 3) {
            str = null;
        } else {
            str = aVMDLDNSInfo.mId;
        }
        if (TextUtils.isEmpty(str)) {
            String.format("****process result err id is empty", new Object[0]);
            return;
        }
        int i7 = 0;
        while (true) {
            if (i7 >= 2) {
                break;
            }
            BaseDNS baseDNS = this.mParsers[i7];
            if (baseDNS != null && str.equals(baseDNS.mId)) {
                this.mParsers[i7].close();
                this.mParsers[i7] = null;
                if (i6 == 3) {
                    this.mStates[i7] = 3;
                } else if (i6 == 2) {
                    this.mStates[i7] = 2;
                }
                String.format("****process result parser index:%d is end, be close", Integer.valueOf(i7));
            } else {
                i7++;
            }
        }
        if (i7 == 0 && i6 == 2) {
            String.format("mian dns parse error, try back up dns", new Object[0]);
            processMsg(6, new AVMDLDNSInfo(this.mBackUpType, aVMDLDNSInfo.mHost, (String) null, 0L, (String) null));
        }
        String.format("****end process result what:%d id:%s host:%s", Integer.valueOf(i6), aVMDLDNSInfo.mId, aVMDLDNSInfo.mHost);
    }
}

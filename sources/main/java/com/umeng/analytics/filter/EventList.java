package com.umeng.analytics.filter;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class EventList extends c implements FileLockCallback {
    private static final int DELETE_LIST_DATA = 2;
    private static final int LOAD_LIST_DATA = 1;
    private static final int SAVE_LIST_DATA = 0;
    private Context mAppContext;
    protected String mEventList;
    protected String mEventListKey;
    protected String mEventListName;
    protected String mEventListVersionKey;
    private FileLockUtil mFileLock = new FileLockUtil();

    public boolean enabled() {
        synchronized (this) {
            try {
                return this.mEventList != null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean matchHit(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    private void deleteDataFile(File file) {
        if (this.mAppContext != null) {
            synchronized (this.mFileLock) {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void saveEventListToFile(Context context, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.mEventList.getBytes());
            fileOutputStream.close();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        if (com.umeng.analytics.pro.d.at.equals(str) && str2 == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> disable black list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
        if (com.umeng.analytics.pro.d.au.equals(str) && str2 == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> disable white list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
    }

    public void register(Context context) {
        if (this.mAppContext == null) {
            this.mAppContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!TextUtils.isEmpty(UMEnvelopeBuild.imprintProperty(this.mAppContext, this.mEventListVersionKey, ""))) {
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this, 1);
            } else {
                setMD5ClearFlag(true);
            }
        }
        if (UMUtils.isMainProgress(this.mAppContext)) {
            ImprintHandler.getImprintService(this.mAppContext).registPreProcessCallback(this.mEventListKey, this);
            ImprintHandler.getImprintService(this.mAppContext).registImprintCallback(this.mEventListVersionKey, this);
        }
    }

    public String toString() {
        if (TextUtils.isEmpty(this.mEventListName) || TextUtils.isEmpty(this.mEventListKey)) {
            return "Uninitialized EventList.";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append("EventListName:" + this.mEventListName + ",");
        sb.append("listKey:" + this.mEventListKey + ",");
        if (TextUtils.isEmpty(this.mEventList)) {
            sb.append("listKeyValue:empty,");
        } else {
            sb.append("listKeyValue:" + this.mEventList + "]");
        }
        if (TextUtils.isEmpty(this.mEventListVersionKey)) {
            sb.append("listKeyVer:empty]");
        } else {
            sb.append("listKeyVer:" + this.mEventListVersionKey + "]");
        }
        return sb.toString();
    }

    public EventList(String str, String str2) {
        this.mEventListName = str;
        this.mEventListKey = str;
        this.mEventListVersionKey = str2;
    }

    private boolean loadEventListFromFile(Context context, File file) {
        Throwable th;
        BufferedReader bufferedReader;
        if (file.exists() && TextUtils.isEmpty(this.mEventList)) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    String md5 = HelperUtils.getMD5(sb2);
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(context, this.mEventListVersionKey, "");
                    this.mEventList = sb2;
                    eventListChange();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> loadEventListFromFile: mEventList = " + this.mEventList);
                    if (UMUtils.isMainProgress(context)) {
                        if (md5.equalsIgnoreCase(imprintProperty)) {
                            this.mEventList = sb2;
                            setMD5ClearFlag(false);
                            try {
                                bufferedReader.close();
                                return true;
                            } catch (Throwable th3) {
                                UMCrashManager.reportCrash(context, th3);
                                return true;
                            }
                        }
                        setMD5ClearFlag(true);
                        try {
                            bufferedReader.close();
                            return false;
                        } catch (Throwable th4) {
                            UMCrashManager.reportCrash(context, th4);
                            return false;
                        }
                    }
                    if (md5.equalsIgnoreCase(imprintProperty)) {
                        this.mEventList = sb2;
                        eventListChange();
                        bufferedReader.close();
                        return true;
                    }
                    bufferedReader.close();
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
                try {
                    UMCrashManager.reportCrash(context, th);
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th6) {
                            UMCrashManager.reportCrash(context, th6);
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i6) {
        if (i6 == 0) {
            synchronized (this) {
                saveEventListToFile(this.mAppContext, file);
            }
        } else if (i6 == 1) {
            synchronized (this) {
                try {
                    if (loadEventListFromFile(this.mAppContext, file)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> find event list data file, load it.");
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> can't find event list file.");
                    }
                } finally {
                }
            }
        } else if (i6 == 2) {
            synchronized (this) {
                this.mEventList = null;
                deleteDataFile(file);
            }
        }
        return true;
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
    public boolean onPreProcessImprintKey(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onPreProcessImprintKey: key = " + str + "; len of value=" + str2.length());
            StringBuilder sb = new StringBuilder();
            sb.append("--->>> onPreProcessImprintKey: value = ");
            sb.append(str2);
            UMRTLog.i(UMRTLog.RTLOG_TAG, sb.toString());
            this.mEventList = str2;
            eventListChange();
            File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
            if (!file.exists()) {
                try {
                    try {
                        file.createNewFile();
                    } catch (IOException unused) {
                        file.createNewFile();
                    }
                } catch (IOException e6) {
                    UMCrashManager.reportCrash(this.mAppContext, e6);
                }
            }
            this.mFileLock.doFileOperateion(file, this, 0);
            setMD5ClearFlag(false);
            return true;
        }
        return true;
    }

    protected void eventListChange() {
    }

    public void setMD5ClearFlag(boolean z5) {
    }
}

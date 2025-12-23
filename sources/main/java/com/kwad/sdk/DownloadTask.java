package com.kwad.sdk;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadTask implements Serializable {
    private static final long serialVersionUID = -7092669850073266500L;
    public int downloadType;
    private int mAllowedNetworkTypes;
    protected transient com.kwad.framework.filedownloader.a mBaseDownloadTask;
    private String mDestinationDir;
    private String mDestinationFileName;
    private int mNotificationVisibility;
    private Map<String, String> mRequestHeaders;
    private Serializable mTag;
    private String mUrl;
    private boolean mUserPause;
    private boolean mWakeInstallApk;
    private transient List<a> mDownloadListeners = new ArrayList();
    private boolean mIsCanceled = false;
    public boolean downloadEnablePause = false;
    private boolean notificationRemoved = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DownloadRequest implements Serializable {
        private static final long serialVersionUID = -3638290207248829674L;
        private int mAllowedNetworkTypes;
        private String mDestinationFileName;
        private String mDownloadUrl;
        private Serializable mTag;
        private final Map<String, String> mRequestHeaders = new HashMap();
        private boolean mInstallAfterDownload = true;

        @Deprecated
        private boolean mIsPhotoAdDownloadRequest = false;
        private int mNotificationVisibility = 0;
        public boolean downloadEnablePause = false;
        private String mDestinationDir = c.AA().AB().getPath();

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }

        public int getAllowedNetworkTypes() {
            return this.mAllowedNetworkTypes;
        }

        public String getDestinationDir() {
            return this.mDestinationDir;
        }

        public String getDestinationFileName() {
            return this.mDestinationFileName;
        }

        public String getDownloadUrl() {
            return this.mDownloadUrl;
        }

        public Serializable getTag() {
            return this.mTag;
        }

        public boolean isDownloadEnablePause() {
            return this.downloadEnablePause;
        }

        public boolean isPhotoAdDownloadRequest() {
            return this.mIsPhotoAdDownloadRequest;
        }

        public DownloadRequest setAllowedNetworkTypes(int i6) {
            this.mAllowedNetworkTypes = i6;
            return this;
        }

        public DownloadRequest setDestinationDir(String str) {
            this.mDestinationDir = str;
            return this;
        }

        public DownloadRequest setDestinationFileName(String str) {
            this.mDestinationFileName = str;
            return this;
        }

        public void setDownloadEnablePause(boolean z5) {
            this.downloadEnablePause = z5;
        }

        public DownloadRequest setInstallAfterDownload(boolean z5) {
            this.mInstallAfterDownload = z5;
            return this;
        }

        public DownloadRequest setNotificationVisibility(int i6) {
            this.mNotificationVisibility = i6;
            return this;
        }

        public DownloadRequest setTag(Serializable serializable) {
            this.mTag = serializable;
            return this;
        }

        public DownloadRequest(String str) {
            this.mAllowedNetworkTypes = 3;
            this.mDownloadUrl = str;
            NetworkInfo de = ao.de(c.AA().getContext());
            if (de != null && de.getType() == 0) {
                this.mAllowedNetworkTypes = 3;
            } else {
                this.mAllowedNetworkTypes = 2;
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            ax.hh(str);
            if (!str.contains(":")) {
                if (str2 == null) {
                    str2 = "";
                }
                this.mRequestHeaders.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("header may not contain ':'");
        }
    }

    private void onCanceled(com.kwad.framework.filedownloader.a aVar) {
        try {
            this.mIsCanceled = true;
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().d(this);
            }
            aVar.cancel();
            notifyDownloadCanceled();
            r.xI().q(getId(), this.mBaseDownloadTask.getTargetFilePath());
            releaseDownloadTask();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002e, code lost:
    
        r5 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onConnected(com.kwad.framework.filedownloader.a r2, java.lang.String r3, boolean r4, int r5, int r6) {
        /*
            r1 = this;
            long r3 = (long) r6
            java.io.File r5 = new java.io.File     // Catch: java.lang.Exception -> L15
            java.lang.String r6 = r1.mDestinationDir     // Catch: java.lang.Exception -> L15
            r5.<init>(r6)     // Catch: java.lang.Exception -> L15
            boolean r5 = r5.exists()     // Catch: java.lang.Exception -> L15
            if (r5 == 0) goto L17
            java.lang.String r5 = r1.mDestinationDir     // Catch: java.lang.Exception -> L15
            long r5 = com.kwad.sdk.crash.utils.h.getAvailableBytes(r5)     // Catch: java.lang.Exception -> L15
            goto L2e
        L15:
            r5 = move-exception
            goto L2a
        L17:
            boolean r5 = com.kwad.sdk.utils.bc.useStoragePermissionDisable()     // Catch: java.lang.Exception -> L15
            if (r5 != 0) goto L2d
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L15
            java.lang.String r5 = r5.getPath()     // Catch: java.lang.Exception -> L15
            long r5 = com.kwad.sdk.crash.utils.h.getAvailableBytes(r5)     // Catch: java.lang.Exception -> L15
            goto L2e
        L2a:
            r5.printStackTrace()
        L2d:
            r5 = r3
        L2e:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            com.kwad.sdk.c r3 = com.kwad.sdk.c.AA()
            int r4 = r2.getId()
            r3.cancel(r4)
            r1.notifyDownloadCanceled()
            r1.onLowStorage(r2)
            return
        L44:
            java.util.List<com.kwad.sdk.a> r3 = r1.mDownloadListeners     // Catch: java.lang.Exception -> L54
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Exception -> L54
        L4a:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Exception -> L54
            if (r4 == 0) goto L56
            r3.next()     // Catch: java.lang.Exception -> L54
            goto L4a
        L54:
            r2 = move-exception
            goto L5b
        L56:
            r3 = 0
            r1.notifyDownloadProgress(r2, r3)     // Catch: java.lang.Exception -> L54
            return
        L5b:
            r2.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.DownloadTask.onConnected(com.kwad.framework.filedownloader.a, java.lang.String, boolean, int, int):void");
    }

    void userPause() {
        this.mUserPause = true;
        pause();
    }

    private void initDownloadTaskParams() {
        this.mBaseDownloadTask.f(this.mTag);
        this.mBaseDownloadTask.bf((this.mAllowedNetworkTypes ^ 2) == 0);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.bl(entry.getKey());
            this.mBaseDownloadTask.u(entry.getKey(), entry.getValue());
        }
    }

    private void notifyDownloadCompleted(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.3
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.k(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadError(com.kwad.framework.filedownloader.a aVar) {
        if ((this.mNotificationVisibility & 1) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.5
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.j(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadPending() {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.i(DownloadTask.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlockCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            notifyDownloadCompleted(aVar);
            if (this.mWakeInstallApk) {
                installApk();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloading(com.kwad.framework.filedownloader.a aVar, int i6, int i7) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, i6, i7);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.kwad.framework.filedownloader.a aVar, Throwable th) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().a(this, th);
            }
            notifyDownloadError(aVar);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void onLowStorage(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().f(this);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause(com.kwad.framework.filedownloader.a aVar, int i6, int i7) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().c(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPending(com.kwad.framework.filedownloader.a aVar, int i6, int i7) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadPending();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void onResume(com.kwad.framework.filedownloader.a aVar, int i6, int i7) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().e(this);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStarted(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWarn(com.kwad.framework.filedownloader.a aVar) {
        try {
            Iterator<a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void releaseDownloadTask() {
        this.mBaseDownloadTask.a(null);
        clearListener();
    }

    public void addListener(a aVar) {
        if (aVar == null || this.mDownloadListeners.contains(aVar)) {
            return;
        }
        this.mDownloadListeners.add(aVar);
    }

    void cancel() {
        try {
            onCanceled(this.mBaseDownloadTask);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void clearListener() {
        this.mDownloadListeners.clear();
    }

    int downLoadProgress() {
        long smallFileTotalBytes = this.mBaseDownloadTask.getSmallFileTotalBytes();
        int smallFileSoFarBytes = smallFileTotalBytes != 0 ? (int) ((this.mBaseDownloadTask.getSmallFileSoFarBytes() * 100.0f) / smallFileTotalBytes) : 0;
        if (smallFileSoFarBytes != 100 || w.P(new File(this.mBaseDownloadTask.getTargetFilePath()))) {
            return smallFileSoFarBytes;
        }
        return 0;
    }

    public int getAllowedNetworkTypes() {
        return this.mAllowedNetworkTypes;
    }

    public String getDestinationDir() {
        return this.mDestinationDir;
    }

    public String getFilename() {
        return this.mBaseDownloadTask.getFilename();
    }

    public int getId() {
        return this.mBaseDownloadTask.getId();
    }

    public int getNotificationVisibility() {
        return this.mNotificationVisibility;
    }

    public String getPath() {
        return this.mBaseDownloadTask.getPath();
    }

    public int getSmallFileSoFarBytes() {
        return this.mBaseDownloadTask.getSmallFileSoFarBytes();
    }

    public int getSmallFileTotalBytes() {
        return this.mBaseDownloadTask.getSmallFileTotalBytes();
    }

    public int getSpeed() {
        return this.mBaseDownloadTask.getSpeed();
    }

    public int getStatus() {
        return this.mBaseDownloadTask.wJ();
    }

    public long getStatusUpdateTime() {
        return this.mBaseDownloadTask.getStatusUpdateTime();
    }

    public Object getTag() {
        return this.mBaseDownloadTask.getTag();
    }

    public String getTargetFilePath() {
        return this.mBaseDownloadTask.getTargetFilePath();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public boolean isCompleted() {
        return this.mBaseDownloadTask.wJ() == -3;
    }

    public boolean isError() {
        return this.mBaseDownloadTask.wJ() == -1;
    }

    public boolean isErrorBecauseWifiRequired() {
        return this.mBaseDownloadTask.wQ() && isError() && (this.mBaseDownloadTask.wL() instanceof FileDownloadNetworkPolicyException);
    }

    public boolean isInvalid() {
        return this.mBaseDownloadTask.wJ() == 0;
    }

    public boolean isNotificationRemoved() {
        return this.notificationRemoved;
    }

    public boolean isPaused() {
        return this.mBaseDownloadTask.wJ() == -2;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.isRunning();
    }

    boolean isUserPause() {
        return this.mUserPause;
    }

    void pause() {
        this.mBaseDownloadTask.pause();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    public void removeListener(a aVar) {
        if (aVar != null) {
            this.mDownloadListeners.remove(aVar);
        }
    }

    public void setAllowedNetworkTypes(int i6) {
        this.mAllowedNetworkTypes = i6;
        this.mBaseDownloadTask.bf((i6 ^ 2) == 0);
    }

    public void setNotificationRemoved(boolean z5) {
        this.notificationRemoved = z5;
    }

    public void submit() {
        try {
            if (this.mBaseDownloadTask.isRunning()) {
                return;
            }
            this.mBaseDownloadTask.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    com.kwad.framework.filedownloader.a unwrap() {
        return this.mBaseDownloadTask;
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
    }

    private void initDownloadRequestParams(DownloadRequest downloadRequest) {
        this.mWakeInstallApk = downloadRequest.mInstallAfterDownload;
        this.mUrl = downloadRequest.mDownloadUrl;
        this.mAllowedNetworkTypes = downloadRequest.mAllowedNetworkTypes;
        this.mNotificationVisibility = downloadRequest.mNotificationVisibility;
        this.mDestinationDir = downloadRequest.mDestinationDir;
        this.mDestinationFileName = downloadRequest.mDestinationFileName;
        this.mRequestHeaders = downloadRequest.mRequestHeaders;
        this.mTag = downloadRequest.mTag;
        this.downloadEnablePause = downloadRequest.isDownloadEnablePause();
    }

    private void notify(DownloadTask downloadTask, com.kwad.sdk.g.a<d> aVar) {
        d AC = c.AA().AC();
        if (AC == null) {
            return;
        }
        if (downloadTask.isCanceled()) {
            AC.co(downloadTask.getId());
        } else {
            aVar.accept(AC);
        }
    }

    private void notifyDownloadCanceled() {
        d AC = c.AA().AC();
        if (AC == null) {
            return;
        }
        AC.co(getId());
    }

    private void notifyDownloadProgress(com.kwad.framework.filedownloader.a aVar, final boolean z5) {
        if ((aVar.getSmallFileTotalBytes() != 0 || aVar.getSmallFileSoFarBytes() != 0) && !TextUtils.isEmpty(aVar.getFilename()) && (this.mNotificationVisibility & 1) != 0) {
            notify(this, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.DownloadTask.4
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(d dVar) {
                    dVar.a(DownloadTask.this, z5);
                }
            });
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.mDownloadListeners = new ArrayList();
    }

    void installApk() {
        try {
            c.AA().g(this);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    void instantiateDownloadTask() {
        String path;
        r.xI();
        com.kwad.framework.filedownloader.a bq = r.bm(this.mUrl).bd(true).bq(3);
        if (TextUtils.isEmpty(this.mDestinationFileName)) {
            path = this.mDestinationDir;
        } else {
            path = new File(this.mDestinationDir, this.mDestinationFileName).getPath();
        }
        this.mBaseDownloadTask = bq.c(path, TextUtils.isEmpty(this.mDestinationFileName)).a(new com.kwad.framework.filedownloader.i() { // from class: com.kwad.sdk.DownloadTask.1
            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, String str, boolean z5, int i6, int i7) {
                DownloadTask.this.onConnected(aVar, str, z5, i6, i7);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar, int i6, int i7) {
                DownloadTask.this.onDownloading(aVar, i6, i7);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onStarted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onBlockCompleted(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar, int i6, int i7) {
                DownloadTask.this.onPause(aVar, i6, i7);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void d(com.kwad.framework.filedownloader.a aVar) {
                DownloadTask.this.onWarn(aVar);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, int i6, int i7) {
                DownloadTask.this.onPending(aVar, i6, i7);
            }

            @Override // com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                DownloadTask.this.onError(aVar, th);
            }
        });
    }

    void resume(DownloadRequest downloadRequest) {
        if (!ao.isNetworkConnected(c.AA().getContext())) {
            return;
        }
        if (downloadRequest != null) {
            initDownloadRequestParams(downloadRequest);
            initDownloadTaskParams();
        }
        this.mUserPause = false;
        if (!this.mBaseDownloadTask.isRunning()) {
            try {
                if (com.kwad.framework.filedownloader.d.d.bY(this.mBaseDownloadTask.wJ())) {
                    this.mBaseDownloadTask.wB();
                }
                submit();
                com.kwad.framework.filedownloader.a aVar = this.mBaseDownloadTask;
                onResume(aVar, aVar.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
                return;
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        com.kwad.framework.filedownloader.a aVar2 = this.mBaseDownloadTask;
        onResume(aVar2, aVar2.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
    }
}

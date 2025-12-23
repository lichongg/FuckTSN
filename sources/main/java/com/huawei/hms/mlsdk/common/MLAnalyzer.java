package com.huawei.hms.mlsdk.common;

import android.util.SparseArray;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorEvent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class MLAnalyzer<T> {
    private List<AnalyzerMonitor> monitors = new ArrayList();
    private final Object syncAnalyzer = new Object();
    private MLTransactor<T> transactor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface MLTransactor<T> {
        void destroy();

        void transactResult(Result<T> result);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Result<T> {
        private SparseArray<T> analyseList;
        private MLFrame.Property frameProperty;
        private boolean isAnalyzerAvailable;

        public SparseArray<T> getAnalyseList() {
            return this.analyseList;
        }

        public MLFrame.Property getFrameProperty() {
            return this.frameProperty;
        }

        public boolean isAnalyzerAvaliable() {
            return this.isAnalyzerAvailable;
        }

        public Result(SparseArray<T> sparseArray, MLFrame.Property property, boolean z5) {
            this.analyseList = sparseArray;
            this.frameProperty = property;
            this.isAnalyzerAvailable = z5;
        }
    }

    public abstract SparseArray<T> analyseFrame(MLFrame mLFrame);

    public boolean isAvailable() {
        return true;
    }

    public boolean traceItem(int i6) {
        return true;
    }

    public void destroy() {
        synchronized (this.syncAnalyzer) {
            try {
                MLTransactor<T> mLTransactor = this.transactor;
                if (mLTransactor != null) {
                    mLTransactor.destroy();
                    this.transactor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected MLFrame.Property.Ext getFramePropertyExt(MLFrame mLFrame) {
        if (mLFrame == null || mLFrame.acquireProperty() == null) {
            return null;
        }
        return mLFrame.acquireProperty().getExt();
    }

    public boolean hasMonitorRegistered() {
        return !this.monitors.isEmpty();
    }

    public void obtainPicture(MLFrame mLFrame) {
        synchronized (this.syncAnalyzer) {
            try {
                if (this.transactor == null) {
                    throw new IllegalStateException("Transactor must be specified first to receive detection results.");
                }
                MLFrame.Property property = new MLFrame.Property(mLFrame.acquireProperty());
                property.resetWidthAndHeight();
                this.transactor.transactResult(new Result<>(analyseFrame(mLFrame), property, isAvailable()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void postMonitorEvent(MonitorEvent monitorEvent) {
        for (AnalyzerMonitor analyzerMonitor : this.monitors) {
            if (analyzerMonitor != null) {
                analyzerMonitor.receive(monitorEvent);
            }
        }
    }

    public void registerMonitor(AnalyzerMonitor analyzerMonitor) {
        this.monitors.add(analyzerMonitor);
    }

    public void setTransactor(MLTransactor<T> mLTransactor) {
        synchronized (this.syncAnalyzer) {
            this.transactor = mLTransactor;
        }
    }

    public void unregisterMonitor(AnalyzerMonitor analyzerMonitor) {
        this.monitors.remove(analyzerMonitor);
    }
}

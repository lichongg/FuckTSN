package com.huawei.hms.ml.scan;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.agconnect.d;
import com.huawei.hmf.tasks.k;
import com.huawei.hmf.tasks.n;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.mlsdk.common.MLAnalyzer;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.o4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HmsScanAnalyzer extends MLAnalyzer<HmsScan> {
    private static final String TAG = "HmsScanAnalyzer";
    private Context mContext;
    private HmsScanAnalyzerOptions mlVisionScanDetectorOptions;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Creator {
        private Context mContext;
        private HmsScanAnalyzerOptions mOptions;

        public Creator(Context context) {
            this.mContext = context;
        }

        public Creator setHmsScanTypes(int i6, int... iArr) {
            this.mOptions = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(i6, iArr).create();
            return this;
        }

        public HmsScanAnalyzer create() {
            Context context = this.mContext;
            HmsScanAnalyzerOptions hmsScanAnalyzerOptions = this.mOptions;
            if (hmsScanAnalyzerOptions == null) {
                hmsScanAnalyzerOptions = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(0, new int[0]).create();
            }
            return new HmsScanAnalyzer(context, hmsScanAnalyzerOptions);
        }

        public Creator setHmsScanTypes(HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
            if (hmsScanAnalyzerOptions == null) {
                this.mOptions = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(0, new int[0]).create();
                return this;
            }
            this.mOptions = hmsScanAnalyzerOptions;
            return this;
        }

        public Creator() {
            this.mContext = d.b().getContext();
        }
    }

    public HmsScanAnalyzer(HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        this.mContext = d.b().getContext();
        this.mlVisionScanDetectorOptions = hmsScanAnalyzerOptions;
    }

    @Override // com.huawei.hms.mlsdk.common.MLAnalyzer
    public SparseArray<HmsScan> analyseFrame(MLFrame mLFrame) {
        o4.b("scankit mul", "start analyseFrame");
        if (mLFrame == null) {
            return new SparseArray<>();
        }
        HmsScan[] detectForHmsDector = ScanUtil.detectForHmsDector(this.mContext, mLFrame, this.mlVisionScanDetectorOptions);
        o4.b("scankit mul", "analyseFrame end");
        SparseArray<HmsScan> sparseArray = new SparseArray<>();
        for (HmsScan hmsScan : detectForHmsDector) {
            if (hmsScan != null && !TextUtils.isEmpty(hmsScan.originalValue)) {
                sparseArray.append(hmsScan.originalValue.hashCode(), hmsScan);
            }
        }
        return sparseArray;
    }

    public k<List<HmsScan>> analyzInAsyn(final MLFrame mLFrame) {
        return n.e(new Callable<List<HmsScan>>() { // from class: com.huawei.hms.ml.scan.HmsScanAnalyzer.1
            @Override // java.util.concurrent.Callable
            public List<HmsScan> call() throws Exception {
                if (mLFrame == null) {
                    return null;
                }
                HmsScan[] detectForHmsDector = ScanUtil.detectForHmsDector(HmsScanAnalyzer.this.mContext, mLFrame, HmsScanAnalyzer.this.mlVisionScanDetectorOptions);
                ArrayList arrayList = new ArrayList();
                for (HmsScan hmsScan : detectForHmsDector) {
                    if (hmsScan != null && !TextUtils.isEmpty(hmsScan.originalValue)) {
                        arrayList.add(hmsScan);
                    }
                }
                return arrayList;
            }
        });
    }

    @Override // com.huawei.hms.mlsdk.common.MLAnalyzer
    public boolean isAvailable() {
        return ScanUtil.isScanAvailable(this.mContext);
    }

    public void destory() throws IOException {
        super.destroy();
    }

    public HmsScanAnalyzer() {
        if (d.b() != null) {
            this.mContext = d.b().getContext();
        } else {
            o4.e(TAG, "AGConnectInstanceImpl contect is null");
        }
    }

    private HmsScanAnalyzer(Context context, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        this.mContext = context;
        this.mlVisionScanDetectorOptions = hmsScanAnalyzerOptions;
    }
}

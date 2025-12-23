package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceDriverMonitorInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceDriverMonitor {
    private BDFaceInstance bdFaceInstance;

    public FaceDriverMonitor(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    public native BDFaceDriverMonitorInfo nativeDriverMonitor(long j6, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo);

    public native int nativeDriverMonitorInit(long j6, byte[] bArr);

    public native int nativeUnInitDriverMonitor(long j6);

    public BDFaceDriverMonitorInfo driverMonitor(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo) {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0 || bDFaceImageInstance == null || faceInfo == null) {
            return null;
        }
        return nativeDriverMonitor(index, bDFaceImageInstance, faceInfo);
    }

    public void initDriverMonitor(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceDriverMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDriverMonitor.this.bdFaceInstance.getIndex();
                int i6 = -1;
                if (index == 0) {
                    callback.onResponse(-1, "驾驶行为监测能力加载失败 instanceIndex=0");
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                if (modelContent.length != 0 && (i6 = FaceDriverMonitor.this.nativeDriverMonitorInit(index, modelContent)) != 0) {
                    callback.onResponse(i6, "驾驶行为监测模型加载失败");
                } else if (i6 == 0) {
                    callback.onResponse(0, "驾驶行为监测模型加载成功");
                } else {
                    callback.onResponse(1, "驾驶行为监测模型加载失败");
                }
            }
        });
    }

    public int uninitDriverMonitor() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUnInitDriverMonitor(index);
    }

    public FaceDriverMonitor() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}

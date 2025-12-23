package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceMouthMask {
    private static final String TAG = "FaceMouthMask";
    private BDFaceInstance bdFaceInstance;

    public FaceMouthMask(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float[] nativeCheckMask(long j6, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeInitModel(long j6, byte[] bArr);

    private native int nativeUninitModel(long j6);

    public float[] checkMask(BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr) {
        if (bDFaceImageInstance == null || faceInfoArr == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCheckMask(index, bDFaceImageInstance, faceInfoArr);
    }

    public void initModel(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceMouthMask.1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceMouthMask.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                if (modelContent.length != 0) {
                    i6 = FaceMouthMask.this.nativeInitModel(index, modelContent);
                    if (i6 != 0) {
                        callback.onResponse(i6, "口罩检测模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                if (i6 == 0) {
                    callback.onResponse(0, "口罩检测模型加载成功");
                } else {
                    callback.onResponse(1, "口罩检测模型加载失败");
                }
            }
        });
    }

    public int uninitModel() {
        if (this.bdFaceInstance.getIndex() == 0) {
            return -1;
        }
        return nativeUninitModel(this.bdFaceInstance.getIndex());
    }

    public FaceMouthMask() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}

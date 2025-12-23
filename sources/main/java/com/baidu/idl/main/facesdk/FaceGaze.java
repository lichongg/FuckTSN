package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceGazeInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.utils.FileUitls;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceGaze {
    private static final String TAG = "FaceGaze";
    private BDFaceInstance bdFaceInstance;

    public FaceGaze(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native BDFaceGazeInfo nativeGaze(long j6, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGazeModelInit(long j6, byte[] bArr);

    private native int nativeUninitGazeModel(long j6);

    public BDFaceGazeInfo gaze(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance == null || fArr == null || fArr.length < 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeGaze(index, bDFaceImageInstance, fArr);
    }

    public void initModel(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceGaze.1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceGaze.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return;
                }
                byte[] modelContent = FileUitls.getModelContent(context, str);
                if (modelContent.length != 0) {
                    i6 = FaceGaze.this.nativeGazeModelInit(index, modelContent);
                    if (i6 != 0) {
                        callback.onResponse(i6, "注意力检测模型加载失败");
                        return;
                    }
                } else {
                    i6 = -1;
                }
                if (i6 == 0) {
                    callback.onResponse(0, "注意力检测模型加载成功");
                } else {
                    callback.onResponse(1, "注意力检测模型加载失败");
                }
            }
        });
    }

    public int uninitGazeModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitGazeModel(index);
    }

    public FaceGaze() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}

package com.baidu.idl.main.facesdk;

import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceCropParam;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceIsOutBoundary;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceCrop {
    private static final String TAG = "FaceCrop";
    private BDFaceInstance bdFaceInstance;

    public FaceCrop(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native BDFaceImageInstance nativeCropFaceByBox(long j6, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f6, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByBoxIsOutofBoundary(long j6, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByBoxParam(long j6, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmark(long j6, BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f6, boolean z5, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByLandmarkIsOutofBoundary(long j6, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmarkParam(long j6, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCropImageInit(long j6);

    private native BDFaceImageInstance nativeResizeImage(BDFaceImageInstance bDFaceImageInstance, int i6, BDFaceSDKCommon.BDFaceImageType bDFaceImageType);

    private native int nativeUnInitCropImage(long j6);

    public BDFaceImageInstance cropFaceByBox(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f6, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance == null || faceInfo == null || atomicInteger == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        int[] iArr = new int[1];
        BDFaceImageInstance nativeCropFaceByBox = nativeCropFaceByBox(index, bDFaceImageInstance, faceInfo, f6, iArr);
        atomicInteger.set(iArr[0]);
        return nativeCropFaceByBox;
    }

    public BDFaceIsOutBoundary cropFaceByBoxIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || faceInfo == null || bDFaceCropParam == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByBoxIsOutofBoundary(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByBoxParam(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || faceInfo == null || bDFaceCropParam == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByBoxParam(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByLandmark(BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f6, boolean z5, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance == null || atomicInteger == null || fArr.length < 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        int[] iArr = new int[1];
        BDFaceImageInstance nativeCropFaceByLandmark = nativeCropFaceByLandmark(index, bDFaceImageInstance, fArr, f6, z5, iArr);
        atomicInteger.set(iArr[0]);
        return nativeCropFaceByLandmark;
    }

    public BDFaceIsOutBoundary cropFaceByLandmarkIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByLandmarkIsOutofBoundary(index, bDFaceImageInstance, fArr, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByLandmarkParam(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByLandmarkParam(index, bDFaceImageInstance, fArr, bDFaceCropParam);
    }

    public void initFaceCrop(final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceCrop.1
            @Override // java.lang.Runnable
            public void run() {
                long index = FaceCrop.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    callback.onResponse(-1, "抠图能力加载失败 instanceIndex=0");
                    return;
                }
                int nativeCropImageInit = FaceCrop.this.nativeCropImageInit(index);
                if (nativeCropImageInit == 0) {
                    callback.onResponse(nativeCropImageInit, "抠图能力加载成功");
                    return;
                }
                callback.onResponse(nativeCropImageInit, "抠图能力加载失败: " + nativeCropImageInit);
            }
        });
    }

    public BDFaceImageInstance resizeImage(BDFaceImageInstance bDFaceImageInstance, int i6) {
        if (bDFaceImageInstance == null) {
            return null;
        }
        return nativeResizeImage(bDFaceImageInstance, i6, bDFaceImageInstance.imageType);
    }

    public int uninitFaceCrop() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUnInitCropImage(index);
    }

    public FaceCrop() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}

package com.baidu.idl.main.facesdk.model;

import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDFaceGazeInfo {
    public float leftEyeConf;
    public BDFaceSDKCommon.BDFaceGazeDirection leftEyeGaze;
    public float rightEyeConf;
    public BDFaceSDKCommon.BDFaceGazeDirection rightEyeGaze;

    public BDFaceGazeInfo(int i6, float f6, int i7, float f7) {
        this.leftEyeGaze = BDFaceSDKCommon.BDFaceGazeDirection.values()[i6];
        this.leftEyeConf = f6;
        this.rightEyeGaze = BDFaceSDKCommon.BDFaceGazeDirection.values()[i7];
        this.rightEyeConf = f7;
    }
}

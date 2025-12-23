package com.baidu.idl.face.platform.model;

import android.graphics.Point;
import android.graphics.Rect;
import com.baidu.idl.main.facesdk.FaceInfo;
import com.baidu.idl.main.facesdk.model.BDFaceOcclusion;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceExtInfo {
    private static int nComponents = 9;
    private HashMap<String, Point[]> facePointMap;
    private float mAngle;
    private float mBluriness;
    private float mCenterX;
    private float mCenterY;
    private int mFaceID;
    private float mHeight;
    private int mIllum;
    private float[] mLandmarks;
    private float mLeftEyeClose;
    private BDFaceOcclusion mOcclusion;
    private float mPitch;
    private float mRightEyeClose;
    private float mRoll;
    private float mScore;
    private float mWidth;
    private float mYaw;
    private static int[] comp1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private static int[] comp2 = {13, 14, 15, 16, 17, 18, 19, 20, 13, 21};
    private static int[] comp3 = {22, 23, 24, 25, 26, 27, 28, 29, 22};
    private static int[] comp4 = {30, 31, 32, 33, 34, 35, 36, 37, 30, 38};
    private static int[] comp5 = {39, 40, 41, 42, 43, 44, 45, 46, 39};
    private static int[] comp6 = {47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 47};
    private static int[] comp7 = {51, 57, 52};
    private static int[] comp8 = {58, 59, 60, 61, 62, 63, 64, 65, 58};
    private static int[] comp9 = {58, 66, 67, 68, 62, 69, 70, 71, 58};
    private static int[] nPoints = {13, 10, 9, 10, 9, 11, 3, 9, 9};

    public FaceExtInfo() {
    }

    public Rect getFaceRect() {
        float f6 = this.mCenterX;
        float f7 = this.mWidth;
        return new Rect((int) (f6 - (f7 / 2.0f)), (int) (this.mCenterY - (f7 / 2.0f)), (int) f7, (int) f7);
    }

    public FaceExtInfo(FaceInfo faceInfo) {
        this.mFaceID = faceInfo.faceID;
        this.mCenterX = faceInfo.centerX;
        this.mCenterY = faceInfo.centerY;
        this.mWidth = faceInfo.width;
        this.mHeight = faceInfo.height;
        this.mAngle = faceInfo.angle;
        this.mScore = faceInfo.score;
        this.mLandmarks = faceInfo.landmarks;
        this.mPitch = faceInfo.pitch;
        this.mRoll = faceInfo.roll;
        this.mYaw = faceInfo.yaw;
        this.mBluriness = faceInfo.bluriness;
        this.mIllum = faceInfo.illum;
        BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
        this.mOcclusion = bDFaceOcclusion;
        bDFaceOcclusion.leftEye = bDFaceOcclusion.leftEye;
        bDFaceOcclusion.rightEye = bDFaceOcclusion.rightEye;
        bDFaceOcclusion.nose = bDFaceOcclusion.nose;
        bDFaceOcclusion.mouth = bDFaceOcclusion.mouth;
        bDFaceOcclusion.leftCheek = bDFaceOcclusion.leftCheek;
        bDFaceOcclusion.rightCheek = bDFaceOcclusion.rightCheek;
        bDFaceOcclusion.chin = bDFaceOcclusion.chin;
        this.mLeftEyeClose = faceInfo.leftEyeclose;
        this.mRightEyeClose = faceInfo.rightEyeclose;
    }

    public void addFaceInfo(FaceInfo faceInfo) {
        this.mFaceID = faceInfo.faceID;
        this.mCenterX = faceInfo.centerX;
        this.mCenterY = faceInfo.centerY;
        this.mWidth = faceInfo.width;
        this.mHeight = faceInfo.height;
        this.mAngle = faceInfo.angle;
        this.mScore = faceInfo.score;
        this.mLandmarks = faceInfo.landmarks;
        this.mPitch = faceInfo.pitch;
        this.mRoll = faceInfo.roll;
        this.mYaw = faceInfo.yaw;
        this.mBluriness = faceInfo.bluriness;
        this.mIllum = faceInfo.illum;
        BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
        this.mOcclusion = bDFaceOcclusion;
        bDFaceOcclusion.leftEye = bDFaceOcclusion.leftEye;
        bDFaceOcclusion.rightEye = bDFaceOcclusion.rightEye;
        bDFaceOcclusion.nose = bDFaceOcclusion.nose;
        bDFaceOcclusion.mouth = bDFaceOcclusion.mouth;
        bDFaceOcclusion.leftCheek = bDFaceOcclusion.leftCheek;
        bDFaceOcclusion.rightCheek = bDFaceOcclusion.rightCheek;
        bDFaceOcclusion.chin = bDFaceOcclusion.chin;
        this.mLeftEyeClose = faceInfo.leftEyeclose;
        this.mRightEyeClose = faceInfo.rightEyeclose;
    }

    public float getBluriness() {
        return this.mBluriness;
    }

    public float getConfidence() {
        return this.mScore;
    }

    public int getFaceId() {
        return this.mFaceID;
    }

    public Rect getFaceRect(float f6, float f7, float f8) {
        float f9 = this.mCenterX * f6;
        float f10 = this.mCenterY * f7;
        float f11 = this.mWidth;
        return new Rect((int) (f9 - (((f11 / 2.0f) * f6) * f8)), (int) (f10 - (((f11 / 2.0f) * f7) * f8)), (int) (f9 + ((f11 / 2.0f) * f6 * f8)), (int) (f10 + ((f11 / 2.0f) * f7 * f8)));
    }

    public int getFaceWidth() {
        return (int) this.mWidth;
    }

    public int getIllum() {
        return this.mIllum;
    }

    public int getLandmarksOutOfDetectCount(Rect rect) {
        if (this.mLandmarks.length != 144) {
            return 0;
        }
        int[][] iArr = {comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9};
        int i6 = 0;
        for (int i7 = 0; i7 < nComponents; i7++) {
            int i8 = 0;
            while (i8 < nPoints[i7] - 1) {
                float[] fArr = this.mLandmarks;
                int[] iArr2 = iArr[i7];
                int i9 = iArr2[i8];
                float f6 = fArr[i9 << 1];
                float f7 = fArr[(i9 << 1) + 1];
                i8++;
                int i10 = iArr2[i8];
                float[] fArr2 = {f6, f7, fArr[i10 << 1], fArr[(i10 << 1) + 1]};
                if (!rect.contains((int) (fArr2[0] * 1.0f), (int) (fArr2[1] * 1.0f))) {
                    i6++;
                }
                if (!rect.contains((int) (fArr2[2] * 1.0f), (int) (fArr2[3] * 1.0f))) {
                    i6++;
                }
            }
        }
        return i6;
    }

    public float getLeftEyeClose() {
        return this.mLeftEyeClose;
    }

    public BDFaceOcclusion getOcclusion() {
        return this.mOcclusion;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public void getRectPoints(int[] iArr) {
        int[] iArr2 = iArr;
        double d6 = (this.mAngle * 3.14159d) / 180.0d;
        double cos = Math.cos(d6);
        double sin = Math.sin(d6);
        double d7 = this.mCenterX;
        float f6 = this.mWidth;
        int i6 = (int) ((d7 + ((f6 * cos) / 2.0d)) - ((f6 * sin) / 2.0d));
        int i7 = (int) (this.mCenterY + ((sin * f6) / 2.0d) + ((cos * f6) / 2.0d));
        double d8 = (this.mAngle * 3.14159d) / 180.0d;
        double cos2 = Math.cos(d8) * 0.5d;
        double sin2 = Math.sin(d8) * 0.5d;
        if (iArr2 == null || iArr2.length == 0) {
            iArr2 = new int[8];
        }
        double d9 = i6;
        float f7 = this.mWidth;
        int i8 = (int) ((d9 - (f7 * sin2)) - (f7 * cos2));
        iArr2[0] = i8;
        double d10 = i7;
        int[] iArr3 = iArr2;
        int i9 = (int) (((f7 * cos2) + d10) - (f7 * sin2));
        iArr3[1] = i9;
        int i10 = (int) ((d9 + (f7 * sin2)) - (f7 * cos2));
        iArr3[2] = i10;
        int i11 = (int) ((d10 - (cos2 * f7)) - (sin2 * f7));
        iArr3[3] = i11;
        int i12 = i6 * 2;
        iArr3[4] = i12 - i8;
        int i13 = i7 * 2;
        iArr3[5] = i13 - i9;
        iArr3[6] = i12 - i10;
        iArr3[7] = i13 - i11;
    }

    public float getRightEyeClose() {
        return this.mRightEyeClose;
    }

    public float getRoll() {
        return this.mRoll;
    }

    public float getYaw() {
        return this.mYaw;
    }

    public float[] getmLandmarks() {
        return this.mLandmarks;
    }

    public void setLeftEyeClose(float f6) {
        this.mLeftEyeClose = f6;
    }

    public void setRightEyeClose(float f6) {
        this.mRightEyeClose = f6;
    }

    public boolean isOutofDetectRect(Rect rect) {
        return rect.contains(getFaceRect());
    }
}

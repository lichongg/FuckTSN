package androidx.constraintlayout.motion.widget;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
interface ProxyInterface {
    int designAccess(int i6, String str, Object obj, float[] fArr, int i7, float[] fArr2, int i8);

    float getKeyFramePosition(Object obj, int i6, float f6, float f7);

    Object getKeyframeAtLocation(Object obj, float f6, float f7);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f6, float f7, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i6, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i6, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i6, int i7, float f6, float f7);

    void setToolPosition(float f6);
}

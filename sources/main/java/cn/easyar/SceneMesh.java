package cn.easyar;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeId("C23E6D4A2")
/* loaded from: D:\Downloads\app\classes2.dex */
public class SceneMesh extends RefBase {
    @MethodId("C669D0A23")
    public native float getBlockDimensionInMeters();

    @MethodId("C7EB70090")
    public native ArrayList<e> getBlocksInfoIncremental();

    @MethodId("CCE57B7BF")
    public native Buffer getIndicesAll();

    @MethodId("C5C5A3A2D")
    public native Buffer getIndicesIncremental();

    @MethodId("CD25D6612")
    public native Buffer getNormalsAll();

    @MethodId("CBE8FE899")
    public native Buffer getNormalsIncremental();

    @MethodId("CD19BCB1A")
    public native int getNumOfIndexAll();

    @MethodId("C9DC23414")
    public native int getNumOfIndexIncremental();

    @MethodId("C8BE49803")
    public native int getNumOfVertexAll();

    @MethodId("C353E70AB")
    public native int getNumOfVertexIncremental();

    @MethodId("CA18994F8")
    public native Buffer getVerticesAll();

    @MethodId("CEA32E330")
    public native Buffer getVerticesIncremental();

    protected SceneMesh(long ptr, RefBase dummy) {
        super(ptr, dummy);
    }
}

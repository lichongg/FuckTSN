package com.amap.api.maps.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapPara {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_DEFAULT = -1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);

        private int type;

        public static LineCapType valueOf(int i6) {
            LineCapType[] values = values();
            return values[Math.max(0, Math.min(i6, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }

        LineCapType(int i6) {
            this.type = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int type;

        public static LineJoinType valueOf(int i6) {
            LineJoinType[] values = values();
            return values[Math.max(0, Math.min(i6, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }

        LineJoinType(int i6) {
            this.type = i6;
        }
    }
}

package com.baidu.mobads.sdk.internal.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public int a(Object[] objArr, int i6, int i7) {
        if (objArr != null && objArr.length > i6) {
            Object obj = objArr[i6];
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return i7;
    }

    public Object a(Object[] objArr, int i6, Object obj) {
        Object obj2;
        return (objArr == null || objArr.length <= i6 || (obj2 = objArr[i6]) == null) ? obj : obj2;
    }
}

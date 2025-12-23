package xyz.adscope.amps.tool;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSListUtil {
    public static void addDataToList(List list, List list2) {
        if (list == null || list2 == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public static void addDataToList(List list, Object obj) {
        if (list == null || obj == null) {
            return;
        }
        list.add(obj);
    }
}

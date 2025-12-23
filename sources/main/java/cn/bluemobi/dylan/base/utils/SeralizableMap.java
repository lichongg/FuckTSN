package cn.bluemobi.dylan.base.utils;

import java.io.Serializable;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SeralizableMap implements Serializable {
    private static final long serialVersionUID = 1;
    private Map<String, Object> map;

    public Map<String, Object> getMap() {
        return this.map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}

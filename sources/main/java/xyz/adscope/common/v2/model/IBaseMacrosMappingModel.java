package xyz.adscope.common.v2.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.model.annotation.MacrosReplace;
import xyz.adscope.common.v2.tool.reflect.ReflectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IBaseMacrosMappingModel implements IMacrosMapping {
    @Override // xyz.adscope.common.v2.model.IMacrosMapping
    public Map<String, String> getMacrosReplaceMap() {
        String str;
        List<Field> allFields = ReflectUtil.getAllFields(getClass());
        if (!allFields.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Field field : allFields) {
                field.setAccessible(true);
                if (ReflectUtil.isAnnotationType(field, MacrosReplace.class)) {
                    try {
                        MacrosReplace macrosReplace = (MacrosReplace) field.getAnnotation(MacrosReplace.class);
                        if (macrosReplace != null) {
                            String macros = macrosReplace.macros();
                            Object obj = field.get(this);
                            if (obj != null) {
                                str = obj.toString();
                            } else {
                                str = "";
                            }
                            hashMap.put(macros, str);
                        }
                    } catch (IllegalAccessException e6) {
                        SDKLog.stack(e6);
                    }
                } else {
                    try {
                        Object obj2 = field.get(this);
                        if (obj2 instanceof IMacrosMapping) {
                            hashMap.putAll(((IMacrosMapping) obj2).getMacrosReplaceMap());
                        }
                    } catch (IllegalAccessException e7) {
                        SDKLog.stack(e7);
                    }
                }
            }
            return hashMap;
        }
        return null;
    }
}

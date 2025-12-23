package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SimplePropertyPreFilter implements PropertyPreFilter {
    private final Class<?> clazz;
    private final Set<String> excludes;
    private final Set<String> includes;
    private int maxLevel;

    public SimplePropertyPreFilter(String... strArr) {
        this(null, strArr);
    }

    @Override // com.alibaba.fastjson.serializer.PropertyPreFilter
    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str) {
        if (obj == null) {
            return true;
        }
        Class<?> cls = this.clazz;
        if (cls != null && !cls.isInstance(obj)) {
            return true;
        }
        if (this.excludes.contains(str)) {
            return false;
        }
        if (this.maxLevel > 0) {
            int i6 = 0;
            for (SerialContext serialContext = jSONSerializer.context; serialContext != null; serialContext = serialContext.parent) {
                i6++;
                if (i6 > this.maxLevel) {
                    return false;
                }
            }
        }
        return this.includes.size() == 0 || this.includes.contains(str);
    }

    public SimplePropertyPreFilter(Class<?> cls, String... strArr) {
        this.includes = new HashSet();
        this.excludes = new HashSet();
        this.maxLevel = 0;
        this.clazz = cls;
        for (String str : strArr) {
            if (str != null) {
                this.includes.add(str);
            }
        }
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    public Set<String> getExcludes() {
        return this.excludes;
    }

    public Set<String> getIncludes() {
        return this.includes;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxLevel(int i6) {
        this.maxLevel = i6;
    }
}

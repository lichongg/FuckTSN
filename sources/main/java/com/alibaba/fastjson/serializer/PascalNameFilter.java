package com.alibaba.fastjson.serializer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PascalNameFilter implements NameFilter {
    @Override // com.alibaba.fastjson.serializer.NameFilter
    public String process(Object obj, String str, Object obj2) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }
}

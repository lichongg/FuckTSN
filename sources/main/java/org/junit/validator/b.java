package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<ValidateWith, a> f51570a = new ConcurrentHashMap<>();

    public a a(ValidateWith validateWith) {
        ConcurrentHashMap<ValidateWith, a> concurrentHashMap = f51570a;
        a aVar = concurrentHashMap.get(validateWith);
        if (aVar != null) {
            return aVar;
        }
        Class<? extends a> value = validateWith.value();
        if (value == null) {
            throw new IllegalArgumentException("Can't create validator, value is null in annotation " + validateWith.getClass().getName());
        }
        try {
            concurrentHashMap.putIfAbsent(validateWith, value.newInstance());
            return concurrentHashMap.get(validateWith);
        } catch (Exception e6) {
            throw new RuntimeException("Exception received when creating AnnotationValidator class " + value.getName(), e6);
        }
    }
}

package xyz.adscope.common.json.inter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IJSONParse {
    <T> T fromJson(String str, Class<T> cls);

    <T> T fromJsonAnnotation(String str, Class<T> cls);

    String toJson(Object obj);
}

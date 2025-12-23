package xyz.adscope.common.network.simple;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class Callback<Succeed, Failed> {
    public abstract void onCancel();

    public abstract void onEnd();

    public abstract void onException(Exception exc);

    public abstract void onResponse(SimpleResponse<Succeed, Failed> simpleResponse);

    public abstract void onStart();

    public Type getFailed() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public Type getSucceed() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}

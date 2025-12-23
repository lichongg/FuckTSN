package xyz.adscope.common.network.simple;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class SimpleCallback<V> extends Callback<V, String> {
    @Override // xyz.adscope.common.network.simple.Callback
    public Type getFailed() {
        return String.class;
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public Type getSucceed() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onCancel() {
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onEnd() {
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onStart() {
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onException(Exception exc) {
    }
}

package com.tsn.chat.utils;

import com.tsn.chat.model.RequestMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {
    public static Object a(RequestMessage requestMessage) {
        b.f40730a.writeAndFlush(requestMessage);
        return "response time out!";
    }
}

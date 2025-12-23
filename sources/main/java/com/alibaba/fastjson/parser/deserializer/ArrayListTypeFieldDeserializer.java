package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ArrayListTypeFieldDeserializer extends FieldDeserializer {
    private ObjectDeserializer deserializer;
    private int itemFastMatchToken;
    private final Type itemType;

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        Class cls;
        int i6;
        int i7;
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer = this.deserializer;
        int i8 = 0;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i7 = 0;
                    while (i7 < length) {
                        if (cls.getTypeParameters()[i7].getName().equals(typeVariable.getName())) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                }
                i7 = -1;
                if (i7 != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i7];
                    if (!type2.equals(this.itemType)) {
                        objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                    }
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    Type type3 = actualTypeArguments[0];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                        if (cls != null) {
                            int length2 = cls.getTypeParameters().length;
                            i6 = 0;
                            while (i6 < length2) {
                                if (cls.getTypeParameters()[i6].getName().equals(typeVariable2.getName())) {
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                        }
                        i6 = -1;
                        if (i6 != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i6];
                            type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                        }
                    }
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 14) {
            if (objectDeserializer == null) {
                objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = objectDeserializer;
            }
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, 0));
            defaultJSONParser.checkListResolve(collection);
            return;
        }
        if (objectDeserializer == null) {
            objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
            this.deserializer = objectDeserializer;
            this.itemFastMatchToken = objectDeserializer.getFastMatchToken();
        }
        ObjectDeserializer objectDeserializer2 = objectDeserializer;
        jSONLexer.nextToken(this.itemFastMatchToken);
        while (true) {
            if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                while (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                }
            }
            if (jSONLexer.token() == 15) {
                jSONLexer.nextToken(16);
                return;
            }
            collection.add(objectDeserializer2.deserialze(defaultJSONParser, type2, Integer.valueOf(i8)));
            defaultJSONParser.checkListResolve(collection);
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(this.itemFastMatchToken);
            }
            i8++;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = jSONLexer.token();
        if (i6 == 8 || (i6 == 4 && jSONLexer.stringVal().length() == 0)) {
            setValue(obj, (String) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ParseContext context = defaultJSONParser.getContext();
        defaultJSONParser.setContext(context, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(context);
        if (obj == null) {
            map.put(this.fieldInfo.name, arrayList);
        } else {
            setValue(obj, arrayList);
        }
    }

    public ArrayListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        Type type = fieldInfo.fieldType;
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
            this.itemType = type2;
            return;
        }
        this.itemType = Object.class;
    }
}

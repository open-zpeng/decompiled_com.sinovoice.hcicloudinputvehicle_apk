package b.a.a.w.l;

import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes.dex */
public final class h extends t<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f109a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final b.a.a.e f110b;

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements u {
        a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            if (aVar.c() == Object.class) {
                return new h(eVar);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f111a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f111a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f111a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f111a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f111a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f111a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f111a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    h(b.a.a.e eVar) {
        this.f110b = eVar;
    }

    @Override // b.a.a.t
    public Object b(JsonReader jsonReader) {
        switch (b.f111a[jsonReader.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(b(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
                b.a.a.w.g gVar = new b.a.a.w.g();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    gVar.put(jsonReader.nextName(), b(jsonReader));
                }
                jsonReader.endObject();
                return gVar;
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // b.a.a.t
    public void d(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        t l = this.f110b.l(obj.getClass());
        if (l instanceof h) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        l.d(jsonWriter, obj);
    }
}

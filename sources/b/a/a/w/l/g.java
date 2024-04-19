package b.a.a.w.l;

import b.a.a.o;
import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class g implements u {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.w.c f105a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f106b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    private final class a<K, V> extends t<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private final t<K> f107a;

        /* renamed from: b  reason: collision with root package name */
        private final t<V> f108b;
        private final b.a.a.w.h<? extends Map<K, V>> c;

        public a(b.a.a.e eVar, Type type, t<K> tVar, Type type2, t<V> tVar2, b.a.a.w.h<? extends Map<K, V>> hVar) {
            this.f107a = new m(eVar, tVar, type);
            this.f108b = new m(eVar, tVar2, type2);
            this.c = hVar;
        }

        private String e(b.a.a.j jVar) {
            if (jVar.g()) {
                o c = jVar.c();
                if (c.q()) {
                    return String.valueOf(c.m());
                }
                if (c.o()) {
                    return Boolean.toString(c.h());
                }
                if (c.s()) {
                    return c.n();
                }
                throw new AssertionError();
            } else if (jVar.e()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public Map<K, V> b(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> a2 = this.c.a();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K b2 = this.f107a.b(jsonReader);
                    if (a2.put(b2, this.f108b.b(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new r("duplicate key: " + b2);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    b.a.a.w.e.INSTANCE.promoteNameToValue(jsonReader);
                    K b3 = this.f107a.b(jsonReader);
                    if (a2.put(b3, this.f108b.b(jsonReader)) != null) {
                        throw new r("duplicate key: " + b3);
                    }
                }
                jsonReader.endObject();
            }
            return a2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.a.a.t
        /* renamed from: g */
        public void d(JsonWriter jsonWriter, Map<K, V> map) {
            if (map == null) {
                jsonWriter.nullValue();
            } else if (!g.this.f106b) {
                jsonWriter.beginObject();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.f108b.d(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    b.a.a.j c = this.f107a.c(entry2.getKey());
                    arrayList.add(c);
                    arrayList2.add(entry2.getValue());
                    z |= c.d() || c.f();
                }
                if (z) {
                    jsonWriter.beginArray();
                    int size = arrayList.size();
                    while (i < size) {
                        jsonWriter.beginArray();
                        b.a.a.w.j.b((b.a.a.j) arrayList.get(i), jsonWriter);
                        this.f108b.d(jsonWriter, arrayList2.get(i));
                        jsonWriter.endArray();
                        i++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                int size2 = arrayList.size();
                while (i < size2) {
                    jsonWriter.name(e((b.a.a.j) arrayList.get(i)));
                    this.f108b.d(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.endObject();
            }
        }
    }

    public g(b.a.a.w.c cVar, boolean z) {
        this.f105a = cVar;
        this.f106b = z;
    }

    private t<?> b(b.a.a.e eVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return eVar.k(b.a.a.x.a.b(type));
        }
        return n.f;
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
        Type e = aVar.e();
        if (Map.class.isAssignableFrom(aVar.c())) {
            Type[] j = b.a.a.w.b.j(e, b.a.a.w.b.k(e));
            return new a(eVar, j[0], b(eVar, j[0]), j[1], eVar.k(b.a.a.x.a.b(j[1])), this.f105a.a(aVar));
        }
        return null;
    }
}

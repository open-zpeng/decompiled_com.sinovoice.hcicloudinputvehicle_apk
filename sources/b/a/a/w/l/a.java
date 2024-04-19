package b.a.a.w.l;

import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<E> extends t<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f93a = new C0010a();

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f94b;
    private final t<E> c;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: b.a.a.w.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0010a implements u {
        C0010a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            Type e = aVar.e();
            if ((e instanceof GenericArrayType) || ((e instanceof Class) && ((Class) e).isArray())) {
                Type g = b.a.a.w.b.g(e);
                return new a(eVar, eVar.k(b.a.a.x.a.b(g)), b.a.a.w.b.k(g));
            }
            return null;
        }
    }

    public a(b.a.a.e eVar, t<E> tVar, Class<E> cls) {
        this.c = new m(eVar, tVar, cls);
        this.f94b = cls;
    }

    @Override // b.a.a.t
    public Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.c.b(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f94b, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.a.a.t
    public void d(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.d(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.endArray();
    }
}

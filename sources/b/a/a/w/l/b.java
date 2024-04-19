package b.a.a.w.l;

import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class b implements u {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.w.c f95a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    private static final class a<E> extends t<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final t<E> f96a;

        /* renamed from: b  reason: collision with root package name */
        private final b.a.a.w.h<? extends Collection<E>> f97b;

        public a(b.a.a.e eVar, Type type, t<E> tVar, b.a.a.w.h<? extends Collection<E>> hVar) {
            this.f96a = new m(eVar, tVar, type);
            this.f97b = hVar;
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Collection<E> b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> a2 = this.f97b.a();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                a2.add(this.f96a.b(jsonReader));
            }
            jsonReader.endArray();
            return a2;
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Collection<E> collection) {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (E e : collection) {
                this.f96a.d(jsonWriter, e);
            }
            jsonWriter.endArray();
        }
    }

    public b(b.a.a.w.c cVar) {
        this.f95a = cVar;
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
        Type e = aVar.e();
        Class<? super T> c = aVar.c();
        if (Collection.class.isAssignableFrom(c)) {
            Type h = b.a.a.w.b.h(e, c);
            return new a(eVar, h, eVar.k(b.a.a.x.a.b(h)), this.f95a.a(aVar));
        }
        return null;
    }
}

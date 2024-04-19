package b.a.a;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
/* compiled from: TypeAdapter.java */
/* loaded from: classes.dex */
public abstract class t<T> {

    /* compiled from: TypeAdapter.java */
    /* loaded from: classes.dex */
    class a extends t<T> {
        a() {
        }

        @Override // b.a.a.t
        public T b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return (T) t.this.b(jsonReader);
        }

        @Override // b.a.a.t
        public void d(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.nullValue();
            } else {
                t.this.d(jsonWriter, t);
            }
        }
    }

    public final t<T> a() {
        return new a();
    }

    public abstract T b(JsonReader jsonReader);

    public final j c(T t) {
        try {
            b.a.a.w.l.f fVar = new b.a.a.w.l.f();
            d(fVar, t);
            return fVar.a();
        } catch (IOException e) {
            throw new k(e);
        }
    }

    public abstract void d(JsonWriter jsonWriter, T t);
}

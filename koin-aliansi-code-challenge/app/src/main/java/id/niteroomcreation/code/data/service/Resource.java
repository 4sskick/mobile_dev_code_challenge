package id.niteroomcreation.code.data.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Septian Adi Wijaya on 16/08/2022.
 * please be sure to add credential if you use people's code
 */
public class Resource<T> {

    @NonNull
    public final Status.Local status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;

    public Resource() {
        this(Status.Local.LOADING, null, null);
    }

    public Resource(@NonNull Status.Local status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(Status.Local.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(Status.Local.ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.Local.LOADING, data, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Resource<?> resource = (Resource<?>) o;

        if (status != resource.status) {
            return false;
        }
        if (message != null ? !message.equals(resource.message) : resource.message != null) {
            return false;
        }
        return data != null ? data.equals(resource.data) : resource.data == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
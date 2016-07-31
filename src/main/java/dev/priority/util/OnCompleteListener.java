package dev.priority.util;

/**
 * Created by yoavbenishai on 19-Jul-16.
 */
public interface OnCompleteListener<T> {
    public void onSuccess(T t);

   public void onError(int code, String message, Throwable exception);
}

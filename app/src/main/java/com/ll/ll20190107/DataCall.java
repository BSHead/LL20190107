package com.ll.ll20190107;

public interface DataCall<T> {
    void success(T data);
    void fail();
}

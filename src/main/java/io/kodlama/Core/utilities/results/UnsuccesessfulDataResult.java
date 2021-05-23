package io.kodlama.Core.utilities.results;

public class UnsuccesessfulDataResult<T> extends DataResult<T>{
    public UnsuccesessfulDataResult(boolean result) {
        super(false);
    }

    public UnsuccesessfulDataResult(T Data, boolean result) {
        super(Data, false);
    }

    public UnsuccesessfulDataResult(T data, boolean result, String message) {
        super(data, false, message);
    }
}

package io.kodlama.Core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(boolean result) {
        super(true);
    }

    public SuccessDataResult(T Data, boolean result) {
        super(Data, true);
    }

    public SuccessDataResult(T data, boolean result, String message) {
        super(data, true, message);
    }



}

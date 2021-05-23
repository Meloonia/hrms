package io.kodlama.Core.utilities.results;

public class DataResult<T> {

    private boolean dataResult;
    private String message;
    public DataResult(boolean result) {

        this.dataResult = result;

    }
    public DataResult(T Data ,boolean result) {

        this.dataResult = result;

    }
    public DataResult(T data ,boolean result, String message) {

        this.dataResult = result;
        this.message = message;

    }

}

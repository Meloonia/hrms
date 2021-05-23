package io.kodlama.Core.utilities.results;

public class UnsuccessfulResult extends Result{
    public UnsuccessfulResult(boolean success) {
        super(false);
    }

    public UnsuccessfulResult(boolean success, String message) {
        super(false, message);
    }
}

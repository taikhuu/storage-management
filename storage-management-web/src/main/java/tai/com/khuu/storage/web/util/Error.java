package tai.com.khuu.storage.web.util;

public class Error<T, E, U> {
    private T owner;
    private E reason;
    private U suggestion;

    public T getOwner() {
        return owner;
    }

    public void setOwner(T owner) {
        this.owner = owner;
    }

    public E getReason() {
        return reason;
    }

    public void setReason(E reason) {
        this.reason = reason;
    }

    public U getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(U suggestion) {
        this.suggestion = suggestion;
    }

    public Error(T owner, E reason, U suggestion) {
        this.owner = owner;
        this.reason = reason;
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "error from "+owner.toString()+" because "+reason+" do "+suggestion.toString()+" to resolve"
    }
}

package com.minorius.data;

/**
 * Created by minorius on 22.02.2017.
 */
public class SessionData {

    private String name;
    private String message;
    private String rating;

    public SessionData(String name, String message, String rating) {
        this.name = name;
        this.message = message;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "SessionData{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionData that = (SessionData) o;

        if (!name.equals(that.name)) return false;
        if (!message.equals(that.message)) return false;
        return rating.equals(that.rating);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + rating.hashCode();
        return result;
    }
}

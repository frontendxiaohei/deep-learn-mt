package book.chapter01.query;

import java.sql.ResultSet;

public interface RowHandler<T> {
    T handle(ResultSet rs);
}

package ar.com.ada.online.second.library.advice.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RestErrorsResponse<T> {
    private Timestamp timestamp;
    private Integer status;
    private String error;
    private List<T> errors;

    public RestErrorsResponse(Integer status, String error, List<T> errors) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.status = status;
        this.error = error;
        this.errors = errors;
    }

}

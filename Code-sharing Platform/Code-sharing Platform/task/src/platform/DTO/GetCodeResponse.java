package platform.DTO;

import lombok.Data;
import platform.Entities.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class GetCodeResponse {
    private String code;
    private String date;
    private long time;
    private long views;
    public GetCodeResponse(Code code) {
        this.code = code.getCode();
        this.date = getDateFormatted(code.getDate());
        this.time = code.getInitialTime() <= 0 ? 0
                : code.getTimeLeft();
        this.views = code.getInitialViews() <= 0 ? 0 : code.getViewsLeft();
    }

    private String getDateFormatted(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return date.format(formatter);
    }
}
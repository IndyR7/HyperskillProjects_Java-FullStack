package platform.DTO;

import lombok.Data;

@Data
public class CreateCodeRequest {
    private String code;
    private long time;
    private long views;
}
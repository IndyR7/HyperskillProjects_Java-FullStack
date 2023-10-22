package platform.DTO;

import lombok.Data;
import platform.Entities.Code;

@Data
public class CodeCreationSuccessResponse {
    private String id;
    public CodeCreationSuccessResponse(Code code) {
        this.id = code.getUuid();
    }
}
package if_46_03_1_fitspace.fitspace.dto.photo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoUpdateRequest {

    @JsonProperty("photo_url")
    private String photoUrl;

}

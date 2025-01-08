package if_46_03_1_fitspace.fitspace.dto.venue;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueRatingUpdateRequest {

    @NotBlank
    private Double rating;
}

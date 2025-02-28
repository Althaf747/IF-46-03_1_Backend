package if_46_03_1_fitspace.fitspace.repository;

import fitspace.fitspace_sports_venue_booking_website_backend.entity.Field;
import fitspace.fitspace_sports_venue_booking_website_backend.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
    Optional<Field> findFirstByIdAndVenue(Long id, Venue venue);
    List<Field> findAllByVenue(Venue venue);
    Optional<Field> findById(Integer id);

    List<Field> findAll();

    Optional<Field> findFirstByVenueAndType(Venue venue, String type);
}

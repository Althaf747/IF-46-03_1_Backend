package if_46_03_1_fitspace.fitspace.controller;

import fitspace.fitspace_sports_venue_booking_website_backend.dto.WebResponse;
import fitspace.fitspace_sports_venue_booking_website_backend.dto.bookings.BookingAddRequest;
import fitspace.fitspace_sports_venue_booking_website_backend.dto.bookings.BookingDataResponse;
import fitspace.fitspace_sports_venue_booking_website_backend.dto.bookings.BookingUpdateStatusRequest;
import fitspace.fitspace_sports_venue_booking_website_backend.dto.schedule.ScheduleDataResponse;
import fitspace.fitspace_sports_venue_booking_website_backend.entity.User;
import fitspace.fitspace_sports_venue_booking_website_backend.helper.DtoToWebMapper;
import fitspace.fitspace_sports_venue_booking_website_backend.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping(
            path = "/api/{venueId}/bookings",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BookingDataResponse> create(User user, @PathVariable Long venueId, @RequestBody BookingAddRequest request) {
        BookingDataResponse bookingDataResponse = bookingService.create(user, venueId, request);
        return DtoToWebMapper.toWebResponse(bookingDataResponse);
    }

    @GetMapping(
            path = "/api/bookings",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse <List<BookingDataResponse>> get(User user) {
        List<BookingDataResponse> bookings = bookingService.get(user);
        return DtoToWebMapper.toWebResponse(bookings);
    }

    @DeleteMapping(
            path = "/api/{bookingId}/bookings",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(User user, @PathVariable Long bookingId) {
        bookingService.delete(user, bookingId);
        return DtoToWebMapper.toWebResponse("Delete Booking Successfully");
    }

    @PatchMapping(
            path = "/api/{bookingId}/bookings",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BookingDataResponse> updateStatus(User user, @PathVariable Long bookingId, @RequestBody BookingUpdateStatusRequest request) {
        BookingDataResponse bookingDataResponse = bookingService.updateStatus(user,bookingId,request);
        return DtoToWebMapper.toWebResponse(bookingDataResponse);
    }

    @GetMapping(
            path = "/api/bookings/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<BookingDataResponse>> getAll() {
        List<BookingDataResponse> books = bookingService.getBookings();
        return DtoToWebMapper.toWebResponse(books);
    }

    @DeleteMapping(
            path = "/api/bookings/{bookingId}/delete",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteBook(@PathVariable long bookingId) {
        bookingService.deleteBooking(bookingId);
        return DtoToWebMapper.toWebResponse("Delete Booking Successfully");
    }

    @PatchMapping(
            path = "/api/bookings/{bookingId}/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BookingDataResponse> updateBook(@PathVariable("bookingId")Long bookingId, @RequestBody BookingUpdateStatusRequest request) {
        BookingDataResponse bookingDataResponse = bookingService.updateBooking(bookingId,request);

        return DtoToWebMapper.toWebResponse(bookingDataResponse);
    }

    @GetMapping(
            path = "/api/bookings/schedule/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ScheduleDataResponse> getScheduleByBooking(@PathVariable Long id) {
        ScheduleDataResponse schedule = bookingService.getScheduleByBooking(id);
        return DtoToWebMapper.toWebResponse(schedule);
    }

}

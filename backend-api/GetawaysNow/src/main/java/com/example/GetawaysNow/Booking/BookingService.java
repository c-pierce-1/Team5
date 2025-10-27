package com.example.getawaysnow.booking;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
        if (booking.getStartDate().isAfter(booking.getEndDate())) {
            throw new IllegalStateException("Start date must be before end date");
        }
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking with id:" + id + " not found"));
    }

    public List<Booking> getBookingsByProfileId(Long profileId) {
        return bookingRepository.findByProfileId(profileId);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking existingBooking = getBookingById(id);
        existingBooking.setStartDate(bookingDetails.getStartDate());
        existingBooking.setEndDate(bookingDetails.getEndDate());
        if (existingBooking.getStartDate().isAfter(existingBooking.getEndDate())) {
            throw new IllegalStateException("Start date must be before end date");
        }

        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new EntityNotFoundException("Booking with id:" + id + " not found");
        }
        bookingRepository.deleteById(id);
    }
}

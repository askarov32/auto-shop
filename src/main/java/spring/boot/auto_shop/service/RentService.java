package spring.boot.auto_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.auto_shop.models.Rent;
import spring.boot.auto_shop.repository.RentRepository;

import java.util.List;

@Service
public class RentService {
    private final RentRepository rentRepository;

    @Autowired

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }
}

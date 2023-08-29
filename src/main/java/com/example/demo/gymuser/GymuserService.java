package com.example.demo.gymuser;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GymuserService {
    private final GymuserRepository gymuserRepository;

    @Autowired
    public GymuserService(GymuserRepository gymuserRepository) {
        this.gymuserRepository = gymuserRepository;
    }

    public void addNewGymuser(Gymuser gymuser) {
        Optional<Gymuser> gymuserOptional = gymuserRepository.findGymuserByEmail(gymuser.getEmail());
        if(gymuserOptional.isPresent()){
            throw new IllegalStateException("Email taken!");
        }
        gymuserRepository.save(gymuser);
    }

    public List<Gymuser> getGymusers(){
        return gymuserRepository.findAll();
    }

    @Transactional
    public void updateGymuser(Long gymuserId, String name, String email, Integer daysAllowed) {
        Gymuser gymuser = gymuserRepository.findById(gymuserId).orElseThrow(() -> new IllegalStateException(
                "Gymuser with id " + gymuserId + " does not exist!"
        ));

        if(name != null &&
        name.length() > 0 &&
        !Objects.equals(gymuser.getName(), name)){
            gymuser.setName(name);
        }

        if (email != null &&
        email.length() > 0 &&
        !Objects.equals(gymuser.getEmail(), email)) {
            Optional<Gymuser> gymuserOptional = gymuserRepository.findGymuserByEmail(email);
            if(gymuserOptional.isPresent()){
                throw new IllegalStateException("Email taken!");
            }
            gymuser.setEmail(email);
        }
        if(daysAllowed != null &&
        daysAllowed >= 0 &&
        !Objects.equals(gymuser.getDaysAllowed(), daysAllowed)){
            gymuser.setDaysAllowed(daysAllowed);
        }

    }

    public void deleteGymuser(Long gymuserId) {
        boolean exist = gymuserRepository.existsById(gymuserId);
        if(!exist){
            throw new IllegalStateException("Gymuser with id " + gymuserId + " does not exist!");
        }
        gymuserRepository.deleteById(gymuserId);
    }
}

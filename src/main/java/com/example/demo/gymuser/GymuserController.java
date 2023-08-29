package com.example.demo.gymuser;

import com.example.demo.gymuser.Gymuser;
import com.example.demo.gymuser.GymuserService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gymuser")
public class GymuserController {

    private final GymuserService gymuserService;

    @Autowired
    public GymuserController(GymuserService gymuserService) {
        this.gymuserService = gymuserService;
    }

    @GetMapping
    public List<Gymuser> getAllGymuser(){
        return gymuserService.getGymusers();
    }

    @PostMapping
    public void registerNewGymuser(@RequestBody Gymuser gymuser){
        gymuserService.addNewGymuser(gymuser);
    }

    @DeleteMapping(path = "{gymuserId}")
    public void deteleGymuser(
            @PathVariable("gymuserId") Long gymuserId
    ){
        gymuserService.deleteGymuser(gymuserId);
    }

    @PutMapping(path = "{gymuserId}")
    public void updateGymuser(
            @PathVariable("gymuserId") Long gymuserId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer daysAllowed){
        gymuserService.updateGymuser(gymuserId, name, email, daysAllowed);

    }
}

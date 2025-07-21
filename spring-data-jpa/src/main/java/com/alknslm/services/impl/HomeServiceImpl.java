package com.alknslm.services.impl;

import com.alknslm.dto.DtoHome;
import com.alknslm.dto.DtoRoom;
import com.alknslm.entities.Home;
import com.alknslm.entities.Room;
import com.alknslm.repository.HomeRepository;
import com.alknslm.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        Home home = optional.get();
        List<Room> dbRooms = optional.get().getRoom();

        BeanUtils.copyProperties(home, dtoHome);
        if(dbRooms != null && !dbRooms.isEmpty()) {
            for(Room room : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }

        return dtoHome;
    }
}

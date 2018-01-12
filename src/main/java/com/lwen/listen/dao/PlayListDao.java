package com.lwen.listen.dao;


import com.lwen.listen.entity.PlayList;
import com.lwen.listen.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayListDao {
    @Autowired
    private PlayListRepository repository;

    public PlayList savePlayList(PlayList list) {
        return repository.save(list);
    }

    public List<PlayList> findByName(String name) {
        return repository.findByNameLike("%"+name+"%");
    }


}

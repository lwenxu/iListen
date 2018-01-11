package com.lwen.listen.repository;


import com.lwen.listen.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music,Long> {
     List<Music> findByNameLike(String name);

     Music findByMId(Long id);

}

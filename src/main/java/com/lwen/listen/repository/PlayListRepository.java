package com.lwen.listen.repository;


import com.lwen.listen.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
//    List<PlayList> findByListNameLike(String name);

    List<PlayList> findByNameLike(String s);
}

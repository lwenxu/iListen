package com.lwen.listen.Enmu;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ResultEnmu {
    SUCCESS(200, "成功! :) "),
    // ERROR(201, "失败！:( "),
    MUSIC_CACHE_INDEX_ERROR(201, "歌曲索引缓存失败"),
    UNKNOWN_ERROR(-1, "未知错误"),
    SEARCH_ERROR(202, "非法的检索类型");

    @Getter @Setter private int code;
    @Getter @Setter private String msg;
}

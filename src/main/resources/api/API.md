## 1. 推荐歌单

```json
        'Connection': 'keep-alive',
        'Content-Type': 'application/x-www-form-urlencoded',
        'Host': 'music.163.com',
        'Referer': 'http://music.163.com/search/'

http://music.163.com/api/playlist/list?cat=&order=&offset=&total=(true/false)&limit=
```

## 2. 歌单 [根据歌单id获取歌单的信息]

```json
http://music.163.com/api/playlist/detail?id=playlist_id
```

## 3.歌手 [根据歌手id获取歌手信息]

```json
http://music.163.com/api/artist/artist_id
``` 

## 4. 专辑

#### 1. 根据歌手id获取他的专辑列表
```json
http://music.163.com/api/artist/albums/artist_id?offset=0&limit=50
```
#### 2. 根据专辑 id 获取专辑内的歌曲
```json
http://music.163.com/api/album/%s/' % album_id
```

## 5. 检索

#### 1. 关键字检索 [有几种类型]
```json
    http://music.163.com/api/search/get
    's': keyword,
    'type': stype,
    'offset': offset,
    'total': total,
    'limit': 60
```


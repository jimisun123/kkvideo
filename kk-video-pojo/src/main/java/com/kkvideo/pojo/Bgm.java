package com.kkvideo.pojo;

import javax.persistence.Id;

public class Bgm {
    @Id
    private String id;

    private String author;

    private String name;

    /**
     * 播放地址
     */
    private String path;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取播放地址
     *
     * @return path - 播放地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置播放地址
     *
     * @param path 播放地址
     */
    public void setPath(String path) {
        this.path = path;
    }
}
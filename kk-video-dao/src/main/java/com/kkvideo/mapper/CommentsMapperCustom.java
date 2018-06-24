package com.kkvideo.mapper;

import com.kkvideo.pojo.Comments;
import com.kkvideo.utils.MyMapper;
import com.kkvideo.vo.CommentsVO;

import java.util.List;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 11:28 2018-06-21
 * @Modified By:
 */
public interface CommentsMapperCustom extends MyMapper<Comments> {
    public List<CommentsVO> queryComments(String videoId);
}

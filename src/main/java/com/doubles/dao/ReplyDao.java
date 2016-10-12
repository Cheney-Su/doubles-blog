package com.doubles.dao;

import com.doubles.entity.Reply;
import com.doubles.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * UserLoginDao用户登陆dao层
 * Created by Administrator on 2016/7/12.
 * USER: Suhuaqiang
 */
@Repository()
public class ReplyDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询博客回复list
     *
     * @param blogId
     * @return
     */
    public List<Reply> replyListByBlogId(String blogId) {
        List<Reply> list = new ArrayList<Reply>();
        StringBuffer sb = new StringBuffer();
        sb.append("select t.id id,t.blogId blogId,t.rootId rootId,t.content content,t.createTime createTime,t.ownerId ownerId,t.toUserId toUserId,")
                .append("   owner.id ownerId,owner.nickName ownerNickName,owner.createTime ownerCreateTime,")
                .append("   toUser.id toUserId,toUser.nickName toUserNickName,toUser.createTime toUserCreateTime")
                .append("   from tb_reply t ,tb_user OWNER,tb_user toUser")
                .append("   where t.blogId = ? and t.rootId is null and t.ownerId = owner.id and t.toUserId = toUser.id");
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sb.toString(), new Object[]{blogId});
        while (rs != null && rs.next()) {
            Reply entity = new Reply();
            entity.setId(rs.getInt("id"));
            entity.setBlogId(rs.getInt("blogId"));
            entity.setRootId(rs.getInt("rootId"));
            entity.setContent(rs.getString("content").toString());
            entity.setCreateTime(rs.getString("createTime").toString());
            entity.setOwnerId(rs.getInt("ownerId"));
            entity.setToUserId(rs.getInt("toUserId"));
            entity.setChilds(childsListByRootId(rs.getInt("id") + ""));
            User owner = new User();
            owner.setId(rs.getInt("ownerId"));
            owner.setNickName(rs.getString("ownerNickName").toString());
            owner.setCreateTime(rs.getString("ownerCreateTime").toString());
            entity.setOwner(owner);
            User toUser = new User();
            toUser.setId(rs.getInt("toUserId"));
            toUser.setNickName(rs.getString("toUserNickName").toString());
            toUser.setCreateTime(rs.getString("toUserCreateTime").toString());
            entity.setToUser(toUser);
            list.add(entity);
        }

        return list;
    }

    /**
     * 根据rootId(博客的replyId)查询到回复博客回复的list
     *
     * @param rootId
     * @return
     */
    public List<Reply> childsListByRootId(String rootId) {
        List<Reply> list = new ArrayList<Reply>();
        StringBuffer sb = new StringBuffer();
        sb.append("select t.id id,t.blogId blogId,t.rootId rootId,t.content content,t.createTime createTime,t.ownerId ownerId,t.toUserId toUserId,")
                .append("   owner.id ownerId,owner.nickName ownerNickName,owner.createTime ownerCreateTime,")
                .append("   toUser.id toUserId,toUser.nickName toUserNickName,toUser.createTime toUserCreateTime")
                .append("   from tb_reply t ,tb_user OWNER,tb_user toUser")
                .append("   where t.rootId = ? and t.ownerId = owner.id and t.toUserId = toUser.id order by t.createTime desc");
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sb.toString(), new Object[]{rootId});
        while (rs != null && rs.next()) {
            Reply entity = new Reply();
            entity.setId(rs.getInt("id"));
            entity.setBlogId(rs.getInt("blogId"));
            entity.setRootId(rs.getInt("rootId"));
            entity.setContent(rs.getString("content").toString());
            entity.setCreateTime(rs.getString("createTime").toString());
            entity.setOwnerId(rs.getInt("ownerId"));
            entity.setToUserId(rs.getInt("toUserId"));
            User owner = new User();
            owner.setId(rs.getInt("ownerId"));
            owner.setNickName(rs.getString("ownerNickName").toString());
            owner.setCreateTime(rs.getString("ownerCreateTime").toString());
            entity.setOwner(owner);
            User toUser = new User();
            toUser.setId(rs.getInt("toUserId"));
            toUser.setNickName(rs.getString("toUserNickName").toString());
            toUser.setCreateTime(rs.getString("toUserCreateTime").toString());
            entity.setToUser(toUser);
            list.add(entity);
        }
        return list;
    }
}

package kkvideo.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideosExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAudioIdIsNull() {
            addCriterion("audio_id is null");
            return (Criteria) this;
        }

        public Criteria andAudioIdIsNotNull() {
            addCriterion("audio_id is not null");
            return (Criteria) this;
        }

        public Criteria andAudioIdEqualTo(String value) {
            addCriterion("audio_id =", value, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdNotEqualTo(String value) {
            addCriterion("audio_id <>", value, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdGreaterThan(String value) {
            addCriterion("audio_id >", value, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdGreaterThanOrEqualTo(String value) {
            addCriterion("audio_id >=", value, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdLessThan(String value) {
            addCriterion("audio_id <", value, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdLessThanOrEqualTo(String value) {
            addCriterion("audio_id <=", value, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdLike(String value) {
            addCriterion("audio_id like", value, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdNotLike(String value) {
            addCriterion("audio_id not like", value, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdIn(List<String> values) {
            addCriterion("audio_id in", values, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdNotIn(List<String> values) {
            addCriterion("audio_id not in", values, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdBetween(String value1, String value2) {
            addCriterion("audio_id between", value1, value2, "audioId");
            return (Criteria) this;
        }

        public Criteria andAudioIdNotBetween(String value1, String value2) {
            addCriterion("audio_id not between", value1, value2, "audioId");
            return (Criteria) this;
        }

        public Criteria andVideoDescIsNull() {
            addCriterion("video_desc is null");
            return (Criteria) this;
        }

        public Criteria andVideoDescIsNotNull() {
            addCriterion("video_desc is not null");
            return (Criteria) this;
        }

        public Criteria andVideoDescEqualTo(String value) {
            addCriterion("video_desc =", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotEqualTo(String value) {
            addCriterion("video_desc <>", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescGreaterThan(String value) {
            addCriterion("video_desc >", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescGreaterThanOrEqualTo(String value) {
            addCriterion("video_desc >=", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLessThan(String value) {
            addCriterion("video_desc <", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLessThanOrEqualTo(String value) {
            addCriterion("video_desc <=", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLike(String value) {
            addCriterion("video_desc like", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotLike(String value) {
            addCriterion("video_desc not like", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescIn(List<String> values) {
            addCriterion("video_desc in", values, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotIn(List<String> values) {
            addCriterion("video_desc not in", values, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescBetween(String value1, String value2) {
            addCriterion("video_desc between", value1, value2, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotBetween(String value1, String value2) {
            addCriterion("video_desc not between", value1, value2, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoPathIsNull() {
            addCriterion("video_path is null");
            return (Criteria) this;
        }

        public Criteria andVideoPathIsNotNull() {
            addCriterion("video_path is not null");
            return (Criteria) this;
        }

        public Criteria andVideoPathEqualTo(String value) {
            addCriterion("video_path =", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathNotEqualTo(String value) {
            addCriterion("video_path <>", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathGreaterThan(String value) {
            addCriterion("video_path >", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathGreaterThanOrEqualTo(String value) {
            addCriterion("video_path >=", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathLessThan(String value) {
            addCriterion("video_path <", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathLessThanOrEqualTo(String value) {
            addCriterion("video_path <=", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathLike(String value) {
            addCriterion("video_path like", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathNotLike(String value) {
            addCriterion("video_path not like", value, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathIn(List<String> values) {
            addCriterion("video_path in", values, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathNotIn(List<String> values) {
            addCriterion("video_path not in", values, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathBetween(String value1, String value2) {
            addCriterion("video_path between", value1, value2, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoPathNotBetween(String value1, String value2) {
            addCriterion("video_path not between", value1, value2, "videoPath");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsIsNull() {
            addCriterion("video_seconds is null");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsIsNotNull() {
            addCriterion("video_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsEqualTo(Float value) {
            addCriterion("video_seconds =", value, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsNotEqualTo(Float value) {
            addCriterion("video_seconds <>", value, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsGreaterThan(Float value) {
            addCriterion("video_seconds >", value, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsGreaterThanOrEqualTo(Float value) {
            addCriterion("video_seconds >=", value, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsLessThan(Float value) {
            addCriterion("video_seconds <", value, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsLessThanOrEqualTo(Float value) {
            addCriterion("video_seconds <=", value, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsIn(List<Float> values) {
            addCriterion("video_seconds in", values, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsNotIn(List<Float> values) {
            addCriterion("video_seconds not in", values, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsBetween(Float value1, Float value2) {
            addCriterion("video_seconds between", value1, value2, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoSecondsNotBetween(Float value1, Float value2) {
            addCriterion("video_seconds not between", value1, value2, "videoSeconds");
            return (Criteria) this;
        }

        public Criteria andVideoWidthIsNull() {
            addCriterion("video_width is null");
            return (Criteria) this;
        }

        public Criteria andVideoWidthIsNotNull() {
            addCriterion("video_width is not null");
            return (Criteria) this;
        }

        public Criteria andVideoWidthEqualTo(Integer value) {
            addCriterion("video_width =", value, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthNotEqualTo(Integer value) {
            addCriterion("video_width <>", value, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthGreaterThan(Integer value) {
            addCriterion("video_width >", value, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("video_width >=", value, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthLessThan(Integer value) {
            addCriterion("video_width <", value, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthLessThanOrEqualTo(Integer value) {
            addCriterion("video_width <=", value, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthIn(List<Integer> values) {
            addCriterion("video_width in", values, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthNotIn(List<Integer> values) {
            addCriterion("video_width not in", values, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthBetween(Integer value1, Integer value2) {
            addCriterion("video_width between", value1, value2, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("video_width not between", value1, value2, "videoWidth");
            return (Criteria) this;
        }

        public Criteria andVideoHeightIsNull() {
            addCriterion("video_height is null");
            return (Criteria) this;
        }

        public Criteria andVideoHeightIsNotNull() {
            addCriterion("video_height is not null");
            return (Criteria) this;
        }

        public Criteria andVideoHeightEqualTo(Integer value) {
            addCriterion("video_height =", value, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightNotEqualTo(Integer value) {
            addCriterion("video_height <>", value, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightGreaterThan(Integer value) {
            addCriterion("video_height >", value, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("video_height >=", value, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightLessThan(Integer value) {
            addCriterion("video_height <", value, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightLessThanOrEqualTo(Integer value) {
            addCriterion("video_height <=", value, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightIn(List<Integer> values) {
            addCriterion("video_height in", values, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightNotIn(List<Integer> values) {
            addCriterion("video_height not in", values, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightBetween(Integer value1, Integer value2) {
            addCriterion("video_height between", value1, value2, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andVideoHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("video_height not between", value1, value2, "videoHeight");
            return (Criteria) this;
        }

        public Criteria andCoverPathIsNull() {
            addCriterion("cover_path is null");
            return (Criteria) this;
        }

        public Criteria andCoverPathIsNotNull() {
            addCriterion("cover_path is not null");
            return (Criteria) this;
        }

        public Criteria andCoverPathEqualTo(String value) {
            addCriterion("cover_path =", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotEqualTo(String value) {
            addCriterion("cover_path <>", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathGreaterThan(String value) {
            addCriterion("cover_path >", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathGreaterThanOrEqualTo(String value) {
            addCriterion("cover_path >=", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLessThan(String value) {
            addCriterion("cover_path <", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLessThanOrEqualTo(String value) {
            addCriterion("cover_path <=", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLike(String value) {
            addCriterion("cover_path like", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotLike(String value) {
            addCriterion("cover_path not like", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathIn(List<String> values) {
            addCriterion("cover_path in", values, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotIn(List<String> values) {
            addCriterion("cover_path not in", values, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathBetween(String value1, String value2) {
            addCriterion("cover_path between", value1, value2, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotBetween(String value1, String value2) {
            addCriterion("cover_path not between", value1, value2, "coverPath");
            return (Criteria) this;
        }

        public Criteria andLikeCountsIsNull() {
            addCriterion("like_counts is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountsIsNotNull() {
            addCriterion("like_counts is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountsEqualTo(Long value) {
            addCriterion("like_counts =", value, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsNotEqualTo(Long value) {
            addCriterion("like_counts <>", value, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsGreaterThan(Long value) {
            addCriterion("like_counts >", value, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsGreaterThanOrEqualTo(Long value) {
            addCriterion("like_counts >=", value, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsLessThan(Long value) {
            addCriterion("like_counts <", value, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsLessThanOrEqualTo(Long value) {
            addCriterion("like_counts <=", value, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsIn(List<Long> values) {
            addCriterion("like_counts in", values, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsNotIn(List<Long> values) {
            addCriterion("like_counts not in", values, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsBetween(Long value1, Long value2) {
            addCriterion("like_counts between", value1, value2, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andLikeCountsNotBetween(Long value1, Long value2) {
            addCriterion("like_counts not between", value1, value2, "likeCounts");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}